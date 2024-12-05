
import Days.*;

public class Main
{
	public static void main(String[] args) {
		day2();
	}

	public static void day1()
	{
		System.out.println("Starting Day 1!");
		Day1 obj = new Day1();
		obj.inputTxt("Inputs/inputDay1.txt");
		int distance = obj.findDist();
		System.out.println(distance);
		int similarity = obj.findSimilarity();
		System.out.println("Similarity: " + similarity);
		obj.inputTxt("Inputs/inputDay1.txt");
		int hashSimilarity = obj.findSimilarityHash();
		System.out.println("Similarity (HashMap Version): " + hashSimilarity);
	}

	public static void day2()
	{
		System.out.println("Starting Day 2!");
		Day2 obj = new Day2("Inputs/inputDay2.txt");
		int safeReports = obj.getSafeReports();
		System.out.println(safeReports);
		int safeReportsDampened = obj.getSafeReportsDampened();
		System.out.println("Part 2:" + safeReportsDampened);
	}

	public static void day3()
	{
		System.out.println("Starting Day 3!");
		Day3 obj = new Day3("Inputs/inputDay3.txt");
	}
}