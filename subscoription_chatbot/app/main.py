# -*- coding: utf-8 -*-
from unittest import result
from flask import Flask, jsonify, request
import os,sys, json
import pandas as pd 
from sqlalchemy import create_engine, MetaData, Table, Column, Integer, String
import psycopg2
import database

app = Flask(__name__)

@app.route("/")
def hello():
    #database.db_create()
    return "Verson : 137"

# 단순메세지
@app.route("/api/hello")
def test():
    req = request.get_json()
    response = {
        "version" : "2.0",
        "template": {
            "outputs" : [
                {
                    'simpleText':{
                        "text": "안녕하세요"
                    }
                }
            ]
        }
    }

# 사용자가 공고를 보기 원할 때 
@app.route("/api/anninputloc", methods=["post"])
def announcement_input():  
    req = request.get_json()
    print(req)
    print(req['userRequest']['utterance'])
    response = {
        "version" : "2.0",
        "template": {
            "outputs" : [
                {
                    'simpleText':{
                        "text": "지역을 입력해주세요\n(예시: 평택시 -> 평택)"
                    }
                }
            ]
        }
    }
    return jsonify(response)

# 지역입력 시 공고 출력
@app.route('/api/annout', methods=['POST'])
def location():
    
    req = request.get_json()
    print(req)
    # 카카오 챗봇에서 보낸 요청값을 body에 저장
    loc=req['action']['params']['loc']
    print(loc)
    # 사용자 발화값 중 입력값을 받기 위해 사용
    df1=database.area_db(loc)
    # db_select함수에 loc_li값 입력
    #print(df1)
    name=df1['name']
    print(name)
    print(type(name))
    # df1이라는 데이터프레임의 'name'컬럼값을 series형식으로 저장
    URL = df1['rink']
    # df1이라는 데이터프레임의 'rink'컬럼값을 series형식으로 저장
    image=df1['image']
    location = df1['location']
    x = len(df1)
    if len(df1) >= 3:
        responseBody = {
            "version": "2.0",
            "template": {
                "outputs": [
                    {
                        "SimpleText": {
                            "header": {
                                "title": "공고 내역입니다."
                            },
                            "items": [
                                {
                                    "title": name[0],
                                    "description": location[0],
                                    "imageUrl": image[0],
                                    "link": {
                                        "web": URL[0]
                                    }
                                },
                                {
                                    "title": name[1],
                                    "description": location[1],
                                    "imageUrl": image[1],
                                    "link": {
                                        "web": URL[1]
                                    }
                                },
                                {
                                    "title": name[2],
                                    "description": location[2],
                                    "imageUrl": image[2],
                                    "link": {
                                        "web": URL[2]
                                    }
                                }
                            ]
                        }
                    }
                ]
            }
        }
    elif len(df1) == 2:
        responseBody = {
            "version": "2.0",
            "template": {
                "outputs": [
                    {
                        "listCard": {
                            "header": {
                                "title": "공고 내역입니다."
                            },
                            "items": [
                                {
                                    "title": name[0],
                                    "description": location[0],
                                    "imageUrl": image[0],
                                    "link": {
                                        "web": URL[0]
                                    }
                                },
                                {
                                    "title": name[1],
                                    "description": location[1],
                                    "imageUrl": image[1],
                                    "link": {
                                        "web": URL[1]
                                    }
                                }
                            ]
                        }
                    }
                ]
            }
        }
    elif len(df1) == 1:
        responseBody = {
            "version": "2.0",
            "template": {
                "outputs": [
                    {
                        "listCard": {
                            "header": {
                                "title": "공고 내역입니다."
                            },
                            "items": [
                                {
                                    "title": name[0],
                                    "description": location[0],
                                    "imageUrl": image[0],
                                    "link": {
                                        "web": URL[0]
                                    }
                                }
                            ]
                        }
                    }
                ]
            }
        }
    elif len(df1) == 0:
        responseBody = {
            "version": "2.0",
            "template": {
                "outputs": [
                    {
                        "listCard": {
                            "header": {
                                "title": "공고 내역입니다."
                            },
                            "items": [
                                {
                                    "title": '현재 모집중인 공고가 없습니다.',
                                },
                            ],
                            "buttons": [
                                {
                                    "label": "다른공고더보기",
                                    "action": "webLink",
                                    "webLinkUrl": "https://www.applyhome.co.kr/ai/aia/selectAPTLttotPblancListView.do#"
                                }
                            ]
                        }
                    }
                ]
            }
        }


    
    return responseBody

