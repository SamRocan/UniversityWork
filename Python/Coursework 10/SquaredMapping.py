X = [int(x) for x in input().split()]
Y = [int(x) for x in input().split()]

it_squared_mapping = zip((x**2 for x in X),Y) #insert a zip expression here
print(set(it_squared_mapping))
for x in it_squared_mapping: print(x[0], x[1])