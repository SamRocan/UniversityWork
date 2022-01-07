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


public class EscapeTest {
    //Tests to see that they reach the orb
    //The program is expected to initially fail as it cannot return home
    //Due to Escape function being incomplete. This is why they only
    //implement GUI so i can personally see that they complete.
    @Test
    public void testExplore1() throws IOException {
        int g = GameState.runNewGame(-1208949, true);
    }
    @Test
    public void testExplore2() throws IOException {
        int g = GameState.runNewGame(89268510, true);

    }
    @Test
    public void testExplore3() throws IOException {
        int g = GameState.runNewGame(-65628461, true);

    }
    @Test
    public void testExplore4() throws IOException {
        int g = GameState.runNewGame(384, true);

    }
    @Test
    public void testExplore5() throws IOException {
        int g = GameState.runNewGame(-299, true);
    }
}
