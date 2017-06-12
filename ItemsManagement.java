import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemsManagement {
	private static ItemsManagement instance = null;
	private List<Item> items = new ArrayList<Item>();
	private int lastID = 0;
	
	protected ItemsManagement(){
		
	}
	public static ItemsManagement getInstance(){
		if (instance == null) {
			instance = new ItemsManagement();
		
		}
		return instance;
	}
	
	public void addNewItem(Item item) {
		items.add(item);
		try {
			Serializer.saveItemsData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ItemTable.UpdateTable();
	}
	public void removeSelectedItem(int index){
		items.remove(index);
		try {
			Serializer.saveItemsData();
			} catch (IOException e) {
				e.printStackTrace();
			}
		ItemTable.UpdateTable();
		
	}
	public void changeQuantity(int index, float amount){
		items.get(index).setQuantity(items.get(index).getQuantity() + amount);
		ItemTable.UpdateTable();
		try {
			Serializer.saveItemsData();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void setLastID(int LastID) {
		this.lastID = LastID;
	}
	
	public void LoadAllExistingItems() {
		try {
			Serializer.getItemsData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Item> getItems(){
		return items;
	}
	public int getLastIDAndIncrement()
    {
        lastID++;
        return lastID;
    }
    public int getLastID()
    {
        return lastID;
    }
}
