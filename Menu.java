
import java.util.Scanner;
    //Primary UI driver
	//calls all printing for questions to the user and gets all input, methods return integer control codes
public class Menu {

	public static int BattleMenu(String prompt)
	{
		int choice = 0;
		Scanner menuScanner = new Scanner(System.in);
		do {
			System.out.println("battle menu:");
			System.out.println(prompt);
			choice = menuScanner.nextInt();

		} while (choice == 0);
		return choice;
	}
	public static int WorldMenu(Player player) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static String NameMenu()
	{
		String name = "RickAst";
		return name;
	}
	public static int[] StatsMenu()
	{
		int[] choices = new int[]{100,100,100};
		return choices;
	}
}
