package recursion;

public class Gcd {
	
	public static int gcd(int a,int b){
		if(a < 0){
			a = -a;
		}
		if(b < 0){
			b = -b;
		}
		if(b == 0 ){
			return a;
		}
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		return gcd(b,a%b);
		
	}
	public static void main(String[] args) {
		System.out.println(gcd(120,-250));

	}

}
