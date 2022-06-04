

public class Battle {
	
	protected Player player;
	protected Monster monster;
	protected boolean battling;
	
	
	Battle(Monster monster) //constructor
	{
		this.player = World.player; // there is only one player
		this.monster = monster; // monster the battle is with
		this.battling = true; //keeps while looping until DoneCheck() sees either the player or monster has 0 HP
	
	}
	
	public void BattleLoop()
	{
		System.out.println("The battle begins!");
		while(battling)
		{
			System.out.print("\n\n");
			System.out.println("Your HP: " + this.player.getHp());
			System.out.println("Enemy HP: " + this.monster.getHp());
			PlayerTurn();
			if(DoneCheck()) {battling=false;}
			System.out.print("\n\n");
			System.out.println("Your HP: " + this.player.getHp());
			System.out.println("EnemyHP: " + this.monster.getHp());
			MonsterTurn();
			if(DoneCheck()) {battling=false;} //ends the battle
			Wait.Wait(500);			
		}
		if(this.player.getHp() <= 0)
		{
			World.Death();
		}
		if(this.monster.getHp()<=0) //after you kill the monster you get a gem and use it
		{
			System.out.println(" and in it's wake, a gem has appeared!");
			Gem gem = new Gem(this.monster);
			System.out.println("You eat the gem and your power grows!");
			this.player.UseGem(gem);
			World.setPlayer(this.player);

			player.incrementVictoryCounter();
			int chapter = StoryChecker();
			StoryPrinter(chapter);
		}
		
	}

	private int StoryChecker()
			//checks how many wins you have to determine which chapter of the story to print
		{
			if (player.getVictoryCounter() == 0)
			{
				return 0;
			}
			if (player.getVictoryCounter() == 5)
			{
				return 1;
			}
			if (player.getVictoryCounter() == 10)
			{
				return 2;
			}
			if (player.getVictoryCounter() == 15)
			{
				return 3;
			}
			else{
				return 99;
			}
		}

	public void StoryPrinter(int chapterNumber) //determines when story elements appear by counting number of victories
			/*
			* the story consists of 4 chapters, which are printed when the victoryCounter threshold is reached for each element
			* starting at 0, then at 5 10 and 15
			 */
	{
		switch (chapterNumber)
		{
			case 0: //chapter 0 at 0 wins
				System.out.println("...");
				System.out.println("...");
				System.out.println("Digging, digging blindly in the dark");
				System.out.println("You have to reach your cave-town and warn your cave-mates that an attack is immanent");
				System.out.println("You almost reach the cave when you smell a terrible monster ahead of you!");
				System.out.println("It attacks!");
				System.out.println("You are saved in the last moment by another monster which attacks the first");
				System.out.println("They cling together like two coiled serpents and and writhe in their death grips.");
				System.out.println("...");
				System.out.println("They both shreik and destroy each other leaving behind some kind of GEM");
				System.out.println("...");
				System.out.println("You pick up the GEM and are imbued with energy and strange powers! Suddenly you can see the tunnel you are in!");
				System.out.println("You are surrounded by corpses of your fallen cave-mates!");
				System.out.println("...");
				System.out.println("These monsters must have killed all your cave-mates...");
				System.out.println("...");
				System.out.println("Another monster notices you and approaches!");
				System.out.println("...");
				System.out.println("It attacks!");
				break;
			case 1: //chapter 1 at 5 wins
				System.out.println("The wreckage of your foes lies behind you");
				System.out.println("...");
				System.out.println("You have destroyed all the monsters in what was once your cave-town");
				System.out.println("After destroying the last monster. You find another GEM");
				System.out.println("It begins to glow in the dark, and emits a sorcerous green light;");
				System.out.println("As it floats in the air it illuminates the ruins of your cave-town:");
				System.out.println("Your home, underground chamber with high ceilings and sweet air, now a smoldering pit of despair");
				System.out.println("The green gem speaks:");
				System.out.println("\"If you wish to save your people you must follow me!\"");
				System.out.println("The gem begins to float away...");
				System.out.println("You follow after, asking: ");
				System.out.println("\"How can I save them if they are already all destroyed?\"");
				System.out.println("GEM: \"You must go back in time and save them, of course");
				System.out.println("YOU: \"How can I do that?\" ");
				System.out.println("GEM: \"You must seek CRON in the CAVES OF DOOM\"");
				System.out.println("\"Only he has the power of TIME\"");
				System.out.println("You follow the gem to the tunnel deeper into the earth, the bottom exit of cave-town");
				System.out.println("Behold the entrance to the CAVES of DOOM!");
				System.out.println("You enter");
				System.out.println("A monster attacks!");
				break;
			case 2: //chapter 2 at 10 wins

				System.out.println("Cron: \"...\"");
				System.out.println("\"You have defeated my demonic army\"");
				System.out.println("\"I will grant your wish and send you back in time\"");
				System.out.println("\"Good luck saving your people!\"");
				System.out.println("Green time energy begins to spiral around you.");
				System.out.println("You feel yourself going back in time. A weird feeling");
				System.out.println("Suddenly you are back at your village, but now it is not destroyed");
				System.out.println("But it is under attack!");
				break;

			case 3: //chapter 3 at 15 wins
				System.out.println("You saved us " + player.getName() + "!");
				System.out.println("Thank goodness you arrived in time");
				System.out.println("Yes in *time* indeed!");
				System.out.println("THE END");
				break;
			case 99:
				// this is the default chapter in between battles
				System.out.println("Down ever deeper into the Caves Of Doom...");
				System.out.println("										/");
				System.out.println("									   /");
				System.out.println("                                      /");

		}
	}

