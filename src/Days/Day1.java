package Days;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
	ArrayList<Integer> leftList;
	ArrayList<Integer> rightList;


	// Create a method to take in a .txt input to create the ArrayLists
	public void inputTxt(String filePath) {
		leftList = new ArrayList<>();
		rightList = new ArrayList<>();

		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new FileInputStream(filePath));

			while (fileIn.hasNextLine()) {
				int left = fileIn.nextInt();
				int right = fileIn.nextInt();

				leftList.add(left);
				rightList.add(right);
				System.out.println(left);
			}
			fileIn.close();
			System.out.println("Successfully read input file!");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// left and right list should be populated before this method is called
	public int findDist() {
		int totalDist = 0;
		// First sort the arrayLists:
		leftList.sort(null);
		rightList.sort(null);

		// Then go through and add up their distances:
		for (int i = 0; i < leftList.size(); i++) {
			totalDist += Math.abs(leftList.get(i) - rightList.get(i));
		}

		return totalDist;
	}
}