class Counter:
  def __init__(self, my_id):
      self._items = 0
      self._id = my_id
      self._dict = {}
      self._dictAmount = {}
      self._total = 0
  def add(self, item_name, amount, price_of_unit): #Done
      self._dict[item_name] = price_of_unit
      self._dictAmount[item_name] = amount
      self._items += amount
      self._total += amount*price_of_unit

  def remove(self, item_name, amount):
      if (self._dictAmount[item_name] <= amount):
          self._total -= self._dictAmount[item_name] 
          del self._dict[item_name]
      else:
          self._dictAmount[item_name] -= amount
          self._total -= amount*self._dict[item_name]
      self._items -= amount

  def reset(self): #Done
      self._dict = {}
      self._dictAmount = {}
      self._items = 0      
      self._total = 0
  def get_total(self):
      return self._total
  def status(self): #Done
      return (str(self._id) + " " + str(self._items) + " " + str(round(self._total, 5)))

c = Counter("C001")
#Test1 checks if above not crashes 
c.add("Spaghetti", 5, 1.8)
print(c.status())
#Test2 checks c.status()=="C001 5 9.0"
c.add("Ice Cream", 2, 3.4)
print(c.status())
#Test3 checks c.status()=="C001 7 15.8"
c.get_total()
#Test4 checks c.get_total()==15.8
c.add("Spaghetti", 3, 1.8)
print(c.status())
#Test5 checks c.status()=="C001 10 21.2"
c.remove("Ice Cream", 1)
print(c.status())
#Test6 checks c.status()=="C001 9 17.8"
c.reset()
print(c.status())
c.add("Coke", 5, 1.45)
print(c.status())
#Test7 checks c.status()== "C001 5 7.25"
