package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ParsingContextSnapshot;

import entity.Department;
import entity.Employee;
import entity.GodownKeeper;
import utils.Md5;

/**
 * 系统管理员对数据库的所有操作
 * 
 * @author lipeipei
 *
 */
public class AdminDao {
	/**
	 * 系统管理员登录
	 * 
	 * @param name
	 * @param pwd
	 * @return true or false
	 */
	public boolean login(String name, String pwd) {
		Connection conn = BaseDao.getConnection();
		pwd = Md5.md5(pwd, "123456");
		if (conn != null) {
			String sql = "select *from admin where name='" + name + "' and pwd='" + pwd + "'";
			PreparedStatement stmt;
			ResultSet rs;
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 查询仓库管理员信息
	 * 
	 * @return list
	 * @throws SQLException
	 */
	public List<GodownKeeper> queryGodownKeepersInfo() throws SQLException {
		List<GodownKeeper> list = new ArrayList<GodownKeeper>();
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "select *from godown_keeper";
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					GodownKeeper gk = new GodownKeeper();
					gk.setId(rs.getInt("id"));
					gk.setName(rs.getString("name"));
					gk.setGodown_id(rs.getInt("godown_id"));
					gk.setMobile_number(rs.getString("mobile_number"));
					gk.setReal_name(rs.getString("real_name"));
					list.add(gk);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs.close();
				stmt.close();
				conn.close();
			}
		}
		return list;
	}

	/**
	 * 查询部门信息
	 * 
	 * @return list
	 * @throws SQLException
	 */
	public List<Department> queryDepartInfo() throws SQLException {
		List<Department> list = new ArrayList<Department>();
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "select *from department";
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					Department dt = new Department();
					dt.setId(rs.getInt("id"));
					dt.setName(rs.getString("name"));
					list.add(dt);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs.close();
				stmt.close();
				conn.close();
			}
		}
		return list;
	}

	/**
	 * 查询员工信息
	 * 
	 * @return list
	 * @throws SQLException
	 */
	public List<Employee> queryEmpInfo() throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "select e.id,e.name,d.name  depart_name,real_name from employee e left join department d on e.depart_id=d.id;";
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					Employee em = new Employee();
					em.setId(rs.getInt("id"));
					em.setName(rs.getString("name"));
					em.setReal_name(rs.getString("real_name"));
					em.setDepart_name(rs.getNString("depart_name"));
					list.add(em);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs.close();
				stmt.close();
				conn.close();
			}
		}
		return list;
	}

	/**
	 * 删除仓库管理员的信息
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public boolean delGodownKeepersInfo(int id) throws SQLException {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "DELETE FROM godown_keeper WHERE id = ?";
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, id);
				int row = stmt.executeUpdate();
				if (row >= 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * 删除员工信息
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean delEmpInfo(String id) throws SQLException {
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from employee where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int row = ps.executeUpdate();
			if (row >= 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
		return false;
	}

	/**
	 * 删除部门信息
	 * 
	 * @param id
	 */
	public boolean delDepartment(String id) {
		Connection conn = BaseDao.getConnection();
		String sql = "delete from department  where id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int row = ps.executeUpdate();
			if (row >= 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 编辑仓库管理员信息
	 * 
	 * @param gk
	 * @return true or false
	 */
	public boolean updateGodownKeepersInfo(GodownKeeper gk) {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "update godown_keeper set name=?,mobile_number=?,real_name=? where id =?;";
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, gk.getName());
				stmt.setString(2, gk.getMobile_number());
				stmt.setString(3, gk.getReal_name());
				stmt.setInt(4, gk.getId());
				int row = stmt.executeUpdate();
				if (row >= 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * 编辑员工信息
	 * 
	 * @param id
	 * @return true or false
	 */
	public boolean updateEmpInfo(Employee emp) {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "update employee set name=?,mobile_number=?,real_name=? where id =?;";
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, emp.getName());
				stmt.setString(2, emp.getMobile_number());
				stmt.setString(3, emp.getReal_name());
				stmt.setInt(4, emp.getId());
				int row = stmt.executeUpdate();
				if (row >= 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * 编辑部门信息
	 * 
	 * @param id
	 * @return true or false
	 */
	public boolean updateDepartment(Department dt) {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "update department set name=? where id =?;";
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, dt.getName());
				stmt.setInt(2, dt.getId());
				int row = stmt.executeUpdate();
				if (row >= 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
