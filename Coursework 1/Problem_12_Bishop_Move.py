col1 = int(input())
row1 = int(input())
col2 = int(input())
row2 = int(input())

rowDiff = abs(row1-row2)
colDiff = abs(col1-col2)

if (rowDiff == colDiff):
  print("YES")
else:
  print("NO")