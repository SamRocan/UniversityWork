def square(x): 
    return x*x

X = [1,3,7,8] #1B items
z = 0
it_squares_X = (square(x) for x in X) #creates an iterator instead of a list
while z<4:
    next_value = next(it_squares_X)
    print(next_value)
    z += 1

