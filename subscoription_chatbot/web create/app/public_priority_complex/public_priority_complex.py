# app/public_priority_complex/public_priority_complex.py
from flask import Blueprint, render_template

bp = Blueprint('public_priority_complex',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_priority_complex")

@bp.route('/', methods=['GET'])
def public_priority_complex():
    return render_template("public_priority_complex.jinja2", title = '공공분양(일반공급)')