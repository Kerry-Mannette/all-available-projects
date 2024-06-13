from django.shortcuts import render

from .models import Book

from django.core.exceptions import ObjectDoesNotExist, MultipleObjectsReturned

from django.core.paginator import Paginator


# Create your views here.


def home(request):
 return render(request, 'home.html')

def add_book(request):
 return render(request, 'add_book.html')

def save_book_action(request):
    
    if request.method == 'POST':
        
        try:  
            title = request.POST.get('title')
            author = request.POST.get('author')
            isbn = request.POST.get('isbn')
            book = Book.objects.get(title=title, isbn=isbn)
        except ObjectDoesNotExist:
            book = Book(title=title, author=author, isbn=isbn, available="T")
            book.save()
            confirmation_message = title, "was added successfully."
            return render(request, 'confirmation_message.html', {
           'confirmation_message': confirmation_message}) 
        except MultipleObjectsReturned:
            book = Book(title=title, author=author, isbn=isbn, available="T")
            book.save()
            confirmation_message = title, "was added successfully."
            return render(request, 'confirmation_message.html', {
           'confirmation_message': confirmation_message})         
        else:
           confirmation_message = title, "already added."
           return render(request, 'confirmation_message.html', {
           'confirmation_message': confirmation_message})  
            

def remove_book(request):
 return render(request, 'remove_book.html')


def remove_book_action(request):
    
    if request.method == 'POST':
        
        try:    
            isbn = request.POST.get('isbn')
            book = Book.objects.get(isbn=isbn)
            book.delete()
            confirmation_message = isbn, "was remove successfully."
            return render(request, 'confirmation_message.html', {
           'confirmation_message': confirmation_message})  
         
        except Book.DoesNotExist:
            confirmation_message = isbn, "does not exist."
            return render(request, 'confirmation_message.html', {
           'confirmation_message': confirmation_message})  

            
def display_available_book(request):
    
     books_list = Book.objects.all()
     items_per_page = 2
     paginator = Paginator(books_list, items_per_page)
     page_number = request.GET.get('page')
     books = paginator.get_page(page_number)
     
     return render(request, 'display_available_book.html',
                   {'books': books})
         

def borrow_book(request):
 return render(request, 'borrow_book.html')


def borrow_book_action(request):
    
    if request.method == 'POST':
        
        try:  
            title = request.POST.get('title')
            book = Book.objects.get(title=title)
            book.available = "F"
            book.save()
            confirmation_message = title, "was borrow successfully."
            return render(request, 'confirmation_message.html', {
           'confirmation_message': confirmation_message})  
        except Book.DoesNotExist:
            confirmation_message = title, "does not exist."
            return render(request, 'confirmation_message.html', {
           'confirmation_message': confirmation_message})  


def return_book(request):
 return render(request, 'return_book.html')


def return_book_action(request):
        
        if request.method == 'POST':
            try:
                title = request.POST.get('title')
                book = Book.objects.get(title=title)
                book.available = "T"
                book.save()
                confirmation_message = title, "was return successfully."
                return render(request, 'confirmation_message.html', {
                'confirmation_message': confirmation_message})  
            except Book.DoesNotExist:
                confirmation_message = title, "does not exist."
                return render(request, 'confirmation_message.html', {
                'confirmation_message': confirmation_message})  
       
            
def help_menu (request):
 return render(request, 'help_menu.html')


def confirmation_message(request):
    return render(request, 'confirmation_message.html')


def error_page_not_found(request):
    return render(request, '404.html')


