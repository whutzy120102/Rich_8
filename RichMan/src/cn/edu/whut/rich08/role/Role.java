package cn.edu.whut.rich08.role;
import cn.edu.whut.rich08.building.*;
import cn.edu.whut.rich08.effect.Prop;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import cn.edu.whut.rich08.map.Map;
import cn.edu.whut.rich08.main.Obj;

//角色类，派生出阿土伯、孙小美等具体的角色
public class Role extends Obj{
	private String name;	 //角色名称
	private char   letter;	 //显示的字符
	private int    money;	 //当前拥有的金额
	private int    score;	 //当前拥有的点数
	private Color  color;	 //角色的颜色
	private ArrayList<Prop> props;		//角色拥有的所有道具
	private int unluckyTimes;			//被衰神附体的剩余次数
	private int luckyTimes;		    	//被财神附体的剩余次数
	private ArrayList<House> houses;	//角色拥有的所有房产
	private int in_hospital_cnt;	    //住院的剩余天数
	private int in_prison_cnt;			//进监狱的剩余天数
	
	
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getUnluckyTimes() {
		return unluckyTimes;
	}

	public void setUnluckyTimes(int unluckyTimes) {
		this.unluckyTimes = unluckyTimes;
	}

	public int getLuckyTimes() {
		return luckyTimes;
	}

	public void setLuckyTimes(int luckyTimes) {
		this.luckyTimes = luckyTimes;
	}

	public int getIn_hospital_cnt() {
		return in_hospital_cnt;
	}

	public void setIn_hospital_cnt(int in_hospital_cnt) {
		this.in_hospital_cnt = in_hospital_cnt;
	}

	public int getIn_prison_cnt() {
		return in_prison_cnt;
	}

	public void setIn_prison_cnt(int in_prison_cnt) {
		this.in_prison_cnt = in_prison_cnt;
	}

	//角色内部类：骰子
	static class Dice
	{
		private static int score;	//骰子的当前点数
		
		public static int getScore(){
			return score;
		}
		
		public void setScore(int score){
			this.score =score;
		}
		
		public static void cast(){
			score = new Random().nextInt(6) + 1;
		}
	}
	
	//投骰子前进
	public void move(){
		Dice.cast();	
		int steps = Dice.getScore();	//前进的步数
		//从旧位置的列表中删除
		Map.getInstance().remove(pos, this);
		//计算新位置
		pos = ( pos + steps ) % Map.NUM_ELEMENTS;
		//插入新位置的列表
		Map.getInstance().insert(pos, this);
	}

	//角色绘制自身
	public void paint() {
		System.out.print(letter);
	}
	
}
