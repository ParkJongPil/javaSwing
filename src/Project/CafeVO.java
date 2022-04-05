package Project;

public class CafeVO {

	private int idx;
	private String part;
	private String menuName;
	private int price;
	
	private int idx1;
	private String name;
	private String menuName1;
	private int price1;
	private String saleDay;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getIdx1() {
		return idx1;
	}
	public void setIdx1(int idx1) {
		this.idx1 = idx1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenuName1() {
		return menuName1;
	}
	public void setMenuName1(String menuName1) {
		this.menuName1 = menuName1;
	}
	public int getPrice1() {
		return price1;
	}
	public void setPrice1(int price1) {
		this.price1 = price1;
	}
	public String getSaleDay() {
		return saleDay;
	}
	public void setSaleDay(String saleDay) {
		this.saleDay = saleDay;
	}
	@Override
	public String toString() {
		return "CafeVO [idx=" + idx + ", part=" + part + ", menuName=" + menuName + ", price=" + price + ", idx1="
				+ idx1 + ", name=" + name + ", menuName1=" + menuName1 + ", price1=" + price1 + ", saleDay=" + saleDay
				+ "]";
	}

	
}
