"""
URL configuration for library_management_system project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/5.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from library_management import views 

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', views.home, name= 'home'),
    path('add_book/',views.add_book,name= 'add_book'),
    path('remove_book/',views.remove_book,name= 'remove_book'),
    path('display_available_book/',views.display_available_book,name= 'display_available_book'),
    path('borrow_book/',views.borrow_book,name= 'borrow_book'),
    path('return_book/',views.return_book,name= 'return_book'),
    path('help_menu/',views.help_menu,name= 'help_menu'),
    path('save_book_action/',views.save_book_action,name= 'save_book_action'),
    path('remove_book_action/',views.remove_book_action,name= 'remove_book_action'),
    path('borrow_book_action/',views.borrow_book_action,name= 'borrow_book_action'),
    path('return_book_action/',views.return_book_action,name= 'return_book_action'),
    path('confirmation_message/<str:confirmation_message>/',views.confirmation_message,name= 'confirmation_message'),
    path('error_page_not_found/',views.error_page_not_found,name= 'error_page_not_found'),
]

