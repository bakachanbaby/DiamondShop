package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.IProductService;

@Controller
public class ProductController extends BaseController {
	
	@Autowired
	private IProductService produtService;
	//Chuyển đến trang chi tiết sản phẩm theo id sản phẩm tương ứng
	@RequestMapping(value = {"chi-tiet-san-pham/{id}"})
	public ModelAndView Index(@PathVariable long id) {
		_mvShare.setViewName("user/products/product");
		ProductsDto product = produtService.GetDataProductById(id); 
		// Lấy giá trị product
		_mvShare.addObject("product", product);
		// Lấy giá trị các products
		_mvShare.addObject("products", _homeService.GetDataProducts());
		int idCategory = product.getId_category();
		// Lấy giá trị product theo id của loại sản phẩm
		_mvShare.addObject("productByIdCategory", produtService.GetProductByIdCategory(idCategory));
		return _mvShare;
	}
	
}
