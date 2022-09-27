# 자바 토이 프로젝트
## 포켓몬스터 게임 구현 (자바)
- 기간 : 2022.09.22 - 2022.09.26
- 팀원 : 정민경 외 4명
- 주제 : 포켓몬스터 게임 자바로 간단하게 구현해보기

## 프로젝트 정보
- 사용되는 언어: Java 11
- 사용된 도구: sts 3
- 인코딩 : MS949

<details>
<summary>프로젝트 설명 상세보기</summary>
    <div markdown="1">

  - 1.게임시작

  - 2.태초마을
    - 스타팅 포켓몬 선택
    - 게임 설명 (스킵 가능)

  - 3.모험시작
    - 풀마을 (야생전투)
    - 불마을 (야생전투)
    - 물마을 (야생전투)
    - 전기마을 (야생전투)
    - 흙마을 (야생전투)
    - 체육관 (관장전투)
---
  - *포켓몬스터 등록 : 
    - 기본 포켓몬
      - 총 5개 속성  
        풀 < 불 < 물 < 전기 < 땅 < 풀
      - 각 속성 별로 포켓몬 10마리
      - 총 50마리
    - 관장 포켓몬
      - 총 3셋트
      - 각 셋트 당 4마리
      - 총 12마리
      - 관장 포켓몬은 스킬이 없음. 초급자인 플레이어가 스킬까지 사용하는 관장의 포켓몬을 이길 수 없기 때문.
---
  - *포켓볼 :
    - 실제 포켓몬 게임 속의 포켓볼 포획률을 코드에 적용함.
    - 실제 포켓몬 게임 속의 흔들림 공식을 코드에 적용함.
---
  - *야생전투 (1대1): 
    - 인트로
      - "전투를 하시겠습니까?"  
        | 1-싸운다 | 2-도망간다 |  
      - "내고싶은 포켓몬을 선택해주세요!"  
        --------[나의 포켓몬리스트]--------
    - 대결
      - 플레이어 턴  
        | 1-기본 공격 | 2-스킬1 (마나 30 소모) | 스킬2 (마나 50 소모) | 포켓몬 볼 | 도망치기 |  
        플레이어가 선택한 행동 실시 
        마나가 부족한데 스킬을 사용하면 자동으로 기본공격이 들어감.  
      - 야생 포켓몬 턴  
        | 1-기본 공격 | 2-스킬1 (마나 30 소모) | 스킬2 (마나 50 소모) |  
        랜덤으로 공격  
        마나가 부족한데 스킬을 사용하면 자동으로 기본공격이 들어감.  
      - 결과
        - [결과1] 플레이어 포켓몬 hp 10 → 패배  
          hp 10가 된 포켓몬은 다음 전투에서 기존 hp로 자동 충전  
        - [결과2] 포켓몬 잡기(def 포켓몬볼 사용) → 잡힘
          - 포켓몬 추가  
            잡은 포켓몬의 이름을 [플레이어 현재 포켓몬 리스트]에 입력한다.  
            [플레이어의 현재 포켓몬 갯수]에 +1을 한다.  
          - 포켓몬 버리기  
            해당 버튼은 5번째 포켓몬을 잡았을 때에만 생성된다.  
            그 외에는 사용 불가  
            *코드*  
            사용자가 선택한 번호= a, a-1번째 인덱스  
            기존 배열 중 사용자가 버린 포켓몬과, 잡은 포켓몬 바꿔치기  
        - [결과3] 포켓몬 잡기(def 포켓몬볼 사용) → 놓침
        - [결과4] 야생 포켓몬 hp 10 → 도망, 수집 불가
      - 대결 종료
        전투에 참여한 모든 포켓몬의 hp, 마나, 방어력을 기존 게이지로 원상복구한다.  
---
  - *관장전투 (4대4):  
    - 인트로  
      플레이어가 보유한 포켓몬이 4마리 미만이면 체육관에 입장 불가  
    - 대결
      - 플레이어 턴  
        | 1-기본 공격 | 2-스킬1 (마나 30 소모) | 스킬2 (마나 50 소모) |  
        플레이어가 선택한 행동 실시  
        마나가 부족한데 스킬을 사용하면 자동으로 기본공격이 들어감.  
      - 관장 포켓몬 턴  
        | 1-기본 공격 |  
      - 결과  
        4:4에서 먼저 상대의 모든 포켓몬 hp를 10으로 만든 사람 승리
        - [결과1] 관장 승리
          - 재도전 1번 가능
          - | 1-야생 전투로 돌아가 포켓몬 재구성하기 | 2-바로 재도전 |
          - 재도전에서도 관장이 승리하면  
            플레이어 패배. 게임 종료.
        - [결과2] 플레이어 승리  
          플레이어 승리. 게임 종료.
      - 대결 종료  
        전투에 참여한 모든 포켓몬의 hp, 마나, 방어력을 기존 게이지로 원상복구한다.

    </div>
