package pk.com.wtech.dao;

import java.util.List;




import pk.com.wtech.dto.Author;


public interface GenericDAO {
	public void addAuthor(Author aut);
	public void deleteAuthor(int auth);
	 public void updateAuthor(Author aut);
	 public List<Author> getAllAuthors();
	 public Author getAuthorById(int Id);

}

