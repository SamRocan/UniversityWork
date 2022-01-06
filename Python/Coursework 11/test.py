#map returns a function to each item in a list
def plus(x,y):
    return x+y

def binary_map(func_of_2, col1, col2):
  return map(col1,col2)

X = [1,2,3]


Y = [10, 20, 30]

print(list(binary_map(plus, Y, X)))