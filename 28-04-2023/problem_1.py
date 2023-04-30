print("\nBook 1 : INTRODUCTION TO PYTHON PROGRAMMING : RS 499.00")
print("Book 2 : PYTHON LIBRARIES COOKBOOK : RS 855.00")
print("Book 3 : DATA SCIENCE IN PYTHON : RS 645.00\n")
print("Enter no.of books of Book 1 : ",end = "")
Book1 = float(input())
print("Enter no.of books of Book 2 : ",end = "")
Book2 = float(input())
print("Enter no.of books of Book 3 : ",end = "")
Book3 = float(input())
amount = Book1 * 499.00 + Book2 * 855.00 + Book3 * 645.00
gst = (12 * amount)/100
Total_price = gst + 250 + amount
print("\nThe total invoice amount is",Total_price)


