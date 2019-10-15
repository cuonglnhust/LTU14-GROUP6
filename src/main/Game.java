package main;

import mouse.Mouse;
import state.GameState;
import state.State;
import graphics.CreateImage;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Display display;
    private String title;
    private int width, height;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    private State state;
    private Mouse mouse;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        mouse = new Mouse();
    }

    private void init() {
        Handler.getInstance().setGame(this);
        display = new Display(title, width, height);
        CreateImage.create();
        state = new GameState();
        State.setCurrentState(state);
    }

    private void tick() {
        if (State.getCurrentState() != null) {
            State.getCurrentState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        // Draw here
        if (State.getCurrentState() != null) {
            State.getCurrentState().render(g);
        }
        // End draw here
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }

        stop();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Mouse getMouse() {
        return mouse;
    }
}