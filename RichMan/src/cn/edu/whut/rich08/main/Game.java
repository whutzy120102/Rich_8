package cn.edu.whut.rich08.main;
import cn.edu.whut.rich08.role.Role;

public class Game {
	public static int NUM_ROLE;		//游戏角色数目
	private Role [] roles ;			//游戏玩家列表
	private static Role currentRole;		//当前的角色
	
	static public Role getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(Role currentRole) {
		this.currentRole = currentRole;
	}

}
