import ATag from "../../../atom/aTag";

export const educations = [
    {
        name: "청주대학교",
        date : "2015.03 ~ 2022.02",
        content: "인공지능 소프트웨어 융합 전공"
    },
    {
        name: "웹 개발 과정",
        date: "2024.02 - 2024.07",
        content: (
            <div>
                <p>
                    JAVA를 바탕으로 웹사이트를 개발 할 수 있도록 진행하는 교육과정으로 JAVA를 이용한 객체지향적 프로그래밍부터 DBMS(Oracle, MySQL)과 연동하는 JDBC 기술, 프론트 영역의 웹표준(HTML/CSS/JS)까지 배웁니다.
                </p>
                <p>
                    매주 평일 오후 3시 ~ 6시까지 진행되었습니다. 
                </p>
                <p>
                    최종 프로젝트로는 <ATag link={""} text={"예비 창업자들을 위한 프랜차이즈 정보 제공 및 커뮤니티"}></ATag>를 만들었습니다.
                </p>
            </div>
        ),
        subjects: "코리아IT아카데미"
    },
    {
        name: "프론트엔드 과정",
        date: "2024.02 - 2024.08",
        content: (
            <div>
                <p>
                    기본적인 웹표준(HTML, CSS, Javascript) 활용을 최대한 높이고, 추가로 React, NextJs, Typescript까지 기술을 습득하는 것에 목적을 둡니다.
                </p>
                <p>
                    매주 주말 오전 09시 ~ 13시까지 진행되었습니다.
                </p>
            </div>
        ),
        subjects: "코리아IT 아카데미"
    },
    {
        name: "AI데이터플랫폼을 활용한 빅데이터 분석전문가 과정 3기",
        date: "2022.06 - 2022.12",
        content: (
            <div>
                <p>
                빅데이터 분석 결과를 이해하기 쉽도록 시각화하는 방법을 결정하고, 구현하는 과정으로 자바 및 파이썬 프로그래밍 습득부터 데이터베이스 관리시스템과 R프로그래밍을 배웁니다.
                </p>
                <p>
                최종 프로젝트로는 <ATag link={"https://github.com/JungBear/public_transport_webproject"} text={"한강 교량 혼잡도 분석과 실시간 교통정보 공유 커뮤니티"}></ATag>를 만들었습니다.
                </p>
            </div>
        ),
        subjects: "휴면교육센터"
    }

]