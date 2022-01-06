col1 = int(input())
row1 = int(input())
col2 = int(input())
row2 = int(input())
color1 = "Y"
color2 = "N"

if(row1%2 == col1%2):
  color1 = "WHITE"
if(row1%2 != col1%2):
  color1 = "BLACK"
  
if(row2%2 == col2%2):
  color2 = "WHITE"
if(row2%2 != col2%2):
  color2 = "BLACK"


  
if(color1==color2):
  print("YES")
if(color1!=color2):
  print("NO")