package daoInterface;

import java.util.List;

import model.Libri;
import model.Riviste;

public interface IlibriDAO {
	public void save(Libri e);
	public Libri getByISBN(int isbn);
	public void delete(Libri e);
	public void update(Libri e);
	public List<Libri> getAll();
}
