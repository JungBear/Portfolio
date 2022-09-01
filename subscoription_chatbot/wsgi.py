from app.main import app
import database

if __name__ == "__main__":
    #database.db_create()
    app.run(threaded=True, port=5000)