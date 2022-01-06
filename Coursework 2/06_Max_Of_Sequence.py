def maxOfSequence(entry):
  largest = entry
  while(entry != 0):
    entry = int(input())
    if (entry > largest):
      largest = entry
  print(largest)
  
maxOfSequence(int(input()))