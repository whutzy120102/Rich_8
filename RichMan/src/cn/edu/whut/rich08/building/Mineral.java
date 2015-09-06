package cn.edu.whut.rich08.building;

import java.awt.Color;

//矿地
public class Mineral extends generalBuilding
{
	private int score ;	// 提供给玩家的点数
	
	public Mineral(int score)
	{
		name = "矿地";
		letter ='$';
		color = Color.black;
		this.score=score;
	}

	public int getScore() {
		return score;
	}
	
}
