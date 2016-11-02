package graph.define;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Client {

	public static void main(String[] args) throws Exception {
		//准备顶点和边
		String[] vertexArr = new String[]{"A","B","C","D","E"};
		List<String> vertex = new LinkedList<>(Arrays.asList(vertexArr));
		Edge[] edgeArr = new Edge[]{new Edge(0,1,10),new Edge(0,4,20),new Edge(1,3,30),new Edge(3,2,50),new Edge(2,1,40),};
		List<Edge> edge = new LinkedList<>(Arrays.asList(edgeArr));
		
		//创建图
		Graph<String> graph = new Graph<String>(vertex, edge);
		
		//打印图
		graph.printMatrix();
		System.out.println(graph.getNumOfVertex());
		System.out.println(graph.getNumOfEdge());
		System.out.println(graph.getValue(2));
		System.out.println(graph.getWeight("B", "D"));
		
		//增加边
		graph.addEdge("B", "A", 12);
		graph.printMatrix();
		
		//删除边
		graph.deleteEdge("A", "B");
		graph.printMatrix();
		
		//新增顶点 边
		graph.insertVertex("E", "F", 15);
		graph.printMatrix();
		
		//删除顶点
		graph.deleteVertex("F");
		graph.printMatrix();

	}

}
