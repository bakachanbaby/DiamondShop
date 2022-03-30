package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bills;

@Service
public interface IBillService {
	@Autowired 
	public int AddBills(Bills bills);
	@Autowired 
	public void AddBillsDetail(HashMap<Long, CartDto> carts);
}
