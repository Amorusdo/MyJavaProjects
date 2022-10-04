package OnlineMarket;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Data {

    private static final String directory ="src/Serializable/OnlineMarket" ;
    private  static  void save(Market saveMarket){
        try {
            FileOutputStream fos = new FileOutputStream(directory);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(saveMarket);
            oos.close();
        }catch (Exception e){
            System.out.println("Some go wrong");

        }
    }
//    private static Market getSavedMarket()throws Exception{
//        Market market = new Market();
//        FileInputStream fis = new FileInputStream(directory);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        if
//    }
}
