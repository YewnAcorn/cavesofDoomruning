

public class Player extends Character {
	
	
	private int victoryCounter = 0; //incremented after winning a battle
	//used to determine when a new storyGem happens


	Player(String name, int maxHp, int maxMana, int maxStam, Ability[] abilities)
	{
		super(name, maxHp, maxMana, maxStam, abilities);
	}
	public void UseGem(Gem gem)
	{
		System.out.println("using        a                  ;GEM");
		switch(gem.getType())
		{
		case 0:
			super.setMaxHp(maxHp+gem.getHp());
			break;
		case 1:
			super.setMaxMana(maxMana+gem.getMana());
			break;
		case 2:
			super.setMaxStam(maxStam+gem.getStam());
			break;
		}
	}

	public int getVictoryCounter() {
		return victoryCounter;
	}
	public void incrementVictoryCounter() {
		victoryCounter = victoryCounter + 1;
	}
	//public String[] getOutputInfo(){}

}
