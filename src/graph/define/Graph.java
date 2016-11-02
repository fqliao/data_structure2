package graph.define;

import java.util.LinkedList;
import java.util.List;

/**
 * @decription:图类
 * @version:1.0
 * @date: 2016年10月28日下午10:15:31
 * @author: lfq
 * 
 */
public class Graph<T> {
	
	private List<T> vertex;//列表存放顶点
	private int n;//顶点个数
	private List<Edge> edge;//列表存放的边来初始化邻接矩阵
	private int m;//边的条数
	private int[][] matrix;//邻接矩阵，存放所有顶点和边的关系
	
	public Graph(){
		
	}
	public Graph(List<T> vertex, List<Edge> edge) throws Exception {
		super();
		this.vertex = vertex;
		this.edge = edge;
		createMatrix();//将边的信息设置到邻接矩阵中
	}
	
	private void createMatrix() throws Exception {
		n = vertex.size();
		m = edge.size();
		matrix = new int[n][n];//创建大小n*n的邻接矩阵
		//初始化邻接矩阵
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				if(i == j)
					matrix[i][j] = 0;
				else
					matrix[i][j] = Edge.maxWeight;
			}
		}
		//用列表存放的边设置到邻接矩阵中
		for (int i=0; i < m; i++) 
		{
			int v1 = edge.get(i).getV1();
			int v2 = edge.get(i).getV2();
			if(v1 < 0 || v1 >= n || v2 < 0 || v2 >= n)
				throw new Exception("顶点序号越界");
			matrix[v1][v2] = edge.get(i).getWeight();
		}
	}
	
	//打印邻接矩阵
	public void printMatrix(){
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	//返回边数
	public int getNumOfEdge(){
		return m;
	}
	
	//返回节点数
	public int getNumOfVertex(){
		return n;
	}
	
	//返回结点的值
	public T getValue(int index)
	{
		return vertex.get(index);
	}
	
	//获得某条边的权值
	public int getWeight(T start,T end) throws Exception{
		int v1 = vertex.indexOf(start);
		int v2 = vertex.indexOf(end);
		if(v1 < 0 || v1 >= n || v2 < 0 || v2 >= n)
			throw new Exception("没有该顶点");

		return matrix[v1][v2];
	}
	
	//增加边
	public void addEdge(T start,T end ,int weight) throws Exception{

		if(weight == Edge.maxWeight)
			throw new Exception("权值不能为"+Edge.maxWeight);
		int v1 = vertex.indexOf(start);
		if(v1 == -1)
			throw new Exception("弧尾不存在");
		int v2 = vertex.indexOf(end);
		if(v2 == -1 )
			throw new Exception("弧头不存在");
		
		edge.add(new Edge(v1, v2, weight));
		matrix[v1][v2] = weight;
		
	}
	
	//删除边
	public void deleteEdge(T start,T end) throws Exception{

		int v1 = vertex.indexOf(start);
		if(v1 == -1)
			throw new Exception("弧尾不存在");
		int v2 = vertex.indexOf(end);
		if(v2 == -1 )
			throw new Exception("弧头不存在");
		//边列表删除边
		for (Edge e : edge) 
		{
			if(e.getV1() == v1 && e.getV2() == v2)
			{
				edge.remove(e);
				break;//这里要终止，因为删除了数据，再迭代就出现java.util.ConcurrentModificationException
			}
		}
//		edge.remove(new Edge(v1,v2,matrix[v1][v2]));
		//对应遍的权值设置为最大
		matrix[v1][v2] = Edge.maxWeight;
	}
	
	//插入新顶点和边
	public void insertVertex(T start,T end,int weight) throws Exception{
		//判断参数的合法性
		if(!vertex.contains(start))
			throw new Exception("狐尾不存在");
		if(vertex.contains(end))
			throw new Exception("新增顶点已存在");
		if(weight == Edge.maxWeight)
			throw new Exception("权值不能为"+Edge.maxWeight);
		//顶点加入顶点列表
		vertex.add(end);
		//边加入边列表
		edge.add(new Edge(vertex.indexOf(start),n,weight));
		//创建新的邻接矩阵
		createMatrix();
		
	}
	
	//删除顶点和边
	public void deleteVertex(T end) throws Exception{
		//判断参数的合法性
		int v2 = vertex.indexOf(end);
		if(v2 == -1 )
			throw new Exception("顶点不存在");
		
		//删除顶点列表中的该顶点
		vertex.remove(end);
		
		//创建要删除边（弧）的list
		List<Edge> edgesDel = new LinkedList<>();
		//查找该顶点牵连的边
		for (Edge e : edge) 
		{
			if(e.getV1() == v2 || e.getV2() == v2)
			{
				edgesDel.add(e);
			}
		}
		//删除边
		edge.removeAll(edgesDel);
		
		//创建新的邻接矩阵
		createMatrix();
		
	}
	
	
	
}
