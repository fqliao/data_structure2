package recursion;

/**
 * 求解乘方运算
 * @author lfq
 *
 */
public class Pow {
	
	public static double pow(double x, int n){
		if(x == 1.0 || n == 0){
			return 1.0;
		}
		if(x == 0.0 || n == 1){
			return x;
		}

		if(n < 0){
			if(n == Integer.MIN_VALUE){
				++n;
				if(x < 0){
					x = -x;//保证为正数 因为Integer.MIN_VALUE为偶数，偶数的乘方为正数
				}
			}
			n = -n;
			x = 1.0/x;
		}
		return n%2 == 0 ? pow(x*x,n/2):x*pow(x*x,n/2);
	}
	
	public static void main(String[] args) {
		System.out.println(pow(-1, Integer.MIN_VALUE));

	}

}
