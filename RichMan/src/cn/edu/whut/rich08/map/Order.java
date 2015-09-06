package cn.edu.whut.rich08.map;

import cn.edu.whut.rich08.role.Role;

public class Order {
	
	//仍色子
	public void Roll(Role r){
		r.move();
	}
	
	//使用障碍物
	public void Block(Role r,int n){
		if(n<-10||n>10){
			System.out.println("输入错误，无效！");  //文本框输出错误
		}
		else{
			
		}
	}
	
	//使用炸弹
	public void Bomb(int n){
		
	}
	
	//使用机器娃娃
	public void Robot(){
		
	}

	//查询资产
	public void Query(){

	}

	//退出
	public void Quit(){

	}

	//查询命令
	public void Help(){

	}


}
