package tree.iterator;

import tree.BiTreeNode;

public class IteratorClient {
	
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
		BiTreeNode root = makeTree();
		System.out.println("前序遍历：");
		MyBiTreeIterator preIt = new PreIterator(root);

		for(preIt.reset();!preIt.getEndOfBiTree();preIt.next())
		{
			System.out.print(preIt.getData()+" ");
		}
		System.out.println();
		
		System.out.println("中序遍历：");
		MyBiTreeIterator inIt = new InIterator(root);
		
		for(inIt.reset();!inIt.getEndOfBiTree();inIt.next())
		{
			System.out.print(inIt.getData()+" ");
		}
		System.out.println();
		
		System.out.println("后序遍历：");
		MyBiTreeIterator postIt = new PostIterator(root);
		
		for(postIt.reset();!postIt.getEndOfBiTree();postIt.next())
		{
			System.out.print(postIt.getData()+" ");
		}
		System.out.println();
		
		System.out.println("层序遍历：");
		MyBiTreeIterator levelIt = new LevelIterator(root);
		
		for(levelIt.reset();!levelIt.getEndOfBiTree();levelIt.next())
		{
			System.out.print(levelIt.getData()+" ");
		}
		System.out.println();

	}

}
