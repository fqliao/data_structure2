package tree.haffmanTree;

public class Client {
	
	public static void main(String[] args) {
		int[] weight = {1,3,5,7};
		int n = weight.length;
		HaffmanTree haffTree = new HaffmanTree(n);
		HaffNode[] haffNode = new HaffNode[2*n-1];
		Code[] codes = new Code[n];
		
		haffTree.haffman(weight, haffNode);
		
		haffTree.haffmanCode(haffNode, codes);
		
		for(int i = 0; i < n; i++)
		{
			System.out.print("weight = "+codes[i].weight+" Code = ");
			for (int j = codes[i].start+1; j < n; j++) 
			{
				System.out.print(codes[i].bit[j]);
			}
			System.out.println();
		}
		
	}
}
