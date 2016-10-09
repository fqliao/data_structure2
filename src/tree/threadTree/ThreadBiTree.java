package tree.threadTree;

import java.util.Scanner;

/**
 * 线索二叉树类
 * @author lfq
 *
 */
public abstract class ThreadBiTree {
	protected BiTreeNode head;
	protected static final String ENDFLAG = "null";
	public ThreadBiTree()
	{
		this.head = null;
	}
	
	//初始化二叉树的根节点
	public void initBiTree()
	{
		String item;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入二叉树树根节点（输入null表示该节点为空）");
		item = in.next();
		if(!item.equalsIgnoreCase(ENDFLAG))
		{
			head = new BiTreeNode(item);
			init(head);
		}
	}
	
	//初始化二叉树
	private void init(BiTreeNode head) {
		String item;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入"+head.getData()+"节点的左孩子节点");
		item = in.next();
		if(!item.equalsIgnoreCase(ENDFLAG))
		{
			head.setLeftNode(new BiTreeNode(item));
			init(head.getLeftNode());//递归
		}
		System.out.println("请输入"+head.getData()+"节点的右孩子节点");
		item = in.next();
		if(!item.equalsIgnoreCase(ENDFLAG))
		{
			head.setRightNode(new BiTreeNode(item));
			init(head.getRightNode());//递归
		}
		
	}
	
	//创建线索二叉树
	public abstract void createThreadBiTree();
	//线索遍历算法
	public abstract void traversal();
	
}
