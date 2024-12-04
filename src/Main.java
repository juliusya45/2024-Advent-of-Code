
import Days.*;

public class Main
{
	public static void main(String[] args) {
		day1();
	}

	public static void day1()
	{
		System.out.println("Starting Day 1!");
		Day1 obj = new Day1();
		obj.inputTxt("C:/Users/Julius/Downloads/inputDay1.txt");
		int distance = obj.findDist();
		System.out.println(distance);
	}
}