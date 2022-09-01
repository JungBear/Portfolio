from flask import Flask
import pandas as pd
from sqlalchemy import create_engine
import psycopg2


def db_create():
    engine = create_engine("postgresql://xnrniyjhurkuos:b0d752cc9e29106fb8c4b1f7cd39c985a5a23bb67a35d8c365a6175355e9bf13@ec2-50-19-255-190.compute-1.amazonaws.com:5432/dashvvhprslttt", echo = False)

    engine.connect()

    engine.execute("""
        CREATE TABLE IF NOT EXISTS area(
            name TEXT,
            division TEXT,
            location TEXT,
            notice_date TEXT,
            start_day TEXT,
            end_day TEXT,
            release_date TEXT,
            rink TEXT,
            image TEXT
        );"""
    )
    data = pd.read_csv('data/area.csv')
    print(data)
    data.to_sql(name='area', con=engine, schema = 'public', if_exists='replace', index=False)



def area_db(loc):
# 입력된 지역이 포함된 행을 불러오는 함수
    conn = psycopg2.connect(host="ec2-50-19-255-190.compute-1.amazonaws.com", dbname="dashvvhprslttt", user="xnrniyjhurkuos", password="b0d752cc9e29106fb8c4b1f7cd39c985a5a23bb67a35d8c365a6175355e9bf13")
    # heroku에 배포되어 있는 데이터베이스에 접속하기
    cur = conn.cursor()
    # cursor = 임시 객체생성
    # 생성된 임시객체를 cur에 저장
    #loc = "\'평택'"
    cur.execute("SELECT * FROM public.area WHERE location LIKE '%{}%';".format(loc))
    # sql문장을 실행할 수 있게 해주는 메서드
    # Location 컬럼에 loc가 포함되는 행 출력해주는 쿼리
    rows = cur.fetchall() 
    # 데이터내용 전부 불러서 rows에 입력
    # list 타입
    df = pd.DataFrame(rows, columns = ['name','division','location','notice_date','start_day','end_day','release_date','rink', 'image'])
    #print(df)
    # DataFrame으로 만들어주기
    # 컬럼명을 지정
    return df

def score_db1(sel):
# 가점표를 보고 사용자가 선택한 값의 점수를 불러오는 함수
    # sel1 = 무주택기간 input
    conn = psycopg2.connect(host="ec2-50-19-255-190.compute-1.amazonaws.com", dbname="dashvvhprslttt", user="xnrniyjhurkuos", password="b0d752cc9e29106fb8c4b1f7cd39c985a5a23bb67a35d8c365a6175355e9bf13")
    # heroku에 배포되어 있는 데이터베이스에 접속하기
    cur = conn.cursor()
    # cursor = 임시 객체생성
    # 생성된 임시객체를 cur에 저장
    cur.execute("SELECT score FROM public.score WHERE input = {};".format(sel))
    # sql문장을 실행할 수 있게 해주는 메서드
    # Location 컬럼에 loc가 포함되는 행 출력해주는 쿼리
    rows = cur.fetchall() 
    # 데이터내용 전부 불러서 rows에 입력
    # list 타입
    return rows

app = Flask(__name__)

@app.route("/")
def index():
    #db_create()
    return "Hello World!"


if __name__ == "__main__":
    #db_create()
    #area_db()
    #score_db1()
    app.run()