package com.nitvakyi.maze;

public class Maze {

	private final boolean[][] MAZE;

	public Maze(final int width, final int height){
		this.MAZE = new boolean[width][];
		for(int i = 0; i < width; i++){
			this.MAZE[i] = new boolean[height];
		}
	}	
	
	public Maze(boolean[][] maze){
		this.MAZE = maze;
	}
	
	public int getHeight(){
		return MAZE[0].length;
	}	
	
	public int getWidth(){
		return MAZE.length;
	}
	
	public boolean isRoad(int x, int y){
		if(x >= MAZE.length){
			return false;
		}
		if(y >= MAZE[x].length){
			return false;
		}
		return MAZE[x][y];
	}
	
	public void buildRoad(int x, int y){
		MAZE[x][y] = true;
	}
	
	public void destroyRoad(int x, int y){
		MAZE[x][y] = false;
	}	

}
