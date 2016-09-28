package recursion;

import java.util.Arrays;

/**
 * 二分查找
 * @author Administrator
 *
 */
public class BinarySearch {

	public static int find(int[] arr,int value,int start,int end){
		if(start > end){
			return -1;
		}
		int mid = (start+end)/2;
		if(value == arr[mid]){
			return mid;
		}
		if(value > arr[mid]){
			return find(arr, value, mid+1, end);
		}
		else if(value < arr[mid]){
			return find(arr, value, start, mid-1);
		}
		else{
			return arr[mid];
		}
	}
	
	public static int find(int[] arr,int value){
		return find(arr, value, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,6,8,2};
		Arrays.sort(arr);
		System.out.println(find(arr, 9));

	}

}
