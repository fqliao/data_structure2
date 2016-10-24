package tree;
public class Node  
{  
    private Object data;  
    private Node left;  
    private boolean leftIsThread;        // 左孩子是否为线索  
    private Node right;  
    private boolean rightIsThread;       // 右孩子是否为线索  
  
    public Node(Object data)  
    {  
        this.data = data;  
        this.left = null;  
        this.leftIsThread = false;  
        this.right = null;  
        this.rightIsThread = false;  
    }  
  
    public Object getData()  
    {  
        return data;  
    }  
  
    public void setData(Object data)  
    {  
        this.data = data;  
    }  
  
    public Node getLeft()  
    {  
        return left;  
    }  
  
    public void setLeft(Node left)  
    {  
        this.left = left;  
    }  
  
    public boolean isLeftIsThread()  
    {  
        return leftIsThread;  
    }  
  
    public void setLeftIsThread(boolean leftIsThread)  
    {  
        this.leftIsThread = leftIsThread;  
    }  
  
    public Node getRight()  
    {  
        return right;  
    }  
  
    public void setRight(Node right)  
    {  
        this.right = right;  
    }  
  
    public boolean isRightIsThread()  
    {  
        return rightIsThread;  
    }  
  
    public void setRightIsThread(boolean rightIsThread)  
    {  
        this.rightIsThread = rightIsThread;  
    }  
  
    @Override  
    public boolean equals(Object obj)  
    {  
        if (obj instanceof Node)  
        {  
            Node temp = (Node) obj;  
            if (temp.getData() == this.data)  
            {  
                return true;  
            }  
        }  
        return false;  
    }  
  
    @Override  
    public int hashCode()  
    {  
        return super.hashCode() + Integer.parseInt(this.data.toString());  
    }  
    
	@Override
	public String toString() {
		return "[Node=" + data + "]";
	}  
}  


