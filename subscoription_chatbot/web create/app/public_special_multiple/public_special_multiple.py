# app/public_special_multiple/public_special_multiple.py
from flask import Blueprint, render_template

bp = Blueprint('public_special_multiple',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_special_multiple")

@bp.route('/', methods=['GET'])
def public_special_multiple():
    return render_template("public_special_multiple.jinja2", title = '공공분양(다자녀가구특별공급)')