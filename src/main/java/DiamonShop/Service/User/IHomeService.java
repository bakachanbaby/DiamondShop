package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Categorys;
import DiamonShop.Entity.Menus;
import DiamonShop.Entity.Slides;

@Service
public interface IHomeService {
	//Thực hiện lấy sản phẩm slide
	@Autowired 
	public List<Slides> GetDataSlide();
	//THực hiện lấy phân loại các sản phẩm
	@Autowired 
	public List<Categorys> GetDataCategorys();
	//Thưc hiện lấy danh mục các sản phẩm
	@Autowired 
	public List<Menus> GetDataMenus();
	//Thực hiện lấy các sản phẩm
	@Autowired 
	public List<ProductsDto> GetDataProducts();
}
