package DiamonShop.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Entity.Users;

@Service
public interface IAccountService {
	@Autowired 
	public int AddAccount(Users user);
	@Autowired 
	public Users CheckAccount(Users user);
}
