def word_count(s):
  count = 0
  t = s.split()
  for word in t:
    count+= 1
  return count
  
print(word_count(input()))