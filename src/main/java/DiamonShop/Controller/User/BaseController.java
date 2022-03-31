package DiamonShop.Controller.User;

import javax.annotation.PostConstruct;

import DiamonShop.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.HomeServiceImpl;

@Controller
public class BaseController  {
	@Autowired
	HomeServiceImpl _homeService;
	public ModelAndView _mvShare = new ModelAndView();

	//Gửi các thông tin mặc định
	@PostConstruct
	public ModelAndView Init() {
		_mvShare.addObject("menus", _homeService.GetDataMenus());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	

}
