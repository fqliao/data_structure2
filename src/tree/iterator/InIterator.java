package tree.iterator;

import java.util.Stack;

import tree.Node;

/**
 * 中序遍历
 * @author lfq
 *
 */
public class InIterator extends MyBiTreeIterator {
	
	Stack<Node> stack = new Stack<Node>();

	public InIterator() {
		super();
	}

	public InIterator(Node root) {
		super(root);
	}
	
	/**
	 * 得到最左边的节点
	 * @param node
	 * @return Node
	 */
	public Node getFarLeft(Node node)
	{
		if(node == null)
		{
			return null;
		}
		while(node.getLeft() != null)
		{
			stack.push(node);
			node = node.getLeft();
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
		
		if(this.getCurr().getRight() != null)
		{	//在右孩子中找到最左边的节点
			this.setCurr(getFarLeft(this.getCurr().getRight()));
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
