package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.MaterialApplyEmp;
import entity.Warehouse;
import utils.Md5;

/**
 * 仓库管理员对数据库的操作
 * 
 * @author lipeipei
 *
 */
public class GodownKeeperDao {
	/**
	 * 仓库管理员登录
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public boolean login(String name, String pwd) {
		Connection conn = BaseDao.getConnection();
		pwd = Md5.md5(pwd, "123456");
		if (conn != null) {
			String sql = "select *from godown_keeper where name='" + name + "' and pwd='" + pwd + "'";
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
	 * 查询仓库信息
	 * @return list
	 * @throws SQLException 
	 */
	public List<Warehouse> queryWarehouseData() throws SQLException {
		List<Warehouse> list = new ArrayList<Warehouse>();
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "select *from godown";
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					Warehouse warehouse = new Warehouse();
					warehouse.setId(rs.getInt("id"));
					warehouse.setMaterial_number(rs.getString("material_number"));
					list.add(warehouse);
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
	 * 查询物料申请记录
	 * @return list
	 * @throws SQLException 
	 */
	public List<MaterialApplyEmp> queryMaterialApplies() throws SQLException {
		List<MaterialApplyEmp> list = new ArrayList<MaterialApplyEmp>();
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "select flag,m.id material_id,m.name,m.unit_price,g.id godown_id,applicant from material_apply ma left join material m on ma.name=m.name left\n" + 
					" join godown as g on m.godown_id=g.id;";
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
					mae.setApplicant(rs.getString("applicant"));
					mae.setFlag(rs.getInt("flag"));
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
	 * 刪除资产信息
	 * 
	 * @param assetNo
	 * @return
	 */
	public boolean del_godown(String id) {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "DELETE FROM godown WHERE id = ?";
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				int row = stmt.executeUpdate();
				System.out.println(row);
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
	 * 修改资产信息
	 * 
	 * @param assetInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateGodown(Warehouse wh) {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			String sql = "update godown set material_number=? where id =?;";
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, wh.getMn());
				stmt.setInt(2, wh.getId());
				int row = stmt.executeUpdate();
//				System.out.println(row);
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
