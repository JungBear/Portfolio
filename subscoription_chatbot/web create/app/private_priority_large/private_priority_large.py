# app/private_priority_large/private_priority_large.py
from flask import Blueprint, render_template

bp = Blueprint('private_priority_large',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_priority_large")

@bp.route('/', methods=['GET'])
def private_priority_large():
    return render_template("private_priority_large.jinja2", title = '공공분양(일반공급)')