@app.route('/api/score', methods=['POST'])
def score():
    try:
    # try-except는 예외처리문법
    #  - 코드를 실행하는 중에 발생한 에러를 처리할때 사용
    #  - 에러가 났을때 코드가 멈추지않고 계속 실행되게 사용
    #  - 프로그램이 멈추는 현상 방지
        req = request.get_json()
        print(req)
        # 카카오챗봇에서 요구받은값 출력
        # heroku logs를 터미널에 입력하면 값을 볼 수 있음

        sco1 = req['action']['detailParams']['sys_text1']["value"]
        #'action/detailParams/sys_text1/value'의 값이 첫번째 조건의 입력값이 된다
        sco2 = req['action']['detailParams']['sys_text2']["value"]
        # 두번째 조건의 입력값
        sco3 = req['action']['detailParams']['sys_text3']["value"]
        # 세번째 조건의 입력값

        print('sco1의 값입니다:',sco1)
        print('sco2의 값입니다:',sco2)
        print('sco3의 값입니다:',sco3)
        print(type(sco1))
        # type = str

        score1 = int(sco1)
        score2 = int(sco2)  
        score3 = int(sco3)
        print(type(score1))
        # 형변환 str -> int

        score_list1 = database.score_db1(sco1)
        # 리스트의 형태로 입력받는다

        score_end1 = score_list1[0][0]
        print(score_end1)
        # 조건1의 결괏값
        # 리스트의 형태 중 내가 원하는 인덱스값 불러오기
        score_list2 = database.score_db1(sco2)
        score_end2 = score_list2[1][0]
        # 조건2의 결괏값
        score_list3 = database.score_db1(sco3)
        print(score_list3)
        # 조건3의 값이 조건2의값보다 크다
        # 조건3의 값이 조건2의 값보다 크면 리스트에 값이 입력이 안된다
        
        if len(score_list3) == 2:
            # 조건3의 값 > 조건2의 값
            # 조건2의 값이 입력이안되어서 원래의 리스트의 갯수가 3개가 되어야하는데 2개가된다
            # 그래서 리스트 갯수 = 2일 때로 지정
            score_end3 = score_list3[1][0]
            
        else:
            score_end3 = score_list3[2][0]
            # 조건3 <= 조건2일때
            # 원래대로 리스트의 갯수가 3개가 된다
        print(score_end3)
        result = score_end1 + score_end2 + score_end3
        print(result)
        # 우리가 필요한 값은 조건1, 2, 3의 총 합이므로 변수를 하나 설정해 준다
        # result = int
    
    except:
    # 에러가 났을 경우 실행
        responseBody = {
            "version": "2.0",
            "template": {
                "outputs": [
                    {
                        "basicCard": {
                            "title": '잘못입력하셨습니다',
                            "buttons": [
                                {
                                    "action": "block",
                                    "label": "처음으로",
                                    "blockId": "62f5bbff70055f434dccff3b"
                                },
                                {
                                    "action": "block",
                                    "label": "다시하기",
                                    "blockId": "62fcf4c58a1240569898cd10"
                                }
                            ]  
                        },
                    }
                ]
            }
        }
    else:
    # 에러가 나지 않았을 경우 실행
        responseBody = {
            "version": "2.0",
            "template": {
                "outputs": [
                    {
            
                        "basicCard": {
                            "title": "귀하의 총합은 : {0}점 입니다.".format(result),
                                # format매서드를 써서 변수값을 출력 가능하게 해준다.
                            "description": "조건1의 점수는 : {0} \n조건2의 점수는 : {1}\n조건3의 점수는 : {2}".format(score_end1,score_end2,score_end3),
                            "thumbnail": {
                                "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EB%AF%BC%EA%B0%84%EB%B6%84%EC%96%91%20%EA%B0%80%EC%A0%90%EC%A0%9C%EC%B6%94%EC%B2%A8%EC%A0%9C.png",
                                "fixedRatio" : True,
                                "width": 800,
                                "height": 800
                            }
                        }
                    }
                ]
            }
        }
            
    return responseBody
    

