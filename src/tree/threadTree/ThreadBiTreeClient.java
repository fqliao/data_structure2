package tree.threadTree;

public class ThreadBiTreeClient {

	public static void main(String[] args) {
		ThreadBiTree tree = new InThreadBiTree();
		tree.initBiTree();
		tree.createThreadBiTree();
		System.out.println("中序遍历结果：");
		tree.traversal();
	}

}
