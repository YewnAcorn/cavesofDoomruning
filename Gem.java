

public class Gem {
	int hp;
	int stam;
	int mana;
	int type;

	Gem(Monster monster)
	{
		hp = monster.getMaxHp() / 3;
		stam = monster.getMaxStam() / 5;
		mana = monster.getMaxMana() / 5;
		type = 0;//Random.RandInt(0, 3);
	}
	
	Gem(int hp, int mana, int stam, int type)
	{
		this.hp = hp;
		this.mana = mana;
		this.stam = stam;
		this.type = type;
	}

	public int getHp() {
		return hp;
	}

	public int getStam() {
		return stam;
	}

	public int getMana() {
		return mana;
	}

	public int getType() {
		return type;
	}

}
