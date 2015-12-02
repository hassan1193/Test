package pk.com.wtech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import pk.com.wtech.dto.Author;
import pk.com.wtech.util.AUtil;
public class AuthorDAO {
	private Connection connection;
	public AuthorDAO(ServletContext ctx){
		connection = AUtil.getConnection(ctx);
		System.out.println(connection);
	}
	public void addAuthor(Author aut){
		PreparedStatement prepstate;
		try {
			prepstate = connection.prepareStatement("insert into author(name,publisher,address) values ( ?, ?, ? )");
			prepstate.setString(1,aut.getName());
		    prepstate.setString(2,aut.getPublisher());
		    prepstate.setString(3,aut.getAddress());
		    prepstate.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	public void deleteAuthor(int auth){
		try {
			PreparedStatement prepstate = connection.prepareStatement("delete from author where id=?");
			prepstate.setInt(1,auth);
			 prepstate.executeUpdate();
	 } catch (SQLException e) {
			e.printStackTrace();
		}}
	
	public void updateAuthor(Author aut) {
		try {
			PreparedStatement prepstate = connection.prepareStatement("update author set name=?, publisher=?, address=?" + "where id=?");
		prepstate.setString(1, aut.getName());
		prepstate.setString(1, aut.getPublisher());
		prepstate.setString(1, aut.getAddress());
		prepstate.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}}
	public List<Author> getAllAuthors(){
	      List<Author> authors = new ArrayList<Author>();
	      Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from author");
			while(rs.next()){
				Author au = new Author();
             au.setId(rs.getInt("id"));
              au.setName(rs.getString("name"));
              au.setPublisher(rs.getString("publisher"));
              au.setAddress(rs.getString("address"));
              authors.add(au);
			}
			
			
			
			 
		} 
		
		
		catch (SQLException e) {
		 e.printStackTrace();
		}
		return authors;
		 }}
