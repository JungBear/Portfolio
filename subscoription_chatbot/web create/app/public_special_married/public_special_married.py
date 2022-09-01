# app/public_special_married/public_special_married.py
from flask import Blueprint, render_template

bp = Blueprint('public_special_married',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_special_married")

@bp.route('/', methods=['GET'])
def public_special_married():
    return render_template("public_special_married.jinja2", title = '공공분양(신혼부부특별공급)')