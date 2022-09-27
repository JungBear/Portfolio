import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {// class 시작
	static Scanner sc = new Scanner(System.in);
	static int count = 0;

	public static void main(String[] args) { // 메인 시작
		// TODO Auto-generated method stub

		// [포켓몬스터 50마리]
		// Electric(이름, 체력, 공격력, 방어, 마나)
		typeElec 피카츄 = new typeElec("피카츄", 100, 20, 5, 50);
		typeElec 라이츄 = new typeElec("라이츄", 120, 22, 6, 60);
		typeElec 코일 = new typeElec("코일", 115, 23, 2, 50);
		typeElec 레어코일 = new typeElec("레어코일", 120, 26, 3, 60);
		typeElec 찌리리공 = new typeElec("찌리리공", 100, 23, 4, 50);
		typeElec 붐볼 = new typeElec("붐볼", 120, 25, 3, 50);
		typeElec 에레브 = new typeElec("에레브", 130, 28, 8, 70);
		typeElec 쥬피썬더 = new typeElec("쥬피썬더", 160, 25, 10, 70);
		typeElec 에레키드 = new typeElec("에레키드", 115, 23, 2, 60);
		typeElec 썬더 = new typeElec("썬더", 200, 30, 10, 80);

		// Fire(이름, 체력, 공격력, 방어, 마나)
		typeFire 파이리 = new typeFire("파이리", 100, 22, 3, 50);
		typeFire 리자드 = new typeFire("리자드", 120, 24, 4, 60);
		typeFire 리자몽 = new typeFire("리자몽", 140, 26, 3, 70);
		typeFire 식스테일 = new typeFire("식스테일", 105, 23, 3, 50);
		typeFire 나인테일 = new typeFire("나인테일", 110, 24, 4, 60);
		typeFire 마그마 = new typeFire("마그마", 125, 25, 5, 60);
		typeFire 브케인 = new typeFire("브케인", 121, 23, 3, 50);
		typeFire 마그케인 = new typeFire("마그케인", 123, 24, 3, 60);
		typeFire 윈디 = new typeFire("윈디", 120, 26, 5, 50);
		typeFire 파이어 = new typeFire("파이어", 200, 31, 10, 70);

//      // Water(이름, 체력, 공격력, 방어, 마나)
		typeWater 꼬부기 = new typeWater("꼬부기", 100, 22, 3, 50);
		typeWater 독파리 = new typeWater("독파리", 120, 24, 5, 70);
		typeWater 킹크랩 = new typeWater("킹크랩", 110, 20, 6, 50);
		typeWater 야도란 = new typeWater("야도란", 130, 20, 10, 50);
		typeWater 아쿠스타 = new typeWater("아쿠스타", 125, 25, 4, 60);
		typeWater 갸라도스 = new typeWater("갸라도스", 140, 25, 12, 70);
		typeWater 잉어킹 = new typeWater("잉어킹", 130, 23, 6, 60);
		typeWater 라프라스 = new typeWater("라프라스", 130, 21, 5, 60);
		typeWater 암스타 = new typeWater("암스타", 130, 26, 5, 60);
		typeWater 투구푸스 = new typeWater("투구푸스", 120, 21, 11, 60);
//
//      // Plant(이름, 체력, 공격력, 방어, 마나)
		typePlant 이상해씨 = new typePlant("이상해씨", 100, 22, 3, 50);
		typePlant 뚜벅초 = new typePlant("뚜벅초", 100, 21, 3, 40);
		typePlant 냄새꼬 = new typePlant("냄새꼬", 110, 22, 4, 50);
		typePlant 라플레시아 = new typePlant("라플레시아", 120, 23, 5, 70);
		typePlant 파라스 = new typePlant("파라스", 105, 21, 3, 50);
		typePlant 파라섹트 = new typePlant("파라섹트", 115, 23, 5, 60);
		typePlant 모다피 = new typePlant("모다피", 100, 20, 2, 40);
		typePlant 우츠보트 = new typePlant("우츠보트", 130, 25, 10, 60);
		typePlant 아라리 = new typePlant("아라리", 100, 22, 3, 50);
		typePlant 나시 = new typePlant("나시", 130, 24, 7, 60);
//
//      // Soil(이름, 체력, 공격력, 방어, 마나)
		typeSoil 모래두지 = new typeSoil("모래두지", 130, 20, 9, 40);
		typeSoil 고지 = new typeSoil("고지", 140, 21, 10, 50);
		typeSoil 디그다 = new typeSoil("디그다", 110, 20, 3, 60);
		typeSoil 꼬마돌 = new typeSoil("꼬마돌", 110, 21, 4, 40);
		typeSoil 딱구리 = new typeSoil("딱구리", 120, 23, 7, 60);
		typeSoil 롱스톤 = new typeSoil("롱스톤", 140, 26, 4, 70);
		typeSoil 탕구리 = new typeSoil("탕구리", 110, 20, 4, 50);
		typeSoil 뿔카노 = new typeSoil("뿔카노", 125, 23, 8, 60);
		typeSoil 코뿌리 = new typeSoil("코뿌리", 130, 25, 9, 60);
		typeSoil 니드킹 = new typeSoil("니드킹", 130, 23, 7, 60);

		// [포켓몬스터 속성별 리스트]
		// 전기
		ArrayList<pokemon> elecList = new ArrayList<>();
		elecList.add(피카츄);
		elecList.add(라이츄);
		elecList.add(코일);
		elecList.add(레어코일);
		elecList.add(찌리리공);
		elecList.add(붐볼);
		elecList.add(에레브);
		elecList.add(쥬피썬더);
		elecList.add(에레키드);
		elecList.add(썬더);

		// 불
		ArrayList<pokemon> fireList = new ArrayList<>();
		fireList.add(파이리);
		fireList.add(리자드);
		fireList.add(리자몽);
		fireList.add(식스테일);
		fireList.add(나인테일);
		fireList.add(마그마);
		fireList.add(브케인);
		fireList.add(마그케인);
		fireList.add(윈디);
		fireList.add(파이어);

		// 물
		ArrayList<pokemon> waterList = new ArrayList<>();
		waterList.add(꼬부기);
		waterList.add(독파리);
		waterList.add(킹크랩);
		waterList.add(야도란);
		waterList.add(아쿠스타);
		waterList.add(갸라도스);
		waterList.add(라프라스);
		waterList.add(암스타);
		waterList.add(잉어킹);
		waterList.add(투구푸스);

		// 풀
		ArrayList<pokemon> plantList = new ArrayList<>();
		plantList.add(이상해씨);
		plantList.add(뚜벅초);
		plantList.add(냄새꼬);
		plantList.add(라플레시아);
		plantList.add(파라스);
		plantList.add(파라섹트);
		plantList.add(모다피);
		plantList.add(우츠보트);
		plantList.add(아라리);
		plantList.add(나시);
		// 땅
		ArrayList<pokemon> soilList = new ArrayList<>();
		soilList.add(모래두지);
		soilList.add(고지);
		soilList.add(디그다);
		soilList.add(꼬마돌);
		soilList.add(딱구리);
		soilList.add(롱스톤);
		soilList.add(탕구리);
		soilList.add(뿔카노);
		soilList.add(코뿌리);
		soilList.add(니드킹);

//      // [관장 포켓몬 12마리]
//      // typeBossSet1(이름, 체력, 공격력, 방어)
		bossSet1 레시라무 = new bossSet1("레시라무", 130, 20, 30, "불");
		bossSet1 케르디오 = new bossSet1("케르디오", 130, 19, 30, "물");
		bossSet1 제크로무 = new bossSet1("제크로무", 130, 18, 30, "전기");
		bossSet1 악비르 = new bossSet1("악비르", 130, 17, 30, "땅");
//
//      // typeBossSet2(이름, 체력, 공격력, 방어)
		bossSet2 불카모스 = new bossSet2("불카모스", 130, 22, 10, "불");
		bossSet2 맘복치 = new bossSet2("맘복치", 130, 20, 9, "물");
		bossSet2 비리디온 = new bossSet2("비리디온", 130, 19, 9, "풀");
		bossSet2 메더 = new bossSet2("메더", 130, 12, 9, "전기");
//
//      // typeBossSet3(이름, 체력, 공격력, 방어)
		bossSet3 활화르바 = new bossSet3("활화르바", 130, 22, 9, "불");
		bossSet3 탱탱겔 = new bossSet3("탱탱겔", 130, 18, 10, "물");
		bossSet3 엘풍 = new bossSet3("엘풍", 130, 16, 11, "풀");
		bossSet3 하마돈 = new bossSet3("하마돈", 130, 15, 12, "땅");
//
//      // [관장 포켓몬 셋트별 리스트]
		ArrayList<pokemon> bossSetlist1 = new ArrayList<>();
		bossSetlist1.add(레시라무);
		bossSetlist1.add(케르디오);
		bossSetlist1.add(제크로무);
		bossSetlist1.add(악비르);
//
		ArrayList<pokemon> bossSetlist2 = new ArrayList<>();
		bossSetlist2.add(불카모스);
		bossSetlist2.add(맘복치);
		bossSetlist2.add(비리디온);
		bossSetlist2.add(메더);
//
		ArrayList<pokemon> bossSetlist3 = new ArrayList<>();
		bossSetlist3.add(활화르바);
		bossSetlist3.add(탱탱겔);
		bossSetlist3.add(엘풍);
		bossSetlist3.add(하마돈);

		// [게임 시작]
		gameStart();
		Player player = new Player();

		// [태초마을]
		System.out.println("포켓몬스터의 세계에 오신 것을 환영합니다.");
		timedelay(500);
		System.out.println("당신의 캐릭터 이름을 작성해주세요 : ");
		String playerName = sc.next();
		player.setName(playerName);
		System.out.print("-");
		timedelay(200);
		System.out.print("-");
		timedelay(200);
		System.out.print("-");
		timedelay(200);
		System.out.print("멀");
		timedelay(200);
		System.out.print("리");
		timedelay(200);
		System.out.print("서 ");
		timedelay(200);
		System.out.print("누");
		timedelay(200);
		System.out.print("군");
		timedelay(200);
		System.out.print("가 ");
		timedelay(200);
		System.out.print("걸");
		timedelay(200);
		System.out.print("어");
		timedelay(200);
		System.out.print("온");
		timedelay(200);
		System.out.print("다");
		timedelay(200);
		System.out.print("-");
		timedelay(200);
		System.out.print("-");
		timedelay(200);
		System.out.print("-");
		timedelay(200);
		System.out.println("");
		System.out.printf("오박사 : …응? 자넨  %s이잖아! 이야 많이 컸는데?", player.getName());
		timedelay(1000);
		System.out.println("");
		System.out.println("       넌 아직 자신의 포켓몬을 가져본 적이 없다고 하던데?");
		timedelay(1000);
		System.out.println("       자 한 마리를 골라 보렴");
		timedelay(1000);

		// [스타팅 포켓몬 선택]
		selectStartPokemon(player, 꼬부기, 파이리, 이상해씨);
		// 파이어를 이상해씨로 고치기(치트키 사용)

		// [게임 설명 스킵여부]
		System.out.println("");
		System.out.println("오박사 : 포켓몬 트레이닝은 처음이니??");
		timedelay(1000);
		System.out.println("--- 1. 게임 설명을 듣는다---");
		System.out.println("--- 2. S K I P ---");
		int skipOrNot = sc.nextInt();
		Explanation(skipOrNot, player);

		// 맵 선택 1~6 switch case문
		// 6. 체육관
		// 어차피 인트로 끝나면 탐험 함수 나옴
		// 전투 함수(싸우기/도망치기/전투내용/결과/전투종료)
		// System.out.println("이동하실 마을을 선택해 주세요.");
		// System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
		// int Space = sc.nextInt();
		// 탐험(Space,player.getName());

	}/////// 메인 끝

	// -----------함수 시작---------//

	// [시간 지연 함수 시작]
	public static void timedelay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}// [시간 지연 함수 끝]

	// [게임 시작 함수 시작]
	public static void gameStart() {
		System.out.println("포켓몬 게임을 시작합니다.");
		timedelay(1000);
		System.out.println("게임 진행을 원하시면 '게임실행'을 입력해주세요");
		String gamestart = sc.next();
		if (gamestart.equals("게임실행")) {
			System.out.println("게임을 시작합니다.");
			System.out.println("-------------");
		} else {
			System.out.println("오타가 있습니다. 정확한 값을 입력해주세요.");
			System.out.println("-------------");
		}
	}// [게임 시작 끝]

	// [스타팅 포켓몬 함수 시작]
	public static void selectStartPokemon(Player player, pokemon 꼬부기, pokemon 파이리, pokemon 이상해씨) {
		System.out.println("| 1-꼬부기 | 2-파이리 | 3-이상해씨 |");
		System.out.println("필히 숫자로 입력 부탁");
		System.out.print("원하시는 포켓몬을 입력해 주세요 : ");
		String userPickPockmon = sc.next();
		switch (userPickPockmon) {
		case "1":
			player.myPokemonList.add(꼬부기);
			System.out.println("-------------");
			System.out.printf("당신이 고른 포켓몬은 %s입니다.\n", 꼬부기.name);
			System.out.println("-------------");
			break;
		case "2":
			player.myPokemonList.add(파이리);
			System.out.println("-------------");
			System.out.printf("당신이 고른 포켓몬은 %s입니다.\n", 파이리.name);
			System.out.println("-------------");
			break;
		case "3":
			player.myPokemonList.add(이상해씨);
			System.out.println("-------------");
			System.out.printf("당신이 고른 포켓몬은 %s입니다.\n", 이상해씨.name);
			System.out.println("-------------");
			break;
		default:
			System.out.println("입력값이 잘못되었습니다. 숫자 1 ~ 3만 입력해 주세요.");
			selectStartPokemon(player, 꼬부기, 파이리, 이상해씨);
			break;
		}
	}// [스타팅 포켓몬 함수 끝]

	// [게임 설명 함수 시작]
	public static void Explanation(int skipOrNot, Player player) {
		switch (skipOrNot) {
		case 1: // 1. 게임 설명을 듣는다
			System.out.println("오박사 : 이제 너도 어엿한 포켓몬 트레이너가 되었으니 주의할 점을 알려주마!");
			timedelay(1000);
			System.out.println("       포켓몬은 총 5가지 속성이 있단다.");
			timedelay(1000);
			System.out.println("       각각 풀<불<물<전기<땅<풀 순서대로 상성을 보이지");
			timedelay(1000);
			System.out.println("       그러니 전투를 할 때에는 상대 포켓몬의 속성을 잘 해야겠지?");
			System.out.println("--------------------------------------------");
			timedelay(2000);
			System.out.println("오박사 : 야생 포켓몬과의 전투 중에는 포켓몬 볼을 활용하여 포켓몬을 수집할 수 있단다.");
			timedelay(1000);
			System.out.println("       다만 최대 4마리 까지만 수집가능하고, 그 이상 잡으면 5마리 중 반드시 한 마리를 선택해 버려야 한단다!");
			timedelay(1000);
			System.out.println("       잘 판단하여 너만의 훌륭한 포켓몬 조합을 만들기 바란다!");
			System.out.println("--------------------------------------------");
			timedelay(2000);
			System.out.println("오박사 : 포켓몬을 충분히 훈련했다면 체육관으로 가서 관장님을 찾아뵈렴!");
			timedelay(1000);
			System.out.println("       분명 좋은 가르침을 주실거란다!");
			timedelay(1000);
			System.out.println("       들어보니 관장님은 항상 물속성, 불속성 포켓몬들을 전투에 보내신다고 하셨어.");
			timedelay(1000);
			System.out.println("       행운을 빈다!");
			timedelay(2000);
			System.out.println("이동하실 마을을 선택해 주세요.");
			System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
			int firstMovingSpace1 = sc.nextInt();
			탐험(firstMovingSpace1, player);
			break;
		case 2: // 2. S K I P
			System.out.println("오박사 : 그렇다면 행운을 빈다!");
			timedelay(2000);
			System.out.println("이동하실 마을을 선택해 주세요.");
			System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
			int firstMovingSpace2 = sc.nextInt();
			탐험(firstMovingSpace2, player);
			break;
		default:
			System.out.println("입력값이 잘못되었습니다. 숫자 1 또는 2만 입력해 주세요.");
			System.out.println("--- 1. 게임 설명을 듣는다---");
			System.out.println("--- 2. S K I P ---");
			int Explanationwrong = sc.nextInt();
			Explanation(Explanationwrong, player);
			break;
		}
	}// [게임 설명 함수 끝]

	// [맵 함수 시작]
	public static void 탐험(int Space, Player player) {
		switch (Space) {

		case 1: // 1-풀마을
			System.out.println("앗! 야생의 풀 속성 포켓몬이 튀어나왔다!");
			timedelay(1000);
			System.out.println("전투를 하시겠습니까?");
			System.out.println("| 1-싸운다 | 2-도망간다 |");
			int chooseFightOrRun1 = sc.nextInt();

			// 풀속성 포켓몬
			typePlant 이상해씨 = new typePlant("이상해씨", 100, 22, 3, 50);
			typePlant 뚜벅초 = new typePlant("뚜벅초", 100, 21, 3, 40);
			typePlant 냄새꼬 = new typePlant("냄새꼬", 110, 22, 4, 50);
			typePlant 라플레시아 = new typePlant("라플레시아", 120, 23, 5, 70);
			typePlant 파라스 = new typePlant("파라스", 105, 21, 3, 50);
			typePlant 파라섹트 = new typePlant("파라섹트", 115, 23, 5, 60);
			typePlant 모다피 = new typePlant("모다피", 100, 20, 2, 40);
			typePlant 우츠보트 = new typePlant("우츠보트", 130, 25, 10, 60);
			typePlant 아라리 = new typePlant("아라리", 100, 22, 3, 50);
			typePlant 나시 = new typePlant("나시", 130, 24, 7, 60);

			// 풀속성 리스트
			ArrayList<pokemon> plantList = new ArrayList<>();
			plantList.add(이상해씨);
			plantList.add(뚜벅초);
			plantList.add(냄새꼬);
			plantList.add(라플레시아);
			plantList.add(파라스);
			plantList.add(파라섹트);
			plantList.add(모다피);
			plantList.add(우츠보트);
			plantList.add(아라리);
			plantList.add(나시);

			// 전투 여부 선택
			fightOrRun(chooseFightOrRun1, player.myPokemonList, plantList);
			// 전투함수(플레이어 포켓몬리스트, 싸울 리스트)

			// 전투 종료 후 이동
			System.out.println("다음으로 이동하실 마을을 선택해 주세요.");
			System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
			int movingSpace1 = sc.nextInt();
			탐험(movingSpace1, player);
			break;

		case 2: // 2-불마을
			System.out.println("앗! 야생의 불 속성 포켓몬이 튀어나왔다!");
			timedelay(1000);
			System.out.println("전투를 하시겠습니까?");
			System.out.println("| 1-싸운다 | 2-도망간다 |");
			int chooseFightOrRun2 = sc.nextInt();

			// 불속성 포켓몬
			typeFire 파이리 = new typeFire("파이리", 100, 22, 3, 50);
			typeFire 리자드 = new typeFire("리자드", 120, 24, 4, 60);
			typeFire 리자몽 = new typeFire("리자몽", 140, 26, 3, 70);
			typeFire 식스테일 = new typeFire("식스테일", 105, 23, 3, 50);
			typeFire 나인테일 = new typeFire("나인테일", 110, 24, 4, 60);
			typeFire 마그마 = new typeFire("마그마", 125, 25, 5, 60);
			typeFire 브케인 = new typeFire("브케인", 121, 23, 3, 50);
			typeFire 마그케인 = new typeFire("마그케인", 123, 24, 3, 60);
			typeFire 윈디 = new typeFire("윈디", 120, 26, 5, 50);
			typeFire 파이어 = new typeFire("파이어", 200, 31, 10, 70);

			// 불속성 리스트
			ArrayList<pokemon> fireList = new ArrayList<>();
			fireList.add(파이리);
			fireList.add(리자드);
			fireList.add(리자몽);
			fireList.add(식스테일);
			fireList.add(나인테일);
			fireList.add(마그마);
			fireList.add(브케인);
			fireList.add(마그케인);
			fireList.add(윈디);
			fireList.add(파이어);

			// 전투 여부 선택
			fightOrRun(chooseFightOrRun2, player.myPokemonList, fireList);

			// 전투 종료 후 이동
			System.out.println("다음으로 이동하실 마을을 선택해 주세요.");
			System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
			int movingSpace2 = sc.nextInt();
			탐험(movingSpace2, player);
			break;

		case 3: // 3-물마을
			System.out.println("앗! 야생의 물 속성 포켓몬이 튀어나왔다!");
			timedelay(1000);
			System.out.println("전투를 하시겠습니까?");
			System.out.println("| 1-싸운다 | 2-도망간다 |");
			int chooseFightOrRun3 = sc.nextInt();

			// 물속성 포켓몬
			typeWater 꼬부기 = new typeWater("꼬부기", 100, 22, 3, 50);
			typeWater 독파리 = new typeWater("독파리", 120, 24, 5, 70);
			typeWater 킹크랩 = new typeWater("킹크랩", 110, 20, 6, 50);
			typeWater 야도란 = new typeWater("야도란", 130, 20, 10, 50);
			typeWater 아쿠스타 = new typeWater("아쿠스타", 125, 25, 4, 60);
			typeWater 갸라도스 = new typeWater("갸라도스", 140, 25, 12, 70);
			typeWater 잉어킹 = new typeWater("잉어킹", 130, 23, 6, 60);
			typeWater 라프라스 = new typeWater("라프라스", 130, 21, 5, 60);
			typeWater 암스타 = new typeWater("암스타", 130, 26, 5, 60);
			typeWater 투구푸스 = new typeWater("투구푸스", 120, 21, 11, 60);

			// 물속성 리스트
			ArrayList<pokemon> waterList = new ArrayList<>();
			waterList.add(꼬부기);
			waterList.add(독파리);
			waterList.add(킹크랩);
			waterList.add(야도란);
			waterList.add(아쿠스타);
			waterList.add(갸라도스);
			waterList.add(라프라스);
			waterList.add(암스타);
			waterList.add(잉어킹);
			waterList.add(투구푸스);

			// 전투 여부 선택
			fightOrRun(chooseFightOrRun3, player.myPokemonList, waterList);

			// 전투 종료 후 이동
			System.out.println("다음으로 이동하실 마을을 선택해 주세요.");
			System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
			int movingSpace3 = sc.nextInt();
			탐험(movingSpace3, player);
			break;

		case 4: // 4-전기마을
			System.out.println("앗! 야생의 전기 속성 포켓몬이 튀어나왔다!");
			timedelay(1000);
			System.out.println("전투를 하시겠습니까?");
			System.out.println("| 1-싸운다 | 2-도망간다 |");
			int chooseFightOrRun4 = sc.nextInt();

			// 전기속성 포켓몬
			typeElec 피카츄 = new typeElec("피카츄", 100, 20, 5, 50);
			typeElec 라이츄 = new typeElec("라이츄", 120, 22, 6, 60);
			typeElec 코일 = new typeElec("코일", 115, 23, 2, 50);
			typeElec 레어코일 = new typeElec("레어코일", 120, 26, 3, 60);
			typeElec 찌리리공 = new typeElec("찌리리공", 100, 23, 4, 50);
			typeElec 붐볼 = new typeElec("붐볼", 120, 25, 3, 50);
			typeElec 에레브 = new typeElec("에레브", 130, 28, 8, 70);
			typeElec 쥬피썬더 = new typeElec("쥬피썬더", 160, 25, 10, 70);
			typeElec 에레키드 = new typeElec("에레키드", 115, 23, 2, 60);
			typeElec 썬더 = new typeElec("썬더", 200, 30, 10, 80);

			// 전기속성 리스트
			ArrayList<pokemon> elecList = new ArrayList<>();
			elecList.add(피카츄);
			elecList.add(라이츄);
			elecList.add(코일);
			elecList.add(레어코일);
			elecList.add(찌리리공);
			elecList.add(붐볼);
			elecList.add(에레브);
			elecList.add(쥬피썬더);
			elecList.add(에레키드);
			elecList.add(썬더);

			// 전투 여부 선택
			fightOrRun(chooseFightOrRun4, player.myPokemonList, elecList);

			// 전투 종료 후 이동
			System.out.println("다음으로 이동하실 마을을 선택해 주세요.");
			System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
			int movingSpace4 = sc.nextInt();
			탐험(movingSpace4, player);
			break;
		case 5: // 5-흙마을
			System.out.println("앗! 야생의 흙 속성 포켓몬이 튀어나왔다!");
			timedelay(1000);
			System.out.println("전투를 하시겠습니까?");
			System.out.println("| 1-싸운다 | 2-도망간다 |");
			int chooseFightOrRun5 = sc.nextInt();

			// 흙속성 포켓몬
			typeSoil 모래두지 = new typeSoil("모래두지", 130, 20, 9, 40);
			typeSoil 고지 = new typeSoil("고지", 140, 21, 10, 50);
			typeSoil 디그다 = new typeSoil("디그다", 110, 20, 3, 60);
			typeSoil 꼬마돌 = new typeSoil("꼬마돌", 110, 21, 4, 40);
			typeSoil 딱구리 = new typeSoil("딱구리", 120, 23, 7, 60);
			typeSoil 롱스톤 = new typeSoil("롱스톤", 140, 26, 4, 70);
			typeSoil 탕구리 = new typeSoil("탕구리", 110, 20, 4, 50);
			typeSoil 뿔카노 = new typeSoil("뿔카노", 125, 23, 8, 60);
			typeSoil 코뿌리 = new typeSoil("코뿌리", 130, 25, 9, 60);
			typeSoil 니드킹 = new typeSoil("니드킹", 130, 23, 7, 60);

			// 흙속성 리스트
			ArrayList<pokemon> soilList = new ArrayList<>();
			soilList.add(모래두지);
			soilList.add(고지);
			soilList.add(디그다);
			soilList.add(꼬마돌);
			soilList.add(딱구리);
			soilList.add(롱스톤);
			soilList.add(탕구리);
			soilList.add(뿔카노);
			soilList.add(코뿌리);
			soilList.add(니드킹);

			// 전투 여부 선택
			fightOrRun(chooseFightOrRun5, player.myPokemonList, soilList);

			// 전투 종료 후 이동
			System.out.println("다음으로 이동하실 마을을 선택해 주세요.");
			System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
			int movingSpace5 = sc.nextInt();
			탐험(movingSpace5, player);
			break;
		case 6: // 6-체육관
			/////// presentPokemonNumber를 입력 값이 player 에서 따오기 수정수정수정!!!!

			// 수정. 자동입뺀시스템
			////////
			player.presentPokemonNumber = player.myPokemonList.size();
			if (player.presentPokemonNumber < player.maxPokemonNumber) {
				System.out.println("보유하신 포켓몬 수가 부족하여 체육관에 입장할 수 없습니다. 4마리를 채워오세요!");
				System.out.println("이동하실 마을을 선택해 주세요.");
				System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
				int cantSpace = sc.nextInt();
				탐험(cantSpace, player);

			} else {
				System.out.printf("관장님 : 너가 바로 %s로구나! 오박사님께 말씀 많이 들었다.", player.getName());
				System.out.println("");
				System.out.println("얼마나 성장했는지 한 번 볼까?");
				timedelay(1000);
				// 수정. 관장전투 수정 시작
				// typeBossSet1
				// (이름, 체력, 공격력, 방어)
				bossSet1 레시라무 = new bossSet1("레시라무", 130, 20, 30, "불");
				bossSet1 케르디오 = new bossSet1("케르디오", 130, 19, 30, "물");
				bossSet1 제크로무 = new bossSet1("제크로무", 130, 18, 30, "전기");
				bossSet1 악비르 = new bossSet1("악비르", 130, 17, 30, "땅");
				ArrayList<pokemon> bossSetlist1 = new ArrayList<>();
				bossSetlist1.add(레시라무);
				bossSetlist1.add(케르디오);
				bossSetlist1.add(제크로무);
				bossSetlist1.add(악비르);

				// typeBossSet2
				// (이름, 체력, 공격력, 방어)
				bossSet2 불카모스 = new bossSet2("불카모스", 130, 22, 10, "불");
				bossSet2 맘복치 = new bossSet2("맘복치", 130, 20, 9, "물");
				bossSet2 비리디온 = new bossSet2("비리디온", 130, 19, 9, "풀");
				bossSet2 메더 = new bossSet2("메더", 130, 12, 9, "전기");
				ArrayList<pokemon> bossSetlist2 = new ArrayList<>();
				bossSetlist2.add(불카모스);
				bossSetlist2.add(맘복치);
				bossSetlist2.add(비리디온);
				bossSetlist2.add(메더);

				// typeBossSet3
				// (이름, 체력, 공격력, 방어)
				bossSet3 활화르바 = new bossSet3("활화르바", 130, 22, 9, "불");
				bossSet3 탱탱겔 = new bossSet3("탱탱겔", 130, 18, 10, "물");
				bossSet3 엘풍 = new bossSet3("엘풍", 130, 16, 11, "풀");
				bossSet3 하마돈 = new bossSet3("하마돈", 130, 15, 12, "땅");
				ArrayList<pokemon> bossSetlist3 = new ArrayList<>();
				bossSetlist3.add(활화르바);
				bossSetlist3.add(탱탱겔);
				bossSetlist3.add(엘풍);
				bossSetlist3.add(하마돈);
				//////////
				if (count == 1) {
					System.out.println("두번째 도전입니다.");
					System.out.println("이번에도 관장에게 패배시 게임이 종료되므로 힘을 내서 관장을 이겨주세요!");
				}
				int bossListRandom = (int) (Math.random() * 3);
				switch (bossListRandom) {
				case 0:
					enemaBattle(player.myPokemonList, bossSetlist1);
					break;
				case 1:
					enemaBattle(player.myPokemonList, bossSetlist2);
					break;
				case 2:
					enemaBattle(player.myPokemonList, bossSetlist3);
					break;
				}
				if (count == 2) {
					System.exit(0);
				}
				// 관장전투 수정끝
				System.out.println("전투가 종료되었습니다.");
				timedelay(1000);
				System.out.println("다음으로 이동하실 마을을 선택해 주세요.");
				System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
				int movingSpace6 = sc.nextInt();
				탐험(movingSpace6, player);
			}
			break;
		default:
			System.out.println("입력값이 잘못되었습니다. 숫자 1 ~ 6사이의 숫자만 입력해 주세요.");
			System.out.println("이동하실 마을을 선택해 주세요.");
			System.out.println("| 1-풀마을 | 2-불마을 | 3-물마을 | 4-전기마을 | 5-흙마을 | 6-체육관 |");
			int wrongSpace = sc.nextInt();
			탐험(wrongSpace, player);
		}
	}// [맵 함수 끝]

	// [포켓볼 함수 시작]
	public static boolean 포획률(int 최대HP, int 현재HP, String 포켓몬이름) {
		// 확률
		System.out.println("플레이어는 몬스터볼을 사용했다!");
		double 포획률 = (3 * 최대HP - 2 * 현재HP) * 150 / (3 * 최대HP);
//         System.out.println("포획률:"+포획률 );
		// 공식 (1차포획률이 숫자 255를 넘으면 무조건 포획)
		if (포획률 >= 255) {
			System.out.printf("신난다! %s을(를) 붙잡았다!", 포켓몬이름);
			return true;
		}

		// 공식 (1차포획률이 255를 안넘을 경우 흔들림공식을 이용)
		else {

			// 임의로 65535 이하의 난수 4개 구해서 배열로 오름차순하기
			double 흔들림포획률 = 포획률 / 255;
//            System.out.println("흔들림포획률:"+흔들림포획률);
			double 흔들림공식 = 65535 * Math.pow(흔들림포획률, 1.0 / 4.0);
			// Math.pow로 4제곱근 구현
//            System.out.println("흔들림공식:"+흔들림공식);
			int 흔들림공식반올림 = (int) Math.round(흔들림공식);
//            System.out.println("흔들림공식반올림:"+흔들림공식반올림);
			int 흔들림랜덤변수[] = new int[4];
			for (int i = 0; i < 4; i++) {
				int 랜덤선정 = (int) (Math.random() * 65536);
//               System.out.println("랜덤선정"+i+":"+랜덤선정);
				흔들림랜덤변수[i] = 랜덤선정;
			}
			Arrays.sort(흔들림랜덤변수);
//            for(int k = 0; k<4; k++) {
//               System.out.println("흔들림랜덤변수"+k+":"+흔들림랜덤변수[k]);
//            }

			// 65535 이하의 난수를 1,2,3,4번째랑 흔들림공식이랑 반복문으로 비교해서

			for (int j = 0; j < 4; j++) {
				// 흔들림공식 < 난수 이면 3번까지 흔들(약간의 지연시간 입력)
				if (흔들림랜덤변수[j] < 흔들림공식반올림) {

					// 4번째는 대사를 다르게 설정해서 포획
					if (j == 3) {
						try {
							TimeUnit.SECONDS.sleep((long) 1.5);
							System.out.printf("신난다! %s을(를) 붙잡았다!", 포켓몬이름);
						} catch (Exception e) {
							System.out.println(e);
						}
						return true;
					}
					// 1,2,3번째는 흔들...(지연시간 추가)
					else {
						try {
							TimeUnit.SECONDS.sleep((long) 1.5);
							System.out.println("흔들" + ".".repeat(j + 2));
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}

				// 흔들림공식 >= 난수 이면 잡기 실패
				else {
					System.out.println("안돼! 포켓몬이 볼에서 나와버렸다!");
					return false;
				}
			}

			// 4번째에는 놓치는 걸로
			if (흔들림랜덤변수[3] < 흔들림공식반올림) {
				System.out.println("안돼! 포켓몬이 볼에서 나와버렸다!");
				return false;
			} else {
				System.out.printf("신난다! %s을(를) 붙잡았다!", 포켓몬이름);
				return true;
			}
		}
	} // [포켓볼 함수 끝]

	// [전투 여부 함수 시작]
	public static void fightOrRun(int chooseFightOrRun, ArrayList<pokemon> 내포켓몬리스트, ArrayList<pokemon> 속성별리스트) {
		switch (chooseFightOrRun) {
		case 1:
			wildBattle(내포켓몬리스트, 속성별리스트);
		case 2:
			break;
		default:
			System.out.println("입력값이 잘못되었습니다. 숫자 1 ~ 3사이의 숫자만 입력해 주세요.");
			timedelay(1000);
			System.out.println("전투를 하시겠습니까?");
			System.out.println("| 1-싸운다 | 2-도망간다 |");
			int wrongChooseFightOrRun = sc.nextInt();
			fightOrRun(wrongChooseFightOrRun, 내포켓몬리스트, 속성별리스트);
		}

	}// [전투 여부 함수 끝]

	// [야생전투 함수 시작]
	public static void wildBattle(ArrayList<pokemon> 내포켓몬리스트, ArrayList<pokemon> 속성별리스트) {
		// 속성별리스트 랜덤으로 돌려서 전투할 야생 포켓몬 지정
		int random1 = (int) (Math.random() * 10);
		pokemon enemy = 속성별리스트.get(random1);

		System.out.printf("야생의 포켓문은 %s이다!\n", enemy.name);

		// -전투할 플레이어 포켓몬 선정-
		System.out.println("내고싶은 포켓몬을 선택해주세요!");
		timedelay(1000);
		System.out.println("--------[나의 포켓몬리스트]--------");
		for (int i = 0; i < 내포켓몬리스트.size(); i++) {
			System.out.printf("| %d-%s (현재 체력 : %d)", i + 1, 내포켓몬리스트.get(i).name, 내포켓몬리스트.get(i).presentHp);
		}
		System.out.println("|");
		System.out.println("-------------------------------");
		System.out.printf("\n");
		int choosepokemon = sc.nextInt();
		pokemon playerPick = 내포켓몬리스트.get(choosepokemon - 1);
		System.out.printf("%s를(을) 선택하셨습니다.", 내포켓몬리스트.get(choosepokemon - 1).name);
		System.out.println("");
		timedelay(2000);

		// -본격적인 전투 시작-
		Loop2: while (enemy.presentHp > 10 && playerPick.presentHp > 10) {
			System.out.println("-------------------");
			timedelay(1000);
			System.out.println("[알림] 나의턴입니다.");
			System.out.println("-------------------");
			timedelay(1000);
			System.out.println("사용하실 스킬을 선택해 주세요.");
			System.out.println("| 1-기본 공격 | 2-스킬1 (마나 30 소모) | 3-스킬2 (마나 50 소모) | 4-포켓몬 볼 | 5-도망치기 |");
			int atc = sc.nextInt(); // attack Choose
			if (atc == 1) {// -기본공격-
				System.out.println("-------------------");
				playerPick.기본공격(enemy);
				timedelay(1000);
				System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
				timedelay(1000);
				System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
				System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
				timedelay(2000);
			} else if (atc == 2) {// -스킬1-
				if (playerPick.presentMp >= 30) {
					if (playerPick.type.equals("전기")) { // 원시형 8가지는 써도되는데 주소참조형은 ==을 쓰지 않는 이유는 주소를 가져오기 때문.
						playerPick.스킬1(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} else if (playerPick.type.equals("불")) {
						playerPick.스킬3(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} else if (playerPick.type.equals("풀")) {
						playerPick.스킬5(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} else if (playerPick.type.equals("땅")) {
						playerPick.스킬7(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} else if (playerPick.type.equals("물")) {
						playerPick.스킬9(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} // 마나 충분 시 스킬1 실행 함수 끝
				} else {// 스킬1 사용할 만큼의 마나가 충분하지 않을 땐 기본공격 ㄱ
					System.out.printf("%s의 마나가 스킬을 사용하기에 부족합니다!\n", playerPick.name);
					System.out.printf("%s가 기본공격을 실시합니다!\n", playerPick.name);
					System.out.println("-------------------");
					timedelay(2000);
					playerPick.기본공격(enemy);
					timedelay(1000);
					System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
					timedelay(1000);
					System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
					System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
					timedelay(2000);
				} // -스킬1 끝

			} else if (atc == 3) {// -스킬2-
				if (playerPick.presentMp >= 50) {
					if (playerPick.type.equals("전기")) { // 원시형 8가지는 써도되는데 주소참조형은 ==을 쓰지 않는 이유는 주소를 가져오기 때문.
						playerPick.스킬2(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} else if (playerPick.type.equals("불")) {
						playerPick.스킬4(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} else if (playerPick.type.equals("풀")) {
						playerPick.스킬6(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} else if (playerPick.type.equals("땅")) {
						playerPick.스킬8(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} else if (playerPick.type.equals("물")) {
						playerPick.스킬10(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} // 마나 충분 시 스킬2 실행 함수 끝
				} else {// 스킬2 사용할 만큼의 마나가 충분하지 않을 땐 기본공격 ㄱ
					System.out.printf("%s의 마나가 스킬을 사용하기에 부족합니다!\n", playerPick.name);
					System.out.printf("%s가 기본공격을 실시합니다!\n", playerPick.name);
					System.out.println("-------------------");
					timedelay(2000);
					playerPick.기본공격(enemy);
					timedelay(1000);
					System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
					timedelay(1000);
					System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
					System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
					timedelay(2000);
				} // -스킬2 끝
			} else if (atc == 4) {// -포켓볼-

				if (포획률(enemy.maxHp, enemy.presentHp, enemy.name) == true) {
					if (내포켓몬리스트.size() < 4) {
						내포켓몬리스트.add(enemy);
						timedelay(2000);
						System.out.println("");
						System.out.printf("현재 보유중인 포켓몬은 %d 총 마리 입니다.\n", 내포켓몬리스트.size());
						timedelay(1000);
						System.out.println("--------[나의 포켓몬리스트]--------");
						for (int i = 0; i < 내포켓몬리스트.size(); i++) {

							System.out.printf("%d. %s     \n", i + 1, 내포켓몬리스트.get(i).name);
							// 내 리스트에 추가
						}
						System.out.println("-------------------------------");
						timedelay(2000);
					} else { // 여기서 제거해야해. 내가 선택하는 놈을.
						// syso ("보유할 수 있는 총 포켓몬 양을 초과했습니다. 포기할 포켓몬을 선택해 주세요.")
						timedelay(2000);
						System.out.println("");
						System.out.printf("현재 보유중인 포켓몬은 %d 총 마리 입니다.\n", 내포켓몬리스트.size());
						timedelay(1000);
						System.out.println("포기할 포켓몬을 선택해주세요!");
						timedelay(1000);
						System.out.println("--------[나의 포켓몬리스트]--------");
						for (int i = 0; i < 내포켓몬리스트.size(); i++) {
							System.out.printf("%d. %s     \n", i + 1, 내포켓몬리스트.get(i).name);
						}
						System.out.println("-------------------------------");

						// 버릴 포켓몬 입력 받기
						int 버릴포켓몬 = sc.nextInt();
						내포켓몬리스트.remove(버릴포켓몬 - 1);
						// 사용자가 번호입력한것 을 받는다
						// 내포켓몬리스트.remove(사용자가 입력한 번호)
						// 내리스트에 추가 enemy를
						내포켓몬리스트.add(enemy);
						System.out.println("--------[나의 포켓몬리스트]--------");
						for (int i = 0; i < 내포켓몬리스트.size(); i++) { // 여기서 제거된 리스트에 방금 잡은enemy를 넣어야 해
							System.out.printf("%d. %s     \n", i + 1, 내포켓몬리스트.get(i).name);
						}
						System.out.println("-------------------------------");
						timedelay(2000);
					}
					break Loop2;
				}
			} else if (atc == 5) {// -도망가기 시작- (확률)
				// 도망성공 확률식
				// '확률식' 5로 나눈 나머지가 1,2,3,4 일땐 도망 성공
				int 확률식 = (int) Math.round((Math.random() * 1000));
				if (확률식 % 5 != 0) {
					// 도망 성공
					System.out.println("무사히 도망쳤다.");
					timedelay(1000);
					System.out.print("휴");
					timedelay(200);
					System.out.print(".");
					timedelay(200);
					System.out.print(".");
					timedelay(200);
					System.out.print(".");
					timedelay(200);
					System.out.println("살았다.");
					timedelay(2000);
					break;
				} else {// 도망 실패
					System.out.println("도망에 실패했습니다.");
					timedelay(1000);
					System.out.println("야생포켓몬의 공격이 들어옵니다.");
					timedelay(2000);
				}
			} // -도망가기 끝-

			else {// -입력값 오류-
				System.out.println("입력값이 잘못되었습니다. 1 ~ 5 사이의 숫자만 입력해 주세요.");
				timedelay(1000);
				System.out.println("입력값이 잘못되었으므로, 자동으로 기본공격을 실시합니다!");
				System.out.println("-------------------");
				timedelay(2000);
				playerPick.기본공격(enemy);
				timedelay(1000);
				System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
				timedelay(1000);
				System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
				System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
				timedelay(2000);
			}

			if (enemy.presentHp <= 10) {
				System.out.printf("야생의 %s는 쓰러졌다\n", enemy.name);
				timedelay(2000);
				break;
			}
			timedelay(1000);
			// -상대 포케몬 공격 턴-
			if (playerPick.presentHp > 10) {
				timedelay(1000);
				System.out.println("-------------------");
				System.out.printf("[알림] %s의턴입니다.\n", enemy.name);
				System.out.println("-------------------");
				timedelay(1000);
				int enemyAction = (int) (Math.random() * 3) + 1; // 이부분 1~3 랜덤값추출
				if (enemyAction == 1) {
					enemy.기본공격(playerPick);
					timedelay(1000);
					System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
					timedelay(1000);
					System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
					System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
					timedelay(2000);
					// 상대포켓몬이 스킬을 안써요 살려줘

				} else if (enemyAction == 2) {// -스킬1-
					if (enemy.presentMp >= 30) {
						if (enemy.type.equals("전기")) { // 원시형 8가지는 써도되는데 주소참조형은 ==을 쓰지 않는 이유는 주소를 가져오기 때문.
							enemy.스킬1(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} else if (enemy.type.equals("불")) {
							enemy.스킬3(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} else if (enemy.type.equals("풀")) {
							enemy.스킬5(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} else if (enemy.type.equals("땅")) {
							enemy.스킬7(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} else if (enemy.type.equals("물")) {
							enemy.스킬9(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} // 마나 충분 시 스킬1 실행 함수 끝
					} else {// 스킬1 사용할 만큼의 마나가 충분하지 않을 땐 기본공격 ㄱ
						System.out.printf("%s의 마나가 스킬을 사용하기에 부족합니다!\n", enemy.name);
						System.out.printf("%s가 기본공격을 실시합니다!\n", enemy.name);
						System.out.println("-------------------");
						timedelay(2000);
						enemy.기본공격(playerPick);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
						timedelay(2000);
					} // -스킬1 끝

				} else if (enemyAction == 3) {// -스킬2-
					if (enemy.presentMp >= 50) {
						if (enemy.type.equals("전기")) { // 원시형 8가지는 써도되는데 주소참조형은 ==을 쓰지 않는 이유는 주소를 가져오기 때문.
							enemy.스킬2(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} else if (enemy.type.equals("불")) {
							enemy.스킬4(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} else if (enemy.type.equals("풀")) {
							enemy.스킬6(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} else if (enemy.type.equals("땅")) {
							enemy.스킬8(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} else if (enemy.type.equals("물")) {
							enemy.스킬10(playerPick);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", enemy.name, enemy.presentMp);
							timedelay(2000);
						} // 마나 충분 시 스킬2 실행 함수 끝
					} else {// 스킬2 사용할 만큼의 마나가 충분하지 않을 땐 기본공격 ㄱ
						System.out.printf("%s의 마나가 스킬을 사용하기에 부족합니다!\n", enemy.name);
						System.out.printf("%s가 기본공격을 실시합니다!\n", enemy.name);
						System.out.println("-------------------");
						timedelay(2000);
						enemy.기본공격(enemy);
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					} // -스킬2 끝
				}
			}
			// -전투 결과-
		} // -while문 끝-
		System.out.println("전투가 종료되었습니다.");
		System.out.println("-------------------");
		timedelay(2000);
		// -전투에 참여한 모든 포켓몬의 hp, 마나, 방어력 원상복구-
		// 모든 포켓몬은 hp가 max hp가 된다.
		playerPick.presentHp = playerPick.maxHp;
		enemy.presentHp = enemy.maxHp;
		// 모든 포켓몬은 마나가 max 마나가 된다.
		playerPick.presentMp = playerPick.maxMp;
		enemy.presentMp = enemy.maxMp;
		// 모든 포켓몬은 방어력은 기존 방어력이 된다.
		playerPick.presentDefence = playerPick.defence;
		enemy.presentDefence = enemy.defence;

	}// [야생전투 함수 끝]

	// [관장전투 함수 시작]
	public static void enemaBattle(ArrayList<pokemon> myPokemonList, ArrayList<pokemon> enemylist) {
		int j = 0;
		int m = 0;
		pokemon playerPick = null;
		pokemon enemy = null;
		Loop1: for (int i = 0; i < myPokemonList.size() + 7; i++) {
			System.out.println("내고싶은 포켓몬을 선택해주세요!");
			timedelay(1000);
			System.out.println("--------[나의 포켓몬리스트]--------");
			for (int z = 0; z < myPokemonList.size(); z++) {
				System.out.printf("| %d-%s (현재 체력 : %d, 타입 : %s)", z + 1, myPokemonList.get(z).name,
						myPokemonList.get(z).presentHp, myPokemonList.get(z).type);
			}
			System.out.println("|");
			System.out.println("-------------------------------");
			int choosepokemon = sc.nextInt();
			playerPick = myPokemonList.get(choosepokemon - 1);
			System.out.printf("%s를(을) 선택하셨습니다.\n", myPokemonList.get(choosepokemon - 1).name);
			System.out.println("");
			timedelay(2000);

			enemy = enemylist.get(j);
			while (enemy.presentHp > 10 && playerPick.presentHp > 10) {
				System.out.println("-------------------");
				timedelay(1000);
				System.out.println("[알림] 나의턴입니다.");
				System.out.println("-------------------");
				timedelay(1000);
				System.out.println("사용하실 스킬을 선택해 주세요.");
				System.out.println("| 1. 공격 | 2. 스킬1 (마나 30 소모) | 3. 스킬2(마나 50 소모) |");
				int chooseAction = sc.nextInt();
				if (enemy.presentHp > 10) {
					if (chooseAction == 1) {// -기본공격-
						System.out.println("-------------------");
						playerPick.기본공격(enemy);
						System.out.println("-------------------");
						timedelay(1000);
						System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
//                  System.out.println("-------------------");
						timedelay(2000);
					} else if (chooseAction == 2) {
						if (playerPick.presentMp >= 30) {
							if (playerPick.type.equals("불")) {
								playerPick.스킬3(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
//                        System.out.println("-------------------");
								timedelay(2000);
							} else if (playerPick.type.equals("물")) {
								playerPick.스킬9(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
//                        System.out.println("-------------------");
								timedelay(2000);
							} else if (playerPick.type.equals("풀")) {
								playerPick.스킬5(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
//                        System.out.println("-------------------");
								timedelay(2000);
							} else if (playerPick.type.equals("전기")) {
								playerPick.스킬1(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
//                        System.out.println("-------------------");
								timedelay(2000);
							} else {
								playerPick.스킬7(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
//                        System.out.println("-------------------");
								timedelay(2000);
							}
						} else {// 스킬1 사용할 만큼의 마나가 충분하지 않을 땐 기본공격 ㄱ
							System.out.printf("%s의 마나가 스킬을 사용하기에 부족합니다!\n", playerPick.name);
							System.out.printf("%s가 기본공격을 실시합니다!\n", playerPick.name);
							System.out.println("-------------------");
							timedelay(2000);
							playerPick.기본공격(enemy);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
							timedelay(2000);
//                     System.out.println("-------------------");
						}
					} else if (chooseAction == 3) {// -스킬2-
						if (playerPick.presentMp >= 50) {
							if (playerPick.type.equals("전기")) { // 원시형 8가지는 써도되는데 주소참조형은 ==을 쓰지 않는 이유는 주소를 가져오기 때문.
								playerPick.스킬2(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
								timedelay(2000);
							} else if (playerPick.type.equals("불")) {
								playerPick.스킬4(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
								timedelay(2000);
							} else if (playerPick.type.equals("풀")) {
								playerPick.스킬6(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
								timedelay(2000);
							} else if (playerPick.type.equals("땅")) {
								playerPick.스킬8(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
								timedelay(2000);
							} else if (playerPick.type.equals("물")) {
								playerPick.스킬10(enemy);
								timedelay(1000);
								System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
								timedelay(1000);
								System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
								System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
								timedelay(2000);
							} // 마나 충분 시 스킬2 실행 함수 끝
						} else {// 스킬2 사용할 만큼의 마나가 충분하지 않을 땐 기본공격 ㄱ
							System.out.printf("%s의 마나가 스킬을 사용하기에 부족합니다!\n", playerPick.name);
							System.out.printf("%s가 기본공격을 실시합니다!\n", playerPick.name);
							System.out.println("-------------------");
							timedelay(2000);
							playerPick.기본공격(enemy);
							timedelay(1000);
							System.out.printf("%s의 공격은 성공적이였다!\n", playerPick.name);
							timedelay(1000);
							System.out.printf("%s의 체력은 %d남았다.\n", enemy.name, enemy.presentHp);
							System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
							timedelay(2000);
						}
					} // -스킬2 끝
				}
				if (enemy.presentHp <= 10) {
					System.out.printf("%s는 쓰러졌다\n", enemy.name);
					timedelay(2000);
					j++;
					if (j == 4) {
						System.out.println("관장의 모든 포켓몬을 쓰러트렸다!");
						System.out.println("-------------------");
						timedelay(2000);
						System.out.println("게임에서 승리하였다!");
						timedelay(2000);
						System.out.println("엔딩 - 게임이 종료되었습니다.");
						System.exit(0);
					}
					break;
				}
				/*
				 * 상대턴 적기 if (내포켓몬 체력 >0){ System.out.printf("[알림] %s의턴입니다.\n",enemy.name); int
				 * enemyAction = (int)(Math.random()); if(enemyAction == 0) {
				 * enemy.기본공격(playerPick); System.out.println("-------------------");
				 * System.out.printf("%s의 공격은 성공적이였다!\n",enemy.name);
				 * System.out.printf("%s의 체력은 %d남았다.\n",playerPick.name,playerPick.presentHp);
				 * System.out.println("-------------------");
				 * 
				 * }
				 */

				if (playerPick.presentHp > 10) {
					timedelay(1000);
					System.out.println("-------------------");
					System.out.printf("[알림] %s의턴입니다.\n", enemy.name);
					timedelay(1000);
					int enemyAction = (int) (Math.random());
					if (enemyAction == 0) {
						System.out.println("-------------------");
						enemy.기본공격(playerPick);
						timedelay(1000);
						System.out.println("-------------------");
						System.out.printf("%s의 공격은 성공적이였다!\n", enemy.name);
						timedelay(1000);
						System.out.printf("%s의 체력은 %d남았다.\n", playerPick.name, playerPick.presentHp);
						System.out.printf("%s의 현재 마나는 %d이다.\n", playerPick.name, playerPick.presentMp);
						timedelay(2000);
					}

				} else {
					System.out.printf("나의 %s이 쓰러졌다\n", playerPick.name);
					timedelay(1000);
					System.out.printf("수고했어 %s. 포켓볼로 돌아와!!", playerPick.name);
					timedelay(2000);

					// 플레이어가 패배했을 때 코드
					m++;
					timedelay(2000);
					if (m >= 4) {
						System.out.println("멀었구나 애송이! 더 성장해서와라!");
						break Loop1;
					}
					System.out.println(); // 뭔놈이야??
				}
			}
			timedelay(2000);
		}
		count++;
		for (int l = 0; l < myPokemonList.size(); l++) {
			myPokemonList.get(l).presentHp = myPokemonList.get(l).maxHp;
			myPokemonList.get(l).presentMp = myPokemonList.get(l).maxMp;
			enemylist.get(l).presentHp = enemylist.get(l).maxHp;
			enemylist.get(l).presentMp = enemylist.get(l).maxMp;
		}
	}
	// [관장전투함수 끝]
}// class 끝