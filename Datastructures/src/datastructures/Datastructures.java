/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author shawn.ngutu
 */
public class Datastructures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    //        Scanner s = new Scanner(System.in);
    //        System.out.println("Enter the size of the matrix");
    //        int n = s.nextInt(); // length of mat matrix
    //        System.out.println("Enter the matrix");
    //        int mat[][] = new int[n][n];
    //        for (int i = 0; i < n; i++) {
    //            for (int j = 0; j < n; j++) {
    //                mat[i][j] = s.nextInt();
    //            }
    //        }

    //        System.out.println("Enter the target size");
    //        int m = s.nextInt(); // length of target matrix
    //        int target[][] = new int[m][m];
    //        System.out.println("Enter the elements of target");
    //        for (int i = 0; i < m; i++) {
    //            for (int j = 0; j < m; j++) {
    //                target[i][j] = s.nextInt();
    //            }
    //        }

    
        //matrix to compare to target rotated matrix
            int[][] mat   = new int[][] {
                            new int[] { 1, 2, 3, 4, 5 },
                            new int[] { 6, 7, 8, 9, 10 },
                            new int[] { 11, 12, 13, 14, 15 },
                            new int[] { 16, 17, 18, 19, 20 },
                            new int[] { 21, 22, 23, 24, 25 } };

          //target matrix to compare with
          int[][] target =  new int[][] {
                            new int[] { 21, 16, 11, 6 ,1 },
                            new int[] { 22, 17 ,12 ,7, 2},
                            new int[] { 23, 18 ,13 ,8 ,3 },
                            new int[] { 24 ,19 ,14 ,9, 4 },
                            new int[] { 25 ,20 ,15, 10, 5} };
          
          System.out.println("matrix can be formed by rotation: "+findRotation(mat, target));
    }
    
    // function to rotate the matrix.
    public static int[][] _rotateMatrix(int[][] mat) {
        int n = mat.length;
        // create a new matrix called rotatedMat with the length of mat matrix to store the rotated matrix.
        int[][] rotatedMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // new row = prev column
                // new column = n - 1 - prev row
                rotatedMat[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotatedMat;
    }
    
    public static boolean findRotation(int[][] mat, int[][] target) {
        // max number of rotations is 4 --> 360 degrees
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) // Checking two matrices are equal or not.
                return true;
            mat = _rotateMatrix(mat);
        }
        return false;
    }
}

//LeetCode solution
class Solution {
    public static boolean findRotation(int[][] mat, int[][] target) {
        // max number of rotations is 4 --> 360 degrees
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) //Checking two matrices are equal or not.
                return true;
            mat = _rotateMatrix(mat);
        }
        return false;
    }
    // function to rotate the matrix.
    public static int[][] _rotateMatrix(int[][] mat) {
        int n = mat.length;
        //create a new matrix called rotatedMat with the length of mat matrix to store the rotated matrix.
        int[][] rotatedMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // new row = prev column
                // new column = n - 1 - prev row 
                rotatedMat[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotatedMat;
    }
}
