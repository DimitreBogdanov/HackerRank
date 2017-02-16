package com.application.main;

import java.util.Scanner;
import java.text.*;

@SuppressWarnings(value = { "unused" })
public class Main {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);

candies();
		
		in.close();
	}
	
	private static void candies(){
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = in.nextInt();
		}
		int count = 1;
		int amount = 1;
		boolean more = false;
		for(int i = 1; i < n; i++){
//			if(a[i] > a[i+1] || (i > 1 && a[i-1] < a[i])){
//				count +=2;
//			}else{
//				count +=3;
//				i++;
//			}
			
			if(a[i] > a[i-1]){
				amount++;
			}else{
				amount = 1;
			}
			count += amount;
		}
		
		System.out.println(count);
	}

	static int sum = 0;

	private static void verticalSticks() {
		int t = in.nextInt();
		DecimalFormat df = new DecimalFormat("#,###,##0.00");

		for (int i = 0; i < t; i++) {
			sum = 0;
			int n = in.nextInt();
			int[] y = new int[n];

			for (int j = 0; j < n; j++) {
				y[j] = in.nextInt();
			}

			permute(y, 0);

			System.out.println(df.format((double) sum / factorial(n)));
		}

	}

	private static void sherlock() {

		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int s = 0;
			int n = in.nextInt();
			int[] b = new int[n];

			for (int j = 0; j < n; j++) {
				b[j] = in.nextInt();
			}

			for (int k = 1; k < n; k++) {
				if (b[k] > b[k - 1]) {
					s += Math.abs(b[k] - 1);
				} else {
					s += Math.abs(1 - b[k - 1]);
				}
			}
			System.out.println(s);
		}

	}

	private static void equal() {
		int cases = in.nextInt();

		for (int i = 0; i < cases; i++) {
			int count = in.nextInt();
			int[] interns = new int[count];
			int high = 0;
			int low = 0;
			for (int j = 0; j < count; j++) {
				interns[j] = in.nextInt();
			}
		}
	}

	private static void xorAndSum() {
		int a = in.nextInt();
		int b = in.nextInt();

	}

	private static void circularRotation() {
		// elements
		int n = in.nextInt();
		// rotations
		int k = in.nextInt();
		// queries
		int q = in.nextInt();
		int rotation = k % n;
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		for (int i = 0; i < q; i++) {
			int num = in.nextInt();
			if (num - rotation >= 0) {
				System.out.println(a[num - rotation]);
			} else {
				System.out.println(a[num - rotation + a.length]);
			}
		}
	}

	private static int max(int... nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
		}
		return max;
	}

	private static void permute(int[] arr, int k) {
		for (int i = k; i < arr.length; i++) {
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;

			permute(arr, k + 1);

			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
		}

		if (k == arr.length - 1) {
			int totalCount = 0;
			for (int j = arr.length - 1; j >= 0; j--) {
				int count = 1;
				for (int t = j - 1; t >= 0; t--) {
					if (arr[t] < arr[j])
						count++;
					else
						break;
				}
				totalCount += count;
			}
			sum += totalCount;
		}

	}
	
	private static void swap(int[] a, int i, int j) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}

	private static int factorial(int n) {
//		if (n <= 1)
//			return 1;
//		return n * factorial(n - 1);
		
		int sum = n;
		while(n > 1){
			sum *=  (--n);
		}
		return sum;
	}

}
