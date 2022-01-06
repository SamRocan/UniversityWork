def swap_columns(M, m, n, i, j):
  rowCount = 0
  newM = 0
  iHold = 0
  jHold = 0
  while(rowCount < m):
    iHold = M[rowCount][i] 
    jHold = M[rowCount][j]
    M[rowCount][i] = jHold
    M[rowCount][j] = iHold
    rowCount += 1
  print(M)

M =  [[11, 12, 13, 14], [21, 22, 23, 24], [31, 32, 33, 34]]

swap_columns(M, 3, 4, 0, 1)