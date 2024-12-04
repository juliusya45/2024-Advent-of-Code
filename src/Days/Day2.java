package Days;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
	private int safeReports;

	public Day2(String filePath)
	{
		safeReports = 0;
		importTxt(filePath);
	}

	public int getSafeReports()
	{
		return safeReports;
	}

	private void importTxt(String filePath)
	{
		try {
			Scanner inputScanner = new Scanner(new FileInputStream(filePath));
			while(inputScanner.hasNextLine())
			{
				String report = inputScanner.nextLine();
				// parse the String report into separate ints:
				Scanner reportScanner = new Scanner(report);
				ArrayList<Integer> levels = new ArrayList<>();
				while(reportScanner.hasNextInt())
				{   // While we have ints in the report add them to the arrayList
					levels.add(reportScanner.nextInt());
				}

				// After adding all of the levels check the report:
				checkReport(levels);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private void checkReport(ArrayList<Integer> report)
	{
		boolean isIncreasing;
		// Remember if the first pair of ints are increasing or decreasing
		isIncreasing = report.get(1) - report.get(0) > 0;

		for(int i = 1; i < report.size(); i++)
		{   // For each level starting at index 1, compare it to the last one in the report
			int difference = report.get(i) - report.get(i-1);
			boolean isCurrentPositive = difference > 0;
			// Ensure the difference is within 1 and 3 inclusive
			if(Math.abs(difference) > 3 || Math.abs(difference) < 1)
				return;
			// Ensure that we are always increasing or decreasing
			else if(isCurrentPositive != isIncreasing)
				return;
		}
		safeReports++;
	}
}
