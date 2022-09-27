public class typeSoil extends pokemon{

	public typeSoil(String name,int maxHp,int attack, int defence, int maxMp){
		super(name);
		super.type = "땅";
		
		super.maxHp = maxHp;
		super.presentHp = maxHp;
		
		super.maxMp = maxMp;
		super.presentMp = maxMp;
	
		super.attack = attack;
		
		super.defence = defence;
		super.presentDefence = defence;
	} 
	//스킬7
	public void 스킬7(pokemon enemy){
		String goodBad = pokemonType(enemy);
		int damage = (int) (super.attack*1.2);
		int costMp = 30;
		
		if(goodBad == "좋음") {
			 damage = (int)( damage * 1.3);
		}else {
			 damage = (int) (damage  * 0.8);
		}
			
		System.out.println("모래지옥 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		super.presentMp = super.presentMp-costMp;
	}
//스킬8
	public void 스킬8(pokemon enemy){
		
		
		int defence = (int) (super.defence + 50);
		int costMp = 50;
		
		System.out.println("대지의 힘 스킬을 사용했다.");
		super.presentDefence = defence; 
		super.presentMp = super.presentMp-costMp;
	}
	
}