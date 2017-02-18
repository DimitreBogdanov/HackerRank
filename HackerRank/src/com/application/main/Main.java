package com.application.main;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.application.structures.Queue;
import com.sun.xml.internal.ws.util.StringUtils;

@SuppressWarnings(value = { "unused" })
public class Main {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);

		queueUsingStacks();

		in.close();
	}

	// https://www.hackerrank.com/challenges/queue-using-two-stacks
	private static void queueUsingStacks() {
		int q = in.nextInt();

		Queue<Integer> queue = new Queue<Integer>();
		
		for (int i = 0; i < q; i++) {
			int type = in.nextInt();

			switch (type) {
			case 1:
				int num = in.nextInt();
				queue.enqueue(num);
				break;
			case 2:
				queue.dequeue();
				break;
			default:
				System.out.println(queue.front());
				break;
			}
		}
	}

	// https://www.hackerrank.com/challenges/maximum-element
	private static void maxStackElement() {

		int n = in.nextInt();

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			switch (in.nextInt()) {
			case 1:
				int num = in.nextInt();
				stack.push(num);
				break;
			case 2:
				stack.pop();
				break;
			case 3:
				System.out.println(sort(stack).pop());
				break;
			default:
				break;
			}
		}
	}

	private static Stack<Integer> sort(Stack<Integer> s) {

		if (s.isEmpty()) {
			return s;
		}
		int pivot = s.pop();

		// partition
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		while (!s.isEmpty()) {
			int y = s.pop();
			if (y < pivot) {
				left.push(y);
			} else {
				right.push(y);
			}
		}
		sort(left);
		sort(right);

		// merge
		Stack<Integer> tmp = new Stack<Integer>();
		while (!right.isEmpty()) {
			tmp.push(right.pop());
		}
		tmp.push(pivot);
		while (!left.isEmpty()) {
			tmp.push(left.pop());
		}
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		return s;
	}

	// https://www.hackerrank.com/challenges/crush
	// Works but is too slow for some test cases
	private static void crush() {

		int n = in.nextInt();
		int m = in.nextInt();

		long max = Long.MIN_VALUE;

		long[] arr = new long[n];

		for (int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			long k = in.nextInt();

			for (int j = a - 1; j < b; j++) {
				long newValue = arr[j] + k;
				arr[j] = newValue;
				if (newValue > max)
					max = newValue;
			}
		}

		System.out.println(max);

	}

	// https://www.hackerrank.com/challenges/dynamic-array
	// Does not pass all tests
	private static void dynamicArray() {

		int n = in.nextInt();
		int q = in.nextInt();

		List<List<Integer>> seqList = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			seqList.add(new ArrayList<Integer>());
		}

		int lastAns = 0;

		for (int i = 0; i < q; i++) {
			int num = in.nextInt();

			int x = in.nextInt();
			int y = in.nextInt();

			int index = (xor(x, lastAns) % n);

			if (num == 1) {
				seqList.get(index).add(y);
			}
			if (num == 2) {
				System.out.println("Size: " + seqList.get(index).size());
				int result = y % seqList.get(index).size();
				lastAns = seqList.get(index).get(result);
				System.out.println(lastAns);
			}
		}
	}

	private static int xor(int a, int b) {
		// if((a == 1 && b == 0) || (a == 0 && b == 1)){
		// return 1;
		// }
		// return 0;

		if (a == b) {
			return 0;
		}
		return 1;
	}

	// https://www.hackerrank.com/challenges/2d-array
	private static void hourglass() {

		int row = 6;
		int col = 6;
		int[][] graph = new int[6][6];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				graph[i][j] = in.nextInt();

		// [1][1] to [4][4] is the middle of an hourglass

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= row - 2; i++) {
			for (int j = 1; j <= col - 2; j++) {
				int a0 = graph[i][j];

				int a1 = graph[i - 1][j - 1];
				int a2 = graph[i - 1][j];
				int a3 = graph[i - 1][j + 1];

				int a4 = graph[i + 1][j - 1];
				int a5 = graph[i + 1][j];
				int a6 = graph[i + 1][j + 1];

				int sum = a0 + a1 + a2 + a3 + a4 + a5 + a6;

				if (sum > max)
					max = sum;
			}
		}

		System.out.println(max);

	}

	// https://www.hackerrank.com/challenges/arrays-ds
	private static void arrayDS() {

		int n = in.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = n - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}

	}

	// https://www.hackerrank.com/challenges/abbr
	// Incompleted
	private static void abbreviation() {
		int q = in.nextInt();

		for (int i = 0; i < q; i++) {
			// Uppercase and lowercase
			String a = in.next();
			// Only uppercase
			String b = in.next();

			List<Integer> positions = new ArrayList<Integer>();

			// if a contains the string of b => might need to check individual
			// letters

			// first start by checking if the whole string is there , remove the
			// string from a and see if the rest are all lowercase
			// and then test that code, if it doesn't work, might need to check
			// individual characters

			// Go through all the characters in B, if it is not present in A get
			// out with false
			// If it is present, add the index to the 'positions' list
			// If it is present but the index is already in 'positions', check
			// for after that
			// At the end, replace all with space, then trim space and check if
			// remaining letters are lower case only,
			// if not return with false
			char[] array = b.toCharArray();
			for (int j = 0; j < array.length; j++) {

				char c = array[j];
				int index = a.toLowerCase().indexOf(Character.toString(Character.toLowerCase(c)));

				if (index < 0) {
					System.out.println("NO");
					continue;
				} else {
					while (positions.contains(index)) {
						index = a.toLowerCase().lastIndexOf(Character.toString(Character.toLowerCase(c)), index + 1);
					}
					if (index < 0) {
						System.out.println("NO");
						continue;
					} else {
						positions.add(index);
					}
				}
			}

			for (int num : positions) {
				char[] arr = a.toCharArray();
				arr[num] = ' ';
				a = String.copyValueOf(arr);
			}

			a = a.replace(" ", "");

			if (isLowerCase(a)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		} // end outer for

		// return true;
	}

	private static boolean isLowerCase(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isLowerCase(c))
				return false;
		}
		return true;
	}

	// https://www.hackerrank.com/challenges/fibonacci-modified
	// up to 32 bit
	private static float modifiedFibonnaci(int first, int second, int n) {

		if (n == 1)
			return first;

		if (n == 2)
			return second;

		return (float) (modifiedFibonnaci(first, second, n - 2) + Math.pow(modifiedFibonnaci(first, second, n - 1), 2));

	}

	// https://www.hackerrank.com/challenges/fibonacci-modified
	// above 64 bit
	private static BigInteger modifiedFib(int first, int second, int n) {
		if (n == 1)
			return BigInteger.valueOf(first);
		if (n == 2)
			return BigInteger.valueOf(second);

		return modifiedFib(first, second, n - 2).add(modifiedFib(first, second, n - 1).pow(2));
	}

	// Incomplete
	private static void candies() {
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int count = 1;
		int amount = 1;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				amount++;
			} else {
				if (i < n - 1 && a[i] > a[i + 1]) {
					amount--;
				} else {
					amount = 1;
				}

				// amount = 1;
				// if(i < n-1 && a[i+1] < a[i]){
				// amount++;
				// }
			}
			count += amount;
		}

		System.out.println(count);
	}

	static int sum = 0;

	// Incomplete
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

	// Incomplete
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

	// Incomplete
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

	// Incomplete
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
		// if (n <= 1)
		// return 1;
		// return n * factorial(n - 1);

		int sum = n;
		while (n > 1) {
			sum *= (--n);
		}
		return sum;
	}

}
