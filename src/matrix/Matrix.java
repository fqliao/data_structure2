package matrix;

import java.awt.image.RescaleOp;
import java.util.Random;

public class Matrix {
	
	private int[][] matrix;
	private Random random;
	
	//利用可变参数，代替方法重载！（只能对参数类型相同，个数不同的方法重载进行代替）
	public Matrix(int... args) throws Exception{
		int num = args.length;
		switch(num){//多用switch 少用if
			case 0:
				matrix = new int[2][2];
				break;
			case 1:
				matrix = new int[args[0]][args[0]];//给定参数n,生成n阶方阵
				break;
			case 2:
				matrix = new int[args[0]][args[1]];//给定参数m,n生成m行n列矩阵
				break;
			default:
				throw new Exception("参数个数只能0，1，2");
		}
	}
	
	public Matrix(int[][] m) throws Exception{
		matrix = m;
	}
	
	
	/**
	 * 矩阵相加
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public Matrix add(Matrix m) throws Exception{
		if (isLevel(this, m)) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] += m.matrix[i][j];
				}
			}
		}
		else{
			throw new Exception("矩阵的阶不一样，不能相加！");
		}
		return this;
	}
	/**
	 * 矩阵相减
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public Matrix subtract(Matrix m) throws Exception{
		if (isLevel(this, m)) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] -= m.matrix[i][j];
				}
			}
		}
		else{
			throw new Exception("矩阵的阶不一样，不能相减！");
		}
		return this;
	}
	
	/**
	 * 矩阵转置
	 * @return
	 * @throws Exception
	 */
	public Matrix transpose() throws Exception{
		int s = matrix.length;
		int t = matrix[0].length;
		Matrix m = new Matrix(t,s);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				m.matrix[j][i] = matrix[i][j];
			}
		}
		return m;
	}
	
	/**
	 * 矩阵相乘
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public Matrix multiply(Matrix m) throws Exception{//列与行要相等
		int num1 = matrix[0].length;//列
		int num2 = m.matrix.length;//行
		Matrix result;
		if (num1 != num2) {//列行不等
			throw new Exception("列行不等，不能相乘！");
		}
		else{
			result = new Matrix(matrix.length,m.matrix[0].length);//相乘后的矩阵行由第一个矩阵的行决定，列由第二个矩阵的列决定
			for (int i = 0; i < result.matrix.length; i++) {
				for (int j = 0; j < result.matrix[0].length; j++) {
					for (int k = 0; k < matrix[0].length; k++) {
						result.matrix[i][j] += matrix[i][k]*m.matrix[k][j];
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 判断两个矩阵的阶是否相等
	 * @param m1
	 * @param m2
	 * @return
	 */
	public boolean isLevel(Matrix m1,Matrix m2){
		int num1 = m1.matrix.length;
		int num2 = m2.matrix.length;
		if (num1 != num2) {//行不等
			return false;
		}
		else{
			if(m1.matrix[0].length != m2.matrix[0].length){//列不等
				return false;
			}
			else{
				return true;
			}
		}
	}
	
	/**
	 * 上三角
	 * @param n
	 */
	public void printUpTriangle(){
		random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(i >= j){
					matrix[i][j] = random.nextInt(10);
				}else{
					matrix[i][j] = 0;
				}
			}
		}
		printMatrix();
	}
	/**
	 * 下三角
	 * @param n
	 */
	public void printDownTriangle(){
		random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(i <= j){
					matrix[i][j] = random.nextInt(10);
				}else{
					matrix[i][j] = 0;
				}
			}
		}
		printMatrix();
	}
	
	public int[][] matrix(){
		return matrix;
	}
	
	public  void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
