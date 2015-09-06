package cn.edu.whut.rich08.main;

import java.awt.Color;

// 本游戏所有元素的共同父类
public abstract class Obj {
	protected int    pos;	  //所在位置，相对于左上角的S，从0开始 
	protected String name;	  //对象名称
	protected char   letter;  //显示在屏幕上的字母
	// letter详解：
	// 阿土伯：A 
	// 钱夫人：Q
	// 金贝贝：J
	// 大老千：D
	// 房子： 空地：0  一级房子：1  二级房子：2  三级房子：3
	// 起始点：  S
	// 医院：       H
	// 道具屋：  T
	// 礼品屋：  G
	// 监狱：       P
	// 魔法屋: M
	protected Color color ;	// 显示的颜色
	
	public Color getColor(){
		return color;
	}
	
	public void setColor( Color c ){
		this.color = c;
	}
	
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLetter() {
		return String.valueOf(letter);
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}
}
