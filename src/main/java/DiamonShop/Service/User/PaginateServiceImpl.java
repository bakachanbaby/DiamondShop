package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginatesDto;
@Service
public class PaginateServiceImpl implements IPaginatesService {
	
	public PaginatesDto GetInfoPaginates(int totalData, int pageSize, int currentPage) {
		PaginatesDto paginate = new PaginatesDto();
		paginate.setPageSize(pageSize);
		paginate.setTotalPage(SetInfoTotalPage(totalData, pageSize));
		paginate.setCurrentPage(CheckCurrentPage(currentPage, paginate.getTotalPage()));		
		paginate.setStart(FindStart(paginate.getCurrentPage(), pageSize));
		paginate.setEnd(FindEnd(paginate.getStart(), pageSize, totalData));
		return paginate;
	}

	// Lay so trang cuoi moi trang
	private int FindEnd(int start, int pageSize, int totalData) {
		return start + pageSize > totalData ? totalData : start+pageSize-1;
	}

	// Lay so trang dau tien moi trang
	private int FindStart(int currentPage, int pageSize) {
		return ((currentPage - 1) * pageSize) + 1;
	}

	// Kiem tra trang hien tai
	private int CheckCurrentPage(int currentPage, int totalPage) {
		if(currentPage < 1)
			return 1;
		if(currentPage > totalPage)
			return totalPage;
		return currentPage;
	}

	//Lay tong so trang
	private int SetInfoTotalPage(int totalData, int pageSize) {
		int totalPage = totalData / pageSize + (totalData % pageSize > 0 ? 1 : 0);
		return totalPage;
	}

	
	
}
