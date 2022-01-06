// 13706342
// SamClendenan@iCloud.com


import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Chess {

	public static abstract class ChessPiece
	{
		private int locX, locY;

		ChessPiece( int x, int y )
		{
			locX = x;
			locY = y;
		}

		int getX()
		{
			return locX;
		}

		int getY()
		{
			return locY;
		}

		abstract boolean canAttack( ChessPiece p );
	}

	public static class King extends ChessPiece
	{
		King( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			if(Math.abs(this.getX() - p.locX) <= 1 &&  Math.abs(this.getY() - p.locY) <= 1 ) { return true;}
			else{return false;}

		}
	}


	public static class Bishop extends ChessPiece
	{
		Bishop( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{

			int diffX = Math.abs(this.getX() - p.getX());
			int diffY = Math.abs(this.getY() - p.getY());

			if(diffX == diffY){return true;}
			else{return false;}


		}
	}

	public static class Rook extends ChessPiece
	{
		Rook( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			if(this.getX() == p.locX || this.getY() == p.locY){return true;}
			else{ return false; }
		}		
	}

	public static class Queen extends ChessPiece
	{
		Queen( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int diffX = Math.abs(this.getX() - p.getX());
			int diffY = Math.abs(this.getY() - p.getY());
			if(diffX == diffY){return true;}
			else if(this.getX() == p.locX || this.getY() == p.locY){return true;}
			else{ return false; }
		}
	}

	public static class Knight extends ChessPiece
	{
		Knight( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			if(((Math.abs(this.getX() - p.locX) == 2) && (Math.abs(this.getY() - p.locY) ==1)) || ((Math.abs(this.getX() - p.locX) == 1) && (Math.abs(this.getY() - p.locY) ==2))) {return true;}
			else{ return false;}
		}		
	}


	public static void main(String[] args) {

	}
}