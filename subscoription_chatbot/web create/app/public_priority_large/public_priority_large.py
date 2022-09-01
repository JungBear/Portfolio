# app/public_priority_large/public_priority_large.py
from flask import Blueprint, render_template

bp = Blueprint('public_priority_large',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_priority_large")

@bp.route('/', methods=['GET'])
def public_priority_large():
    return render_template("public_priority_large.jinja2", title = '공공분양(일반공급)')