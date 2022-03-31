package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.CartDto;

@Service
public interface ICartService {

	//Thực hiện thêm sản phẩm vào giỏ hàng
	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart);
	//Thực hiện sửa số lượng 1 sản phẩm trong giỏ hàng
	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart); 
	//Thực hiện xóa 1 sản phẩm trong giỏ hàng
	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart);
	//Thực hiện lấy tổng số lượng sản phẩm trong giỏ
	public int TotalQuanty(HashMap<Long, CartDto> cart);
	//Thực hiện lấy tổng tiền sản phẩm trong giỏ
	public double TotalPrice(HashMap<Long, CartDto> cart);

}
