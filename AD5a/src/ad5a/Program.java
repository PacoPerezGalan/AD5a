package ad5a;


import java.sql.Date;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

public class Program {
	
	public static void main(String[] args) {
		
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		//PER A INSERTAR
		
		session.beginTransaction();
		
		Empresa e=new Empresa();
		e.setCIF("E12345678");
		e.setNombre("Apple");
		e.setDireccion("Calle Carlos Ferris");
		e.setEmpleados(45);
		session.save(e);
			
		Pedido p=new Pedido();
		p.setFecha(new Date(System.currentTimeMillis()));
		p.getItem().setNombre("Tablet");
		p.getItem().setCantidad(3);
		p.getItems().add(new Items("One Plus 3",5));
		p.getItems().add(new Items("Samsung Galaxy 7",4));
		p.getItems().add(new Items("Iphone 7",3));
		session.save(p);
		
		/*5a
		Item i=new Item();
		i.setNombre("Tablet");
		i.setCantidad(3);
		session.save(i);
		*/
		session.getTransaction().commit();
		//
		
		//PER A AGAFAR/CONSULTAR
		session.beginTransaction();
		
		Empresa em=session.get(Empresa.class, 1);
		System.out.println("Hem recuperat de Empresa: "+em.getNombre()+" "+em.getCIF()+" "+em.getDireccion()+" "+em.getEmpleados());
		
		Pedido pe=session.get(Pedido.class, 1);
		System.out.println("Hem recuperat de Pedido: "+pe.getFecha()+" Item(component):"+pe.getItem().getNombre()+" "+pe.getItem().getCantidad());
		for(Items items : pe.getItems() ){
			System.out.println("item(collection): "+items.getNombre()+" "+items.getCantidad());
		}
		/*5a
		Item it=session.get(Item.class, 1);
		System.out.println("Hem recuperat de Item: "+it.getNombre()+" "+it.getCantidad());
		*/
		session.getTransaction().commit();
		//
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
