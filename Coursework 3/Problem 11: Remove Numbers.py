#entry = input()
#numList = entry.split()
##count = 1
#while(entry != "END"):
    #entry = input()
    #numList2 = numList = entry.split()
    #length1 = len(numList2)
    #if(count%2==1):
        #for i in range(0, numList2):
            #if(numList2[i]=numList[i])
            
    #entry = "END"

entry = input()
numList = set(entry.split())
count = 1
while(entry != "END"):
    if (count == 1):
        entry = input()
        if entry == "END":
            break
        deleteList = []
        numList2 = entry.split()
        for number in numList2:
            for num in numList:
                if(num == number):
                    deleteList.append(num)
        for i in deleteList:
            numList.remove(i)
        #print(numList)
        count-=1

    if (count == 0):
        entry = input()
        if entry == "END":
            break
        numList2 = set(entry.split())
        for i in numList2:
            numList.add(i)
        #print(numList)
        count+=1

final = []
for numbers in numList:
    final.append(int(numbers))

final.sort()
for zz in final:
    print(zz, end=" ")
