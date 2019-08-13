/*****************************************
 * CS1101: Fall 2017
 * Lab 12: due Monday November, 6
 * Author: Yamel Hernandez
 *****************************************/

import java.util.Scanner;

public class myIO {

    // The following method is given to you: you can decide to use it or not.
    public static int[] dimensionsFile(String filename) {
        int[] dimensions = new int[2]; // number of lines and number of grades per line
        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int counter = 0;
        while (textReader.ready()) { 
            if (dimensions[0] == 0)
                // the next line counts the number of elements there are on each line (since all lines have the same amount of info)
                dimensions[1] = textReader.readLine().split(" ").length;
            else textReader.readLine(); // once we have the number of elements per line, no need to recount it
            // the next line keeps track of the number of lines so far: once out of the while loop, we will know how many lines there are in the file
            dimensions[0]++;
        }
        
        textReader.close();
        // array of exactly 2 elements: dimensions[0] is the number of grades per line + 2 (for the first and last name); dimensions[1] is the number of lines in the file
        return dimensions; 
    }
    
    /****************************************************************************
     * Activity 2:
     * This method takes the name of a file as input.
     * It reads a file formatted like students.txt (provided to you):
     * This file contains several lines: each line starts with the name of 
     * a student (last followed by first)
     * and continues with a list of their grades
     * Each line contains the same number of grades
     * You have to create one array from it:
     * an array of integer grades (2D array: n lines and p columns, p being the number of grades per student)
     ****************************************************************************/
    // The following method is the one you have to complete. 
    // The comments in the body of the method help guide you to implement it, telling you the order of concerns
    public static int[][] readGradesFromFile(String filename) throws FileNotFoundException, IOException {
        // you may want to start by acknowledging the number of students and the number of grades per student.
        // To do this, you can use the method called dimensionFile. You are free to do otherwise.
		int [] sg = dimensionFile(filename); // declaring an int array to use method 1 in activity one to get the student grades
        
        // create the 2D array
		int r = sg[0]; //starts off the column in the first element
		int c = sg[1]-2; //need to remove the names
        int[][] grades = new int [r][c];// = new int[][];
        
        // read all lines, one at a time: a for loop would be appropriate since you know the number of lines
        // within the for loop, as you read each line, you extract the grades and store them in your array
		FileReader f = new FileReader(filename);
		BufferedReader b = new BufferedReader(f);
		int i;
		int j;
		for (i=0; i<r; i++) {
			String p = 
			for (j=0; j<c; j++){
				sg[i][j] = ; 
		}
		}
		b.close();
        return grades;
    }    
    
    
    /****************************************************************************
     * Activity 2: 
     * This method takes a 2D array A and the name of a file, filename, as a parameter
     * and creates a new file, filename.average
     * filename.average contains at each line:
     * the name of the student written in filename at the same line
     * the average of the grades of this student, as stored in the 2D array A
     ******************************************************************************/
    public static void writeAveragesToFile(String filename, int[][] A) {
        // your code goes here
		PrintWriter w = new PrintWriter(filename); //writes to a file
		int sum = 0;
		int avg = 0;
		int [] avg2 = new int[A.length];
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				sum = sum + A[i][j];
			}
			avg = sum / A[i].length; 
			avg2[i] = avg;
		}
		for(int i=0; i<avg2.length; i++) { 
			w.println(avg2[i]); //writes to the file
		}
        w.close();
    }
    
     /****************************************************************************
     * Activity 2: 
     * This method takes a line number and computes the average of the grades at this line 
     * This method HAS TO BE RECURSIVE
     * Note: input lines are numbered starting at 1. 
     * Note: there is an extra parameter (an integer called startIndex) which stands for the element on the line of interest that we focus on
     * Complete the code below where prompted
     ******************************************************************************/
    public static double averageAtGivenLine(int[][] A, int line, int startIndex) {
        int result(); 
		if (line-1 >= A.length) {
            System.out.println("There is no grade at this line");
            return 0;
        } else {
            if (startIndex >= A[line].length) return 0;
           	// else: COMPLETE HERE WITH YOUR OWN CODE
			else (startIndex <= A[line-1].length) { 
				result = (A[line-1][startIndex]) / A[line-1].length;	//gets avg
				return averageAtGivenLine(A, line, startIndex);	//recursive part to add up the avgs
			}
        }  
		return result;
    }    
     /****************************************************************************
     * Main method in which the above methods are tested 
     * You DO NOT HAVE to modify it
     ****************************************************************************/
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        int[] dimensions = dimensionsFile("students.txt");
        System.out.println("dimensions: " + dimensions[0] + ", " + dimensions[1]);
        int[][] grades = readGradesFromFile("students.txt");
        System.out.println("number of lines: " + grades.length);
        System.out.println("number of grades per line: " + grades[0].length);
        writeAveragesToFile("students.txt.average", grades);
        System.out.println("the average of student #" + 5 + " is: " + averageAtGivenLine(grades,5,0));
        System.out.println("the average of student #" + 7 + " is: " + averageAtGivenLine(grades,7,0));
    }

}