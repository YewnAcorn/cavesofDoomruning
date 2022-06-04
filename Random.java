

//Carter wrote these randoms for us, 
public class Random 
{
	public static int RandInt(int min, int max)
	{
		int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		return random_int;
	}
	
	public static Monster RandMonGen(int min, int max)
	{	String name = "Randy";
		int maxHP = RandInt(min,max);
		int maxStam = RandInt(min,max);
		int maxMana = RandInt(min,max);
		Monster newMonster = new Monster(name, maxHP, maxStam, maxMana, World.allAbilities);
		return newMonster;
	}
	
	public static Gem RandGemGen(int min,int max)
	{
		int hp = RandInt(min,max);
		int stam = RandInt(min,max);
		int mana = RandInt(min,max);
		int type = RandInt(0,3);
		Gem newGem = new Gem(hp, mana, stam, type);
		return newGem;
	}
}
