numbers = str(input())
delimiter = ' '
seperated = numbers.split(delimiter)
x = 0 

while x < (len(seperated) -1):
  num1 = int(seperated[x])
  num2 = int(seperated[x+1])
  if(num1>=0 and num2>=0):
    print(str(num1)+ " " + str(num2), end=" ")
    x = len(seperated)- 2
  if(num1<0 and num2<0):
    print(str(num1)+ " " + str(num2), end=" ")
    x = len(seperated)- 2
  x += 1
  