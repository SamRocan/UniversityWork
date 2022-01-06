import pytest
from battleships import *

def test_is_sunk1():
    s = (2, 3, False, 3, {(2,3), (3,3), (4,3)})
    assert is_sunk(s) == True

    s = (7, 9, False, 4, {(7,9), (5,9), (4,9)})
    assert is_sunk(s) == False

    s = (5, 9, True, 1, {(4,3)})
    assert is_sunk(s) == True

    s = (6, 2, False, 2, set())
    assert is_sunk(s) == False

    s = (8, 2, False, 1, {(8,2)})
    assert is_sunk(s) == True

def test_ship_type1():
    s =  (2, 3, False, 3, {(2,3), (3,3), (4,3)})
    assert ship_type(s) == 'Cruiser'

    s = (1, 9, False, 2, {(1,9)})
    assert ship_type(s) == 'Destroyer'

    s = (5, 2, True, 4, set())
    assert ship_type(s) == 'Battleship'

    s = (9, 4, True, 1, {(9,4)})
    assert ship_type(s) == "Submarine"

    s = (8, 2, False, 1, set())
    assert ship_type(s) == "Submarine"


def test_is_open_sea1():
    fleet = [(1, 8, False, 4, set()), (3, 6, False, 3, set()), (8, 4, False, 3, set()), (7, 8, False, 2, set()), (6, 5, False, 2, set()), (0, 1, True, 2, set()), (5, 0, False, 1, set()), (5, 8, False, 1, set()), (3, 0, False, 1, set()), (8, 0, True, 1, set())]
    o = (5,7,fleet)
    assert is_open_sea(o[0],o[1],o[2]) == False

    fleet = [(9, 9, False, 4, set()), (4, 1, True, 3, set()), (3, 7, True, 3, set()), (0, 6, True, 2, set()), (6, 5, True, 2, set())]
    o = (8,7,fleet)
    assert is_open_sea(o[0],o[1],o[2]) == False

    fleet = [(3, 2, True, 4, set()), (0, 4, False, 3, set())]
    o = [0,2, fleet]
    assert is_open_sea(o[0],o[1],o[2]) == False

    fleet = [(1, 7, False, 4, set()), (3, 7, False, 3, set()), (0, 9, True, 3, set()), (8, 4, False, 2, set()), (6, 8, True, 2, set()), (3, 2, True, 2, set()), (1, 2, False, 1, set()), (7, 6, False, 1, set()), (9, 6, True, 1, set())]
    o = [5, 3, fleet]
    assert is_open_sea(o[0],o[1],o[2]) == False

    fleet = [(9, 9, False, 4, set()), (5, 1, True, 3, set()), (3, 6, False, 3, set()), (6, 8, False, 2, set())]
    o = [0,9, fleet]
    assert is_open_sea(o[0],o[1],o[2]) == True

def test_ok_to_place_ship_at1():
    fleet = [(4, 9, False, 4, set()), (1, 9, False, 3, set()), (8, 9, False, 3, set()), (1, 0, True, 2, set()), (6, 4, False, 2, set()), (1, 2, True, 2, set()), (9, 3, False, 1, set()), (7, 1, True, 1, set()), (4, 3, True, 1, set()), (2, 4, True, 1, set())]
    s = (6, 4, True, 3, fleet)
    assert ok_to_place_ship_at(s[0],s[1],s[2],s[3], s[4]) == False

    fleet = [(1, 7, False, 4, set()), (9, 4, False, 3, set()), (3, 6, False, 3, set()), (0, 9, True, 2, set())]
    s = (6, 9, True, 2, fleet)
    assert ok_to_place_ship_at(s[0],s[1],s[2],s[3],s[4]) == True

    fleet = [(0, 2, True, 4, set()), (1, 6, False, 3, set()), (8, 9, False, 3, set()), (3, 6, False, 2, set()), (2, 9, True, 2, set()), (6, 8, False, 2, set()), (5, 5, True, 1, set())]
    s = (1, 1, True, 1, fleet)
    assert ok_to_place_ship_at(s[0],s[1],s[2],s[3],s[4]) == False

    fleet = [(0, 7, True, 4, set()), (2, 4, True, 3, set()), (0, 1, True, 3, set()), (7, 5, True, 2, set()), (4, 0, True, 2, set()), (2, 9, True, 2, set()), (8, 3, False, 1, set()), (9, 9, False, 1, set()), (5, 2, False, 1, set())]
    s = (5, 6, False, 1, fleet)
    assert ok_to_place_ship_at(s[0],s[1],s[2],s[3],s[4]) == True

    fleet = []
    s = (2, 7, False, 4, fleet)
    assert ok_to_place_ship_at(s[0],s[1],s[2],s[3],s[4]) == True

