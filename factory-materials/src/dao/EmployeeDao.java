package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.GodownKeeper;
import entity.MaterialApply;
import entity.MaterialApplyEmp;
import utils.Md5;

/**
 * 员工(这里的员工主要做订单的处理)对数据库的操作
 * 
 * @author lipeipei
 *
 */
public class EmployeeDao {
	/**
	 * 员工登录
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public boolean login(String name, String pwd) {
		Connection conn = BaseDao.getConnection();
		pwd = Md5.md5(pwd, "123456");
		if (conn != null) {
			String sql = "select *from employee where name='" + name + "' and pwd='" + pwd + "'";
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
	 * 查询物料申请记录
	 * @return list
	 * @throws SQLException 
	 */
	public List<MaterialApplyEmp> queryMaterialApplies() throws SQLException {
		List<MaterialApplyEmp> list = new ArrayList<MaterialApplyEmp>();
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "select ma.id apply_id,flag,m.id material_id,m.name,m.unit_price,g.id godown_id from material_apply ma left join material m on ma.name=m.name left join godown as g on m.godown_id=g.id;";
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					MaterialApplyEmp mae = new MaterialApplyEmp();
					mae.setMaterial_id(rs.getInt("material_id"));
					mae.setName(rs.getString("name"));
					mae.setUnit_price(rs.getInt("unit_price"));
					mae.setGodown_id(rs.getInt("godown_id"));
					mae.setFlag(rs.getInt("flag"));
					mae.setApply_id(rs.getInt("apply_id")); 
					list.add(mae);
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
	 * 修改订单状态
	 * 
	 * @param assetInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean materialApplyEdit(MaterialApply ma) {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "update material_apply set flag=1 where id=?;";
//			String sql = "UPDATE assetrepairinfo SET assetId=?,sendRepairPerson=?,intermediator=?,reason=? WHERE id=?";
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ma.getId());
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