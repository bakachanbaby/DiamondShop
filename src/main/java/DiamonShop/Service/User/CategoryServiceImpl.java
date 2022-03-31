package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ProductsDao productsDao;
	
	@Override
	public List<ProductsDto> GetDataProductsById(int id) {
		return productsDao.GetAllProductsById(id);
	}

	@Override
	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int pageSize) {
		return productsDao.GetDataProductsPaginate(id, start, pageSize);
	}
}
