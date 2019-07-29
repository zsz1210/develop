from django.contrib.auth.decorators import login_required
from django.http import *
from django.shortcuts import render_to_response,redirect,render
from django.template import RequestContext
from django.contrib.auth.decorators import login_required
from django.contrib.auth import authenticate, login, logout

# this login required decorator is to not allow to any
# view without authenticating
@login_required(login_url="/login/")
def login(request):
    return render(request,"login.html")

def login_user(request):
    logout(request)
    username = password = ''
    print(request.POST)
    if request.POST:
        username = request.POST['username']
        password = request.POST['password']

        user = authenticate(username=username, password=password)
        print(user)
        if user is not None:
            if user.is_active:
                login(request, user)
                return redirect('/dashboard/')
    return render(request, 'registration/login.html')

@login_required(login_url='/login/')
def main(request):
    return "main.html"
