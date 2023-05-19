package daoInterface;

import java.util.List;

import model.Riviste;
import model.Libri;

public interface IrivisteDAO {
	public void save(Riviste e);
	public Riviste getByISBN(int isbn);
	public void delete(Riviste e);
	public void update(Riviste e);
	public List<Riviste> getAll();
}
