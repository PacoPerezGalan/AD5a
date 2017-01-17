package ad5a;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pedido {
	int id;
	Date fecha;
	Item item= new Item();
	List<Items> items= new ArrayList<Items>();
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
}
