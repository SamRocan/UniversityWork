
def expo(a,n):
  if n == 0:
    return 1
  else:
    return a*expo(a,n-1)
    
print(expo(2,3))