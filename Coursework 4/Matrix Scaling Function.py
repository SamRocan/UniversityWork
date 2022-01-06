def scale_matrix(M, m, n, c):
    matrix = [[0] * n for i in range(m)]
    rowCount = 0
    while (rowCount < m):
        for z in range(0, n):
            newVal = c*(M[rowCount][z])
            matrix[rowCount][z] = newVal
        rowCount+=1
    return matrix

M = [[11, 12, 13, 14, 86], [21, 22, 23, 24, 36], [31, 32, 33, 34, 75]]
N = scale_matrix(M, 3, 5, 3)
print(M)
print(N)