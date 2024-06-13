from csv import DictReader
from datetime import datetime

from django.core.management import BaseCommand

from library_management.models import Book
from pytz import UTC



DATETIME_FORMAT = '%m/%d/%Y %H:%M'



class Command(BaseCommand):
    # Show this when the user types help
    help = "Loads data from library_data.csv into our  model"

    def handle(self, *args, **options):
        if  Book.objects.exists():
            print('Book data already loaded...exiting.')
            return
        print("Loading book data.")
        for row in DictReader(open('./library_data.csv')):
            book = Book()
            book.title = row['Title']
            book.author = row['Author']
            book.isbn = row['ISBN']
            book.available = row['Available']
            raw_submission_date = row['Submission Date']
            submission_date = UTC.localize(
                datetime.strptime(raw_submission_date, DATETIME_FORMAT))
            book.submission_date = submission_date
            book.save()
        print("Book data loaded successfully.")    
           
