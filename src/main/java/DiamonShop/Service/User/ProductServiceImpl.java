package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductsDao productsDao;
	
	@Override
	public ProductsDto GetDataProductById(long id) {
		List<ProductsDto> listProducts = productsDao.GetDataProductById(id);
		
		return listProducts.get(0);
	}

	@Override
	public List<ProductsDto> GetProductByIdCategory(int id) {
		return productsDao.GetAllProductsById(id);
	}

	
	
}
