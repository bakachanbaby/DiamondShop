package DiamonShop.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Entity.Users;

@Service
public interface IAccountService {
	// Thực hiện thêm tài khoản người dùng
	@Autowired 
	public int AddAccount(Users user);
	// Thực hiện kiểm tra tài khoản người dùng
	@Autowired 
	public Users CheckAccount(Users user);
}
