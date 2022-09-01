# app/private_priority_rental/private_priority_rental.py
from flask import Blueprint, render_template

bp = Blueprint('private_priority_rental',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_priority_rental")

@bp.route('/', methods=['GET'])
def private_priority_rental():
    return render_template("private_priority_rental.jinja2", title = '공공분양(일반공급)')