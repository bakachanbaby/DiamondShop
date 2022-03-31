package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginatesDto;

@Service
public interface IPaginatesService {
	//Thực hiện lấy thông tin để phân trang
	public PaginatesDto GetInfoPaginates(int totalData, int pageSize, int currentPage);
}
