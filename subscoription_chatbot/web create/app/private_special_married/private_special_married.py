# app/private_special_married/private_special_married.py
from flask import Blueprint, render_template

bp = Blueprint('private_special_married',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_special_married")

@bp.route('/', methods=['GET'])
def private_special_married():
    return render_template("private_special_married.jinja2", title = '공공분양(일반공급)')