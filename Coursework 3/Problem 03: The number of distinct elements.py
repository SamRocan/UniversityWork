#implement the required function

Lst = [10,20,20,30,30, 40, 40, 40, 50, 60, 60]

def numb_of_distinct(test):
    count = 0
    for i in range(0, len(Lst)):
        if(i == 0):
            count+=1
        elif(Lst[i] != Lst[i-1]):
            count+=1
        else:
            pass
    print(count)
numb_of_distinct(Lst)