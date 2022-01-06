numbers = input()
numList = numbers.split()
#print(numList)
even = ""
numList2 = []
length = (len(numList))
for i in range(0, length):
    if (i % 2 == 0):
        even = numList[i]
    if (i % 2 == 1):
        print(numList[i])
        numList2.append(numList[i])
        numList2.append(even)

if (length % 2 == 1):
    numList2.append(numList[length-1])

for num in numList2:
    print(num, end=" ")