limit = int(input())
count = 0 
entry = ""
synonym = {}
while(count < limit):
    entry = input("")
    tempList = entry.split()
    synonym[tempList[1]] = tempList[0]
    count+=1 

getKey = synonym.get(input(""))
count2 = 0
for x in synonym:
    if(synonym[x] == getKey):
        count2 += 1

print(count2)

#UK London
#US Boston
#UK Manchester
#UK Leeds
#US Dallas
#Russia Moscow
#Manchester