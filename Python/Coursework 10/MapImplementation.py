#map returns a function to each item in a list
def plus(x,y):
    return x+y

def binary_map(func_of_2, col1, col2):
  return zip(func_of_2(X,Y), col2)

X = [1,2,3]


Y = [10, 20, 30]

print(binary_map(plus, Y, X))