package sample;

import java.io.Serializable;

public class Manufacturer implements Serializable {

    ClientThread clientThread;
    NetworkUtil networkUtil;
    public Manufacturer(String serverAddress, int serverPort,Main main) {

        try {
             this.networkUtil = new NetworkUtil(serverAddress, serverPort);
             new ClientThread(networkUtil,main);

        } catch (Exception e) {
            System.out.println(e);
    }
    }

    public NetworkUtil getNetworkUtil() {
        return this.networkUtil;
    }









}
