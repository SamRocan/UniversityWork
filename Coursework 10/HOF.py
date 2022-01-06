import math 

#HIGHER ORDER FUNCTIONS EXPLAINED

def double(x): #Multiplies number by 2
    return 2*x

def square(x): #Squares the number
    return x*x

def sum_function_vector(f, X):  #Takes a function and list as argument
    sum = 0                     #Initializes sum as 0
    for x in X:                 #for every value in the list X
        sum+= f(x)              #sum = sum + values of x put through the function
    return sum                  #returns the value of sum

Y = [1,2,3,4]                   #Creates a list

s1 = sum_function_vector(double,Y)      #uses double function
s2 = sum_function_vector(square,Y)      #uses squared function
s3 = sum_function_vector(math.sqrt,Y)   #uses built in square root function

print(s1)                               #prints the values
print(s2)
print(s3)