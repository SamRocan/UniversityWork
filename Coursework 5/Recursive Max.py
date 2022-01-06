def my_max(lst):
  if len(lst) == 1:
    return lst[0]
  else:
    m = my_max(lst[1:])
    return m if m > lst[0] else lst[0]

print(my_max([3,2,5]))