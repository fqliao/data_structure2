package tree.threadTree;
/**
 * 中序线索二叉树类
 * @author lfq
 *
 */
public class InThreadBiTree extends ThreadBiTree {

	public  InThreadBiTree() {
		super();
	}
	
	@Override
	public void createThreadBiTree() {
		create(head,null);
	}
	
	//中序线索化二叉树
	private BiTreeNode create(BiTreeNode curNode,BiTreeNode preNode)
	{
		if (curNode != null) 
		{
			BiTreeNode tempNode = create(curNode.getLeftNode(), preNode);

			if ((!curNode.isLeftFlag()) && (curNode.getLeftNode() == null)) 
			{
				curNode.setLeftFlag(true);
				curNode.setLeftNode(preNode);
			} 

			preNode = tempNode;

			if ((preNode != null) && (preNode.getRightNode() == null)) 
			{
				preNode.setRightFlag(true);
				preNode.setRightNode(curNode);
			} 

			preNode = curNode;
			preNode = create(curNode.getRightNode(), preNode);
			return preNode;
		} 

		return preNode;
	}
	@Override
	public void traversal() {
		BiTreeNode walker = this.head;
		if (this.head != null) {
			while (!walker.isLeftFlag())
				walker = walker.getLeftNode();

			System.out.print(walker.getData() + " ");

			while (walker.getRightNode() != null) {
				if (walker.isRightFlag())
					walker = walker.getRightNode();
				else {
					walker = walker.getRightNode();
					while ((walker.getLeftNode() != null)
							&& (!walker.isLeftFlag()))
						walker = walker.getLeftNode();
				} 

				System.out.print(walker.getData() + " ");
			}
		}
	}

}
