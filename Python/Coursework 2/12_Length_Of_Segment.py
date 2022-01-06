import math

'''
provide your implementation
'''
def distance(x1, y1, x2, y2):
  width = abs(x2-x1)
  height = abs(y2-y1)
  hypotenuse = math.sqrt((width**2)+(height**2))
  return hypotenuse
  
print(distance(1, 5, 7, 9))