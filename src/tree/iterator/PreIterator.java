package tree.iterator;

import java.util.Stack;

import tree.BiTreeNode;

/**
 * 二叉树游标前序遍历
 * @author lfq
 *
 */
public class PreIterator extends MyBiTreeIterator {
	
	Stack<BiTreeNode> stack = new Stack<BiTreeNode>();

	
	public PreIterator() {
		super();
	}


	public PreIterator(BiTreeNode root) {
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
		if(this.getCurr().getRightChild() != null)
		{
			stack.push(this.getCurr().getRightChild());
		}
		if(this.getCurr().getLeftChild() != null)
		{
			stack.push(this.getCurr().getLeftChild());
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
