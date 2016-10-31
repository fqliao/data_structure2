package tree.iterator;

import tree.Node;
import tree.Tree;


public class IteratorClient {
	
	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7};  
		Tree tree = new Tree(data);
		Node root = tree.getRoot();
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
