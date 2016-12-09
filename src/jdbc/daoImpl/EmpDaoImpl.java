package jdbc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.dao.EmpDao;
import jdbc.entity.Emp;
import jdbc.util.DBUtils;

public class EmpDaoImpl implements EmpDao {
	public List<Emp> ListEmps() {
		List<Emp> list = new ArrayList<Emp>();
		String sql = "select e.empno, e.ename, e.job, e.mgr, e2.ename,  e.sal,e.hiredate, e.comm, e.deptno,d.dname from emp e, emp e2 ,dept d where e.mgr = e2.empno and e.deptno = d.deptno";
		// String sql = "select * from emp";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setMgrName(rs.getString(5));
				emp.setSal(rs.getDouble(6));
				emp.setHiredate(rs.getDate(7));
				emp.setComm(rs.getDouble(8));
				emp.setDeptno(rs.getInt(9));
				emp.setDeptName(rs.getString(10));
				// emp.setEmpno(rs.getInt(1));
				// emp.setEname(rs.getString(2));
				// emp.setJob(rs.getString(3));
				// emp.setMgr(rs.getInt(4));
				// emp.setHiredate(rs.getDate(5));
				// emp.setSal(rs.getDouble(6));
				// emp.setComm(rs.getDouble(7));
				// emp.setDeptno(rs.getInt(8));
				 list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, pstmt, conn);
		}
		return list;
	}
}
