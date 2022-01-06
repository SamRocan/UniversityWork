def mult(a,b):
    if b==0:
        print("a: " + str(a) + "\nb: " + str(b))
        return 0
    else:
        print("a: " + str(a) + "\nb: " + str(b))
        print(b)
        return  a+mult(a, b-1)
prod = mult(3,7)
print(prod)