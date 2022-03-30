package DiamonShop.Dto;

public class CartDto {
	private int quanty;
	private double totalPrice;
	private ProductsDto products;

	public CartDto() {
	}

	public CartDto(int quanty, double totalPrice, ProductsDto products) {
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.products = products;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductsDto getProducts() {
		return products;
	}

	public void setProducts(ProductsDto products) {
		this.products = products;
	}

}
