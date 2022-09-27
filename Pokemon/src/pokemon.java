//풀<불<물<전기<땅<풀
public class pokemon {
	// [속성]
	String name;
	String type;

	int maxHp;
	int presentHp;

	int maxMp;
	int presentMp;

	int attack;

	int defence;
	int presentDefence;

//--------------------------------------------------------------//

	// [생성자] only 필수항목들
	public pokemon(String name) {
		this.name = name;
	}

//--------------------------------------------------------------//

	// [타입별 상성]
	public String pokemonType(pokemon enemy) {

		String result = null; // 관계가 없는 경우도 있으니 이 경우를 null 값을 넣어줘야한다.

		// 풀<불<물<전기<땅<풀
		switch (this.type) {

		case "땅":
			if (enemy.type == "전기") {
				result = "좋음";

			} else if (enemy.type == "풀") {
				result = "나쁨";

			}
			break;

		case "불":
			if (enemy.type == "풀") {
				result = "좋음";

			} else if (enemy.type == "물") {
				result = "나쁨";
			}
			break;

		case "물":
			if (enemy.type == "불") {
				result = "좋음";
			} else if (enemy.type == "전기") {
				result = "나쁨";
			}
			break;

		case "풀":
			if (enemy.type == "땅") {
				result = "좋음";
			} else if (enemy.type == "불") {
				result = "나쁨";
			}
			break;

		case "전기":
			if (enemy.type == "물") {
				result = "좋음";
			} else if (enemy.type == "땅") {
				result = "나쁨";
			}
			break;
		}

		return result;

	}

	// --------------------------------------------------------------//

	// [기본공격]
	public void 기본공격(pokemon enemy) {
		String goodBad = pokemonType(enemy);
		int damage;
		if (goodBad == "좋음") {
			damage = (int) (attack * 1.3);
		} else {
			damage = (int) (attack * 0.8);
		}
		System.out.println("기본공격을 성공했다.");

		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
	}

//--------------------------------------------------------------//

	// [스킬1-전기]
	public void 스킬1(pokemon enemy) {
		String goodBad = pokemonType(enemy);
		int damage = (int) (this.attack * 1.2);
		int costMp = 30;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("전기충격 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

	// [스킬2-전기]
	public void 스킬2(pokemon enemy) {
		String goodBad = pokemonType(enemy);

		int damage = (int) (this.attack * 1.5);
		int costMp = 50;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("강화된 전기출격 스킬을 사용했다.");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

//--------------------------------------------------------------//

	// [스킬3-불]
	public void 스킬3(pokemon enemy) {
		String goodBad = pokemonType(enemy);
		int damage = (int) (this.attack * 1.2);
		int costMp = 30;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("불기둥 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

	// [스킬4-불]
	public void 스킬4(pokemon enemy) {
		String goodBad = pokemonType(enemy);

		int damage = (int) (this.attack * 1.5);
		int costMp = 50;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("강화된 불기둥 스킬을 사용했다.");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

//--------------------------------------------------------------//

	// [스킬5-풀]
	public void 스킬5(pokemon enemy) {
		String goodBad = pokemonType(enemy);
		int damage = (int) (this.attack * 1.2);
		int costMp = 30;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("에너지볼 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

	// [스킬6-풀]
	public void 스킬6(pokemon enemy) {
		String goodBad = pokemonType(enemy);

		int damage = (int) (this.attack * 1.5);
		int costMp = 50;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("강화된 에너지볼 스킬을 사용했다.");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

//--------------------------------------------------------------//

	// [스킬7-땅]
	public void 스킬7(pokemon enemy) {
		String goodBad = pokemonType(enemy);
		int damage = (int) (this.attack * 1.2);
		int costMp = 30;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("모래지옥 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

	// [스킬8-땅]
	public void 스킬8(pokemon enemy) {

		int defence = (int) (this.defence + 50);
		int costMp = 50;

		System.out.println("대지의 힘 스킬을 사용했다.");
		this.presentDefence = defence;
		this.presentMp = this.presentMp - costMp;
	}

//--------------------------------------------------------------//

	// [스킬9-물]
	public void 스킬9(pokemon enemy) {
		String goodBad = pokemonType(enemy);
		int damage = (int) (this.attack * 1.2);
		int costMp = 30;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("물대포 스킬을 사용했다!");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

	// [스킬10-물]
	public void 스킬10(pokemon enemy) {
		String goodBad = pokemonType(enemy);

		int damage = (int) (this.attack * 1.5);
		int costMp = 50;

		if (goodBad == "좋음") {
			damage = (int) (damage * 1.3);
		} else {
			damage = (int) (damage * 0.8);
		}

		System.out.println("강화된 물대포 스킬을 사용했다.");
		enemy.presentHp = enemy.presentHp - (damage - enemy.defence);
		this.presentMp = this.presentMp - costMp;
	}

}