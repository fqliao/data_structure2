package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树类
 * @author lfq
 *
 */
public class BiTree {
	
	private BiTreeNode root;//根节点
	
	/**
	 * 初始化空树
	 */
	public BiTree(){
		root = new BiTreeNode();
	}
	/**
	 * 初始化非空二叉树
	 * @param leftTree 左子树
	 * @param data 数据
	 * @param rightTree 右子树
	 */
	public BiTree(BiTree leftTree,Object data,BiTree rightTree){
		BiTreeNode leftNode,rightNode;
		if(leftTree == null){
			leftNode = null;
		}
		else{
			leftNode = leftTree.root;
		}
		if(rightTree == null){
			rightNode = null;
		}
		else{
			rightNode = rightTree.root;
		}
		this.root = new BiTreeNode(leftNode,data,rightNode);
	}
	
	/**
	 * 将原来的树逆时针旋转90度打印
	 * @param root
	 * @param level 从第几层开始打印 根为0层
	 */
	public static void printBiTree(BiTreeNode root,int level){
		if(root != null){
			printBiTree(root.getRightChild(), level+1);
			if(level != 0){
				for (int i = 0; i < 6*(level-1); i++) {
					System.out.print(" ");
				}
				System.out.print("-----");
			}
			System.out.println(root.getData());
			printBiTree(root.getLeftChild(), level+1);
		}
	}
	
	/**
	 * 前序遍历
	 * @param root
	 */
	public static void preOrder(BiTreeNode root){
		if(root != null){
			System.out.print(root.getData()+" ");
			preOrder(root.getLeftChild());
			preOrder(root.getRightChild());
		}
	}
	/**
	 * 中序遍历
	 * @param root
	 */
	public static void inOrder(BiTreeNode root){
		if(root != null){
			inOrder(root.getLeftChild());
			System.out.print(root.getData()+" ");
			inOrder(root.getRightChild());
		}
	}
	/**
	 * 后序遍历
	 * @param root
	 */
	public static void postOrder(BiTreeNode root){
		if(root != null){
			postOrder(root.getLeftChild());
			postOrder(root.getRightChild());
			System.out.print(root.getData()+" ");
		}
	}
	
	/**
	 * 层次遍历
	 * @param root
	 */
	public static void levOrder(BiTreeNode root){
		Queue<BiTreeNode> queue = new LinkedList<BiTreeNode>();
		if(root == null){
			return;
		}
		BiTreeNode ourr;
		queue.add(root);
		while(!queue.isEmpty()){
			ourr = queue.remove();
			System.out.print(ourr.getData()+" ");
			if(ourr.getLeftChild() != null){
				queue.add(ourr.getLeftChild());
			}
			if(ourr.getRightChild() != null){
				queue.add(ourr.getRightChild());
			}
		}
	}
	
	/**
	 * 查找节点
	 * @param root
	 * @param obj
	 * @return
	 */
	public static BiTreeNode search(BiTreeNode root ,Object obj){
		BiTreeNode node = null;
		if(root == null){
			return null;
		}
		if(root.getData().equals(obj)){
			return root;
		}
		if(root.getLeftChild() != null){
			node = search(root.getLeftChild(), obj);
			if(node != null)
			{
				return node;
			}
		}
		if(root.getRightChild() != null){
			node = search(root.getRightChild(), obj);
			if(node != null)
			{
				return node;
			}
		}
		return node;
	}
	
	//翻转二叉树
	public static void reverse(BiTreeNode root)
	{
		BiTreeNode tempNode;
		tempNode = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(tempNode);
		
		if(root.getLeftChild() != null)
		{
			reverse(root.getLeftChild());
		}
		if(root.getRightChild() != null)
		{
			reverse(root.getRightChild());
		}
	}
}
