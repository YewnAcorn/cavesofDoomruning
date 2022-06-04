
// Ability is a data holder class that provides control information
// to an ability effect calculator which is used in the battle methods

public class Ability 
{
	private String name;
	//control codes to select stats for comparison
	private int statCode1; // TODO (question, what is the need for statCode1 and statCode2 if costStat and effectStat already exist? -carter)
	private int statCode2;
	//operative coefficients to tweak comparisons
	private int statCoef1; //TODO (remind me to ask, how this works, what it is exactly - carter)
	private int statCoef2;
	//control code to select logic to carry out on stats with coefficients
	private int operatorCode; //outputs the costAmt and an effectAmt
	//target stat1, and 2
	private int costStat; // what stat is used, mana/HP/stam
	private int effectStat;// what stat is damaged/healed mana/HP/stam
	//requirements to activate, reqStat is just an integer control code to operate a switch/case statement
	//reqVal is the value which is required
	private int reqStat;
	private int reqVal;
	
	//abilities take these values, all abilities are initialized at beginning by a call of world function initAbilities() which
	Ability
		(
			String name, 
			int stat1, 
			int stat2,
			int statCoef1,
			int statCoef2,
			int operatorCode, 
			int costStat, 
			int effectStat,
			int reqStat,
			int reqVal
		)
		
	{
		this.name = name;
		this.statCode1 = stat1;
		this.statCode2 = stat2;
		this.statCoef1 = statCoef1;
		this.statCoef2 = statCoef2;
		this.operatorCode = operatorCode;
		this.costStat = costStat;
		this.effectStat = effectStat;
		this.reqStat = reqStat;
		this.reqVal = reqVal;
	}
	//just getters, abilities are immutable and will be instanced by loading values from an array
	public String getName() {
		return name;
	}

	public int getStatCode1() {
		return statCode1;
	}

	public int getStatCoef1() {
		return statCoef1;
	}

	public int getStatCode2() {
		return statCode2;
	}

	public int getStatCoef2() {
		return statCoef2;
	}

	public int getOperatorCode() {
		return operatorCode;
	}

	public int getCostStat() {
		return costStat;
	}

	public int getEffectStat() {
		return effectStat;
	}

	public int getReqStat() {
		return reqStat;
	}

	public int getReqVal() {
		return reqVal;
	}
}
