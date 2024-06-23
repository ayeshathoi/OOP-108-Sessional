package sample;

import javafx.application.Platform;

import java.util.List;

public class ClientThread implements Runnable{
    private NetworkUtil networkUtil;
    private Thread thread;
    private Main main;

    public ClientThread(NetworkUtil networkUtil, Main main) {
        System.out.println("Inside Constructor");
        this.main = main;
        this.networkUtil=networkUtil;
        this.thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {

        try {
            while (true) {

                if (main.showManufacturerPage) {
                    networkUtil.write("UpdatedList ");

                    List list = (List) networkUtil.read();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                main.showManufacturerPage(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }


                    });


                } else if (main.showViewerPage) {
                    networkUtil.write("UpdatedList ");

                    List list = (List) networkUtil.read();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                main.showViewerPage(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }


                    });

                }
                thread.sleep(900);


            }
        }
    catch (Exception e){
            System.out.println(e);

        }

    }
}