def test_place_ship_at1():
    fleet = [(8, 8, False, 4, set()), (6, 7, False, 3, set()), (3, 1, True, 3, set())]
    s = (6, 2, False, 2, fleet)
    assert place_ship_at(s[0],s[1],s[2],s[3], fleet) == [(8, 8, False, 4, set()), (6, 7, False, 3, set()), (3, 1, True, 3, set()), (6, 2, False, 2, set())]

    fleet = [(1, 3, True, 4, set()), (4, 9, False, 3, set()), (3, 5, True, 3, set()), (6, 8, True, 2, set()), (1, 8, False, 2, set())]
    s = (8, 9, False, 2, fleet)
    assert place_ship_at(s[0],s[1],s[2],s[3], fleet) == [(1, 3, True, 4, set()), (4, 9, False, 3, set()), (3, 5, True, 3, set()), (6, 8, True, 2, set()), (1, 8, False, 2, set()), (8, 9, False, 2, set())]

    fleet = [(2, 2, True, 4, set()), (4, 7, False, 3, set()), (1, 0, True, 3, set()), (2, 6, False, 2, set()), (0, 9, False, 2, set()), (8, 9, False, 2, set()), (8, 5, False, 1, set()), (9, 0, True, 1, set())]
    s = (4, 9, False, 1, fleet)
    assert place_ship_at(s[0],s[1],s[2],s[3], fleet) == [(2, 2, True, 4, set()), (4, 7, False, 3, set()), (1, 0, True, 3, set()), (2, 6, False, 2, set()), (0, 9, False, 2, set()), (8, 9, False, 2, set()), (8, 5, False, 1, set()), (9, 0, True, 1, set()), (4, 9, False, 1, set())]

    fleet = []
    s = (7, 1, True, 1, fleet)
    assert place_ship_at(s[0],s[1],s[2],s[3], fleet) == [(7, 1, True, 1, set())]

    fleet = [(3, 3, True, 4, set()), (2, 6, True, 3, set())]
    s = (1, 0, True, 3, fleet)
    assert place_ship_at(s[0],s[1],s[2],s[3], fleet) == [(3, 3, True, 4, set()), (2, 6, True, 3, set()), (1, 0, True, 3, set())]

def test_check_if_hits1():
    fleet = [(0, 6, True, 4, set()), (9, 5, False, 3, set()), (5, 8, False, 3, set()), (8, 9, False, 2, set()), (2, 0, True, 2, set()), (6, 2, False, 2, set()), (1, 4, True, 1, set()), (7, 5, False, 1, set()), (2, 2, False, 1, set()), (3, 8, True, 1, set())]
    s = (8, 9, fleet)
    assert check_if_hits(s[0],s[1], fleet) == True

    fleet = [(7, 8, False, 4, set()), (0, 5, False, 3, set()), (0, 8, True, 3, set()), (3, 4, False, 2, set()), (4, 1, True, 2, set()), (4, 9, True, 2, set()), (5, 4, False, 1, set()), (8, 2, True, 1, set()), (2, 0, True, 1, set()), (2, 6, False, 1, set())]
    s = (0, 4, fleet)
    assert check_if_hits(s[0],s[1], fleet) == True

    fleet = [(0, 5, True, 4, set()), (2, 2, True, 3, set()), (1, 8, True, 3, set()), (0, 0, True, 2, set()), (4, 0, True, 2, set()), (9, 9, False, 2, set()), (8, 2, True, 1, set()), (9, 4, True, 1, set()), (5, 4, False, 1, set()), (0, 2, True, 1, set())]  
    s = (2, 7, fleet)
    assert check_if_hits(s[0],s[1], fleet) == False

    fleet = [(3, 6, True, 4, set()), (1, 4, False, 3, set()), (5, 1, True, 3, set()), (6, 9, False, 2, set()), (9, 2, False, 2, set()), (7, 4, True, 2, set()), (9, 8, False, 1, set()), (9, 6, True, 1, set()), (3, 3, True, 1, set()), (5, 4, True, 1, set())]
    s = (9, 1, fleet)
    assert check_if_hits(s[0],s[1], fleet) == True

    fleet = [(2, 9, True, 4, set()), (0, 5, True, 3, set()), (7, 8, False, 3, set()), (7, 4, True, 2, set()), (2, 0, True, 2, set()), (5, 2, False, 2, set()), (9, 9, False, 1, set()), (0, 1, True, 1, set()), (0, 9, False, 1, set()), (4, 5, True, 1, set())]
    s = (8, 5, fleet)
    assert check_if_hits(s[0],s[1], fleet) == False
    
  
