package tree;

/**
 * @decription:卡特兰数列，通项f(n)=C(n,2n)/n+1=(2n)!/(n!*(2n-n)!*(n+1))=(2n)!/((n!)^2*(n+1))
 * 利用递归求解，递归公司用f(n)/f(n-1)就可以求出来
 * n个节点构成f(n)中结构的二叉树，f(n)是卡特兰数
 * @version:1.0
 * @date: 2016年10月21日下午2:58:48
 * @author: lfq
 * 
 */
public class Catalan {

	public static int catalan(int n) {
		if (n == 1) {
			return 1;
		} else {
			return catalan(n - 1) * 2 * (2 * n - 1) / (n + 1);
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 8; i++) {
			System.out.println(i + ": " + catalan(i));
		}
	}

}
