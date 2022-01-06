// 13706342
// SamClendenen@iCloud.com
import java.lang.*;

//This code is incomplete and or completely wrong. Just a warning!

public class Knight {
    public Knight() {

    }

    public static int numMoves(int dim, int xstart, int ystart, int xtarget, int ytarget, int[] xrock, int[] yrock) {
        int movesX[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int movesY[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        int count = 0;
        int xpos= xstart, ypos = ystart;
        //(1,7) --> (1,1)
        System.out.println("("+xpos+","+ypos+")");

        while(xpos != xtarget || ypos != ytarget){
            int holdX, holdY;
            int xdiff=xtarget-xstart, ydiff=ytarget-ystart;

            if ((xpos == xtarget || xpos == xtarget + 1|| xpos == xtarget - 1) && (ypos == ytarget || ypos == ytarget + 1 || ypos == ytarget - 1)){
                //Move Away
            }
            for (int z = 0; z< movesX.length; z++){
                //theoretical position if this move was taken
                holdX = xpos + movesX[z];
                holdY = ypos + movesY[z];
                //distance to target if move was taken
                if(xdiff < xtarget -holdX){xdiff = xtarget - holdX;}
                if(ydiff < ytarget -holdY){ydiff = ytarget - holdY;}
            }

            count++; if(count == 7){break;}
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5};
        int[] b = {2,3,6,3};
        numMoves(10, 1, 7, 1, 1, a, b);

    }
}