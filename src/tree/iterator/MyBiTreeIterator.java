package tree.iterator;

import tree.Node;

/**
 * 二叉树游标遍历，非递归算法
 * @author lfq
 *
 */
public abstract class MyBiTreeIterator {
	private Node root;//根节点
	private Node curr;//当前节点
	private boolean isComplete;//判断是否遍历结束
	public MyBiTreeIterator()
	{
		
	}
	public MyBiTreeIterator(Node root)
	{
		this.root = root;
	}
	
	//这两个抽象方法由具体遍历子类实现
	public abstract void reset();

	public abstract void next();
	
	
	public Object getData()
	{
		return curr.getData();
	}
	
	public void setEndOfBiTree(boolean flag)
	{
		this.isComplete = flag;
	}
	public boolean getEndOfBiTree()
	{
		return isComplete;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public Node getCurr() {
		return curr;
	}
	public void setCurr(Node curr) {
		this.curr = curr;
	}

}
