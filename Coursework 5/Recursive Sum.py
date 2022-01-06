def my_sum(lst):
  if len(lst) == 0 :
    return 0
  if len(lst) == 1 :
    return lst[0]
  else:
    return lst[0]+my_sum(lst[1:])
  
print(my_sum([1,2,3]))