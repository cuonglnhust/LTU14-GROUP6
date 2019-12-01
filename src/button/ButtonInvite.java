package button;

import graphics.CreateImage;
import main.Handler;

import java.awt.*;

public class ButtonInvite extends Button {

    OnClickButton onClickButton;

    public ButtonInvite(int x, int y) {
        super(x, y);
    }

    public void tick() {
        if (isOver()) {
            if (Handler.getInstance().getMouse().isLeftClick() || Handler.getInstance().getMouse().isRightClick()) {
                Handler.getInstance().getMouse().setDefaultClick();
                if (onClickButton != null) {
                    onClickButton.onClick();
                }

            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (isOver()) {
            g.drawImage(CreateImage.buttonInvite[1], x, y, null);
        } else {
            g.drawImage(CreateImage.buttonInvite[0], x, y, null);
        }
    }

    @Override
    public Rectangle getBound() {
        int width = CreateImage.buttonInvite[0].getWidth();
        int height = CreateImage.buttonInvite[0].getHeight();
        return new Rectangle(x, y, width, height);
    }

    public void setOnClickButton(OnClickButton onClickButton) {
        this.onClickButton = onClickButton;
    }
}