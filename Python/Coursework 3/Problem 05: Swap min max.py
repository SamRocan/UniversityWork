entry = input()
numbers = entry.split()
length = len(numbers)
numbers2 = []
convert = 0
for num in numbers:
    convert = int(num)
    numbers2.append(convert)

maximum = max(numbers2)
minimum = min(numbers2)
minPos = 0
maxPos = 0
for i in range(0, length):
    if(numbers2[i] == maximum):
        maxPos = i
    if(numbers2[i] == minimum):
        minPos = i

numbers2[maxPos] = minimum
numbers2[minPos] = maximum
for num2 in numbers2:
    print(num2, end=" ")