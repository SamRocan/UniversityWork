package test;
import game.ExplorationState;
import game.GameState;
import org.junit.Test;
import student.Explorer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static org.junit.Assert.assertEquals;


public class ExplorerTest {

    //Tests to see that they reach the orb and then can return
    @Test
    public void testExplore1() throws IOException {
        int g = GameState.runNewGame(-731937463, true);
    }
    @Test
    public void testExplore2() throws IOException {
        int g = GameState.runNewGame(45324, true);

    }
    @Test
    public void testExplore3() throws IOException {
        int g = GameState.runNewGame(-24, true);

    }
    @Test
    public void testExplore4() throws IOException {
        int g = GameState.runNewGame(103481380, true);

    }
    @Test
    public void testExplore5() throws IOException {
        int g = GameState.runNewGame(-7524, true);
    }

}