</details>



## 코드
- [포켓몬 프로젝트 코드 파일](https://github.com/sallyzmk/sallyzmk_project/tree/main/Pokemon/src)

## 소개 자료
- [PDF]()
- [게임 시연 영상]()

---
# English ver.
# Java Toy Project
## Implementation of Pokemon game (Java)
- Project Duration : 2022.09.22 - 2022.09.26
- The number of Teammate : Min Kyung Joung and four others
- Subject : Simple implementation of a Pokemon game in Java

## Project info
- Language used : Java 11
- Tools used : sts 3
- incoding : MS949
- Explanation : 
<details>
<summary>View project description details</summary>
    <div markdown="1">

  - 1.starting Game

  - 2.beginning village
    - Choose your starting pokemon
    - Game description (skipable)

  - 3.Adventure begins
    - Plant Village (Wild Battle)
    - Fire Village (Wild Battle)
    - Water Village (Wild Battle)
    - Electric Village (Wild Battle)
    - Dirt Village (Wild Battle)
    - Gym (Chief Battle)
---
  - *Pokemon registration: 
    - Basic Pokemon
      - five kinds of attributes  
        grass < fire < water < electricity < land < grass
      - 10 Pokémon for each attribute
      - 50 in total
    - Enema Pokémon
      - 3 sets in total
      - 4 in each set
      - 12 in total
      - The leader Pokemon has no skills. Because a beginner player cannot defeat the leader's Pokémon, which even uses skills.
---
  - *Pocket Ball:
    - Applying the Pokeball catch rate in the actual Pokemon game to the code.
    - Applied the shaking formula from the actual Pokemon game to the code.
---
  - *Wild Battle (1v1):
    - intro 
      - "Would you like to fight?"  
        | 1 - Fight | 2 - run away |
      - "Please select the Pokemon you want to play!"  
        --------[My Pokemon List]--------  
    - Battle
      - player turn  
        | 1 - Basic Attack | 2-Skill 1 (consumes 30 mana) | Skill 2 (Consumes 50 Mana) | Pokemon Ball | run away |  
        Perform actions chosen by the player  
        When you use a skill when you run out of mana, you automatically get a basic attack.  
      - Wild Pokemon Turn  
        | 1 - Basic Attack | 2-Skill 1 (consumes 30 mana) | Skill 2 (Consumes 50 Mana) |  
        attack at random  
        When you use a skill when you run out of mana, you automatically get a basic attack.  
      - result
        - [Result 1] Player Pokemon hp 10 → Defeat  
          Pokémon with 10 HP will be automatically recharged with original HP in the next battle.  
        - [Result 2] Catching Pokemon (using def Pokemon Ball) → Caught
          - Added Pokemon  
            Enter the name of the Pokémon you caught in the [Player's Current Pokémon List].  
            Add +1 to [player's current number of Pokémon].  
          - Release Pokemon  
            This button is only created when the 5th Pokémon is caught.  
            not usable otherwise  
            *code*  
            User-selected number = a, a-1th index  
            Swap the Pokémon that the user discarded and the Pokémon caught in the existing arrangement  
        - [Result 3] Catching Pokemon (using def Pokemon Ball) → Missed
        - [Result 4] Wild Pokémon hp 10 → Run away, cannot be collected
      - End of confrontation
        Restores the HP, Mana, and Defense of all Pokémon participating in battle to their original gauges.  
---
  - *Director Battle (4v4):  
    - intro  
      If a player has less than 4 Pokémon, they cannot enter the gym.  
    - Battle
        - player turn  
        | 1 - Basic Attack | 2-Skill 1 (consumes 30 mana) | Skill 2 (Consumes 50 Mana) |  
        Actual action chosen by the player  
        When you use a skill when you run out of mana, you automatically get a basic attack.  
      - Director Turn  
        | 1 - Basic Attack |
      - result  
        The first player to bring all opponent's Pokémon to 10 HP wins at 4:4
        - [Result 1] Director wins
          - Player can retry once.
          - | 1 - Return to Wild Battles and Rebuild Pokémon | 2- Retry right away |
          - If the director wins in the re-challenge  
            player defeat. game over.
        - [Result 2] Player wins  
          player wins. game over.
      - End of confrontation  
        Restores the HP, Mana, and Defense of all Pokémon participating in battle to their original gauges.

    </div>
</details>

## code
- [Pokemone Project code file](https://github.com/sallyzmk/sallyzmk_project/tree/main/Pokemon/src)  

## Introduction our game
- [PDF]()
- [Game Demo Video]()