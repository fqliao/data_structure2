package tree.iterator;

import java.util.Stack;

import tree.BiTreeNode;

/**
 * 中序遍历
 * @author lfq
 *
 */
public class InIterator extends MyBiTreeIterator {
	
	Stack<BiTreeNode> stack = new Stack<BiTreeNode>();

	public InIterator() {
		super();
	}

	public InIterator(BiTreeNode root) {
		super(root);
	}
	
	/**
	 * 得到最左边的节点
	 * @param node
	 * @return BiTreeNode
	 */
	public BiTreeNode getFarLeft(BiTreeNode node)
	{
		if(node == null)
		{
			return null;
		}
		while(node.getLeftChild() != null)
		{
			stack.push(node);
			node = node.getLeftChild();
		}
		return node;
	}
	@Override
	public void reset() {
		if(this.getRoot() == null){
			this.setEndOfBiTree(true);
			return;
		}
		else
		{
			this.setEndOfBiTree(false);
		}
		this.setCurr(getFarLeft(this.getRoot()));
	}

	@Override
	public void next() {
		if(this.getEndOfBiTree()){
			System.out.println("结束遍历！");
			return;
		}
		
		if(this.getCurr().getRightChild() != null)
		{	//在右孩子中找到最左边的节点
			this.setCurr(getFarLeft(this.getCurr().getRightChild()));
		}
		else if(!stack.isEmpty())
		{
			this.setCurr(stack.pop());
		}
		else
		{
			this.setEndOfBiTree(true);
		}
	}
		
}