# 공공분양에서 분류 나누기
@app.route("/public", methods = ['post'])
def public():
    body = request.get_json()
    #print(body)
    #print(body['userRequest']['utterance'])
    response = {
        "version": "2.0",
        "template": {
            "outputs": [
                {
        
                    "basicCard": {
                        "title": "공공분양", # basic 카드에 들어갈 제목
                        "description": "궁금하신 분양유형을 눌러주세요", # 제목 아래에 들어갈 상세 내용
                        "buttons": [ # basic 카드에 소속된 버튼 
                            {
                                "action": "block", # 버튼 1
                                "label": "일반분양", # 버튼 1 내용
                                "blockId": "62fca29a8a1240569898c7a6" # 버튼 1에서 연결될 버튼 주소
                            },
                            {
                                "action":  "block", # 버튼 2
                                "label": "특별분양", # 버튼 2 내용
                                "blockId": "62fca30e9465de0507b1ed33" # 버튼 2에서 연결될 버튼 주소
                            },
                            {
                                "action":  "block",# 버튼 3
                                "label": "우선분양",# 버튼 3내용
                                "blockId": "62fca32b8a1240569898c7e3" # 버튼 3에서 연결될 버튼 주소
                            }   
                        ]
                    }
                }
            ]
        }
    }
    return jsonify(response)

# 공공-일반
@app.route("/public/normal", methods = ['post'])
def normal():
    body = request.get_json()
    #print(body)
    #print(body['userRequest']['block'])
    response = {
        "version": "2.0",
        "template": {
            "outputs": [
                {
        
                    "basicCard": {
                        "title": "공공분양 일반공급", # basic 카드에 들어갈 제목
                        "description": "신청자격 표입니다", # 제목 아래에 들어갈 상세 내용
                        "thumbnail": {
                            "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%9D%BC%EB%B0%98%EA%B3%B5%EA%B8%89%20%EC%9E%90%EA%B2%A9.png",
                            "fixedRatio" : True,
                            "width": 800,
                            "height": 800
                        },
                        "buttons": [ # basic 카드에 소속된 버튼 
                            {
                                "action": "block", # 순위 요건 버튼
                                "label": "순위 요건", # 순위 요건 버튼
                                "blockId": "62fca2f4745ef634f0480557" # 1순위 블록으로 이동 
                            },
                        ]
                    }
                }
            ]
        }
    }
    return jsonify(response)

# 공공-특별
@app.route("/public/special", methods = ['post'])
def special():
    body = request.get_json()
    #print(body)
    #print(body['userRequest']['block'])
    response = {
        "version": "2.0",
        "template": {
            "outputs": [
                    {
                    "carousel": {
                        "type": "basicCard",
                        "items": [
                            {
                                "title": "신혼부부 특별공급",
                                "description": "",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C1.PNG",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },

                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_special_married/"
                                    },
                                ]
                            },
                            {
                                "title": "생애최초 특별공급",
                                "description": "",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C2.PNG",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },
                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_special_first/"
                                    },
                                ]
                            },
                            {
                                "title": "다자녀가구 특별공급",
                                "description": "",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C3.PNG",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },
                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_special_multiple/"
                                    },
                        
                                ]
                            },
                            {
                                "title": "노부모부양 특별공급",
                                "description": "",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C4.PNG",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },
                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_special_parents/"
                                    },
                                ]
                            },
                            {
                                "title": "기관추천 특별공급",
                                "description": "",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C5.PNG",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },
                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_special_institution/"
                                    },
                                ]   
                            }
                        ]
                    }
                }   
            ]
        }
    }

    return jsonify(response)

# 공공-우선
@app.route("/public/first", methods = ['post'])
def first():
    body = request.get_json()
    print(body)
    print(body['userRequest']['block'])
    response = {
        "version": "2.0",
        "template": {
            "outputs": [
                    {
                    "carousel": {
                        "type": "basicCard",
                        "items": [
                            {
                                "title": "직장 주택 조합 우선공급",
                                "description": "",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C6.PNG",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },

                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_priority_job/"
                                    },
                                ]
                            },
                            {
                                "title": "주상복합 건축물의 건설부지 소유자 우선공급",
                                "description": "",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C7.PNG",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },
                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_priority_complex/"
                                    },
                                ]
                            },
                            {
                                "title": "대규모 택지 개발지구 우선공급",
                                "description": "",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C8.PNG",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },
                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_priority_large/"
                                    },
                        
                                ]
                            },
                        ]
                    }
                }   
            ]
        }
    }

    return jsonify(response)

