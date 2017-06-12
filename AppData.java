import java.io.Serializable;
import java.util.List;


public class AppData implements Serializable {
    private List<Item> itemsData;
    private int lastIDData;

    public AppData()
    {

    }

    public List<Item> getItemsData() {
        return itemsData;
    }

    public void setItemsData(List<Item> itemData) {
        this.itemsData = itemsData;
    }

    public int getLastIDData() {
        return lastIDData;
    }

    public void setLastIDData(int lastIDData) {
        this.lastIDData = lastIDData;
    }
}
