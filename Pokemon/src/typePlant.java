public class typePlant extends pokemon{

	public typePlant(String name,int maxHp,int attack, int defence, int maxMp){
		super(name);
		super.type = "풀";
		
		super.maxHp = maxHp;
		super.presentHp = maxHp;
		
		super.maxMp = maxMp;
		super.presentMp = maxMp;
	
		super.attack = attack;
		
		super.defence = defence;
		super.presentDefence = defence;
		
	}
	
	//스킬5
	public void 스킬5(pokemon enemy){
		String goodBad = pokemonType(enemy);
		int damage = (int) (super.attack*1.2);
		int costMp = 30;
		
		if(goodBad == "좋음") {
			 damage = (int)( damage * 1.3);
		}else {
			 damage = (int) (damage  * 0.8);
		}
			
		System.out.println("에너지볼 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		super.presentMp = super.presentMp-costMp;
	}
	//스킬6
	public void 스킬6(pokemon enemy){
		String goodBad = pokemonType(enemy);
		
		int damage = (int) (super.attack*1.5);
		int costMp = 50;
		
		if(goodBad == "좋음") {
			 damage = (int) (damage  * 1.3);
		}else {
			 damage = (int) (damage  * 0.8);
		}
				
		System.out.println("강화된 에너지볼 스킬을 사용했다.");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		super.presentMp = super.presentMp-costMp;
	}
}