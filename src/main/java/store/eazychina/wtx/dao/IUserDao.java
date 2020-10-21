package store.eazychina.wtx.dao;

import java.util.List;

import store.eazychina.wtx.model.User;


public interface IUserDao {
	public User loadByUsername(String username);

	public User loadByEmail(String email);

	
	public List<User> list();
	
	public void add(User user);
	
	public void delete(int id);
}
