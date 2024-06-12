#Library Management System (LMS)
#Develop: 25/02/2024
#Developer: Kerry Mannette
#Description: This application allows users to add,
#remove, borrow, return, and display books.


from library_class import Library 


while True:
  
 # Application user menu input.  
    options = input("""\n
1. Add a book.
2. Remove a book.
3. Display available.
4. Borrow a book.
5. Return a book.
6. Exit.\n
:""")
    
    
   #If, elif, and else selection statement for menu. 
    if  options == "1":
   
   #Adding new book input.
      print("Enter book details:")
      title = input("Title:\n")
      author = input("Author:\n")
      isbn = input("ISBN:\n")
      available = "True"
      library = Library()
   #Adding new books to the library function.
      library.adding_book(title, author, isbn, available)
      
      
    elif options == "2":
       
   #Deleting books input.    
      print("Enter book ISBN:")
      isbn = input("ISBN:\n")
      library = Library()
    #Deleting book function.  
      library.delete_book(isbn)
          

    elif options == "3":
    
   #Checking for available books.
       
       library = Library()
   #Checking for available books function.
       library.available_book()
       
        
    elif options == "4":
       
   #Borrowing books input.    
       book_selection = input("Please enter the title of the book you want to borrow: \n")
       library = Library()
   #Borrowing books function.
       library.borrow_book(book_selection)
       
    elif options == "5":
       
   #Returning books input.
       
       print("Enter book title:")
       title = input("Title:\n")
       library = Library()
   #Returning books function.    
       library.return_book(title)
       
       
    elif options == "6":
       
   #Save/Exit.
       
      library = Library()
   #Save/Exit function.   
      library.save_books()
    else:
   
   #Error handling for wrong option.    
       print("\nWrong option.")
      









