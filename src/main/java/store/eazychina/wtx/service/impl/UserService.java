package store.eazychina.wtx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import store.eazychina.wtx.dao.IUserDao;
import store.eazychina.wtx.exception.SSMException;
import store.eazychina.wtx.model.User;
import store.eazychina.wtx.service.IUserService;


@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;


	@Override
	public List<User> list() {
		return userDao.list();
	}


	@Override
	public User login(User user) throws SSMException {

		User oldUser = userDao.loadByUsername(user.getUsername());
		if (oldUser == null) {
			throw new SSMException("用户名不存在");
		}
		if (!oldUser.getPassword().equals(user.getPassword())) {
			throw new SSMException("密码不正确");
		}
		return oldUser;
			
	}


	@Override
	public void register(User user) throws SSMException {
		User oldUser = userDao.loadByUsername(user.getUsername());
		/**
		 * 思路:
		 * 		如果数据库中用户名已经被注册,那么就不能使用这个username
		 * 		如果数据库中邮箱已经被注册那么就不能使用这个       email
		 * 		如果数据库中用户名查询为空,那么可以进行注册
		 */
		System.out.println(oldUser+" oldUser对象 ");
		if(null==oldUser){
			//这个坑,oldUser为空的时候就不能再调用get方法了,所以要判断对象是否为空,
			//然后在写一个根据邮箱判断是否为空,邮箱一样也要判断对象是否为空不能使用get方法
			/**
			 * 登录校验或者注册校验的时候,假设数据库中对象关键唯一性属性都是唯一的,那么,不会出现这种问题.但是如果,因为高并发
			 * 或者位置情况,让唯一性出现问题,也就是属性重复的时候,就会遇到mybatise的resultType不对的问题
			 * 解决思路:
			 * 思路一: 对所有resultType都设置为list来接收,然后调用处遍历,遍历时根据备用唯一性属性进行选择….感觉很麻烦
			 * 思路二:中间件对属性进行维护,当发现属性重复的时候,进行思路1的操作
			 * 
			 */
			User oldUser2 = userDao.loadByEmail(user.getEmail());
			System.out.println(oldUser2+" oldUser2对象 ");

			if(null!=oldUser2){
				throw new SSMException("邮箱已经存在");
			}	
			userDao.add(user);
//			throw new SSMException("注册成功");
			return;
		}
		/**
		 * 不为空的时候报错
		 */
		if(user.getUsername().equals(oldUser.getUsername())){
			throw new SSMException("用户名已存在");
		}
		if(user.getEmail().equals(oldUser.getEmail())){
			throw new SSMException("邮箱已经存在");
		}
			
					userDao.add(user);
}
}