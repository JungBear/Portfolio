public class typeWater extends pokemon{

	public typeWater(String name,int maxHp,int attack, int defence, int maxMp){
		super(name);
		super.type = "물";
		
		super.maxHp = maxHp;
		super.presentHp = maxHp;
		
		super.maxMp = maxMp;
		super.presentMp = maxMp;
	
		super.attack = attack;
		
		super.defence = defence;
		super.presentDefence = defence;
		
		
	} 
	
	//스킬9
	public void 스킬9(pokemon enemy){
		String goodBad = pokemonType(enemy);
		int damage = (int) (super.attack*1.2);
		int costMp = 30;
		
		if(goodBad == "좋음") {
			 damage = (int)( damage * 1.3);
		}else {
			 damage = (int) (damage  * 0.8);
		}
			
		System.out.println("물대포 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		super.presentMp = super.presentMp-costMp;
	}
	
	//스킬10
	public void 스킬10(pokemon enemy){
		String goodBad = pokemonType(enemy);
		
		int damage = (int) (super.attack*1.5);
		int costMp = 50;
		
		if(goodBad == "좋음") {
			 damage = (int) (damage  * 1.3);
		}else {
			 damage = (int) (damage  * 0.8);
		}
				
		System.out.println("강화된 물대포 스킬을 사용했다.");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		super.presentMp = super.presentMp-costMp;
	}
	
}