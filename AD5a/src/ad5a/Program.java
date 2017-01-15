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
		session.save(p);
		
		Item i=new Item();
		i.setNombre("Tablet");
		i.setCantidad(3);
		session.save(i);
		
		session.getTransaction().commit();
		//
		
		//PER A AGAFAR/CONSULTAR
		session.beginTransaction();
		
		Empresa em=session.get(Empresa.class, 1);
		System.out.println("Hem recuperat de Empresa: "+em.getNombre()+" "+em.getCIF()+" "+em.getDireccion()+" "+em.getEmpleados());
		
		Pedido pe=session.get(Pedido.class, 1);
		System.out.println("Hem recuperat de Pedido: "+pe.getFecha());
		
		Item it=session.get(Item.class, 1);
		System.out.println("Hem recuperat de Item: "+it.getNombre()+" "+it.getCantidad());
		
		session.getTransaction().commit();
		//
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
