num = int(input())
last_dig = num % 10
second_last_dig = (num//10)%10
first_dig = (num//100)%10
output = last_dig+second_last_dig+first_dig

print(output)