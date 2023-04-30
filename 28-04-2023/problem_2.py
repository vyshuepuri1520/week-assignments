print("Enter the string : ",end = "")
str = input()
print("Input : String1 = ",str)
newstr = set(str.lower())
list = list(newstr)
l = len(list)
print("Output : Unique Letters = ",end = "")
for i in range(0,l):
    if i != l-1:
        print(list[i],end = ',')
    else:
        print(list[i])

