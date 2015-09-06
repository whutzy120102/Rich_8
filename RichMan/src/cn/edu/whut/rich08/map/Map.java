package cn.edu.whut.rich08.map;
import cn.edu.whut.rich08.building.*;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.edu.whut.rich08.main.Obj;

//游戏地图，静态生成
//采用设计模式之单例模式
public class Map extends JPanel {
	private static Map map = null;
	private static Square [] list;
	public static final int NUM_ELEMENTS = 66;		   //地图上元素总数,常量，并公开
	public static final int NUM_ELEMENTS_ROW = 25;     //地图每一行的元素个数
	public static final int NUM_ELEMENTS_COL = 10;     //地图每一列的元素个数
	private final int VALUE_LOCATION_ONE = 200;		   // 地皮1的价格
	private final int VALUE_LOCATION_TWO = 500;		   // 地皮2的价格
	private final int VALUE_LOCATION_THREE = 300;	   // 地皮3的价格
	
	//地图构造函数，完成地图初始化工作
	private   Map()
	{
		// 创建Square对象数组
		list = new Square[ NUM_ELEMENTS ];
		for(int i=0;i<NUM_ELEMENTS;i++)
			list[i] = new Square();
		
		list[0].add( new StartPoint() );
		
		for(int i=1;i<12;i++)
		{
			list[i].add( new House(VALUE_LOCATION_ONE) );	// 地皮1的价格
		}
		
		// 医院
		list[12].add( new Hospital() );
		
		for(int i=13;i<24;i++)
		{
			list[i].add( new House(VALUE_LOCATION_ONE) );	// 地皮1的价格
		}
		
		// 道具屋
		list[24].add( new PropHouse() );
		
		// 地皮2
		for(int i=25;i<33;i++)
		{
			list[i].add( new House(VALUE_LOCATION_TWO) );	// 地皮1的价格
		}
		
		// 礼品屋
		list[33].add( new GiftHouse() );
		
		// 地皮3
		for(int i=34;i<45;i++)
		{
			list[i].add( new House(VALUE_LOCATION_THREE) );	// 地皮3的价格
		}
		
		// 监狱
		list[45].add( new Prison() );
		
		// 地皮3
		for(int i=46;i<57;i++)
		{
			list[i].add( new House(VALUE_LOCATION_THREE) );	// 地皮3的价格
		}
		
		// 魔法屋
		list[57].add( new MagicHouse() );
		
		// 矿地
		for(int i=58;i<66;i++)
		{
			list[i].add( new Mineral((i-57)*100) );
		}
		
		// 界面布局
		setLayout( new GridLayout(10,25));
		// 第1行
		for(int i=0;i<25;i++)
			add( list[i] );
		// 第2-9 行
		for(int i=0;i<8;i++)
		{
			add( list[NUM_ELEMENTS-1-i] );
			for(int j=0;j<23;j++)
			{
				add( new JLabel() );
			}
			add( list[ 25 + i ] );
		}
		// 第10行
		for(int i=0;i<25;i++)
		{
			add( list[57-i]);
		}
	}
	
	//获取实例
	public static Map getInstance(){
		if( null == map )
			map = new Map();
		return map;
	}
	
	//在地图指定位置插入一个Obj对象
	public static void insert(int pos , Obj o)
	{
		//传入参数检查
		if( pos < 0 || pos >= NUM_ELEMENTS || null == o ){
			System.out.println("Insert 参数错误! Position:"+pos);
			System.exit(0);
		}
		//判断对象o是否已经存在
		if( true == list[pos].contains(o) )
			return;
		else
			list[pos].add(o);
	}
	
	//在地图指定位置删除一个Obj对象
	public static void remove(int pos , Obj o )
	{
		//传入参数检查
		if( pos < 0 || pos >= NUM_ELEMENTS || null == o ){
			System.out.println("Insert 参数错误! Position:"+pos);
			System.exit(0);
		}
		//判断队列是否为空 
		if( list[pos].isEmpty() ){
			System.out.println("Position "+pos+" of map is empty!");
			return;
		}
		//判断队列是否包含此元素
		if( false == list[pos].contains(o) ){
			System.out.println("Position "+pos+" does not contain the obj!");
		}
		if( list[pos].remove(o) == false )	// 删除失败
		{
			System.out.println("删除失败! pos:" + pos );
		}
	}
}