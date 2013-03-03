package com.nitvakyi.maze;

public class Point {

	public final int X;
	public final int Y;
	
	public Point(int x, int y){
		this.X = x;
		this.Y = y;
	}

	@Override
	public String toString() {
		return "[" + X + ", " + Y + "]";
	}
	
}
