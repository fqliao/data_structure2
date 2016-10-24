package tree.iterator;


/**
 * 二叉树游标遍历，非递归算法
 * @author lfq
 *
 */
public abstract class MyBiTreeIterator {
	private BiTreeNode root;//根节点
	private BiTreeNode curr;//当前节点
	private boolean isComplete;//判断是否遍历结束
	public MyBiTreeIterator()
	{
		
	}
	public MyBiTreeIterator(BiTreeNode root)
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
	public BiTreeNode getRoot() {
		return root;
	}
	public void setRoot(BiTreeNode root) {
		this.root = root;
	}
	public BiTreeNode getCurr() {
		return curr;
	}
	public void setCurr(BiTreeNode curr) {
		this.curr = curr;
	}

}
