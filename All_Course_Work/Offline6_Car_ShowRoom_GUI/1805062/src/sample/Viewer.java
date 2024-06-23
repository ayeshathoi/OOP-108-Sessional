package sample;

public class Viewer {
    NetworkUtil networkUtil;
    Main main;

    public Viewer(String serverAddress, int serverPort, Main main) {

        try {
             this.networkUtil = new NetworkUtil(serverAddress, serverPort);
             this.main=main;
             new ClientThread(this.networkUtil,main);

//
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
