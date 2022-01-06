num = int(input())

#716253
count = 0
sum = 0
sum2 = 0
for i in range(num, 1, -1):
  test = int(input())
  sum += test
  count += 1

for z in range(1, num+1):
    sum2+=z


print(sum2-sum)
  


