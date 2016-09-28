package recursion;

/**
 * 求波列纳契数列之和
 * @author Administrator
 *
 */
public class Fibonacci {
	
	public static int getNum(int n){
		if(n == 1){
			return 1;
		}
		else if(n == 2){
			return 1;
		}
		else{
			return getNum(n-2)+getNum(n-1);
		}
	}
	
	public static long sum(int n){
		long sum = 0L;
		for (int i = 1; i <= n; i++) {
			sum += getNum(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(sum(50));

	}

}
