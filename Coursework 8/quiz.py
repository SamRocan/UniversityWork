class Point:
    def update_coordinates(self, x, y):
        print("1")
        self.x = x
        self.y = y

    def __init__(self, x, y):
        print("2")
        self.update_coordinates(x, y)
    
    def get_coordinates(self):
        print("3")
        return (self.x, self.y)      # this constructs a tuple 

    def point_to_string(self):
        print("4")
        return str(self.get_coordinates())



class Circle:
    def __init__(self, x, y, r):
        print("5")
        self.centre = Point(x,y)
        self.radius = r

    def update_circle(self, x, y, r):
        print("6")
        self.centre.x = x
        self.centre.y = y
        self.radius = r

    def get_circle_coordinates_radius(self):
        print("7")
        return (self.centre.x, self.centre.y, self.r)     # this constructs a tuple 

    def circle_to_string(self):
        print("8")
        return "("+self.centre.point_to_string()+", "+str(self.radius)+")"

C = Circle(45,15,10)
print("-----------")
s = C.circle_to_string()