package tree;
public class TreeClient  
{  
    public static void main(String[] args)  
    {  
        int[] data = { 1, 2, 3, 4, 5, 6, 7};  
          
        Tree tree = new Tree(data); // 根据层序创建普通二叉树  
        Node root = tree.getRoot();
		tree.printTree(root, 0); // 打印树
        
        tree.levOrder(root); //层次遍历
        
        tree.preOrder(root); // 前序遍历
        System.out.println();
        
        tree.inOrder(root);  // 中序遍历
        System.out.println();
        
        tree.postOrder(root);// 后序遍历
        System.out.println();
        
        System.out.println(tree.find(root, 1)); //查找
//        tree.overturn(root);//翻转二叉树
//        tree.printTree(root, 0);
        tree.inThread(root);  // 中序遍历将二叉树线索化  
        tree.inThreadOrder(root);// 中序遍历线索化二叉树  
       
        
    }  
}  