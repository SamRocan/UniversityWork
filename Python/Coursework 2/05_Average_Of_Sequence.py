def AverageOfSequence():
  entry = 1
  sum = 0
  count = 0
  while(entry != 0):
    entry = int(input())
    if (entry != 0):
      sum += entry
      count += 1
    else:
      pass
    
  average = sum/count
  print(int(average))

AverageOfSequence()