package rmi.server;

import constant.ModeType;
import rmi.model.Mode;
import rmi.dataLogin.ConnectionData;

public class ServerViewer extends Mode {

    public ServerViewer(ConnectionData connectionData) {
        super(connectionData);
        modeType = ModeType.SERVER_VIEWER;
    }
}