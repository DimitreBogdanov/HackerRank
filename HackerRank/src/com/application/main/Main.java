package com.application.main;

import java.util.Scanner;

@SuppressWarnings(value = { "unused" })
public class Main {

	private static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		
		xorAndSum();
		
		
		in.close();
	}
	
	private static void xorAndSum(){
		int a = in.nextInt();
		int b = in.nextInt();
		
		
	}
	
	private static void circularRotation(){
        //elements
        int n = in.nextInt();
        //rotations
        int k = in.nextInt();
        //queries
        int q = in.nextInt();
        int rotation=k%n;
        int[] a = new int[n];
        
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < q; i++){
        	int num = in.nextInt();
        	if(num-rotation >= 0){
        		System.out.println(a[num-rotation]);
        	}else{
        		System.out.println(a[num-rotation+a.length]);
        	}
        }
	}

}
