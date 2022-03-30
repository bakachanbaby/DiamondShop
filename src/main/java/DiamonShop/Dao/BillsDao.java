package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Bills;
import DiamonShop.Entity.BillsDetail;

@Repository
public class BillsDao extends BaseDao {

	// Thêm hóa đơn
	public int AddBills(Bills bills) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO bills ");
		sql.append("( ");
		sql.append("	user, ");
		sql.append("	phone, ");
		sql.append("	display_name, ");
		sql.append("	address, ");
		sql.append("	total, ");
		sql.append("	quanty, ");
		sql.append("	note ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	'" + bills.getUser() + "', ");
		sql.append("	'" + bills.getPhone() + "', ");
		sql.append("	'" + bills.getDisplay_name() + "', ");
		sql.append("	'" + bills.getAddress() + "', ");
		sql.append("	" + bills.getTotal() + ", ");
		sql.append("	" + bills.getQuanty() + ", ");
		sql.append("	'" + bills.getNote() + "' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	//Thêm chi tiết hóa đơn
	public int addBillsDetail(BillsDetail billDetail) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO billdetail ");
		sql.append("( ");
		sql.append("	id_product, ");
		sql.append("	id_bills, ");
		sql.append("	quanty, ");
		sql.append("	total ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	" + billDetail.getId_product()+ ", ");
		sql.append("	" + billDetail.getId_bills()+ ", ");
		sql.append("	" + billDetail.getQuanty()+ ", ");
		sql.append("	" + billDetail.getTotal()+ " ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	// Lấy ra id của hóa đơn cuối
	public long getIdLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills; ");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}

}
