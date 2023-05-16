package ProvaJBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		try {
			
			DbConnection db=new DbConnection();
			Cliente c=new Cliente("Marco","Viola",LocalDate.of(1980, 11, 22),"Toscana");
			
		//	db.inserisciCliente(c);
		//	System.out.println(db.leggiCLiente(2));
			
			List<Cliente> listaClienti=db.leggiTuttiClienti();
			//listaClienti.forEach(cl-> System.out.println(cl));
			
		Cliente giallino=listaClienti.get(0);
		giallino.setCognome("alvatore");
		db.modificaCliente(giallino);
		listaClienti.forEach(cl-> System.out.println(cl));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	


}
