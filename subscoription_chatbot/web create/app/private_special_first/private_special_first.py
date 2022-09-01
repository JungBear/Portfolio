# app/private_special_first/private_special_first.py
from flask import Blueprint, render_template

bp = Blueprint('private_special_first',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_special_first")

@bp.route('/', methods=['GET'])
def private_special_first():
    return render_template("private_special_first.jinja2", title = '공공분양(일반공급)')