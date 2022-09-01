# app/public_special_parents/public_special_parents.py
from flask import Blueprint, render_template

bp = Blueprint('public_special_parents',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_special_parents")

@bp.route('/', methods=['GET'])
def public_special_parents():
    return render_template("public_special_parents.jinja2", title = '공공분양(노부모부양특별공급)')