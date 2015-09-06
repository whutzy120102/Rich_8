package cn.edu.whut.rich08.map;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import cn.edu.whut.rich08.main.Game;
import cn.edu.whut.rich08.main.Obj;

//地图中的小方格，继承JLabel
class Square extends JLabel
{
	private final int length =20;	// 长度
	private final int width  =20;	// 宽度
	private ArrayList<Obj> objs ;	// 该小方格所包含的所有对象
	private final int position_x = 8; // 绘制字符的位置
	private final int position_y =15; // 绘制字符的位置
	
	public Square()
	{
		objs = new ArrayList<Obj>();
	}
	
	// 判断是否包含o对象
	public boolean contains( Obj o)
	{
		if( null == o 				// 参数为空
			|| objs.size() == 0 )	// 队列为空
			return false;
		if( objs.contains(o) == true )
			return true;
		else
			return false;
	}
	
	// 判断是否为空队列
	public boolean isEmpty()
	{
		return objs.isEmpty();
	}
	
	public boolean add( Obj o )	// 添加一个对象,true:成功，false:失败
	{
		if( null == o 						//参数为空
			||  true == objs.contains(o) )	//已经包含此对象
			return false;
		else
		{
			objs.add(o);
			return true;
		}
	}
	
	public boolean remove( Obj o )	// 删除一个对象，true:成功，false:失败
	{
		if( null == o						//参数为空
			||  objs.isEmpty() == true 		//队列为空
			||  objs.contains(o) == false )	//不包含删除对象
			return false;
		else
		{
			objs.remove(o);
			return true;
		}
	}
	
	//绘制自身
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//绘制边界
		g.drawRect(0, 0, length , width );
		// 选择绘制对象
		// 优先绘制人物角色，而且优先绘制当前角色
		// 其次是各种道具
		// 最后是建筑物
		Obj toPaint ;	//待绘制的对象
		Color color;	//颜色
		if( objs.size() == 1 ){
			toPaint = objs.get(0);	//建筑物
			color = toPaint.getColor();
			g.setColor(color);
			g.drawString(toPaint.getLetter(), position_x, position_y );	//绘制建筑物的字母
			return;		
		}
		else {
			// 遍历队列,检查是否包含当前角色
			for(int i=0;i<objs.size();i++)
			{
				if( objs.get(i).getLetter() == Game.getCurrentRole().getLetter() )
				{
					toPaint = Game.getCurrentRole();
					color = toPaint.getColor();
					g.setColor(color);
					g.drawString(toPaint.getLetter(), position_x, position_y );
					return;
				}
			}
			// 遍历队列,检查是否包含人物角色
			for(int i=0;i<objs.size();i++)
			{
				if( objs.get(i).getLetter() == "A"    // 阿土伯
				||  objs.get(i).getLetter() == "J"    // 金贝贝
				||  objs.get(i).getLetter() == "Q"    // 钱夫人
				||  objs.get(i).getLetter() == "D"    // 金贝贝
				  )
				{
					toPaint = objs.get(i);
					color = toPaint.getColor();
					g.setColor(color);
					g.drawString(toPaint.getLetter(), position_x, position_y );
					return;
				}
			}
			// 遍历队列，检查是否包含道具
			for(int i=0;i<objs.size();i++)
			{
				if( objs.get(i).getLetter() == "#"    // 路障道具
				||  objs.get(i).getLetter() == "@"    // 炸弹道具
				  )
				{
					toPaint = objs.get(i);
					g.drawString(toPaint.getLetter(), position_x, position_y );
					return;
				}
			}
			// 其他异常情况
			Object[] options = { "OK", "CANCEL" }; 
			JOptionPane.showOptionDialog(null, "Click OK to continue", "Square Paint Error!", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
			null, options, options[0]); 
		}
	}
}
