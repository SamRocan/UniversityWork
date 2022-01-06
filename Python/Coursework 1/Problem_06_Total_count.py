poundsIn = int(input())
penceIn = int(input())
num = int(input())

poundsOut = (poundsIn*num) + ((penceIn*num)//100)
penceOut = (penceIn*num)%100

print(poundsOut)
print(penceOut)