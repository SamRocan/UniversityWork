import random

def is_sunk(ship):
    """Returns Boolean value, which is `True` if `ship` is sunk and `False` otherwise"""
    if(ship[3]==len(ship[4])):
        return True
    else:
        return False

def ship_type(ship):
    """Returns one of the strings `"battleship"`, `"cruiser"`, `"destroyer"`, or 
    `"submarine"` identifying the type of `ship`"""
    if(ship[3] == 1):
        return("Submarine")
    elif(ship[3] == 2):
        return("Destroyer")
    elif(ship[3] == 3):
        return("Cruiser")
    elif(ship[3] == 4):
        return("Battleship")
    else:
        return("Incorrect length")

def is_open_sea(row, column, fleet):
    """Checks if the square given by `row` and `column` neither contains nor is adjacent (horizontally, vertically, or diagonally)
    to some ship in `fleet`. Returns Boolean `True` if so and `False` otherwise """
    allOccupied = []
    for i in fleet: 
        occupied = [] 
        if(i[2] == True): 
            z=i[0] + 1 
            occupied.append((i[0],i[1]))
            while(z<(i[0]+i[3])):
                occupied.append((z,i[1]))
                z += 1
        if(i[2] == False):
            z=i[1]-1
            occupied.append((i[0],i[1]))
            while(z>(i[1]-i[3])):
                occupied.append((i[0],z))
                z-=1
        allOccupied.append(occupied)


    for i in range(row-1, row+2):
        for z in range(column-1,column+2):
            hold = (i,z)
            for g in allOccupied:
                for m in g:
                    if(m == hold):
                        return False                   
    return True

def ok_to_place_ship_at(row, column, horizontal, length, fleet):
    """Checks if addition of a ship, specified by `row, column, horizontal`, and `length`
    as in `ship` representation above, to the `fleet` results in a legal arrangement 
    (see the figure above). If so, the function returns Boolean `True` and it returns
    `False` otherwise. This function makes use of the function `is_open_sea`

    loop through position, if is open sea for all spots of ship = true --> return true
    else return false."""


    if(horizontal == True):
        for i in range(0,length):
            #for each x value
            posX = row+i
            okToPlace = is_open_sea(posX,column,fleet)
            #to stop boats going out of bounds
            if((posX+length-1)>9 or posX<0):
                return False
            #to stop boats going out of bounds
            if(okToPlace == False):
                return False

    if(horizontal == False):
        for i in range(0,length):
            posY = column-i
            if(posY>9 or (posY-length+1)<0):
                return False
            okToPlace = is_open_sea(row,posY,fleet)
            if(okToPlace == False):
                return False

    return True

def place_ship_at(row, column, horizontal, length, fleet):
    """Returns a new fleet that is the result of adding a ship, specified by `row, column, 
    horizontal`, and `length` as in `ship` representation above, to `fleet`. It may be 
    assumed that the resulting arrangement of the new fleet is legal
    Added a hits variable to keep track of how often its been hit."""

    hits = set()
    fleet.append((row, column, horizontal, length, hits))
    
    return fleet

def randomly_place_all_ships():
    """Returns a fleet that is a result of a random legal arrangement of the 10 ships in 
    the ocean. This function makes use of the functions `ok_to_place_ship_at` and `place_ship_at`"""

    fleetSize = [4,3,3,2,2,2,1,1,1,1,]
    fleet = []
    for i in range(len(fleetSize)):
        xPos = -1
        yPos = -1
        YorN = random.randint(0,1)
        horizontal = True
        if(YorN == 1): horizontal = False
        while(ok_to_place_ship_at(xPos, yPos, horizontal, fleetSize[i], fleet)==False):
            xPos = random.randint(0,9)
            yPos = random.randint(0,9)
            YorN = random.randint(0,1)
            if(YorN == 0): horizontal = True
            if(YorN == 1): horizontal = False
        place_ship_at(xPos, yPos, horizontal, fleetSize[i], fleet) 
    return fleet

def check_if_hits(row, column, fleet):
    """Returns Boolean value, which is `True` if the shot of the human player at the square 
    represented by `row` and `column` hits any of the ships of `fleet`, and `False` otherwise"""
    for i in fleet:
        #loops length of ship, starting at top right co-ordinate
        for z in range(0, i[3]):
            
            if(i[2] == True):
                x = i[0]+z
                y = i[1]
                #print(str(x) + "~" +str(y))
                if(x == row and y == column):
                    return True
            if(i[2] == False):
                x = i[0]
                y = i[1]-z
                #print(str(x) + "~" +str(y))
                if(x == row and y == column):
                    return True
    return False    

