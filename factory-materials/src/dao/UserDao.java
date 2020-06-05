package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.MaterialApply;
import utils.Md5;

/**
 * 系统管理员对数据库的操作
 * 
 * @author lipeipei
 *
 */
public class UserDao {
	/**
	 * 用户注册
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public boolean login(String name, String pwd) {
		Connection conn = BaseDao.getConnection();
		pwd = Md5.md5(pwd, "123456");
		if (conn != null) {
			String sql = "select *from user where name='" + name + "' and pwd='" + pwd + "'";
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
	 * 添加物料申请记录
	 * 
	 * @param assetInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean addMaterialApply(MaterialApply ma) {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "INSERT material_apply(" + "name,address,mobile_nubmer,others,applicant)"
					+ "values(?,?,?,?,?)";
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, ma.getName());
				stmt.setString(2, ma.getAddress());
				stmt.setString(3, ma.getMobile_nubmer());
				stmt.setString(4, ma.getOthers());
				stmt.setString(5, ma.getApplicant());
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
