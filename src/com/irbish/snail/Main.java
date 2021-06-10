package com.irbish.snail;

import java.util.Scanner;

public class Main {

	public static final String 	ANSI_RED = "\u001B[31m";
	public static final String 	ANSI_RESET = "\u001B[0m";
	public static final String 	simvol = "*";
	public static final int		randomCoef = 100;
	public static final int		frameCoef = 5;

	private static void	drawFrame(int i){
		System.out.println();
		while(i-- != 0){
			System.out.print(simvol);
		}
		System.out.println(simvol);
	}
	private static int	enterParams(String message){
		var in = new Scanner(System.in);
		System.out.print(message);
		return in.nextInt();
	}
	private static void arrCreate(int m,int n, Integer[][] arr){
		int i = 1;
		int j = 1;
		drawFrame(n * frameCoef);
		while (i <= m){
			j = 1;
			System.out.print(simvol);
			while (j <= n){
				arr[i][j] = (int) (Math.random() * randomCoef);
				if (arr[i][j] < 10) {
					System.out.print(" ");
				}
				System.out.print(" " + ANSI_RED + arr[i][j] + ANSI_RESET + " " + simvol);
				j++;
			}
			drawFrame(n * frameCoef);
			i++;
		}
	}
	private static void result(int m, Integer[][] arr){
		int k = 1;
		int i = 1;
		int j = 1;
		while (m > 0) {
			while (arr[j][i] != null) {
				System.out.print(" " + arr[j][i] + " " + simvol);
				arr[j][i] = null;
				j += k;
			}
			j -= k;
			i += k;
			while (arr[j][i] != null) {
				System.out.print(" " + arr[j][i] + " " + simvol);
				arr[j][i] = null;
				i += k;
			}
			i -= k;
			k *= -1;
			j += k;
			m--;
		}
	}

    public static void main(String[] args) {
		int i = 1;
		int j = 1;
		//we do not check correctness
		int n = enterParams("Enter number of row :");
		int m = enterParams("Enter number of cow :");

		if (n > 0 && m > 0) {
			Integer[][] arr = new Integer[m + 2][n + 2];

			System.out.println("\nLet's randomly fill the array:");
			arrCreate(m,n, arr);

			System.out.print("\nResult:\n\n" + simvol);
			result(m,arr);
		} else {
			System.out.print(ANSI_RED + "Error : Empty arr." + ANSI_RESET);
		}
    }
}
