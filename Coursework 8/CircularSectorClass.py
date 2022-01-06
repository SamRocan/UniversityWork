class Sector:
  def __init__(self):
    self.fr = 0
    self.to = 0
    self.rad = 0
  def rotate(self, angle):
      self.fr += angle
      self.to += angle
  def intersect(self, other):
    radius = 0
    if(self.rad < other.rad): radius = self.rad
    elif(self.rad > other.rad): radius = other.rad
    else: radius = self.rad
    
    if (self.fr < other.fr and self.to > other.fr):
        return str(other.fr) + " " + str(self.to) + " " + str(radius)
    elif (self.fr < other.to and self.to > other.fr):
        return str(self.fr) + " " + str(other.to) + " " + str(radius)
    else:
        return False
  def is_empty(self):
    if (self.fr - self.to == 0):
      return True
    else:
      return False
  def __eq__(self, other):
    if (self.fr == other.fr and self.to == other.to):
      return  True
    else:
      return False
  def __str__(self):
    return str(self.fr) + " " + str(self.to) + " " + str(self.rad)


s1 = Sector()
s1.fr = 0
s1.to = 20
s1.rad = 40
print(s1.__str__())
s2 = Sector()
s2.fr = 40
s2.to = 90
s2.rad = 40
s1.rotate(50)
s2.rotate(30)
print(s1.__str__())
print(s2.__str__())
s1.fr = 70
s1.to = 120
print(s1.__eq__(s2))
