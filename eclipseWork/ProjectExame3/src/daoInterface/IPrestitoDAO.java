package daoInterface;

import java.time.LocalDate;
import java.util.List;

import model.Prestito;

public interface IPrestitoDAO {
	public void save(Prestito e);
	public Prestito getByISBN(int isbn);
	public void delete(Prestito e);
	public void update(Prestito e);
	public List<Prestito> getAll();
	public List<Prestito> getAllElement(int numeroTessere);
	public List<Prestito> getAllElementOverDate(LocalDate e);
}
