# app/public_special_institution/public_special_institution.py
from flask import Blueprint, render_template

bp = Blueprint('public_special_institution',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_special_institution")

@bp.route('/', methods=['GET'])
def public_special_institution():
    return render_template("public_special_institution.jinja2", title = '공공분양(기관추천특별공급)')