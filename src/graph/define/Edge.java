package graph.define;

/**
 * @decription:产生边的类
 * @version:
 * @date: 2016年10月28日下午10:30:32
 * @author: lfq
 * 
 */
public class Edge {
	
	private int v1;//顶点v1
	private int v2;//顶点v2
	private int weight;//边的权值
	public static final int maxWeight = -1;//没有权值
	
	public Edge(int v1, int v2, int weight) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public int getV1() {
		return v1;
	}

	public void setV1(int v1) {
		this.v1 = v1;
	}

	public int getV2() {
		return v2;
	}

	public void setV2(int v2) {
		this.v2 = v2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [v1=" + v1 + ", v2=" + v2 + ", weight=" + weight + "]";
	}
	
	
}
