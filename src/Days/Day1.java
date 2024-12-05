package Days;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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

	public int findSimilarity()
	{
		int totalSimilarity = 0;

		// First sort the arrayLists:
		leftList.sort(null);
		rightList.sort(null);

		for (int i = 0; i < leftList.size(); i++) {
			int count = 0;
			int leftNum = leftList.get(i);
			while(rightList.contains(leftNum))
			{
				// Find and remove
				for(int j = 0; j < rightList.size(); j++)
				{
					if(rightList.get(j) == leftNum)
					{
						rightList.remove(j);
						break;
					}
				}


				count++;
			}
			totalSimilarity += leftNum * count;
		}

		return totalSimilarity;
	}

	public int findSimilarityHash()
	{
		int totalSimilarity = 0;

		// First sort the arrayLists:
		leftList.sort(null);
		rightList.sort(null);

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		// Add the keys in when passing through the left list
		for (int i = 0; i < leftList.size(); i++) {
			if(!hashMap.containsKey(leftList.get(i)) && rightList.contains(leftList.get(i)))
			{
				hashMap.put(leftList.get(i), 0);
			}
			// If it already exists increment it by the value of the key itself
			else if(hashMap.containsKey(leftList.get(i))){
				hashMap.put(leftList.get(i), hashMap.get(leftList.get(i)) + leftList.get(i));
			}

		}

		// Then go through the right list and increment the counter again
		for(int j = 0; j < rightList.size(); j++)
		{
			int value = rightList.get(j);
			if(hashMap.containsKey(value))
			{
				hashMap.put(value, hashMap.get(value) + 1);
			}
		}

		// Find the similarity by going through the key and multiplying the counts with the keys
		for(Integer key : hashMap.keySet())
		{
			totalSimilarity += key * hashMap.get(key);
		}

		System.out.println(hashMap);

		return totalSimilarity;
	}
}