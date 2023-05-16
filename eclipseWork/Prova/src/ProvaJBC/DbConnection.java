package ProvaJBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
	String url="jdbc:postgresql://localhost:5432/Esercizio1Week3";
	String username="postgres";
	String password="mar24051996";
	
	Connection conn;
	Statement st;
	
	
	
	public DbConnection() throws SQLException {
		conn= DriverManager.getConnection(url,username,password);
		 st=conn.createStatement();
		System.out.println("DB collegato");
	}
	
	
	public void inserisciCliente(Cliente c) throws SQLException {
		
		String sql="INSERT INTO clienti(nome,Cognome,DataNascita,regioneResidenza)"+"VALUES ('"+c.getNome()+"', '"+c.getCognome()+"', '"+c.getData_nascita()+"', '"+c.getRegione_residenza()+"');";
		st.executeUpdate(sql);
		System.out.println(c.getNome()+" "+c.getCognome()+" salvato nel DB");
	}
	
	public Cliente leggiCLiente(int id) throws SQLException {
		String sql="SELECT * FROM clienti WHERE NumeroCliente= "+id;
		ResultSet rs= st.executeQuery(sql);
		
		Cliente c=null;
		
		if(rs.next()) {
			int numero_cliente=rs.getInt("NumeroCliente");
			String nome= rs.getString("nome");
			String cognome=rs.getString("Cognome");
			String data_nascita=rs.getString("DataNascita");
			String regione_residenza=rs.getString("regioneResidenza");
			c=new Cliente(numero_cliente,nome,cognome,LocalDate.parse(data_nascita),regione_residenza);
			System.out.println("presente"+nome);
		}
		return c;
	}
	
	
	public List<Cliente> leggiTuttiClienti()throws SQLException{
		List<Cliente> lista=new ArrayList<Cliente>();
		String sql="SELECT * FROM clienti";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			int numero_cliente=rs.getInt("NumeroCliente");
			String nome= rs.getString("nome");
			String cognome=rs.getString("Cognome");
			String data_nascita=rs.getString("DataNascita");
			String regione_residenza=rs.getString("regioneResidenza");
			Cliente c=new Cliente(numero_cliente,nome,cognome,LocalDate.parse(data_nascita),regione_residenza);
			lista.add(c);
		}
		System.out.println(lista.size()+" Numero clienti presenti");
		return lista;
	}
	
	public void modificaCliente(Cliente c) throws SQLException {
		String sql= "UPDATE clienti SET "
					+"nome='"+c.getNome()+"', "
					+"Cognome='"+c.getCognome()+"', "
					+"DataNascita='"+c.getData_nascita()+"', "
					+"regioneResidenza='"+c.getRegione_residenza()+"' WHERE NumeroCliente="+c.getNumero_cliente()+";";
					
		st.executeUpdate(sql);
		
	}
	
	
	public void cancellaCliente(int id)throws SQLException{
		String sql="DELETE FROM clienti WHERE NumeroCliente= "+id;
		st.executeQuery(sql);
	}
}