def test_hit1():
    fleet = [(4, 6, False, 4, set()), (0, 9, True, 3, set()), (8, 9, False, 3, set()), (0, 7, True, 2, set()), (4, 9, False, 2, set()), (2, 4, False, 2, set()), (9, 1, True, 1, set()), (7, 1, True, 1, set()), (1, 1, True, 1, set()), (7, 3, True, 1, set())]
    s = (4, 4, fleet)
    assert hit(s[0],s[1], fleet) == ([(4, 6, False, 4, {(4, 4)}), (0, 9, True, 3, set()), (8, 9, False, 3, set()), (0, 7, True, 2, set()), (4, 9, False, 2, set()), (2, 4, False, 2, set()), (9, 1, True, 1, set()), (7, 1, True, 1, set()), (1, 1, True, 1, set()), (7, 3, True, 1, set())], (4, 6, False, 4, {(4, 4)}))

    fleet = [(3, 3, True, 4, {(3,3),(4,3),(5,3)}), (0, 6, False, 3, {(0,6), (0, 5), (0,4)}), (7, 7, False, 3, {(7,7),(7,6),(7,5)}), (5, 0, True, 2, {(5,0),(6,0)}), (0, 1, True, 2, {(0,1),(1,1)}), (9, 7, False, 2, {(9,7),(9,6)}), (8, 1, True, 1, {(8,1)}), (2, 9, True, 1, set()), (7, 9, True, 1, {(7,9)}), (3, 0, True, 1, set())]
    s = (2, 9, fleet)
    assert hit(s[0],s[1], fleet) == ([(3, 3, True, 4, {(3,3),(4,3),(5,3)}), (0, 6, False, 3, {(0,6), (0, 5), (0,4)}), (7, 7, False, 3, {(7,7),(7,6),(7,5)}), (5, 0, True, 2, {(5,0),(6,0)}), (0, 1, True, 2, {(0,1),(1,1)}), (9, 7, False, 2, {(9,7),(9,6)}), (8, 1, True, 1, {(8,1)}), (2, 9, True, 1, {(2,9)}), (7, 9, True, 1, {(7,9)}), (3, 0, True, 1, set())], (2, 9, True, 1, {(2,9)}))

    fleet = [(2, 9, True, 4, set()), (7, 6, False, 3, {(7,6),(7,5),(7,4)}), (3, 0, True, 3, {(4,0),(5,0)}), (7, 9, True, 2, {(7,9),(8,9)}), (5, 5, False, 2, set()), (9, 5, False, 2, {(9,5)}), (3, 3, False, 1, {(3,3)}), (1, 3, True, 1, set()), (0, 0, False, 1, set()), (7, 2, True, 1, {(7,2)})]
    s = (4, 9, fleet)
    assert hit(s[0],s[1], fleet) == ([(2, 9, True, 4, {(4,9)}), (7, 6, False, 3, {(7,6),(7,5),(7,4)}), (3, 0, True, 3, {(4,0),(5,0)}), (7, 9, True, 2, {(7,9),(8,9)}), (5, 5, False, 2, set()), (9, 5, False, 2, {(9,5)}), (3, 3, False, 1, {(3,3)}), (1, 3, True, 1, set()), (0, 0, False, 1, set()), (7, 2, True, 1, {(7,2)})], (2, 9, True, 4, {(4,9)}))

    fleet = [(2, 8, True, 4, set()), (0, 5, True, 3, set()), (9, 5, False, 3, set()), (6, 3, False, 2, set()), (2, 3, False, 2, set()), (7, 6, False, 2, set()), (9, 9, False, 1, set()), (7, 8, True, 1, set()), (1, 0, False, 1, [(1,0)]), (9, 1, False, 1, [(9,1)])]
    s = (1,5, fleet)
    assert hit(s[0],s[1], fleet) == ([(2, 8, True, 4, set()), (0, 5, True, 3, {(1,5)}), (9, 5, False, 3, set()), (6, 3, False, 2, set()), (2, 3, False, 2, set()), (7, 6, False, 2, set()), (9, 9, False, 1, set()), (7, 8, True, 1, set()), (1, 0, False, 1, [(1,0)]), (9, 1, False, 1, [(9,1)])], (0, 5, True, 3, {(1,5)}))
    
    fleet = [(1, 9, False, 4, {(1,9),(1,8),(1,7)}), (2, 2, True, 3, {(2,2),(3,2),(4,2)}), (9, 4, False, 3, set()), (6, 5, True, 2, set()), (3, 4, True, 2, set()), (4, 0, True, 2, set()), (3, 7, False, 1, set()), (9, 8, False, 1, set()), (5, 9, False, 1, set()), (9, 6, False, 1, set())]
    s = (5, 9, fleet)
    assert hit(s[0],s[1], fleet) == ([(1, 9, False, 4, {(1,9),(1,8),(1,7)}), (2, 2, True, 3, {(2,2),(3,2),(4,2)}), (9, 4, False, 3, set()), (6, 5, True, 2, set()), (3, 4, True, 2, set()), (4, 0, True, 2, set()), (3, 7, False, 1, set()), (9, 8, False, 1, set()), (5, 9, False, 1, {(5,9)}), (9, 6, False, 1, set())], (5, 9, False, 1, {(5,9)}))
    