def hit(row, column, fleet):
    """Returns a tuple `(fleet1, ship)` where `ship` is the ship from the fleet `fleet` that 
    receives a hit by the shot at the square represented by `row` and `column`, and `fleet1` 
    is the fleet resulting from this hit. It may be assumed that shooting at the square 
    `row, column` results in of some ship in `fleet`"""


    fleet1 = fleet
    ship = []
    isHit = False
    if (check_if_hits(row,column,fleet) == True):
        for i in fleet:
            for z in range(0, i[3]):
                if(i[2] == True):
                    x = i[0]+z
                    y = i[1]
                    if(x == row and y == column and isHit == False):
                        ship = i
                        ship[4].add((row,column))
                        isHit = True
                if(i[2] == False):
                    x = i[0]
                    y = i[1]-z
                    #print(str(x) + "~" +str(y))
                    if(x == row and y == column and isHit == False):
                        ship = i
                        ship[4].add((row,column))
                        isHit = True


    return (fleet1, ship)

def are_unsunk_ships_left(fleet):
    """Returns Boolean value, which is `True` if there are ships in the fleet that 
    are still not sunk, and `False` otherwise """

    for ship in fleet:
        if(is_sunk(ship) == False): return True

    return False

def game_board(sunk_list, shot_list, hit_list):
    """Prints the gameboard before each move, updating it showing positions hit, misses
     and sunk ships
    """
    
    S = sunk_list["Submarine"]
    D = sunk_list["Destroyer"]
    C = sunk_list["Cruiser"]
    B = sunk_list["Battleship"]

    print("")   
    print("    0 1 2 3 4 5 6 7 8 9")
    print("    -------------------")
    for i in range(0,10):
        for z in range(0,10):
            if(z == 0):
                print(str(i)+" | ", end="")
                
            if([z,i] in S):
                print("S ", end="")
            elif([z,i] in D):
                print("D ", end="")
            elif([z,i] in C):
                print("C ", end="")
            elif([z,i] in B):
                print("B ", end="")
            elif([z,i] in hit_list):
                print("* ", end="")
            elif([z,i] in shot_list):
                print("- ", end="")
            else:
                print(". ", end="")
        print("")
        
    print("")

def main():
    """ 
    Returns nothing. It prompts the user to call out rows and columns of shots and outputs the 
    responses of the computer iteratively until the game stops
    """
    current_fleet = randomly_place_all_ships()
    
    fleet = [4,3,3,2,2,2,1,1,1,1]
    #Keep track of all the hits
    shot_list = []
    hit_list = []
    sunk_list = {
        "Submarine":[],
        "Destroyer":[],
        "Cruiser":[],
        "Battleship":[]
    }
    S = sunk_list["Submarine"]
    D = sunk_list["Destroyer"]
    C = sunk_list["Cruiser"]
    B = sunk_list["Battleship"]


    #For practicing game against other person
    f = open("ShipPositions.txt", "w")
    for i in current_fleet:
        f.write(str(i))
    f.close()

    game_over = False
    shots = 0

    while not game_over:
        game_board(sunk_list, shot_list, hit_list)
        loc_str = input("Enter row and column to shoot (separted by space): ").split()
        if(len(loc_str) < 2 or len(loc_str)>2):
            print("Incorrect entry: Co-Ordinate length incorrect")
        elif((loc_str[0].isdigit() == False) or (loc_str[1].isdigit() == False)):
            print("Incorrect entry: Not a number")
        elif(int(loc_str[0]) < 0 or int(loc_str[0]) > 9 or int(loc_str[1]) < 0 or int(loc_str[1]) > 9):
            print("Incorrect entry: X or Y cannot be greater than 9 or less than 0")
        else:
            current_row = int(loc_str[0])
            current_column = int(loc_str[1])
            shots += 1
            if (check_if_hits(current_row, current_column, current_fleet)) and ([current_row,current_column] not in hit_list):
                hit_list.append([current_row,current_column])
                print("You have a hit!")
                (current_fleet, ship_hit) = hit(current_row, current_column, current_fleet)
                if is_sunk(ship_hit):
                    print("You sank a " + ship_type(ship_hit) + "!")

                    ##### ADDITION #####  
                    for z in range(0, ship_hit[3]):
                        if(ship_hit[2] == True):
                            x = ship_hit[0]+z
                            y = ship_hit[1]
                        if(ship_hit[2] == False):
                            x = ship_hit[0]
                            y = ship_hit[1]-z
                        sunk_list[ship_type(ship_hit)].append([x,y])

            elif([current_row,current_column] in hit_list):
                print("position already hit")
            else:
                print("You missed!")
            shot_list.append([current_row,current_column])
            if not are_unsunk_ships_left(current_fleet): game_over = True

    game_board(sunk_list, shot_list, hit_list)
    print("Game over! You required", shots, "shots.")


if __name__ == '__main__': #keep this in
   main()