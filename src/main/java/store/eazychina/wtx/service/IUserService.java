package store.eazychina.wtx.service;

import java.util.List;

import store.eazychina.wtx.exception.SSMException;
import store.eazychina.wtx.model.User;


public interface IUserService {

	public List<User> list();

	public User login(User user) throws SSMException;
	
	public void register(User user) throws SSMException;

}
