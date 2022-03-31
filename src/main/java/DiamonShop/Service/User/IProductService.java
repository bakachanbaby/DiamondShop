package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface IProductService {
	//Thực hiện lấy sản phẩm theo id sản phẩm
	public ProductsDto GetDataProductById(long id);
	//Thực hiện lấy sản phẩm theo phân loại sản phẩm đó
	public List<ProductsDto> GetProductByIdCategory(int id);	

}
