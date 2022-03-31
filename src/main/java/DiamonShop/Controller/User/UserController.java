package DiamonShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.Users;
import DiamonShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {

    @Autowired
    AccountServiceImpl accountService = new AccountServiceImpl();

    // Thực hiện vào trang đăng ký
    @RequestMapping(value = {"/dang-ky"}, method = RequestMethod.GET)
    public ModelAndView Register() {
        _mvShare.setViewName("user/account/register");

        _mvShare.addObject("user", new Users());
        return _mvShare;
    }

    // Thực hiện đăng ký tài khoảng
    @RequestMapping(value = {"/dang-ky"}, method = RequestMethod.POST)
    public ModelAndView CreateAcc(@ModelAttribute("user") Users user) {
        int count = accountService.AddAccount(user);
        if (count > 0) {
            _mvShare.addObject("status", "Đăng ký tài khoản thàng công!");
        } else {
            _mvShare.addObject("status", "Đăng ký tài khoản thàng công!");
        }
        _mvShare.setViewName("user/account/register");

        return _mvShare;
    }

    // Thực hiện đăng nhập tài khoản
    @RequestMapping(value = {"/dang-nhap"}, method = RequestMethod.POST)
    public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users user) {
        user = accountService.CheckAccount(user);
        if (user != null) {
            _mvShare.setViewName("redirect:trang-chu");
            session.setAttribute("LoginInfo", user);
        } else {
            _mvShare.addObject("statusLogin", "Đăng nhập tài khoản thất bại!");
        }
        return _mvShare;
    }

    // Thực hiện đăng xuất tài khoản
    @RequestMapping(value = {"/dang-xuat"}, method = RequestMethod.GET)
    public String Login(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("LoginInfo");
        return "redirect:" + request.getHeader("Referer");
    }
}
