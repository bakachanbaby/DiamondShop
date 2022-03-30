package DiamonShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.BillsDao;
import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bills;
import DiamonShop.Entity.BillsDetail;

@Service
public class BillServiceImpl implements IBillService {

	@Autowired
	BillsDao billsDao = new BillsDao();

	// Thêm hóa đơn vào bảng
	@Override
	public int AddBills(Bills bills) {
		return billsDao.AddBills(bills);
	}
	// Thêm chi tiết hóa đơn vào bảng chi tiết hóa đơn
	@Override
	public void AddBillsDetail(HashMap<Long, CartDto> carts) {
		long idBills = billsDao.getIdLastBills();
		
		for (Map.Entry<Long, CartDto> itemCart: carts.entrySet()) {
			BillsDetail billDetail = new BillsDetail();
			billDetail.setId_bills(idBills);
			billDetail.setId_product(itemCart.getValue().getProducts().getId_product());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.addBillsDetail(billDetail);
		}
	}

}
