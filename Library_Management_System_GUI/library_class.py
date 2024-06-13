import pickle
from book_class import Book

#List to store books. 
book_list = []
#Reading store books from file.
file_name = "Books/save_books.pickle"
file = open(file_name, "rb")
#User greetings.
print("""
Welcome to the Library Management System.\n   
Please wait while we get things ready.\n""") 
  
while True:  
                
  try:
        book_list.append(pickle.load(file))   
  except EOFError:
        print("All done.")
        file.close()
        break

  finally:
      
    class Library():
      
      
        def adding_book(self, title, author, isbn, available):
            """This is the adding book function.

            Args:
                title (String): Book Title
                author (String): Book Author
                isbn (String): Book ISBN
                available (String): True/False
            """
            self.title = title
            self.author = author
            self.isbn = isbn
            self.available = available
            
            #For loop to check if the book exists.
            for i in range(0,len(book_list)):
               if book_list[i].title == title or book_list[i].isbn == isbn:
                   print(title,"book exist.")
                   break
            else:
                 book_list.append(Book(title, author, isbn, available))
                 print("\n",title,"book has been added successfully!") 
            
            
        def available_book(self):
            """This is the available book function.
            """
            try:        
                first_element = book_list[0]
            except IndexError:
                print("\nThere are currently no books stored.")
            else:
                print("Available books:\n")   
                
            #For loop to check for available books.   
            n = 0
            a = len(book_list)
            for i in range(0,len(book_list)):  
                n = n+1
                if len(book_list) != 0:
                    if book_list[i].available != "False":
                        print(n,".", book_list[i].title, "by", book_list[i].author)
                    if book_list[i].available == "False":
                        a = a-1
                    if a == 0:
                            print("There are currently no books available.\n")
                        

        def delete_book(self, isbn):
            """This is the delete book function.

            Args:
                isbn (String): Book ISBN
            """
            #For loop to check if the ISBN matches the existing book
            self.isbn = isbn
            for i in range(0,len(book_list)):
             if book_list[i].isbn == isbn:
              delete = i        
              book_list.pop(delete)
              print("The book was deleted successfully!")
              break
            else:
                 print("No match for",isbn)
               
          
        def borrow_book(self, title):
            """This is the borrow book function.

            Args:
                title (String): Book Title
            """
            #For loop to check if the book matches the existing book and if it is available.
            self.title = title
            for i in range(0,len(book_list)):
             if book_list[i].title == title and book_list[i].available != "Flase":
                book_list[i].available = "False"
                print(title,"was borrowed successfully!")     
                break
            else:
                 print(title,"is not available.")
          

        def return_book(self, title):
            """This is the returning book function.

            Args:
                title (String): Book Title
            """
            #For loop to check if the book matches and if it is available.
            self.title = title
            for i in range(0,len(book_list)):
                 if book_list[i].title == title and book_list[i].available != "Flase":
                     book_list[i].available = "True"
                     print(title,"was returned successfully!")


        def save_books(self):
            """This is the save books and exit function.
            """
            try:
                with open(file_name, "wb") as file:
                    #For look to get all books in list and save it to file.
                    for i in range(0,len(book_list)):
                        pickle.dump(book_list[i],file)
            except FileNotFoundError:
                print("We were unable to save your books.\nPlease visit www.lms.com for additional support.")
            else:
                print("Thank you for using the Library Management System!")
                quit()
            
 
                     
                
             
                
         
            
                

                
          