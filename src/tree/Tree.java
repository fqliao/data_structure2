package tree;  

import java.util.LinkedList;
import java.util.Queue;
  
public class Tree  
{  
    private Node root;         // 根节点  
    private int size;          // 大小  
    private Node pre = null;   // 线索化的时候保存前驱  
  
    public Tree()  
    {  
        this.root = null;  
        this.size = 0;  
        this.pre = null;  
    }  
  
    public Tree(int[] data)  
    {  
        this.pre = null;  
        this.size = data.length;  
        this.root = createTree(data, 1);   // 创建二叉树  
    }  
  
    /** 
     * 按层序创建二叉树 
     *  
     */  
    public Node createTree(int[] data, int i)  
    {  
        if (i > data.length)  
        {  
            return null;  
        }  
        Node node = new Node(data[i - 1]);  
        Node left = createTree(data, 2 * i);  
        Node right = createTree(data, 2 * i + 1);  
        node.setLeft(left);  
        node.setRight(right);  
        return node;  
    }
    /**
     * 打印树 右根左
     * @param root
     * @param level
     */
    public void printTree(Node root,int level){
    	if(root != null)
    	{
    		printTree(root.getRight(),level+1);
    		if(level != 0)
    		{
    			for (int i = 0; i < 6*(level-1); i++) 
    			{
    				System.out.print(" ");//注意，这里打印不能换行
    			}
    			System.out.print("------");//注意，这里打印不能换行
    		}
    		System.out.println(root.getData());
    		printTree(root.getLeft(), level+1);
    	}
    	
    }
  
    /**
	 * 层次遍历,利用队列结构
	 * @param root
	 */
	public  void levOrder(Node root){
		if(root == null){//首先判断根节点是否为null
			return;
		}
		//初始化队列
		Queue<Node> queue = new LinkedList<>();
		
		Node curr;//当前节点
		queue.add(root);//首先加入根节点
		while(!queue.isEmpty())
		{	//队列不为空，就遍历输出
			curr = queue.remove();
			System.out.print(curr.getData()+" ");
			
			//递归遍历左右子树
			if(curr.getLeft() != null){
				queue.add(curr.getLeft());
			}
			if(curr.getRight() != null){
				queue.add(curr.getRight());
			}
		}
		System.out.println();
	}  
  
    /** 
     * 前序遍历递归算法 
     *  
     */  
    public void preOrder(Node root)  
    {  
        if (root != null)  
        {  
            System.out.print(root.getData() + " ");  
            preOrder(root.getLeft());  
            preOrder(root.getRight());  
        }
    }  
  
    /** 
     * 中序遍历 
     *  
     */  
    public void inOrder(Node root)  
    {  
        if (root != null)  
        {  
        	inOrder(root.getLeft());  
            System.out.print(root.getData() + " ");  
            inOrder(root.getRight());  
        } 
    }  
    /** 
     * 后序遍历 
     *  
     */  
    public void postOrder(Node root)  
    {  
    	if (root != null)  
    	{  
    		postOrder(root.getLeft());  
    		postOrder(root.getRight());  
    		System.out.print(root.getData() + " ");  
    	}  
    }  
    
    //查找
    public Node find(Node root,Object obj)
    {	
    	Node node = null;
    	if(root == null || obj == null)//先判断树或查找对象是否为null
    	{
    		return null;
    	}
    	if(root.getData().equals(obj))//判断是否匹配根
    		return root;
    	if(root.getLeft() != null)//判断是否匹配左子树，递归匹配
    	{
    		node = find(root.getLeft(), obj);
    		if(node != null)
    			return node;
    	}
    	if(root.getRight() != null)//判断是否匹配右子树，递归匹配
    	{
    		node = find(root.getRight(), obj);
    		if(node != null)
    			return node;
    	}
    	return node;
    }
    /**
     * 翻转二叉树
     * @param root
     */
    public void overturn(Node root){
    	if(root != null)//首先判断树是否为空
    	{
    		//交换左右孩子
    		Node temp = root.getLeft();
    		root.setLeft(root.getRight());
    		root.setRight(temp);
    		
    		//递归左右子树
    		if(root.getLeft() != null)
    			overturn(root.getLeft());
    		if(root.getRight() != null)
    			overturn(root.getRight());
    	}
    }
    
    //求二叉树的深度
    public  int depth(Node root){
        if(root == null)  
            return 0;  
        int left = depth(root.getLeft());  
        int right = depth(root.getRight());  
        return (left > right)?(left+1):(right+1); 
    }
    
    /** 
     * 将以root为根节点的二叉树线索化 
     *  
     */  
    public void inThread(Node root)  
    {  
        if (root != null)  
        {  
            inThread(root.getLeft());     // 线索化左孩子  
            if (root.getLeft() == null)   // 左孩子为空  
            {  
                root.setLeftIsThread(true);    // 将左孩子设置为线索  
                root.setLeft(pre);  
            }  
            if (pre != null && pre.getRight() == null)  // 右孩子为空  
            {  
                pre.setRightIsThread(true);  
                pre.setRight(root);  
            }  
            pre = root;  
            inThread(root.getRight());       // 线索化右孩子  
        }  
    }  
  
    /** 
     * 中序遍历线索二叉树 
     *  
     */  
    public void inThreadOrder(Node root)  
    {  
        if (root != null)  
        {  
            while (root != null && !root.isLeftIsThread())//如果左孩子不是线索  
            {       
                root = root.getLeft();  
            }  
  
            do  
            {  
                System.out.print(root.getData() + " ");  
                if (root.isRightIsThread())   // 如果右孩子是线索  
                {          
                    root = root.getRight();  
                }   
                else         // 有右孩子   
                {        
                    root = root.getRight();  
                    while (root != null && !root.isLeftIsThread())  
                    {  
                        root = root.getLeft();  
                    }  
                }  
            } while (root != null);  
        }  
    }
    
    public Node getRoot()  
    {  
        return root;  
    }  
  
    public void setRoot(Node root)  
    {  
        this.root = root;  
    }  
  
    public int getSize()  
    {  
        return size;  
    }  
  
    public void setSize(int size)  
    {  
        this.size = size;  
    }

  
}  