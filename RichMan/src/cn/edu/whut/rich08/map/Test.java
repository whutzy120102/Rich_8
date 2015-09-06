package cn.edu.whut.rich08.map;

import javax.swing.JFrame;

public class Test extends JFrame {
	
	public Test()
	{
		Map map = Map.getInstance();
		add(map);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.setTitle("Test");
		t.setLocation(100, 100);
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setVisible(true);
		t.setSize(600, 300);
	}

}
