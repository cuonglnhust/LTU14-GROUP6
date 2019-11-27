package client;

import client.ClientImplement.ClientImp;
import client.RemoteInterface.IClient;
import client.RemoteInterface.Player;
import server.RemoteInterface.IServer;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class MyClient {
    public static void main(String[] args) throws UnknownHostException {
        try {

            IServer iServer = (IServer) Naming.lookup("rmi://localhost:9999/hippocampus");

            Player player1 = iServer.signIn("vuong","vuong");

            if(player1 != null) {
                IClient iClient = new ClientImp(player1, iServer); // tạo ra đối tượng Client có chứa player

                List<Player> players = iServer.getPlayersOnline(player1);// lấy player 2 trong list player sau khi đăng nhập

                //ví dụ mời player2 là player đang online có index là 1
                Player player2 = players.get(1);

                //sau khi click mời thì sẽ gọi hàm sendInvitation của server
                // trả về câu trả lời player2 có đồng ý chơi cùng hay không
                iServer.sendInvitation(player1, player2);

                //nếu player 2 đồng ý chơi cùng thì ngay lập tức player1 tạo trận đấu

             }else {
                System.out.println("Username or password incorrect !");
            }


        } catch (RemoteException | NotBoundException | MalformedURLException | SQLException e) {
            e.printStackTrace();
        }
    }
}