# Generated by Django 5.0.3 on 2024-04-02 22:44

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('library_management', '0003_alter_book_author_alter_book_isbn_alter_book_title'),
    ]

    operations = [
        migrations.AlterField(
            model_name='book',
            name='isbn',
            field=models.CharField(blank=True, max_length=100),
        ),
    ]
