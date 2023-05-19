package daoInterface;
import java.time.LocalDate;
import java.util.List;

import model.*;

public interface ICatalogoDAO {

	public void save(Catalogo e);
	public Catalogo getByISBN(int isbn);
	public void delete(Catalogo e);
	public void update(Catalogo e);
	public List<Catalogo> getAll();
	public List<Catalogo> getFindAnnoPublciazione(int e);
	public void deleteByid(int ISBN);
	public List<Catalogo> getFindAutore(String e);
	public List<Catalogo> getFindTitolo(String e);
}
