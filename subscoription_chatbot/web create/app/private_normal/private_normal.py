# app/private_normal/private_normal.py
from flask import Blueprint, render_template

bp = Blueprint('private_normal',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_normal")

@bp.route('/', methods=['GET'])
def private_normal():
    return render_template("private_normal.jinja2", title = '공공분양(일반공급)')