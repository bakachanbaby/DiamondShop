package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.sizes ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("FROM ");
		sql.append("products as p ");
		sql.append("INNER JOIN ");
		sql.append("colors as c ");
		sql.append("ON p.id = c.id_product ");

		return sql;
	}

	// Slq sản phẩm theo sản phẩm mới và nổi bật
	private String SqlProducts(boolean newProduct, boolean highlight) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if (highlight) {
			sql.append("AND p.highlight = true ");
		}
		if (newProduct) {
			sql.append("ANd p.new_product = true ");
		}
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("Order BY RAND() ");
		if (highlight) {
			sql.append("LIMIT 9 ");
		}
		if (newProduct) {
			sql.append("LIMIT 12 ");
		}
		return sql.toString();

	}

	// Sql tìm kiếm theo id của thể loại
	private StringBuffer SqlProductsById(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category =  " + id + " ");

		return sql;

	}
	// Sql tìm kiếm sản phẩn theo id
	private String SqlProductById(long id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id =  " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();

	}
	// Sql phân trang sản phẩm
	private String SqlProductsPaginate(int id, int start, int pageSize) {
		StringBuffer sql = SqlProductsById(id);
		sql.append("LIMIT " + start + ", " + pageSize + " ");
		return sql.toString();

	}
	// List lấy toàn bộ sản phẩm
	public List<ProductsDto> GetDataProducts() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProducts(true, false);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	// List lấy toàn bộ sản phẩm theo id
	public List<ProductsDto> GetAllProductsById(int id) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProductsById(id).toString();
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	// List lấy toàn bộ sản phẩm theo phân trang
	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int pageSize) {
		StringBuffer sqlGetDataById = SqlProductsById(id);

		List<ProductsDto> listProductById = _jdbcTemplate.query(sqlGetDataById.toString(), new ProductsDtoMapper());
		List<ProductsDto> listProducts = new ArrayList<ProductsDto>();
		if (listProductById.size() > 0) {
			String sql = SqlProductsPaginate(id, start, pageSize);
			listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		return listProducts;
	}
	// Lấy giá trị 1 sản phẩm
	public List<ProductsDto> GetDataProductById(long id) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProductById(id);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	// Tìm kiếm sản phẩm theo id
	public ProductsDto FindProductById(long id) {
		String sql = SqlProductById(id);
		ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return product;
	}
}
