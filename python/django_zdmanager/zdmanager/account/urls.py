from django.conf.urls import url
from . import views

# We are adding a URL called /home
urlpatterns = [
    url(r'^login_user/$', views.login_user, name='login_user')
]

