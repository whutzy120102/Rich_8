package cn.edu.whut.rich08.building;

import cn.edu.whut.rich08.main.Obj;

// 建筑物基类
public abstract class Buildings extends Obj{
	
}

//普通建筑物基类
abstract class  generalBuilding extends Buildings{	
	
}

//特殊建筑物基类
abstract class  specialBuilding extends Buildings{	
	public abstract void showList();	// 显示 魔法/道具/礼品 列表
}

