package tree.iterator;

import java.util.Stack;

import tree.Node;

/**
 * 二叉树游标前序遍历
 * @author lfq
 *
 */
public class PreIterator extends MyBiTreeIterator {
	
	Stack<Node> stack = new Stack<Node>();

	
	public PreIterator() {
		super();
	}


	public PreIterator(Node root) {
		super(root);
	}

	@Override
	public void reset() {//初始化游标
		if(this.getRoot() == null){
			this.setEndOfBiTree(true);
			return;
		}
		else
		{
			this.setEndOfBiTree(false);
		}
		this.setCurr(this.getRoot());
	}
	
	@Override
	public void next() {//遍历
		if(this.getEndOfBiTree())
		{
			System.out.println("已经遍历到二叉树结尾！");
			return;
		}
		if(this.getCurr().getRight() != null)
		{
			stack.push(this.getCurr().getRight());
		}
		if(this.getCurr().getLeft() != null)
		{
			stack.push(this.getCurr().getLeft());
		}
		if(!stack.empty())
		{
			this.setCurr(stack.pop());
		}
		else
		{
			this.setEndOfBiTree(true);
		}
	}
	
	
}
