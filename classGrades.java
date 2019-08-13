import java.util.Scanner;
public class ClassGrades{
	public static void main(String [] args){
		Scanner input = new Scanner (System.in);
		//initiallize 2D array of 4 by 6
		double [][] studentGrades = new double [4][6];
		
		for(int row = 0; row < studentGrades.length; row++){
			for(int col = 0; col < studentGrades[row].length; col++){
				System.out.println("Enter grade for student: " + row + " for lab " + col);
				studentGrades[row][col] = input.nextDouble();
			}
		}
		
		printArray(studentGrades);
		individualAvg(studentGrades);
	}
	
	public static void printArray(double[][] a){
		System.out.println("The table listed");
		for(int row = 0; row < a.length; row++){
			for(int col = 0; col < a[row].length; col++){
				System.out.print(" " + a[row][col] + " ");
			}
			System.out.println(" ");
		}
	}
	
	//prints the average of each student row
	public static void individualAvg(double[][] studentGrades){
		double total = 0.0;
		double totalAvg = 0.0;
		for (int row = 0; row < studentGrades.length; row++){
			for(int g = 0; g < studentGrades[row].length; g++){
				total = studentGrades[row][g];
				System.out.print(studentGrades[row][g] + " ");
				//total = row + total;
				//totalAvg = total / 4;
				//System.out.println("The average for student " + row + " is " + totalAvg);
			}
			System.out.println();
			System.out.println("The average is: " + total/studentGrades[row].length);
			
		}
		
	}
	
	/*Extra Credit: method should return an array with the averages 
	/public static int[] individualAvg(double[] studentGrades){
	/
	/
	*/
	
}