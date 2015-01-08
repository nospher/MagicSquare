package MagicSquare;

/*
 * this program checks if a square NxX is magic
 * a square is magic if its line columns and diagonals
 * have the same sum
 * 
 * created by nospheratus
 * 
 * */

import java.util.Scanner;

public class Square {
	
	//user gives the dimensions
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("give the size of square array");
		int size = sc.nextInt();
		
		//create the array with the given length
		int [][]array = new int[size][size];
		
		//now we need to fill the array
		userfills(array);
		//print the array
		print(array);
		
		System.out.println("is the array magic square??? ");
		System.out.println("the answer is " + isMagicSquare(array,15));
	}
	public static void userfills(int[][]arr){
		
		//user inserts a specific element
		//in each cell of array
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length;j++){
				System.out.println("enter the number you want in cell" + "( " + i + " ," + j + ")");
				int number = sc.nextInt();
				arr[i][j] = number;
				
			}
		}
		
	}//userfills
	//now we create the function which checks its magic
	//if our square is magic returns true else false 
	//according to a number
	public static boolean isMagicSquare(int[][]arr, int number){
		
		//initialize a variable to check if it's square
		boolean check = false;
				
		if((checkLines(arr,number) == checkColumns(arr,number)) && 
				checkLines(arr,number) == checkdiagonal(arr,number) 
				/* && checkColumns(arr,number) == checkdiagonal(arr,number)*/)
				
			check = true;
		else
			check = false;
		
		return check;
		
	}
	public static boolean checkLines(int [][]arr, int num){
		//to check the magic
		boolean is = true;
		//to hold the sum
		int sum = 0;
		//a temporary array to hold the sums that
		//every loop returns
		int[] temp = new int[arr.length];
		
		
		for(int i=0; i<arr.length;i++){
			for(int j=0; j<arr.length;j++){
				
				sum += arr[i][j];
				temp[i] = sum;
			}
			sum = 0;
			
		}
		//now we need to check the temporary array
		for(int i=0	; i<temp.length; i++){
			//if the elements aren't equal 
			//then return false else return true
			//System.out.println("the line " + i + " has sum " + temp[i]);
			if(temp[0] != temp[i]){
				is = false;
			}
		}
		
		return is;
	}
	public static boolean checkColumns(int [][]arr, int num){
		
		//to check the magic
		boolean is =true;
		//we need to hold the columns
		int col = 0;
		//and the sum of each column
		int sum = 0;
		//the temporary array holds 
		//the sum of each column
		int [] temp = new int[arr.length];
		//we also need the position of temporary array
		int temp_pos = 0;
		//here is a simple algorithm
		//the idea is....the for loop 
		//iterates the first column when finished
		//we increase the column counter to get the 
		//second column...etc
		//and hold the sum in the temporary array
		while(col < arr.length){
		
		for(int i=0; i<arr.length;i++){
			
			sum += arr[i][col];
			
		}
		temp[temp_pos] = sum;
		//next position of
		//temporary array
		temp_pos++;
		col++;
		sum = 0;
		}
		//now we need to check the temporary array
		for(int i=0; i<temp.length; i++){
			//if the elements aren't equal 
			//then return false else return true
			//System.out.println("the column " + i + " has sum " + temp[i]);
			if(temp[0] != temp[i]){
				is = false;
			}
		}
		return is;
		
	}
	public static boolean checkdiagonal(int [][]arr, int num){
		
		boolean is = true;
		//temporary array to hold the sum
		int [] temp = new int[2];
		//to hold the position of temp
		
		//to hold the sum of main diagonal
		int sum = 0;
		//to hold the sum of reverse diagonal
		int sum2 = reverseDiagonal(arr);
		//the line and column of arr array
		int lines = 0, columns = 0;
		
		while(lines < arr.length){
			
			sum = sum + arr[lines][columns];
			lines++;
			columns++;
			
			
			
		}
		temp[0] = sum;
		temp[1] = sum2;
		
		/*System.out.println("the main diagonal has sum " + temp[0]);
		System.out.println("the reverse diagonal has sum " + temp[1]);*/
		
		if(temp[0] != temp[1])
			is = false;
		
		return is;
	}
	public static int reverseDiagonal(int [][]a){
		
		int lines = a.length-1;
		int cols = 0;
		
		int sum = 0;
		
		while(cols < a.length){
			
			//first loop is the last line and first column
			sum = sum + a[lines][cols];
			//we need to decrease the line and increase the column
			lines--;
			cols++;
			
		}
		return sum;
		
	}
	//print the array for test purposes
	public static void print(int[][]arr){
		
		System.out.println("The array is: ");
		
		for(int i=0; i<arr.length;i++){
			for(int j=0; j<arr.length;j++){
				
				System.out.println("(" + i + " , " + j + ")" + " : " + arr[i][j]);
			}
		}
	}

}
