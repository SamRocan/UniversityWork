Xstrs = input().split() #removes space, puts into list as strings

X = [int(x) for x in Xstrs] # converts the strings to integer
    # x is the first value for Xstrs
    # convert it to an integer
    # add it to list X
#print(X)
Ystrs = input().split()
Y = [int(x) for x in Ystrs]
#print (Y)
#for pair in Z: print(pair[0], pair[1])

Z = [(x,y) for x in X for y in Y if (x<y)] 

for pair in Z: print(pair[0], pair[1])