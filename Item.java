import java.io.Serializable;

public class Item implements Serializable {

	private int ID;
	private String Name;
	private long EAN;
	private String Provider;
	private String Place;
	private float Quantity;
	private float Price;
	
	public Item(){
		
	}
	
	public Item(int ID, String Name, long EAN, String Provider, String Place, float Quantity, float Price){
		this.ID=ID;
		this.Name=Name;
		this.EAN=EAN;
		this.Provider=Provider;
		this.Place=Place;
		this.Quantity=Quantity;
		this.Price=Price;
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public long getEAN() {
		return EAN;
	}


	public void setEAN(long eAN) {
		EAN = eAN;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getProvider() {
		return Provider;
	}


	public void setProvider(String provider) {
		Provider = provider;
	}


	public String getPlace() {
		return Place;
	}


	public void setPlace(String place) {
		Place = place;
	}


	public float getQuantity() {
		return Quantity;
	}


	public void setQuantity(float quantity) {
		Quantity = quantity;
	}
	
	
	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	@Override
    public String toString() {
        return ID + " " + Name + " " + EAN + " " + Provider + " " + Place + " " + Quantity + " " + Price;
    }
}
