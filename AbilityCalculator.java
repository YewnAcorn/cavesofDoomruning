
public class AbilityCalculator {
	//battle damage/effect calculator, compares values in two separate characters with an ability and carries out setting
	//of an int array that describes the magnitude and stats of the effect
		public static int[] Calculate(Ability ability, Character user, Character target)
		{
			//initialize return array
			int[] returnArray = new int[4]; //these have the effects in them that are calculated

			
			//result amounts 1 and 2 are the variables we store the adjustment values for stat 1 and stat 2 while we carry out the calculations and changes
			int costAmt = 0;
			int effectAmt = 0;
			
			
			//getting coefficients
			int coef1 = ability.getStatCoef1();
			int coef2 = ability.getStatCoef2();
			
			
			
			//getting comparison stat values
			int statVal1 = StatValue(user, target, ability.getStatCode1());
			int statVal2 = StatValue(user, target, ability.getStatCode2());
						
			//different arithmetic expressions create different stats comparison dynamics, expression are generalized to compare
			//stat1 and stat2, regardless of what stats are encoded in the ability as stat 1 and stat2
				switch (ability.getOperatorCode())
				{
					//basic  
					case 0:			//basic attack (for players)
						costAmt = 5;
						effectAmt = -50;
						break;
						
					case 1:		//weaker basic attack (for monsters)
						costAmt = 5 ;
						effectAmt = -25;
						break;
						
					case 2:
						costAmt = 5 ;
						effectAmt = -5 ;
						break;
						
					case 3:
						costAmt = 5 ;
						effectAmt = -5 ;
						break;
						
					case 4:
						costAmt = 5 ;
						effectAmt = -5 ;
						break;
						
					case 5:
						costAmt = 5 ;
						effectAmt = -5 ;
						break;
						
					case 6:
						costAmt = 5 ;
						effectAmt = -5 ;
						break;
						
					case 7:
						costAmt = 5 ;
						effectAmt = -5 ;
						break;	
				}
				//whats in the return array:
				returnArray[0] = ability.getCostStat(); //does it cost mana/health/stamina to use the ability?
				returnArray[1] = costAmt; //how much of this stat does it cost?
				returnArray[2] = ability.getEffectStat(); //does it damage the enemy's health/mana/stamina?
				returnArray[3] = effectAmt; //how much damage/healing to this stat does it do?
				return returnArray;

		}
		/*
		* StatValue
		* returns the value of the stat selected by the stat code,
		* used to parse any instance of a stat selection in an ability
		* has 12 cases, 1 each for the current and max value of each stat
		* for both monster and player in the current battle
		*
		* cases are in this order:
		* user stats: 0 getHP, 1 getMaxHP, 2 getMana, 3 getMaxMana, 4 getStam, 5 getMaxStam,
		* target stats : 6 getHP, 7 getMaxHP, 8 getMana, 9 getMaxMana, 10 getStam, 11, getMaxStam
		*/
		public static int StatValue(Character user, Character target, int statCode)
		{	
			int returnVal = 0;
			switch (statCode)
			{
				case 0:
					returnVal = user.getHp();
					break;
					
				case 1:
					returnVal = user.getMaxHp();
					break;
					
				case 2:
					returnVal = user.getMana();
					break;
					
				case 3:
					returnVal = user.getMaxMana();
					break;
					
				case 4:
					returnVal = user.getStam();
					break;
					
				case 5:
					returnVal = user.getMaxStam();
					break;
					
				case 6:
					returnVal = target.getHp();
					break;
					
				case 7:
					returnVal = target.getMaxHp();
					break;
					
				case 8:
					returnVal = target.getMana();
					break;
					
				case 9:
					returnVal = target.getMaxMana();
					break;
					
				case 10:
					returnVal = target.getStam();
					break;
					
				case 11:
					returnVal = target.getMaxStam();
					break;
					
			}
			return returnVal;
		}
		
}
