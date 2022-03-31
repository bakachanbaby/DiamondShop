package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface ICategoryService {
	//Thực hiện lấy sản phẩm theo Id
	public List<ProductsDto> GetDataProductsById(int id);
	//Thực hiện lấy sản phẩm theo phân trang
	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int pageSize);
}
