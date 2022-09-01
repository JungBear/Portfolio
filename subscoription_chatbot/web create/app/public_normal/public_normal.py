# app/public_normal/public_normal.py
from flask import Blueprint, render_template

bp = Blueprint('public_normal',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_normal")

@bp.route('/', methods=['GET'])
def public_normal():
    return render_template("public_normal.jinja2", title = '공공분양(일반공급)')