def test_are_unsunk_ships_left1():
    fleet = [(1, 8, False, 4, set()), (0, 0, True, 3, set()), (5, 3, True, 3, set()), (8, 9, False, 2, set()), (0, 3, True, 2, set()), (4, 6, True, 2, set()), (9, 3, False, 1, set()), (8, 6, False, 1, set()), (4, 9, True, 1, set()), (6, 9, True, 1, set())]
    s = fleet
    assert are_unsunk_ships_left(s) == True

    fleet = [(2, 8, True, 4, {(2,8),(3,8),(4,8),(5,8)}), (9, 7, False, 3, {(9,7),(9,6),(9,5)}), (6, 5, False, 3, {(6,5),(6,4),(6,3)}), (0, 6, False, 2, {(0,6),(0,5)}), (2, 5, False, 2, {(2,5),(2,4)}), (0, 0, True, 2, {(0,0),(0,1)}), (4, 0, True, 1, {(4,0)}), (6, 1, True, 1, {(6,1)}), (4, 5, True, 1, {(4,5)}), (9, 2, False, 1, {(9,2)})]
    s = fleet
    assert are_unsunk_ships_left(s) == False

    fleet = [(1, 9, False, 4, {(1,9),(1,8),(1,7),(1,6)}), (4, 9, False, 3, {(4,9),(4,8)}), (6, 8, False, 3, {(6,8),(6,7),(6,6)}), (1, 2, False, 2, {(1,2),(1,1)}), (5, 4, False, 2, set()), (0, 4, True, 2, {(0,4),(1,4)}), (8, 9, True, 1, {(8,9)}), (6, 0, False, 1, {(6,0)}), (3, 4, False, 1, {(3,4)}), (7, 4, False, 1, {(7,4)})]
    s = fleet
    assert are_unsunk_ships_left(s) == True

    fleet = [(8, 9, False, 4, {(8,9),(8,8),(8,7),(8,6)}), (2, 4, False, 3, {(2,4),(2,3),(2,2)}), (4, 8, True, 3, {(4,8),(5,8),(6,8)}), (1, 9, False, 2, {(1,9),(1,8)}), (4, 0, True, 2, {(4,0),(5,0)}), (6, 3, True, 2, {(6,3),(7,3)}), (4, 5, False, 1, {(4,5)}), (8, 1, True, 1, {(8,1)}), (1, 0, False, 1, {(1,0)}), (4, 3, False, 1, {(4,3)})]
    s = fleet
    assert are_unsunk_ships_left(s) == False

    fleet = [(4, 8, False, 4, set()), (2, 8, False, 3, {(2,8),(2,7)}), (9, 7, False, 3, set()), (6, 5, False, 2, {(6,5),(6,4)}), (4, 2, True, 2, {(4,2),(5,2)}), (6, 8, False, 2, set()), (7, 2, False, 1, {(7,2)}), (9, 9, False, 1, {(9,9)}), (3, 0, True, 1, {3,0}), (0, 8, True, 1, set())]
    s = fleet
    assert are_unsunk_ships_left(s) == True
    #add at least one test for are_unsunk_ships_left by the deadline of session 7 assignment
    #provide at least five tests in total for are_unsunk_ships_left by the project submission deadline
    
