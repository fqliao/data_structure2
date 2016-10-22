package tree;

/**
 * @decription:测试二叉树
 * @version:1.1
 * @date: 2016年10月22日下午7:21:07
 * @author: lfq
 * 
 */
public class Client {
	
	public static void main(String[] args) {
		
		//前序遍历序列，其中#号是扩展的
		String[] preOrderStr = {"A","B","#","D","#","#","C","#","#"};
		//构建二叉树
		BiTreeNode tree = BiTree.createBtree(preOrderStr);
		BiTree.printBiTree(tree, 0);
		System.out.println("层序：");
		BiTree.levOrder(tree);
		System.out.println();
		System.out.println("前序：");
		BiTree.preOrder(tree);
		System.out.println();
		System.out.println("中序：");
		BiTree.inOrder(tree);
		System.out.println();
		System.out.println("后序：");
		BiTree.postOrder(tree);
		System.out.println();
		//查找节点
		System.out.println(BiTree.search(tree, "A"));
		//翻转二叉树
		BiTree.reverse(tree);
		System.out.println();
		BiTree.printBiTree(tree, 0);
	}

}
