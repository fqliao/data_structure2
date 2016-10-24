package tree.iterator;
/**
 * 二叉树节点类
 * @author lfq
 *
 */
public class BiTreeNode {
	
	private Object data;//节点数据
	private BiTreeNode leftChild;//左孩子节点
	private BiTreeNode rightChild;//右孩子节点
	
	public BiTreeNode(){//初始化一个空状态节点
		this.leftChild = null;
		this.rightChild = null;
	}
	/**
	 * 传入数据初始化节点 
	 * @param leftChild
	 * @param data
	 * @param rightChild
	 */
	public BiTreeNode(BiTreeNode leftChild,Object data,BiTreeNode rightChild){
		this.leftChild = leftChild;
		this.data = data;
		this.rightChild = rightChild;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public BiTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BiTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BiTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BiTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	@Override
	public String toString() {
		return "BiTreeNode [data=" + data + "]";
	}
	

}
