package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CategorysDao;
import DiamonShop.Dao.MenusDao;
import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dao.SlidesDao;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Categorys;
import DiamonShop.Entity.Menus;
import DiamonShop.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategorysDao categorysDao;
	@Autowired
	private MenusDao menusDao;
	@Autowired
	private ProductsDao productsDao;
	@Override
	public List<Slides> GetDataSlide() {
		return slidesDao.GetDataSlide();
	}
	@Override
	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategorys();
	}
	@Override
	public List<Menus> GetDataMenus() {
		return menusDao.GetDataMenus();
	}
	@Override
	public List<ProductsDto> GetDataProducts() {
		return productsDao.GetDataProducts();
	}
	
}