	protected void PlayerTurn()
	{
		System.out.println("Your Turn!\n");
		
		int choice = Menu.BattleMenu("0==[ [1] attack  [2] heal  [3] use ability ==>");
		//Menu contains a scanner which returns the player's input as an integer to
		//create interactive moment in gameplay



		switch(choice) //based on what the player selected, either attack, heal, or ability (technically
				       // attack and heal are also abilities)
		{
			case 1: //attack
				Ability attack = new Ability("Attack" , 1, 11, 1, 1, 0, 1, 3, 1, 0);
				UseAbility(player, monster, attack, 0);
				break;
			case 2: //heal
				Ability heal = new Ability("Heal" , 3, 3, 1, 1, 0, 1, 0, 1, 0);
				UseAbility(player, monster, heal, 0);
				break;
			case 3: //use ability

				//calls an ability menu to access more complex abilities

				break;

		}

	}
	protected void MonsterTurn()
	{
		//int choice = Random.RandInt(0, this.monster.getAbilities().length); //randomly select an ability for the monster to use
		Ability bite = new Ability("Bite", 1, 11, 1, 1, 1 , 1, 3, 1, 0);//this.monster.getAbilities()[choice];
		UseAbility(monster, player, bite, 1);
	}
	protected boolean DoneCheck()
	{
		System.out.println("checking if done... current player HP: "+ this.player.getHp());
		if(this.player.getHp() <= 0) // if you died
		{
			System.out.println("Done!!!");
			return true;
		}
		if(this.monster.getHp()<=0) // if you defeated the monster
		{
			System.out.println("Done!!!");
			return true;
		}
		return false;
	}
	
