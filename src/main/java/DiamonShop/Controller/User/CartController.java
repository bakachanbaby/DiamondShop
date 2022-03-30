package DiamonShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bills;
import DiamonShop.Entity.Users;
import DiamonShop.Service.User.BillServiceImpl;
import DiamonShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillServiceImpl billService = new BillServiceImpl();

	// Thực hiện thêm sản phẩm
	@RequestMapping(value = { "/gio-hang" })
	public ModelAndView Index() {
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}

	// Thực hiện thêm sản phẩm
	@RequestMapping(value = { "/AddCart/{id}" })
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	// Thực hiện sửa sản phẩm
	@RequestMapping(value = { "/EditCart/{id}/{quanty}" })
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable long id,
			@PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	// Thực hiện xóa sản phẩm
	@RequestMapping(value = { "/DeleteCart/{id}" })
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	// Thực hiện đến trang thanh toan
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request, HttpSession session) {
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		Users loginInfo = (Users) session.getAttribute("LoginInfo");
		if (loginInfo != null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplay_name(loginInfo.getDisplay_name());
			bills.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bills", bills);
		return _mvShare;
	}

	// Thực hiện đến trang thanh toan
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills")Bills bills) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		bills.setQuanty(cartService.TotalQuanty(cart));
		bills.setTotal(cartService.TotalPrice(cart));
		if(billService.AddBills(bills) > 0) {
			cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
			billService.AddBillsDetail(cart);
		}
		session.removeAttribute("cart");
		return "redirect:gio-hang";
	}
}
