def rev_string(s):
  if len(s) == 0:
    return s
  else:
    return rev_string(s[1:]) + s[0]
    
print(rev_string("zyxwvutsrqponmlkjihgfedcba"))