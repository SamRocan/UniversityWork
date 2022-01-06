entry = input()
Lst1 = entry.split()
entry = input()
Lst2 = entry.split()
LstComb = Lst1+Lst2
LstSet = set(LstComb)
countComb = 0
countSet = 0
for z in LstComb:
  countComb+=1
for i in LstSet:
  countSet+=1
if (2*countSet==countComb):
  print((countComb-countSet))
else:
  print(int((countComb-countSet)/2))
