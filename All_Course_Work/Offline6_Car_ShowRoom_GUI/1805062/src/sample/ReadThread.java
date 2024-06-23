package sample;

import java.io.IOException;
import java.util.List;

public class ReadThread implements Runnable{

    private Thread thr;
    private NetworkUtil networkUtil;
    public ReadThread(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {

        try {

            while (true) {
                System.out.println("back in readthread");
                Object object = networkUtil.read();
                if (object != null) {
                    if(object instanceof String) {
                        String s =(String)object;
                        System.out.println("Received: " + s);
                        String[] data = s.split(" ");
                        if (data[0].equals("Edit")) {
                            //System.out.println("DATA RECEIVED " + data[0] + " " + data[1]);
                            List list = Server.changeData(data, this.networkUtil);


                            this.networkUtil.getOos().reset();
                            this.networkUtil.write(list);
                        } else if (data[0].equals("Delete")) {
                            List list = Server.DeleteCar(data);
                            this.networkUtil.getOos().reset();
                            this.networkUtil.write(list);
                        }else if(data[0].equals("UpdatedList")){
                            this.networkUtil.getOos().reset();
                            this.networkUtil.write(Server.SendUpdatedList());

                        }
                        else if(data[0].equals("Search")){
                            //Server.search(data);
                            System.out.println("Car to search ");
                            networkUtil.write(Server.search(data));
                        }
                        else if(data[0].equals("Buy")){
                            networkUtil.write(Server.buyRequest(data));
                        }
                    }
                    else if(object instanceof Car)
                    {   Car car=(Car)object;
                        System.out.println("Car Received\n Calling Server to Add this car"+ car);
                       List list= Server.AddCar(car);
                        this.networkUtil.getOos().reset();
                        this.networkUtil.write(list);
                    }
            }
        }
            }

         catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
