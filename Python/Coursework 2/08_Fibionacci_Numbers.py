def fibNumbers():
  fib0 = 0
  fib1 = 1
  fibn = 1
  limit = int(input())
  count = 2
  while(count <= limit):
    fibn = fib1 + fib0
    fib0 = fib1
    fib1 = fibn
    count+=1
    
  return fibn
  
print(fibNumbers())