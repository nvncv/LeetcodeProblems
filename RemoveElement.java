package leetcodeProblems;
import java.util.*;

public class RemoveElement 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);  //Use scanner to take input.
		Integer[] nums = null;             //Initialize the nums array.
		
		
		
        //Take input: array size then store it in "arraySize"
        System.out.println("What is the amount of numbers you will insert in the array?");
        int arraySize=s.nextInt();
        
        //Validate constraint: 0 <= nums.length <= 100
        if( arraySize<0 || arraySize>100)
        {
            System.out.println("Size should be between 0 and 100.");
        }
        else
        {
        	//If the size is valid, start taking input using a loop that repeats as many times as the "arraySize".
            nums= new Integer[arraySize];
            System.out.println("nums=");
            
            for(int i=0 ; i<arraySize ;i++)
            {
                int input=s.nextInt();
                //Validate constraint: 0 <= nums[i] <= 50.
                //Repeat warning as long as the input is less than 0 or greater than 100.
                while(input<0 || input >50)	
                {
                	System.out.println("Number should be between 0 and 50.Enter a number again.");
                	input=s.nextInt();
                }
                
                //Finally store input in array.
                nums[i]=input;   

            }
            
          //Take input: val.
            //Initialized val as -1 so that it enters the loop.
            int val=-1;
          //Validate constraint: 0 <= val <= 100.
            while (val<0 || val>100)
            {
            	//Repeat warning as long as the input is less than 0 or greater than 50.
                System.out.println("val=");
                val=s.nextInt();
                if(val<0 || val>100)
                    System.out.println("Invalid input. val should be 0 <= val <= 100. ");
            }


            //Look for val in array, replace it with -1, and increment k by one.
            int k=0;
            for(int i=0; i<arraySize ; i++)
            {
                if(nums[i]==val)
                    nums[i]=-1;
                else
                    k++;    
            }

            
            //Sort nums in descending order so that all -1 values appear at the end of the array.
            Arrays.sort(nums, Collections.reverseOrder());

            //String output for nums.
            String numsOutput="[";
            //Iterate through nums.
            for(int i=0; i<arraySize ; i++)
            {
            	//If the value is negative output a dash.
                if (nums[i]<0)
                    numsOutput+=",_";
                //If the value is the last value that is not equal to val (e.g. 2 in [1,2,_,_] and 3 in [1,2,3,_,_] ) , add it to the numsOutput string without a comma.
                //This is used to eliminate chances of two commas occuring in the output.
                //The condition includes k-1 instead of k since indexes start from 0.
                else if (i==k-1)
                	numsOutput+=nums[i];
                //Aside from those two if conditions, add the value to numsOutput with a comma.
                else
                    numsOutput+=nums[i]+",";
            }

            //Finally, the output.
            System.out.println(k+", nums = "+numsOutput+"]");
        }

        
        
        
	}
	
}
