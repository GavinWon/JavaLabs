import java.util.*;
import java.io.*;

/**
   Chapter 49C - Two-Dimensional Arrays Exercises 1-8

   @author TODO Your Name
   @version TODO Date

   @author Period - TODO Your Period
   @author Assignment - Ch49C_2DArrays

   @author Sources - TODO list collaborators
 */
public class Ch49C_2DArrays
{
    Scanner scan;

    public Ch49C_2DArrays()
    {
        scan = new Scanner( System.in );
    }

    /**
      TODO Description
     */
    public int sumOfAllArrayElements( int[][] data )
    {
        int sum = 0;

        // compute the sum
        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                sum += data[row][col];
            }
        }

        // write out the sum
        System.out.println(sum);
        
        return sum;
    }

    /**
       TODO Description
     */
    public int[] sumOfEachRow( int[][] data )
    {
        // declare the row sum array
        int [] rowSums = new int[data.length];

        // compute the sums for each row
        for ( int row = 0; row < data.length; row++ )
        {
            int sum = 0;

            // compute the sum for this row
            for ( int col = 0; col < data[row].length; col++ )
            {
                sum += data[row][col];
            }

            // write the sum for this row
            System.out.println(sum);
            rowSums[row] = sum;
        }
        
        return rowSums;
    }

    /**
     * TODO Description
     */
    public int[] sumOfEachColumn( int[][] data )
    {
        //find the longest row
        int longestRow = 0;
        for(int index = 0 ; index < data.length ; index++) {
            if(data[index].length > longestRow) {
                longestRow = data[index].length;
            }
        }
        // declare the row sum array
        int [] colSums = new int[longestRow];
        
        for (int col = 0 ; col < longestRow ; col++) {
            int sum = 0;
            
            for(int row = 0 ; row < data.length ; row++) {
                if(data[row].length > col) {
                    sum += data[row][col];
                }
            }
            System.out.println(sum);
            colSums[col] = sum;
        }
        
        
        return colSums;
    }

    /**
       TODO Description
     */
    public int[] maxAndMinElements( int[][] data )
    {
        // declare the max and the min
        int max = data[0][0];
        int min = data[0][0];
        
        // compute the sum
        for ( int row = 0; row < data.length; row++ )
        {
            for ( int col = 0; col < data[row].length; col++ )
            {
                if (data[row][col] > max) {
                    max = data[row][col];
                }else if (data[row][col] < min) {
                    min = data[row][col];
                }
            }
        }

        // write out the results
        System.out.println(max + " " + min);
        
        int[] result = { max, min };
        return result;
    }

    /**
       TODO Description
     */
    public int[] largestElements( int[][] data )
    {
        // declare the largest in row array
        int[] largestInRow = new int[data.length];
        
        for (int row = 0 ; row < data.length ; row++) {
            int largest = data[row][0];
            for (int col = 0 ; col < data[row].length ; col++) {
                if (data[row][col] > largest) {
                    largest = data[row][col];
                }
            }
            System.out.println(largest);
            largestInRow[row] = largest;
        }
        
        return largestInRow;
    }

    /**
      TODO Description
     */
    public void reversalOfElementsInEachRow( int[][] data )
    {
        for (int row = 0 ; row < data.length ; row++) {
            for(int col = 0 ; col < data[row].length / 2 ; col++) {
                int temp = data[row][col];
                data[row][col] = data[row][data[row].length - 1 - col];
                data[row][data[row].length - 1 - col] = temp;
            }
        }
        System.out.println(Arrays.deepToString(data));
    }

    /**
       TODO Description
     */
    public int[][] imageSmootherEasy(int[][] image)
    {
        // assume a rectangular image
        int[][] smooth = new int[image.length][image[0].length];

        // Compute the smoothed value for
        // non-edge locations in the image.

        for ( int row = 1; row < image.length - 1; row++ )
        {
            int sum = 0;
            int col;
            for (col = 1; col < image[row].length - 1; col++ )
            {
                sum = image[row - 1][col - 1] + image[row - 1][col] + image[row - 1][col + 1] + image[row][col - 1] + image[row][col] + image[row][col + 1] + image[row + 1][col - 1] + image[row + 1][col] + image[row + 1][col + 1];
                smooth[row][col] = sum / 9;
            }
        }

        for (int row = 0 ; row < image.length ; row++) {
            
            for (int col = 0 ; col < image.length ; col++) {
                System.out.print(image[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int row = 0 ; row < smooth.length ; row++) {
            
            for (int col = 0 ; col < smooth.length ; col++) {
                System.out.print(smooth[row][col] + " ");
            }
            System.out.println();
        }
        
        return smooth;
    }

    /**
       TODO Description
     */
    public int[][] imageSmootherHard( int[][] image )
    {
        // assume a rectangular image
        int[][] smooth = new int[image.length][image[0].length];
        
        //Handle 4 corner element
        smooth [0][0] = (image[0][0] + image[1][0] + image[0][1] + image[1][1]) / 9;
        smooth[0][image[0].length-1] = image[0][image[0].length-1] + image[0][image[0].length-1-1] + image[1][image[0].length-1] + image[1][image[0].length-1-1];
        smooth[image.length - 1][0] = image[image.length - 1][0] + image[image.length - 1][1] + image[image.length - 1-1][1] + image[image.length - 1-1][0];
        smooth[image.length - 1][image[0].length] = 
        
        // Handle top and bottom rows
        
        
        // Handle left most and right most columns
        
        
        
        for (int row = 0 ; row < image.length ; row++) {
            int sum;
            System.out.println( "row is: " + row );
            for (int col = 0 ; col < image[row].length ; col++) {
                System.out.println( "col is: " + col );
                //left top corner
                if(row == 0 && col == 0) {
                    sum = image[row][col] + image[row + 1][col] + image[row][col + 1] + image[row + 1][col + 1];
                }
                 //right bottom corner  
                else if (row == image.length - 1 && col == image[row].length - 1) {
                    sum = image[row][col] + image[row - 1][col] + image[row][col - 1] + image[row - 1][col - 1];
                }
                //right top corner
                else if (row == 0 && col == image[row].length - 1) {
                    sum = image[row][col] + image[row][col - 1] + image[row + 1][col] + image[row + 1][col - 1];
                }
                //left bottom corner
                else if (row == image.length - 1 && col == 0) {
                    sum = image[row][col] + image[row][col + 1] + image[row - 1][col + 1] + image[row - 1][col];
                }
                //top edge
                else if (row == 0) {
                    sum = image[row][col - 1] + image[row][col] + image[row][col + 1] + image[row + 1][col- 1] + image[row + 1][col] + image[row + 1][col + 1];
                //left edge
                } else if (col == 0) {
                    sum = image[row - 1][col] + image[row - 1][col + 1] + image[row][col] + image[row][col + 1] + image[row + 1][col] + image[row + 1][col + 1];
                //bottom edge    
                }else if (row == image.length - 1) {
                    sum = image[row][col - 1] + image[row][col] + image[row][col + 1] + image[row - 1][col- 1] + image[row - 1][col] + image[row - 1][col + 1];
                 //right edge   
                }else if (col == image[row].length - 1) {
                    sum = image[row - 1][col] + image[row - 1][col - 1] + image[row][col] + image[row][col - 1] + image[row + 1][col] + image[row + 1][col - 1];
                }else {
                    sum = image[row - 1][col - 1] + image[row - 1][col] + image[row - 1][col + 1] + image[row][col - 1] + image[row][col] + image[row][col + 1] + image[row + 1][col - 1] + image[row + 1][col] + image[row + 1][col + 1];
                }
                smooth[row][col] = sum / 9;
            }
            
            
        }
        for (int row = 0 ; row < image.length ; row++) {
            
            for (int col = 0 ; col < image.length ; col++) {
                System.out.print(image[row][col] + " ");
            }
            System.out.println();
        }

            System.out.println();
        for (int row = 0 ; row < smooth.length ; row++) {
            
            for (int col = 0 ; col < smooth.length ; col++) {
                System.out.print(smooth[row][col] + " ");
            }
            System.out.println();
        }
        
        
        return smooth;
    }

    /**
      Testing method: instantiates a Lesson49C Exercises object and
      then invokes each method

      @param args command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch49C_2DArrays exercise = new Ch49C_2DArrays();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Sum of All Array Elements");
            System.out.println( "   (2) Sum of Each Row");
            System.out.println( "   (3) Sum of Each Column");
            System.out.println( "   (4) Maximum and Minimum Elements");
            System.out.println( "   (5) Largest Elements");
            System.out.println( "   (6) Reversal of Elements in Each Row");
            System.out.println( "   (7) Image Smoother (Easy)");
            System.out.println( "   (8) Image Smoother (Hard)");
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        int[][] dataEx1 = { { 3, 2, 5 },
                            { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 },
                            { 0, 2, 6, 3, -1, -8 } };
                        int sum = exercise.sumOfAllArrayElements(dataEx1);
                        break;
                    case '2':
                        int[][] dataEx2 = { { 3, 2, 5 },
                            { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 },
                            { 0, 2, 6, 3, -1, -8 } };
                        int[] rowSums = exercise.sumOfEachRow(dataEx2);
                        break;
                    case '3':
                        int[][] dataEx3 = { { 3, 2, 5 },
                            { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 },
                            { 0, 2, 6, 3, -1, -8 } };
                        int[] colSums = exercise.sumOfEachColumn( dataEx3 );
                        break;
                    case '4':
                        int[][] dataEx4 = { { 3, 2, 5 },
                            { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 },
                            { 0, 2, 6, 3, -1, -8 } };
                        int[] maxMin = exercise.maxAndMinElements( dataEx4 );
                        break;
                    case '5':
                        int[][] dataEx5 = { { 3, 2, 5 },
                            { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 },
                            { 0, 2, 6, 3, -1, -8 } };
                        int[] largestInRow = exercise.largestElements( dataEx5 );
                        break;
                    case '6':
                        int[][] dataEx6 = { { 3, 2, 5 },
                            { 1, 4, 4, 8, 13 },
                            { 9, 1, 0, 2 },
                            { 0, 2, 6, 3, -1, -8 } };
                        exercise.reversalOfElementsInEachRow( dataEx6 );
                        break;
                    case '7':
                        int[][] imageEx7 = {
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
                        int[][] easySmooth =
                            exercise.imageSmootherEasy( imageEx7 );
                        break;
                    case '8':
                        int[][] imageEx8 = {
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 4, 4, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
                        int[][] hardSmooth =
                            exercise.imageSmootherHard( imageEx8 );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                            done = true;
                        else
                            System.out.print( "Invalid Choice" );
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
