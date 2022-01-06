// 13706342
// SamClendenan@iCloud.com

public class Square extends Rectangle
{
	int length;
	Square( int xLowerLeft, int yLowerLeft, int sideLength )
	{
		super(xLowerLeft, yLowerLeft, sideLength, sideLength);
		length = sideLength;
	}

	Square( int sideLength )
	{
		super(sideLength, sideLength);
	}
}