# app/public_priority_job/public_priority_job.py
from flask import Blueprint, render_template

bp = Blueprint('public_priority_job',
                __name__, 
                template_folder = "templates", 
                url_prefix="/public_priority_job")

@bp.route('/', methods=['GET'])
def public_priority_job():
    return render_template("public_priority_job.jinja2", title = '공공분양(일반공급)')