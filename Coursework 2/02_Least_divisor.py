def leastDivisor(num):
    divisor = num
    lowestDivisor = 0
    while(divisor >= 2):
        if num % divisor == 0:
            lowestDivisor = divisor
        divisor -=1 
    return lowestDivisor


print(leastDivisor(int(input())))