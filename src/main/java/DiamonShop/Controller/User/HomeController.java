package DiamonShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

	//Chuyển đến trang chủ trang web
	@RequestMapping(value = {"/", "/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView Index() {
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	//Chuyển đến trang liên hệ của trang web
	@RequestMapping(value = {"lien-he"}, method = RequestMethod.GET)
	public ModelAndView contact() {
		_mvShare.setViewName("user/about/contact");
		return _mvShare;
	}
	//Chuyển đến trang so sánh của trang web
	@RequestMapping(value = {"so-sanh"}, method = RequestMethod.GET)
	public ModelAndView conpair() {
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/products/compair");
		return _mvShare;
	}
}
