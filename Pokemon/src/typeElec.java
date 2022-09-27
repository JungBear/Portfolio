public class typeElec extends pokemon {

//	int skill1Mp = 30;
	public typeElec(String name,int maxHp,int attack, int defence, int maxMp){
		super(name);
		super.type = "전기";
		
		super.maxHp = maxHp;
		super.presentHp = maxHp;
		
		super.maxMp = maxMp;
		super.presentMp = maxMp;
	
		super.attack = attack;
		
		super.defence = defence;
		super.presentDefence = defence;
	} 
	//스킬1
	public void 스킬1(pokemon enemy){
		String goodBad = pokemonType(enemy);
		int damage = (int) (super.attack*1.2);
		int costMp = 30;
		
		if(goodBad == "좋음") {
			 damage = (int)( damage * 1.3);
		}else {
			 damage = (int) (damage  * 0.8);
		}
			
		System.out.println("전기충격 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		super.presentMp = super.presentMp-costMp;
	}
	
	//"피카츄", 100, 20, 5, 50
	//"꼬부기",100,22,3,50
	
	

	
	
	//스킬2
	public void 스킬2(pokemon enemy){
		String goodBad = pokemonType(enemy);
		
		int damage = (int) (super.attack*1.5);
		int costMp = 50;
		
		if(goodBad == "좋음") {
			 damage = (int) (damage  * 1.3);
		}else {
			 damage = (int) (damage  * 0.8);
		}
				
		System.out.println("강화된 전기출격 스킬을 사용했다.");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		super.presentMp = super.presentMp-costMp;
	}
	
	
	// 20*1.5(스킬버프)*1.3(상성) = 39
	// 39-3(방어력) = 36
	// 그래서 꼬부기의 체력 100 - 36 = 64
	// 실제로 남은 체력 64나옴.
}