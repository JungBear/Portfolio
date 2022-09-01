# app/private_special_multiple/private_special_multiple.py
from flask import Blueprint, render_template

bp = Blueprint('private_special_multiple',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_special_multiple")

@bp.route('/', methods=['GET'])
def private_special_multiple():
    return render_template("private_special_multiple.jinja2", title = '공공분양(일반공급)')