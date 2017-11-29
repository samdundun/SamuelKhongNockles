package recursion;

public class Pokemon {

	int level;
	int hp;
	String name;
	boolean poisoned;

	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {

			public void attack(Pokemon target) {
				int hp = target.getHp();
				target.setHp(hp/2);
			}
		});
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {

			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}
		});
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
		System.out.println("Squirtle is attacking again");
		squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.hp;
				target.setHp(hp-20);
			}
		});
		System.out.println("Bulbsaur is trying to whip that booty!");
		bulbasaur.attack(squirtle, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.hp;
				target.setHp(hp-60);
			}
		});
		squirtle.lapse();
		bulbasaur.lapse();
		bulbasaur.levelUp(new Effect() {
	
			public void happens() {
				squirtle
				
			}
		});
		printScore(squirtle, bulbasaur);

	}
	private static void printScore(Pokemon squirtle, Pokemon bulbasaur) {
		System.out.println(squirtle.name + "'s hp: " + squirtle.hp + "\n" + bulbasaur.name + "'s hp: " + bulbasaur.hp);
	}


	public Pokemon(String name, int level) {
		this.level = level;
		this.name = name;
		this.hp = 100;
		this.poisoned = false;
	}

	public void iChooseYou() {
		System.out.println(this.name +", " + this.name + "!");
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}

	public void lapse() {
		if(poisoned) {
			this.hp = this.hp-15;
		}
	}

	public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit");
		}else{
			System.out.println("The attack missed");
		}
	}

	public void levelUp(Effect e) {
		this.level++;
		e.happens();
	}
}
