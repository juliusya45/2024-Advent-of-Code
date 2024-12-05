package Days;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
	String inputString;
	public Day3(String filePath)
	{
		inputString = importFile(filePath);
		int result = findMuls(inputString);
		System.out.println("Result of multiplication commands: " + result);
	}

	private String importFile(String filePath)
	{
		String msg = "";
		try{
			Scanner fileIn = new Scanner(new FileInputStream(filePath));
			while(fileIn.hasNextLine())
			{
				msg = msg + fileIn.nextLine();
			}
			System.out.println("Full Message is: " + msg);
			return msg;
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return msg;
	}

	private int findMuls(String inputString)
	{
		int sumOfMults = 0;
		while(inputString.contains("mul("))
		{   // While we still have mul(_,_) commands in the String continue
			int cmdIndex = inputString.indexOf("mul(");
			inputString = inputString.substring(cmdIndex + 4);
			try
			{
				// Ensure that the comma isn't too far away
				if(inputString.indexOf(",") > 3)
				{
					inputString = inputString.substring(inputString.indexOf("mul"));
					continue;
				}

				// Get the first number to operate on "___", exclude the ","
				int num1 = Integer.parseInt(inputString.substring(0, inputString.indexOf(",")));
				// Update the string to only contain values after the ","
				inputString = inputString.substring(inputString.indexOf(",") + 1);

				// Ensure that the ")" isn't too far away
				if(inputString.indexOf(")") > 3)    // if the last ")" is too far away from the comma
				{
					// If it is too far away then find the next occurance of mul
					inputString = inputString.substring(inputString.indexOf("mul"));
					continue;
				}


				// Now set the second number to be from the beginning of the string to the ")" excluding the ")".
				// Basically the "___" before the ")"
				int num2 = Integer.parseInt(inputString.substring(0, inputString.indexOf(")")));


				sumOfMults += (num1 * num2);

				// After getting the multiplication command remove it and preceding characters from the String:
				inputString = inputString.substring(inputString.indexOf(")") + 1);

			}
			catch(Exception e)
			{   // catch exceptions so our program doesn't just stop
				System.out.println(e.getMessage());
			}
		}
		return sumOfMults;
	}
}
