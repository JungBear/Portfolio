# app/public_special_first/public_special_first.py
from flask import Blueprint, render_template

bp = Blueprint('public_special_first',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_special_first")

@bp.route('/', methods=['GET'])
def public_special_first():
    return render_template("public_special_first.jinja2", title = '공공분양(생애최초특별공급)')