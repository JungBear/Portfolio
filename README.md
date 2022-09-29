# project
## 정보
- 이름 : 정상필
- 출생년도 : 1997년 02월 02일
- 이메일 : <mod459@naver.com>
- - -

## 학력
- 2012년 03월. 성일고 입학
- 2015년 02월. 성일고 졸업
- 2015년 03월. 청주대 컴퓨터정보공학과 입학
- 2017년 04월. 12사단 정보통신대대 입대
- 2019년 01월. 전역
- 2022년 02월. 청주대 소프트웨어융합학부 인공지능소프트웨어전공 졸업
- - -

## 대외활동
- AI데이터플랫폼을 활용한 빅데이터 분석전문가 과정 3기
    - 기간 : 2022년 06월 16일 ~ 2022년 12월 07일 
    - 기관 : 휴면교육센터
    - 내용 : Python 기반 데이터 분석 및 챗봇만들기 프로젝트, JAVA 기반 웹 개발 및 프로젝트
- - -

## 아르바이트
- 캐리비안 베이 그린서비스
    - 기간 : 2015년 06월 ~ 2015년 08월
    - 내용 : 손님응대 및 환경미화
- 정통집 청주점
    - 기간 : 2020년 09월 ~ 2021년 12월
    - 내용 : 손님응대, 음식제조 및 발주, 매장관리
- - -

 ## 프로젝트
1. 자율주행자동차 lv.1
- 폴더명 : [subscoripition_chatbot](https://github.com/JungBear/project/tree/main/subscoription_chatbot)
- 기간 : 2021년 03월 ~ 2021년 06월
- 인원 : 정상필 외 2명
- 사용언어 : ```Python```


- - -

2. 주택청약 챗봇 프로젝트
- 폴더명 : [subscoripition_chatbot](https://github.com/JungBear/project/tree/main/subscoription_chatbot)
- 기간 : 2022년 08월 19일 ~ 2022년 09월 02일
- 인원 : 정상필 외 3명
- 사용언어 : ```Python```
- 사용툴 : ```VSCode```, ```Kakao I open builder```
- 프레임워크 : ```Flask```
- DBMS : ```PostgreSQL```
- 플랫폼 : ```Heroku```
- 라이브러리 : ```flask```, ```SQLAlchemy```,```Pandas```,```Psycopg2``` 등등
- 내용 
    - ```Flask``` 웹 프레임워크를 사용해서 ```Heroku``` 플랫폼에 배포 및 ```Postgresql```을 사용한 간단한 DB관리
    - 서비스1 : 수도권 내의 본인이 알고싶은 지역의 이름을 검색하면 해당지역의 현재 기간에 해당하는 공고 출력(지역은 시,군단위)
    - 서비스2 : 청약의 정보를 유형별로 자체 제작한 간략한 카드와 URL형식으로 제공
    - 서비스3 : 일반가점제도의 가점제를 계산기형식으로 제공
- [PDF](https://github.com/JungBear/project/blob/main/subscoription_chatbot/%EC%B5%9C%EC%A2%85%EB%B0%9C%ED%91%9C_PPT.pdf)
- [시연영상](https://www.youtube.com/watch?v=b3-sZf48M7U)
- [메인코드](https://github.com/JungBear/project/blob/main/subscoription_chatbot/app/main.py)
- - -



### 자바 토이프로젝트
1.  포켓몬스터 게임 구현 (자바)
- 기간 : 2022.09.22 - 2022.09.26
- 인원 : 정상필 외 4명
- 주제 : 포켓몬스터 게임 자바로 간단하게 구현해보기
- 사용언어: ```Java 11```
- 사용툴:```sts 3```
- 인코딩 : ```MS949```

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
- [포켓몬 프로젝트 코드 파일](https://github.com/JungBear/project/tree/main/Pokemon/src)