package cn.edu.whut.rich08.building;
import java.awt.Color;
import cn.edu.whut.rich08.role.Role;

//房子
public class House extends specialBuilding
{
	private int level ;		// 等级： 0：空地  1：茅屋  2：洋房  3：摩天楼
	private String owner;	// 主人姓名， 阿土伯 ， 金贝贝 ， 钱夫人 ， 大老千
	private int value ;		// 购买地皮所需要的价格
	private Color color;	// 颜色，其主人的颜色
	private boolean state;	// 是否收费： true:收费  false:不收费
	private int price;		// 房产累计的价值，包括 买地皮费用 + 升级费用
	private int toll;		// 过路费，即 price 的一半
	private int sellPrice;	// 售价 ，  即 price 的两倍
	
	public House( int value )	// 初始化
	{
		level = 0;
		owner ="";
		this.value = value;
		color = Color.BLACK;
		state = false;
		price = value;
		toll = price / 2;
		sellPrice = price + price;
	}
	
	// Role r 购买了该块地皮
	public void buy( Role r )	
	{
		owner = r.getName(); 
		level = 0 ;	// 空地
		color = r.getColor();
		price = value;
		toll  = price / 2;
		sellPrice = price + price ;
		state = true;
	}
	
	// 升级房子
	public void upgrade()	
	{
		level ++;
		price += value;
		toll = price / 2;
		sellPrice = price + price ;
	}
	
	// 出售房子
	public void sell() 		
	{
		owner ="";			// 无主人
		level = 0;			// 变为空地
		color = Color.black;// 黑色
		state = false;      // 不收费
	}
	
	@Override
	public void showList() {
		// TODO Auto-generated method stub
		
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getToll() {
		return toll;
	}

	public void setToll(int toll) {
		this.toll = toll;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	
}