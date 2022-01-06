def mult(a,b):
    if b==0:
        return 0
    else:
        print("(%i,%i)" % (a, b))
        return  a+mult(a, b-1)

print(mult(6,5))