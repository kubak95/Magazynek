import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Serializer {
    public static void saveItemsData() throws IOException
    {
        AppData appData = new AppData();
        appData.setItemsData(ItemsManagement.getInstance().getItems());
        appData.setLastIDData(ItemsManagement.getInstance().getLastID());
        FileOutputStream fos = new FileOutputStream("ItemsData.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(appData);
        encoder.close();
        fos.close();
    }

    public static void getItemsData() throws IOException
    {
        FileInputStream fis = new FileInputStream("ItemsData.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        AppData decodedData = (AppData)decoder.readObject();
        decoder.close();
        fis.close();
        ItemsManagement.getInstance().setItems(decodedData.getItemsData());
        ItemsManagement.getInstance().setLastID(decodedData.getLastIDData());
    }
}
