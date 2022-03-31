package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperSliders;
import DiamonShop.Entity.Slides;

@Repository
public class SlidesDao  extends BaseDao{
	
	//Lấy giá trị các sản phẩm slide
	public List<Slides> GetDataSlide(){
		List<Slides> list = new ArrayList<Slides>();
		String sql = "SELECT * FROM slides";
		list = _jdbcTemplate.query(sql, new MapperSliders());
		return list;
	}

	
}
