package ProvaJBC;
import java.sql.Connection;
import java.sql.DriverManager;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="jdbc:postgresql://localhost:5432/Prova";
		String username="postgres";
		String password="mar24051996";
		
		Connection conn=null;
		
		try {
			conn= DriverManager.getConnection(url,username,password);
			System.out.println("DB collegato");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
