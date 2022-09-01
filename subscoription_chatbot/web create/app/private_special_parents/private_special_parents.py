# app/private_special_parents/private_special_parents.py
from flask import Blueprint, render_template

bp = Blueprint('private_special_parents',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_special_parents")

@bp.route('/', methods=['GET'])
def private_special_parents():
    return render_template("private_special_parents.jinja2", title = '공공분양(일반공급)')