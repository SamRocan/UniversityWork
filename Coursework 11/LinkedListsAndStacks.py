class Node:
  def __init__(self, init_data):
    self.data = init_data
    self.next = None

class Stack:
  def __init__(self):
    self.top = None    #top stores a Node
    self.items = []
  def push(self, x):
    return self.items.append(x)
    #implement this: adds a new Node, makes top point to it,
    #old top is "saved in" the new Node's next
  def pop(self):
    return self.items.pop()
    #implement this: makes top point to the next of the Node pointed to by top
  def peek(self):
    return self.items[len(self.items)-1]
    #implement this: returns the data of the Node pointed to by top
  def is_empty(self):
    if(self.items == []):
      return True
    else:
      return False
    #implement this: returns True if there are no Nodes in
    #Stack, otherwise False