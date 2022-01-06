// 13706342
// SamClendenan@iCloud.com

public class Rectangle {

    int bottomLeftX;
    int bottomLeftY;
    int topRightX;
    int topRightY;

    int rectWidth;
    int rectHeight;


    Rectangle( int xLowerLeft, int yLowerLeft, int width, int height )
    {
        this.bottomLeftX = xLowerLeft;
        this.bottomLeftY = yLowerLeft;
        this.topRightX= xLowerLeft + width;
        this.topRightY= yLowerLeft + height;
        this.rectWidth = width;
        this.rectHeight = height;
           
    }

    Rectangle( int xUpperRight, int yUpperRight )
    {
        this.topRightX = xUpperRight;
        this.topRightY = yUpperRight;
        this.bottomLeftX = 0;
        this.bottomLeftY = 0;
        this.rectWidth = xUpperRight;
        this.rectHeight = yUpperRight;
          
    }


    public boolean containsPoint( int x, int y )
    {
        if((x >= bottomLeftX && x<= topRightX) && (y <= topRightY && y >= bottomLeftY)){ return true;}
        else if((y >= bottomLeftY && y<= topRightY) && (x <= topRightX && x >= bottomLeftX)){ return true;}
        else {return false;}
    }

    public boolean containsRectangle( Rectangle r )
    {
        if (this.containsPoint(r.bottomLeftX, r.bottomLeftY) && this.containsPoint(r.topRightX, r.topRightY)){ return true;}
        else {return false;}
    }

    public String toString()
    {
        return ("("+bottomLeftX+","+bottomLeftY+"), ("+topRightX+","+topRightY+")");
    }
    public static void main(String[] args) 
    {
        
    }
}