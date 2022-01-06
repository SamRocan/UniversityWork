numbers = str(input())
delimiter = ' '
seperated = numbers.split(delimiter)

for i in range(-1, len(seperated)):
  if(i % 2 == 0):
    print(seperated[i])
  else:
    pass