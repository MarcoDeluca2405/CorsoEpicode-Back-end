package daoInterface;

import java.util.List;

import model.Utente;

public interface IUtenteDAO {
	public void save(Utente e);
	public Utente getByISBN(int isbn);
	public void delete(Utente e);
	public void update(Utente e);
	public List<Utente> getAll();
}
