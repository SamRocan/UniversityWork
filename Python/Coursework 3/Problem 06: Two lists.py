entry = input()
numbers = entry.split()
entry2 = input()
numbers2 = entry2.split()
numbersINT = []
numbers2INT = []

for num2 in numbers2:
    convert = int(num2)
    numbers2INT.append(convert)


for i in numbers2:
    for z in numbers:
        if(z == i):
            numbers.remove(z)
for num in numbers:
    convert = int(num)
    numbersINT.append(convert)

arranged = sorted(numbersINT)

for z in arranged:
    print(z, end=" ")

            
