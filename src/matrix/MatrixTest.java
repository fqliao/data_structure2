package matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void test() throws Exception {
//		int[][] Array1 = {{1,2,3},{4,5,3}};
//		int[][] Array2 = {{1,2},{4,3},{2,4}};
//		Matrix m1 = new Matrix(Array1);
//		Matrix m2 = new Matrix(Array2);
//		m1.printMatrix();
//		m2.printMatrix();
//		m1.add(m2);
//		m1.printMatrix();
//		m1.subtract(m2);
//		m1.printMatrix();
//		Matrix m2 = m1.transpose();
//		m2.printMatrix();
//		Matrix m3 = m1.multiply(m2);
//		m3.printMatrix();
		Matrix m = new Matrix(3);
		m.printUpTriangle();
		m.printDownTriangle();
	}

}
