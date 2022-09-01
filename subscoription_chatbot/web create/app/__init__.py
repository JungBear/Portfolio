# app/__init__.py
import os

from flask import Flask, render_template

def create_app(test_config=None):
    app = Flask(__name__, instance_relative_config=True)
    app.config.from_mapping(
        SECRET_KEY = 'development'
    )

    if test_config is None:
        app.config.from_pyfile('config.py', silent=True)
    else:
        app.config.from_mapping(test_config)

    try:
        os.makedirs(app.instance_path)
    except OSError:
        pass

    @app.route('/')
    def hello():
        return render_template('index.jinja2', title='index page')

    from .public_normal import public_normal
    from .public_special_married import public_special_married
    from .public_special_first import public_special_first
    from .public_special_multiple import public_special_multiple
    from .public_special_parents import public_special_parents
    from .public_special_institution import public_special_institution
    from .public_priority_job import public_priority_job
    from .public_priority_complex import public_priority_complex
    from .public_priority_large import public_priority_large
    from .private_normal import private_normal
    from .private_special_married import private_special_married
    from .private_special_first import private_special_first
    from .private_special_multiple import private_special_multiple
    from .private_special_parents import private_special_parents
    from .private_special_institution import private_special_institution
    from .private_priority_large import private_priority_large
    from .private_priority_rental import private_priority_rental
    from .private_priority_complex import private_priority_complex
    from .private_priority_integration import private_priority_integration

    app.register_blueprint(public_normal.bp)
    app.register_blueprint(public_special_married.bp)
    app.register_blueprint(public_special_first.bp)
    app.register_blueprint(public_special_multiple.bp)
    app.register_blueprint(public_special_parents.bp)
    app.register_blueprint(public_special_institution.bp)
    app.register_blueprint(public_priority_job.bp)
    app.register_blueprint(public_priority_complex.bp)
    app.register_blueprint(public_priority_large.bp)
    app.register_blueprint(private_normal.bp)
    app.register_blueprint(private_special_married.bp)
    app.register_blueprint(private_special_first.bp)
    app.register_blueprint(private_special_multiple.bp)
    app.register_blueprint(private_special_parents.bp)
    app.register_blueprint(private_special_institution.bp)
    app.register_blueprint(private_priority_large.bp)
    app.register_blueprint(private_priority_rental.bp)
    app.register_blueprint(private_priority_complex.bp)
    app.register_blueprint(private_priority_integration.bp)


    return app
