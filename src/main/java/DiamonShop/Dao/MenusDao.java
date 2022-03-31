package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperMenus;
import DiamonShop.Entity.Menus;

@Repository
public class MenusDao  extends BaseDao{
	
	//Lấy giá trị các danh mục của trang web
	public List<Menus> GetDataMenus(){
		List<Menus> list = new ArrayList<Menus>();
		String sql = "SELECT * FROM menu";
		list = _jdbcTemplate.query(sql, new MapperMenus());
		return list;
	}

	
}
