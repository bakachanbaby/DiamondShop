package DiamonShop.Entity;

//Table loại sản phẩm
public class Categorys {
	private int id;
	private String name;
	private String description;
	
	public Categorys() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
