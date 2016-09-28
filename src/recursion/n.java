package recursion;
/**
 * 递归算法求n的阶乘
 * @author Administrator
 *
 */
public class n {
	public static long factorial(int n) {
		//特解 递归出口
		if(n == 1){
			return 1;
		}
		else{//递归公式
			return n*factorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(6));
	}
}
