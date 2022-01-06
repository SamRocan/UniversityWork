def multiplicationTable():
  num1 = int(input())
  num2 = int(input())
  count = 1
  for i in range(1, num1+1):
    while(count <= num2):
      print(str(i*count) + " ", end="")
      count+=1
    print("")
    count = 1
    
multiplicationTable()