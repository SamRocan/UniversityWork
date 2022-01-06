def stringify(f):
  def F(s):
    str = ""
    for x in s:
      str += f(x)
    return str
  return F