	protected void UseAbility(Character user, Character target, Ability ability, int origin)
	{
		
		System.out.println("\n"+user.getName() +" uses " + ability.getName());
		int[] effectArray = AbilityCalculator.Calculate(ability, user, target); //
		EffectParser(effectArray, origin);
		
	}
	protected void EffectParser(int[] effectArray, int origin)
	{
		System.out.println("Parsing...\n");
		//Switches based on who was using the ability to correctly route cost and effect values

		/*The calculations are done here based on the 4 elements in effectArray and the origin code (1 or 0) which
		create an overall command code, for example for the player to attack the enemy set origin to 0,
		*	  The effect array includes [0]ability.getCostStat() // to say which resource is spent on the ability
		* 								[1]costAmt // to say how much of this stat it costs
		* 								[2]ability.getEffectStat() // to say which stat is bing targeted by the ability
		* 								[3]effectAmt //to say what the effect on that stat is
		* for example, a fireball could be: effectArray[0] = 1, [1] = 10, [2] = 3, [3] = 100, origin = 0
		* would be an ability that costs 10 mana and deals 100 damage to the enemy HP

		 */
		switch(origin)
						
		{
		//player origin
		case 0:
			
			//switches between 3 possible cost targets, Hp Mana and Stam for player
			switch(effectArray[0]) //input: ability.getCostStat()
			{
			case 0: //the ability costs HP
				this.player.setHp(this.player.hp + effectArray[1]);  //how much HP it costs
				System.out.println("player health cost "+Integer.toString(effectArray[1]));
				break;
			
			case 1: //the ability costs mana
				this.player.setMana(this.player.mana + effectArray[1]); //how much mana it costs
				System.out.println("player mana cost "+Integer.toString(effectArray[1]));
				break;
			
			case 2: //the ability costs stamina
				this.player.setStam(this.player.stam + effectArray[1]); //how much stamina it costs
				System.out.println("player stam cost "+Integer.toString(effectArray[1]));
				break;
			}
			
			//Switches between 6 possible effect targets, Hp Mana and Stam for each player and monster
			switch(effectArray[2]) //input: getEffectStat()
			{
			case 0: //to your HP
				this.player.setHp(this.player.hp + effectArray[3]); //how much HP
				System.out.println("player health effect "+Integer.toString(effectArray[3]));
				break;
			case 1://to your own mana
				this.player.setMana(this.player.mana + effectArray[3]); //how much mana
				System.out.println("player mana effect "+Integer.toString(effectArray[3]));
				break;
			case 2: //to your own stamina
				this.player.setStam(this.player.stam + effectArray[3]); //how much stamina
				System.out.println("player stam effect "+Integer.toString(effectArray[3]));
				break;
			case 3: //to enemy HP
				this.monster.setHp(this.monster.hp + effectArray[3]); //how much HP
				System.out.println("monster  health effect "+Integer.toString(effectArray[3]));
				break;
			case 4: //to enemy mana
				this.monster.setMana(this.monster.mana + effectArray[3]); //how much mana
				System.out.println("monster  mana effect "+Integer.toString(effectArray[3]));
				break;
			case 5: //to enemy stamina
				this.monster.setStam(this.monster.stam + effectArray[3]); //how much stamina
				System.out.println("monster  stam effect "+Integer.toString(effectArray[3]));
				break;
			}
			break;
			
		//Monster origin
		case 1:
			
			//switches between 3 possible cost targets, Hp Mana and Stam for monster
			switch(effectArray[0])
			{
			case 0: //costs HP
				this.monster.setHp(this.monster.hp + effectArray[1]);
				System.out.println("monster  hp cost"+Integer.toString(effectArray[1]));
				break;
			
			case 1: //costs mana
				this.monster.setMana(this.monster.mana + effectArray[1]);
				System.out.println("monster  mana cost"+Integer.toString(effectArray[1]));
				break;
			
			case 2: //costs stamina
				this.monster.setStam(this.monster.stam + effectArray[1]);
				System.out.println("monster  stam cost"+Integer.toString(effectArray[1]));
				break;
			}
			//Switches between 6 possible effect targets, Hp Mana and Stam for each monster and player
			switch(effectArray[2])
			{
			case 0: // monster's own HP
				this.monster.setHp(this.monster.hp + effectArray[3]);
				System.out.println("monster  health effect "+Integer.toString(effectArray[3]));
				break;
			case 1: // monster's own mana
				this.monster.setMana(this.monster.mana + effectArray[3]);
				System.out.println("monster  mana effect "+Integer.toString(effectArray[3]));
				break;
			case 2: // monster's stamina
				this.monster.setStam(this.monster.stam + effectArray[3]);
				System.out.println("monster  stam effect "+Integer.toString(effectArray[3]));
				break;
			case 3: // monster to player's HP
				this.player.setHp(this.player.hp + effectArray[3]);
				System.out.println("player  hp effect "+Integer.toString(effectArray[3]));
				break;
			case 4: // monster to player's mana
				this.player.setMana(this.player.mana + effectArray[3]);
				System.out.println("player  mana effect "+Integer.toString(effectArray[3]));
				break;
			case 5: //monster to player's stamina
				this.player.setStam(this.player.stam + effectArray[3]);
				System.out.println("player  stam effect "+Integer.toString(effectArray[3]));
				break;
			}
			break;
		}
	}

	public void endBattling() {
		System.out.println("Changed battling!");
		this.battling = false;
	}

	public boolean isBattling() {
		return battling;
	}
	
	
	}
