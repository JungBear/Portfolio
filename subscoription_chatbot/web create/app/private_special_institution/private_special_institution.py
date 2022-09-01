# app/private_special_institution/private_special_institution.py
from flask import Blueprint, render_template

bp = Blueprint('private_special_institution',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_special_institution")

@bp.route('/', methods=['GET'])
def private_special_institution():
    return render_template("private_special_institution.jinja2", title = '공공분양(일반공급)')