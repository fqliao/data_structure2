package tree;
/**
 * 测试二叉树
 * @author lfq
 *
 */
public class Client {
	
	/**
	 * 构建树，从叶子节点到根节点构建
	 * @return
	 */
	public static BiTreeNode makeTree(){
		BiTreeNode a,b,c,d,e,f,g;
		g = new BiTreeNode(null, "G", null);
		d = new BiTreeNode(null,"D",g);
		b = new BiTreeNode(d,"B",null);
		e = new BiTreeNode(null,"E",null);
		f = new BiTreeNode(null,"F",null);
		c = new BiTreeNode(e,"C",f);
		a = new BiTreeNode(b,"A",c);
		return a;
	}
	public static void main(String[] args) {
		BiTreeNode root = makeTree();//构建树
		BiTree.printBiTree(root, 0);//打印树
		BiTree.preOrder(root);//前序遍历
		System.out.println();
		BiTree.inOrder(root);//中序遍历
		System.out.println();
		BiTree.postOrder(root);//后序遍历
		System.out.println();
		BiTree.levOrder(root);//层序遍历
		System.out.println();
		System.out.println(BiTree.search(root, "D"));//查找节点

	}

}
