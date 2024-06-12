from django.db import models

# Create your models here.

class Book(models.Model):
    AVAILABLE_BOOKS =[('T','TRUE'),('F','FALSE')]
    title= models.CharField(max_length=100)
    author=models.CharField(max_length=100)
    isbn=models.CharField(max_length=40)
    available =models.CharField(max_length=1,choices=AVAILABLE_BOOKS)
    submission_date=models.DateTimeField(auto_now_add=True)
    def __str__(self):
     return self.title      

                
                