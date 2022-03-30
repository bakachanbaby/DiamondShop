package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperUsers;
import DiamonShop.Entity.Users;

@Repository
public class UsersDao extends BaseDao {

	public int AddAccount(Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ");
		sql.append("( ");
		sql.append("	user, ");
		sql.append("	password, ");
		sql.append("	display_name, ");
		sql.append("	address ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	'" + user.getUser() + "', ");
		sql.append("	'" + user.getPassword() + "', ");
		sql.append("	'" + user.getDisplay_name() + "', ");
		sql.append("	'" + user.getAddress() + "' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

	public Users GetUserByAccount(Users user) {
		String sql = "SELECT * FROM users WHERE user = '" + user.getUser() + "' ";
		Users rerult = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return rerult;
	}

}
