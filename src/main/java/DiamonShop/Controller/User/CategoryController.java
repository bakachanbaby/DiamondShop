package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginatesDto;
import DiamonShop.Service.User.CategoryServiceImpl;
import DiamonShop.Service.User.PaginateServiceImpl;

@Controller
public class CategoryController extends BaseController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int pageSize = 9;

	@RequestMapping(value = {"/san-pham/{id}"})
	public ModelAndView Index(@PathVariable String id)
	{
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetDataProductsById(Integer.parseInt(id)).size();
		int currentPage = 1;
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, pageSize, currentPage);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("ProductsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id), paginateInfo.getStart(),pageSize));
		return _mvShare;
	}
	
	@RequestMapping(value = {"/san-pham/{id}/{currentPage}"})
	public ModelAndView Index(@PathVariable String id,@PathVariable String currentPage)
	{
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetDataProductsById(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, pageSize, Integer.parseInt(currentPage) );
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("ProductsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id), paginateInfo.getStart(), pageSize));
		return _mvShare;
	}
	
}
