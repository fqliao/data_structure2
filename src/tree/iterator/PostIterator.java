package tree.iterator;

import java.util.Stack;

import tree.BiTreeNode;
/**
 * 后序遍历 双堆栈
 * @author lfq
 *
 */
public class PostIterator extends MyBiTreeIterator {
	
	Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
	Stack<BiTreeNode> temp = new Stack<BiTreeNode>();
	
	
	public PostIterator() {
		super();
	}

	public PostIterator(BiTreeNode root) {
		super(root);
	}

	@Override
	public void reset() {
		if(this.getRoot() == null)
		{
			this.setEndOfBiTree(true);
			return;
		}
		else
		{
			this.setEndOfBiTree(false);
		}
		this.setCurr(this.getRoot());
		
		while(this.getCurr() != null || stack.size() > 0)
		{
			while(this.getCurr() != null)
			{
				temp.push(this.getCurr());
				stack.push(this.getCurr());
				this.setCurr(this.getCurr().getRightChild());
			}
			if(stack.size() > 0)
			{
				this.setCurr(stack.pop());
				this.setCurr(this.getCurr().getLeftChild());
			}
		}
		
		this.setCurr(temp.pop());
	}

	@Override
	public void next() {
		if(this.getEndOfBiTree()){
			System.out.println("结束遍历！");
			return;
		}
		if(!temp.isEmpty())
		{
			this.setCurr(temp.pop());
		}
		else
		{
			this.setEndOfBiTree(true);
		}

	}

}