# 공공-일반-내용
@app.route("/public/level", methods = ['post'])
def level():
    body = request.get_json()
    #print(body)
    #(body['userRequest']['block'])
    response = {
        "version": "2.0",
        "template": {
            "outputs": [
                    {
                    "carousel": {
                        "type": "basicCard",
                        "items": [
                            {
                                "title": "1순위 요건입니다.",
                                "description": "그 외 2순위는 추첨입니다.",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/1%EC%88%9C%EC%9C%84%20%EC%9A%94%EA%B1%B4.png",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },
                            },
                            {
                                "title": "",
                                "description": "동일 순위 시 경쟁 요건표 입니다.",
                                "thumbnail": {
                                    "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EB%8F%99%EC%9D%BC%20%EC%88%9C%EC%9C%84%20%EA%B2%BD%EC%9F%81.png",
                                    "fixedRatio" : True,
                                    "width": 800,
                                    "height": 800
                                },
                                "buttons": [
                                    {
                                        "action": "webLink",
                                        "label": "자세히보기",
                                        "webLinkUrl": "https://human-self-url.herokuapp.com/public_normal/"
                                    },
                                ]
                            },
                        ]
                    }
                }   
            ]
        }
    }

    return jsonify(response)

# 메인 시작블럭
@app.route('/main', methods=['POST'])
def Message():

    content = request.get_json()
    print(content)

    dataSend = {
    "version": "2.0",
    "template": {
        "outputs": [
        {
            "carousel": {
            "type": "basicCard",
            "items": [
                {
                    "title": "현재 진행중인 공고",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%B2%AD%EC%95%BD%EA%B3%B5%EA%B3%A0.png",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "block",
                        "blockId": "62fde9759a43ea1c82652cfb",
                        "label": "공고(수도권)",
                        }
                    ]
                },
                {
                    "title": "청약 유형별 자세히보기",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%B2%AD%EC%95%BD%20%EC%9C%A0%ED%98%95%EB%B3%84%20%EC%A0%95%EB%B3%B4.png",
                        "fixedRatio": True,
                        "width": 800,
                        "height": 800
                    },
                    "buttons": [
                        {
                        "action": "block",
                        "blockId": "62fc9e109a43ea1c8265146f",
                        "label": "공공분양",
                        
                        },
                        {
                        "action": "block",
                        "blockId": "62f5eb7278a1fc2ba5b25b9b",
                        "label": "민간분양",
                        }
                        ]
                        }
                    ]
                }
        }
            ]
        }
    }
    return jsonify(dataSend)




# 민간 분양유형
@app.route('/private', methods=['POST'])
def private():

    content = request.get_json()
    print(content)
    content1= content['userRequest']['block']
    print(content1)
    
    dataSend = {
        "version": "2.0",
        "template": {
            "outputs": [
                {
                    "basicCard": {
                        "title": "민간분양", # basic 카드에 들어갈 제목
                        "description": "궁금하신 분양유형을 눌러주세요", # 제목 아래에 들어갈 상세 내용
                        "buttons": [ # basic 카드에 소속된 버튼 
                    {
                        "action": "block",
                        "label": "일반공급",
                        "blockId": "62f5ccd1f534cf44c78eaf29"
                    },
                    {
                        "action": "block",
                        "label": "특별공급",
                        "blockId": "62f5eb9070055f434dcd0a04"
                    },
                    {
                        "action": "block",
                        "label": "우선공급",
                        "blockId": "62f5ebc370055f434dcd0a0b"
                    }
                        ]
                    }
                }
                    
                ]
            }
        }
    

    return jsonify(dataSend)


