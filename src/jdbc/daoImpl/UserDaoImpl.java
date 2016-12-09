package jdbc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.dao.UserDao;
import jdbc.entity.User;
import jdbc.util.DBUtils;

public class UserDaoImpl implements UserDao {

	public boolean checkUser(String uname, String pwd) {
		boolean flag = false;
		String sql = "select * from user_table where name=? and password=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
				flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, pstmt, conn);
		}
		return flag;
	}
	public boolean checkUser(String uname) {
		boolean flag = false;
		String sql = "select * from user_table where name=? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			rs = pstmt.executeQuery();
			if(rs.next())
				flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, pstmt, conn);
		}
		return flag;
	}
//	public static void main(String[] args) {
//		UserDaoImpl dao = new UserDaoImpl(); 
//		for(int i = 0; i < 10; i++){
//			User u = new User();
//			u.setName("user1"+i);
//			u.setPwd("123456");
//			u.setPhone("13901234567");
//			dao.insertUser(u);
//		}
//	}
	public boolean insertUser(User user) {
		boolean flag = false;
		String sql = "insert into user_table (name,password,register_date,phone)values(?,?,sysdate,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getPhone());
			result = pstmt.executeUpdate();
			flag = result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, pstmt, conn);
		}
		return flag;
	}

	public User queryUserById(int id) {
		User user = new User();
		
		return user;
	}

	public User queryUserByName(String name) {
		User user = new User();
		String sql = "select * from user_table where name=? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				Date d = rs.getDate(4);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				user.setDate(format.format(d));
				user.setPhone(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, pstmt, conn);
		}
		return user;
	}
	public List<User> listUsers() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user_table order by id";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPwd(rs.getString(3));
				Date d = rs.getDate(4);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				u.setDate(format.format(d));
				u.setPhone(rs.getString(5));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public boolean deleteUserById(int id) {
		
		String sql = "delete  from user_table where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, pstmt, conn);
		}
		return result > 0;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update user_table set name=?, password=?,register_date=?,phone=?"
				+ "where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPwd());
			String dt = user.getDate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date = format.parse(dt);
			pstmt.setDate(3, new java.sql.Date(date.getTime()));
			pstmt.setString(4, user.getName());
			pstmt.setInt(5, user.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, pstmt, conn);
		}
		return result > 0;
	}

}
