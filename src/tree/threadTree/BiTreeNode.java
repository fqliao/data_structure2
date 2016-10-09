package tree.threadTree;
/**
 * 线索二叉树节点类
 * @author lfq
 *
 */
public class BiTreeNode {
	private BiTreeNode leftNode;//左孩子节点
	private BiTreeNode rightNode;//右孩子节点
	private boolean leftFlag;//是否是左线索
	private boolean rightFlag;//是否是右线索
	private Object data;//节点数据
	
	public BiTreeNode()
	{
		this.leftNode = null;
		this.rightNode = null;
		this.leftFlag = false;
		this.rightFlag = false;
		this.data = null;
	}
	
	public BiTreeNode(Object data)
	{
		this();
		this.data = data;
	}

	public BiTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BiTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BiTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BiTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public boolean isLeftFlag() {
		return leftFlag;
	}

	public void setLeftFlag(boolean leftFlag) {
		this.leftFlag = leftFlag;
	}

	public boolean isRightFlag() {
		return rightFlag;
	}

	public void setRightFlag(boolean rightFlag) {
		this.rightFlag = rightFlag;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
