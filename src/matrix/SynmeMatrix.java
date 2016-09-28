package matrix;
/**
 * 对称矩阵
 * @author Administrator
 *
 */
public class SynmeMatrix {
	private int[] matrix;//矩阵元素 用一个一维数组来表示
	private int n;//列
	private int m;//行

	public SynmeMatrix(int n) {
		//需要保持元素的个数
		this.n = n;
		int m = n*(n+1)/2;
		matrix = new int[m];
	}
	//通过一个二维数组初始化
	public void evaluate(int[][] arr){
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i >= j){
					matrix[k++] = arr[i][j];//只保留下三角元素
				}
			}
		}
	}
	
	//通过一维数组初始化
	public void evaluate(int[] b)
	{
		for(int k=0;k<b.length;k++)
		{
			matrix[k]= b[k];
		}
	}
	
	//对称矩阵相加
	public SynmeMatrix add(SynmeMatrix b)
	{
	   for (int i = 0; i < b.matrix.length; i++) {
		matrix[i] += b.matrix[i];
	   }
	   return this;
	}
	
	//打印对称矩阵
	public void print()
	{
	   int k;
	   for(int i=1;i<=n;i++)
	   {
		   for(int j=1;j<=n;j++)
		   {
			   if(i>=j)
			   {
				   k= i*(i-1)/2+j-1;
			   }
			   else
			   {
				   k= j*(j-1)/2+i-1;
			   }
			   System.out.print(" "+matrix[k]);
		   }
		   System.out.println();
	   }
	}
}
