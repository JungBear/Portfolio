# app/private_priority_complex/private_priority_complex.py
from flask import Blueprint, render_template

bp = Blueprint('private_priority_complex',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_priority_complex")

@bp.route('/', methods=['GET'])
def private_priority_complex():
    return render_template("private_priority_complex.jinja2", title = '공공분양(일반공급)')