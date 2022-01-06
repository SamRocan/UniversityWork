def matrix_max_index(M, m, n):
  rowCount = 0
  maxColVal = M[0][0]
  x = 0
  y = 0
  while(rowCount < m):
    for i in range(0,n):
      if(M[rowCount][i] > maxColVal):
        maxColVal = M[rowCount][i]
        x = rowCount
        y = i
        #print(maxColVal)
    rowCount += 1
    
  return (x,y)


M = [[0, 3, 2, 4], [2, 3, 5, 5],  [5, 1, 2, 3]]

print(matrix_max_index(M, 3, 4))
