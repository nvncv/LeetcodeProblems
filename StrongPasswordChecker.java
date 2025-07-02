/* =================================PROBLEM==============================================================
 A password is considered strong if the below conditions are all met:

It has at least 6 characters and at most 20 characters.
It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
It does not contain three repeating characters in a row (i.e., "Baaabb0" is weak, but "Baaba0" is strong).
Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.

In one step, you can:

Insert one character to password,
Delete one character from password, or
Replace one character of password with another character.
 

Example 1:

Input: password = "a"
Output: 5
Example 2:

Input: password = "aA1"
Output: 3
Example 3:

Input: password = "1337C0d3"
Output: 0
 

Constraints:

1 <= password.length <= 50
password consists of letters, digits, dot '.' or exclamation mark '!'
========================================================================================================
 */

package leetcodeProblems;
import java.util.Scanner;

public class StrongPasswordChecker 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);		                                    //Scanner used to take input.
        String password;		                                                    //Variable of type String to hold the password entered by the user.
        boolean dot=false, exclamationMark=false, digits=false, letters=false;		//variables to ensure that the input only contains letters,digits,. or ! (e.g., no @, #, spaces, etc.).
        int stepsToFix=0;		                                                    //Integer variable that holds the amount of steps that need to be taken to strengthen the password.
        String issue="issues:\n";		                                            //String variable the displays the steps that need to be taken to strengthen the password.
        boolean enterTheNextIfCondition=true;		                                //Used to prevent the existence of two else-statements that lack an if condition.

        
        //Take input and place in the "password" variable.
        System.out.println("password= ");
        password= s.nextLine();
        
        
        //Make sure the password only contains letters,digits,. or ! (e.g., no @, #, spaces, etc.).
        //Iterate through all the characters of the input.
        for (int i=0 ; i<password.length() ; i++)
        {
        	//Set "letters" variable to true if the character's value is in between the ascii value of 'A' and the ascii value of 'z' then skip the rest of the if statements.
            if(password.charAt(i)>='A' && password.charAt(i)<='z')
                {letters=true; continue;}

           
            //Set "digits" variables to true if the character's value is in between the ascii value of '0' and the ascii value of '9'then skip the rest of the if statements.
            else if(password.charAt(i)>='0' && password.charAt(i)<='9')
                {digits=true; continue; }

            //Set "dot" variable to true if the character's value is equal to the ascii value of '.' then skip the rest of the if statements.
            else if(password.charAt(i)=='.')
                {dot=true; continue;}

            //Set "exclamationMark" variable to true if the character's value is equal to the ascii value of '!'.
            else if(password.charAt(i)=='!')
                {exclamationMark=true;}
            else
            {
            	dot=false; exclamationMark=false; digits=false; letters=false; break;
            }
        }
        
        
        //Enforce constraints: 1 <= password.length <= 50  / password consists of letters, digits, dot '.' or exclamation mark '!' only.
        //Return steps to fix + issues if one of the boolean variables letters, digits, dot or exclamationMark is true therefore contains letters,digits, dot '.' or exclamation mark '!' and if the lngth of the input is between 1 and 50.
		if ( (letters || digits || dot || exclamationMark) && (password.length()>=1 && password.length()<=50))
		{
			
			//Verify condition 1: It has at least 6 characters and at most 20 characters.
			//Specify the number of characters that need to be added if the length of the input is <6.
			if( password.length()<6)
            {
                stepsToFix= 6-password.length();
                issue+="You should add "+ stepsToFix + " characters to your password.\n";
            }
			//Specify the number of characters that need to be deleted if the length of the input is >20.
			else if (password.length()>20)
			{
				stepsToFix= password.length()-20;
                issue+="You should delete "+ stepsToFix + " characters from your password.\n";
                enterTheNextIfCondition=false;
			}
			
			
			//Verify condition 2: It contains at least one lower case letter, at least one upper case letter, and at least one digit.
			else if(enterTheNextIfCondition)
			{
				boolean containsLowerCaseLetter=false;  //boolean variable that shows if the password contains a lower case letter.
				boolean containsUpperCaseLetter=false;  //boolean variable that shows if the password contains an upper case letter.
				boolean containsDigit=false;
				//Iterate through all the characters of the input.
				for (int i=0 ; i<password.length() ; i++)
		        {
					//Set "containsLowerCaseLetter" variable  to true if the character's value is in between the ascii value of 'a' and the ascii value of 'z' then skip the next if statement.
					if (password.charAt(i)>='a' && password.charAt(i)<='z')
						{containsLowerCaseLetter=true; continue;}
					//Set "containsLowerCaseLetter" variable to true if the character's value is in between the ascii value of 'a' and the ascii value of 'z' then skip the next if statement.
					if (password.charAt(i)>='A' && password.charAt(i)<='Z')
						{containsUpperCaseLetter=true; continue;}
					//Set "containsDigit" variable to true if the character's value is in between the ascii value of '0' and the ascii value of '9'
					if (password.charAt(i)>='0' && password.charAt(i)<='9')
						containsDigit=true;
		        }
				
				
				//Prompt user to add a lower case letter if the length of the input is less than 20 (we already verified that it is greater than 6 before).
				if(password.length()<20 && !containsLowerCaseLetter)
				{
					stepsToFix++;
					issue+="You should add atleast 1 lower case letter.";
				}
				//Prompt user to change at least 1 character to a lower case letter if the length of the input is 20 
				else if(password.length()==20 && !containsLowerCaseLetter)
				{
					stepsToFix++;
					issue+="You should change atleast 1 character to a lowercase letter.";
				}
				//Prompt user to add an upper case letter if the length of the input is less than 20 (we already verified that it is greater than 6 before).
				else if(password.length()<20 && !containsUpperCaseLetter)
				{
					stepsToFix++;
					issue+="You should add atleast 1 uppercase letter.";
				}
				//Prompt user to change at least 1 character to an upper case letter if the length of the input is 20.
				else if(password.length()==20 && !containsUpperCaseLetter)
				{
					stepsToFix++;
					issue+="You should change atleast 1 character to an uppercase letter.";
				}
				//Prompt user to add a digit if the length of the input is less than 20 (we already verified that it is greater than 6 before).
				else if(password.length()<20 && !containsDigit)
				{
					stepsToFix++;
					issue+="You should add atleast 1 digit.";
				}
				//Prompt user to change at least 1 character to a digit if the length of the input is 20. 
				else if(password.length()==20 && !containsDigit)
				{
					stepsToFix++;
					issue+="You should change atleast 1 character to a digit.";
				}
			}
			
			//Condition 3: It does not contain three repeating characters in a row (i.e., "Baaabb0" is weak, but "Baaba0" is strong).
			else
			{
				//Iterate through all the characters of the input.
				for ( int i=0 ; i<password.length()-3;i++)
				{
					//Compare each character to the one next to it (i+1) and the one after(i+2). If they are identical, prompt to change atleast one of them.
					if( password.charAt(i)==password.charAt(i+1) &&  password.charAt(i)==password.charAt(i+2) )
					{
						stepsToFix++;
						issue+="You should change atleast one of the three "+ password.charAt(i) +" characters that are placed in a row.";
						break;
					}
				}
			}
			//Check if the password is strong: if it has 0 steps to fix then it is strong.
			if(stepsToFix!=0)
				System.out.println("Steps to fix: "+ stepsToFix+"\n"+issue);
			else
				System.out.println("Steps to fix: "+ stepsToFix+"\nYour password is Strong!");
			
		}
		//Check if the length of the input verifies: 1 <= password.length() <= 50
		else if (password.length()<1 || password.length()>50)
			{System.out.println("The input should be of length between 1 and 50. ");}
		//Print message if it contains any characters other than letters, digits, . or !
		else
		    {System.out.println("The input should consist of letters, digits, . or ! only ");} 
		
	}
}
