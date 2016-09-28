package tree.iterator;

import java.util.LinkedList;
import java.util.Queue;

import tree.BiTreeNode;

public class LevelIterator extends MyBiTreeIterator {
	
	Queue<BiTreeNode> queue = new LinkedList<BiTreeNode>();
	
	
	public LevelIterator() {
		super();
	}

	public LevelIterator(BiTreeNode root) {
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
		if(this.getCurr().getLeftChild() != null)
		{
			queue.add(this.getCurr().getLeftChild());
		}
		if(this.getCurr().getRightChild() != null)
		{
			queue.add(this.getCurr().getRightChild());
		}

	}

	@Override
	public void next() {
		if(this.getEndOfBiTree()){
			System.out.println("结束遍历！");
			return;
		}
		if(!queue.isEmpty())
		{
			this.setCurr(queue.remove());
			if(this.getCurr().getLeftChild() != null)
			{
				queue.add(this.getCurr().getLeftChild());
			}
			if(this.getCurr().getRightChild() != null)
			{
				queue.add(this.getCurr().getRightChild());
			}
		}
		else
		{
			this.setEndOfBiTree(true);
		}
	}

}
