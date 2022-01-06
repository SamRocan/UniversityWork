def double(x):
    return 2*x

def square(x):
    return x*x
#Takes in a function as f
#Then it runs the function but adds it to list.
#Returns functions
#returns it again
def vectorize(f):
    def new_func(X):
        Y = []
        for x in X:
            Y.append(f(x))
        return Y
    return new_func
#Takes double function, for each item in the list runs the double function, then puts back into a list
vec_double = vectorize(double)
#Takes square function, for each item in the list runs the square function, then puts back into a list
vec_square = vectorize(square)

z = vec_square([1,2,3])
print(z)
