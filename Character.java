
public class Character {
	protected String name;
	protected int maxHp;
	protected int maxMana;
	protected int maxStam;
	protected int hp;
	protected int mana;
	protected int stam;
	protected Ability[] abilities;
	protected String[] outputInfo;
	
	Character(String name, int maxHp, int maxMana, int maxStam, Ability[] abilities)
	{
		this.name = name;
		this.maxHp = maxHp;
		this.maxMana = maxMana;
		this.maxStam = maxStam;
		this.hp = maxHp;
		this.mana = maxMana;
		this.stam = maxStam;
		this.abilities = abilities;
		//this.outputInfo = OutputInfo();
	}
	
	/*public String[] OutputInfo()
	{	
		String abilitiesString = "";
		for(int i = 0; i < abilities.length; i++)
		{
			abilitiesString = abilitiesString +Integer.toString(i)+".) " + abilities[i].getName() + "\n"; 
		}
		String[] info = {this.name, Integer.toString(this.hp), Integer.toString(this.maxHp), Integer.toString(this.mana), Integer.toString(this.maxMana), Integer.toString(this.stam), Integer.toString(this.maxStam), abilitiesString};
		return info;
	}
*/
	public String getName() {
		return name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public int getMaxStam() {
		return maxStam;
	}

	public int getHp() {
		return hp;
	}

	public int getMana() {
		return mana;
	}

	public int getStam() {
		return stam;
	}

	public Ability[] getAbilities() {
		return abilities;
	}
	
	public String[] getOutputInfo() {
		return outputInfo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public void setMaxStam(int maxStam) {
		this.maxStam = maxStam;
	}

	public void setHp(int hp) {
		if(hp<this.maxHp){this.hp = hp;}
		if(hp>=this.maxHp) {this.hp=this.maxHp;}
	}

	public void setMana(int mana) {
		if(mana<this.maxMana){this.mana = mana;}
		if(mana>=this.maxMana) {this.mana=this.maxMana;}
	}

	public void setStam(int stam) {
		if(stam<this.maxStam){this.stam = stam;}
		if(stam>=this.maxStam) {this.stam=this.maxStam;}
		}

	public void setAbilities(Ability[] abilities) {
		this.abilities = abilities;
	}
	public void fullRestore()
	{
		this.hp = this.maxHp;
		this.mana = this.maxMana;
		this.stam = this.maxStam;
	}
}