# 민간 - 특별
@app.route('/private/special', methods=['POST'])
def private2():

    content = request.get_json()
    print(content)
    content1= content['userRequest']['block']
    print(content1)

    dataSend = {
    "version": "2.0",
    "template": {
        "outputs": [
        {
            "carousel": {
            "type": "basicCard",
            "items": [
                {
                    "title": "신혼부부 특별공급",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C9.PNG",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "webLink",
                        "webLinkUrl": "https://human-self-url.herokuapp.com/private_special_married/",
                        "label": "자세히보기",
                        }
                    ]
                },
                {
                    "title": "생애최초 특별공급",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C10.PNG",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "webLink",
                        "webLinkUrl": "https://human-self-url.herokuapp.com/private_special_first/",
                        "label": "자세히보기",
                        }
                    ]
                },
                {
                    "title": "다자녀가구 특별공급",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C11.PNG",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "webLink",
                        "webLinkUrl": "https://human-self-url.herokuapp.com/private_special_multiple/",
                        "label": "자세히보기",
                        }
                    ]
                },
                {
                    "title": "노부모부양 특별공급",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C12.PNG",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "webLink",
                        "webLinkUrl": "https://human-self-url.herokuapp.com/private_special_parents/",
                        "label": "자세히보기",
                        }
                    ]
                },
                {
                    "title": "기관추천 특별공급",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C13.PNG",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "webLink",
                        "webLinkUrl": "https://human-self-url.herokuapp.com/private_special_institution/",
                        "label": "자세히보기",
                        }
                    ]
                }
            ]
        }
        }
        ]
    }
    }
    return jsonify(dataSend)

# 민간 - 우선공급 스킬
@app.route('/private/priority', methods=['POST'])
def private3():

    content = request.get_json()
    print(content)
    content1= content['userRequest']['block']
    print(content1)

    dataSend = {
    "version": "2.0",
    "template": {
        "outputs": [
        {
            "carousel": {
            "type": "basicCard",
            "items": [
                {
                    "title": "대규모택지 개발지구 우선공급",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C14.PNG",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "webLink",
                        "webLinkUrl": "https://human-self-url.herokuapp.com/private_priority_large/",
                        "label": "자세히보기",
                        }
                    ]
                },
                {
                    "title": "임대사업자 우선공급",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C15.PNG",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "webLink",
                        "webLinkUrl": "https://human-self-url.herokuapp.com/private_priority_rental/",
                        "label": "자세히보기",
                        }
                    ]
                },
                {
                    "title": "주상복합 건축물의 건설부지 소유자 특별공급",
                    "thumbnail": {
                        "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C16.PNG",
                        "fixedRatio": True,
                        "width": 378,
                        "height": 378
                    },
                    "buttons": [
                        {
                        "action": "webLink",
                        "webLinkUrl": "https://human-self-url.herokuapp.com/private_priority_complex/",
                        "label": "자세히보기",
                        }
                    ]
                },
            ]
        }
        }
        ]
    }
    }
    return jsonify(dataSend)

# 민간-일반
@app.route("/private/normal", methods = ['POST'])
def qwerasdf():
    req = request.get_json()
    print(req)
    response = {
        "version": "2.0",
        "template": {
            "outputs": [
                {
                    "basicCard": {
                        "title": "민간분양 일반공급 유형",
                        "thumbnail": {
                            "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EB%AF%BC%EA%B0%84%20%EC%9D%BC%EB%B0%98.png",
                            "fixedRatio": True,
                            "width": 800,
                            "height": 800
                        },
                        "buttons": [
                            {
                                "action": "block",
                                "label": "순위요건",
                                "blockId": "630c1df50ed3e074370a589a"
                            }
                        ]
                    },
                }
            ]
        }
    }
    return response

# 민간-일반-가점표
@app.route("/private/add", methods = ['POST'])
def qwerasdfd():
    req = request.get_json()
    print(req)
    response = {
        "version": "2.0",
        "template": {
            "outputs": [
                {
                    "basicCard": {
                        "thumbnail": {
                            "imageUrl": "https://raw.githubusercontent.com/JungBear/human-chatbot-subscription/main/image/%EA%B0%80%EC%A0%90%ED%91%9C.png",
                            "fixedRatio": True,
                            "width": 800,
                            "height": 800
                        },
                        "buttons": [
                            {
                                "action": "block",
                                "label": "가점제 점수계산표",
                                "blockId": "62fcf4c58a1240569898cd10"
                            }
                        ]
                    },
                }
            ]
        }
    }
    return response