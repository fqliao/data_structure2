package tree.iterator;

import java.util.LinkedList;
import java.util.Queue;

import tree.Node;

public class LevelIterator extends MyBiTreeIterator {
	
	Queue<Node> queue = new LinkedList<Node>();
	
	
	public LevelIterator() {
		super();
	}

	public LevelIterator(Node root) {
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
		if(this.getCurr().getLeft() != null)
		{
			queue.add(this.getCurr().getLeft());
		}
		if(this.getCurr().getRight() != null)
		{
			queue.add(this.getCurr().getRight());
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
			if(this.getCurr().getLeft() != null)
			{
				queue.add(this.getCurr().getLeft());
			}
			if(this.getCurr().getRight() != null)
			{
				queue.add(this.getCurr().getRight());
			}
		}
		else
		{
			this.setEndOfBiTree(true);
		}
	}

}
