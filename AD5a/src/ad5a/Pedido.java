package ad5a;

import java.sql.Date;

public class Pedido {
	int id;
	Date fecha;
	Item item= new Item();
	
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
}
