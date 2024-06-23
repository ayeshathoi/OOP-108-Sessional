package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class Server {
    private static CarDataBase carDataBase=new CarDataBase();
    public static void loadFromFile(){

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("cars.txt"));
            while (true) {
                line = br.readLine();
                if (line == null) break;
                String[] str=line.split(",");
                System.out.println("getting car from file");

                carDataBase.addCar(new Car(str[0],Integer.parseInt(str[1]),str[2],str[3],str[4],str[5],str[6],Integer.parseInt(str[7]),Integer.parseInt(str[8])));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    private ServerSocket serverSocket;
    public HashMap<String, String> ManufacturerInfo;

    Server() {
        try {
            serverSocket = new ServerSocket(12444);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        System.out.println("writing the first list");
        List list=carDataBase.getCars();
        networkUtil.write(list);
         new ReadThread(networkUtil);

    }

    public static void main(String args[]) {
        loadFromFile();
        Server server = new Server();

    }
    public static List AddCar(Car carToAdd){
        System.out.println("In server");
        System.out.println(carToAdd);
        carDataBase.addCar(carToAdd);
        loadToFile();
        return carDataBase.getCars();


    }
    public static Car buyRequest(String[] str){
      int index=  carDataBase.queryCar(str[1]);
      if(index==-1){
          Car o=null;
          return o;
      }
      else {
          int quantity = carDataBase.getCars().get(index).getQuantity();
          if (quantity > 0) {
              quantity = quantity - 1;

              carDataBase.getCars().get(index).setQuantity(quantity);
              loadToFile();
              return carDataBase.searchCar(str[1]);

          }
      }
              Car o=null;
              return o;
    }
    public static Car search(String[] str){
        if(str.length==3){
            System.out.println("Searching for "+str[1]+" "+str[2]);
           return carDataBase.searchCar(str[1],str[2]);
        }else {
            System.out.println("Searching for "+str[1]);
            return carDataBase.searchCar(str[1]);
        }

    }
    public static List changeData(String[] data,NetworkUtil networkUtil){
        // carDataBase..setPrice(Integer.parseInt(data[1]));
        System.out.println("In change data Method");
        int index=carDataBase.queryCar(data[1]);
        carDataBase.EditCar(Integer.parseInt(data[2]),Integer.parseInt(data[3]),index);
        loadToFile();
        return (carDataBase.getCars());
    }
    public static List DeleteCar(String[] str){

        System.out.println("In delete car Method Server");

        carDataBase.removeCar(str[1]);
        loadToFile();
        return (carDataBase.getCars());
    }
    public static void loadToFile(){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("cars.txt"));
            for(Car c:carDataBase.getCars()){
                bw.write(c.toString());
                bw.write("\n");}
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List SendUpdatedList(){
        return carDataBase.getCars();
    }
}
