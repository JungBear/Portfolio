# app/private_priority_integration/private_priority_integration.py
from flask import Blueprint, render_template

bp = Blueprint('private_priority_integration',
                __name__, 
                template_folder = "templates", 
                url_prefix="/private_priority_integration")

@bp.route('/', methods=['GET'])
def private_priority_integration():
    return render_template("private_priority_integration.jinja2", title = '공공분양(일반공급)')