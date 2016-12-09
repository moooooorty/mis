package jdbc.dao;

import java.util.List;

import jdbc.entity.User;

public interface UserDao {
	boolean checkUser(String uname, String pwd);
	boolean checkUser(String uname);
	boolean insertUser(User user);
	User queryUserById(int id);
	User queryUserByName(String name);
	List<User> listUsers();
	boolean deleteUserById(int id);
	boolean updateUser(User user);
}
