

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//used to print file contents to terminal
public class Printer
{
	static void PrintFile(String path) throws FileNotFoundException
	{
		File file = new File(path);
		Scanner input = new Scanner(file);
		while (input.hasNextLine())
		{
			System.out.println(input.nextLine());
		}
		input.close();

	}
	static void PrintStat(Character character)
	{
		System.out.println("HP: " + character.getHp());
		System.out.println("Stamina: " + character.getStam());
		System.out.println("Mana: " + character.getMana());
	}
}
