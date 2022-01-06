class Node:
  def __init__(self, init_data):
    self.data = init_data
    self.next = None

class Stack:
  def __init__(self):
    self.top = None    #top stores a Node
  def push(self, x):
    new_node = Node(x)
    new_node.next = self.top
    self.top = new_node
  def pop(self):
    self.top = self.top.next
  def peek(self):
    return self.top.data
  def is_empty(self):
    return self.top == None
    
stk = Stack()
s= input()
for sym in s:
  if sym in {"(", "[", "{", "<"}:
    stk.push(sym)
  else: #sym is a closing symbol
    sym1 = stk.peek()
    if (sym1 == "(" and sym == ")") or (sym1 == "[" and sym == "]") or \
    (sym1 == "{" and sym == "}") or (sym1 == "<" and sym == ">"): 
      stk.pop()
    else: 
      break
    
if stk.is_empty(): print("True")
else: print("False")
