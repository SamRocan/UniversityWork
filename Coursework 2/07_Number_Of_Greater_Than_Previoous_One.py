def numGreaterThanPrev ():
    count = 0
    entry = -1
    prev = int(input())
    while(entry!=0):
        entry = int(input())
        if entry > prev:
            count += 1
        prev = entry
    return count

print(numGreaterThanPrev())

