def powerOfTwo(square):
    i = 0
    count = 0
    while(2*i <= square):
        if(i == 0):
            i +=1
        else:
            i = i * 2
        count += 1
    print(str(count-1)+" "+str(i))


powerOfTwo(int(input()))