package com.nitvakyi.maze;

import java.util.ArrayList;
import java.util.List;

public class RecursivePathFinder {
	
	private final Maze MAZE;
	
	private List<List<? extends Point>> pathes = new ArrayList<>();
	
	public RecursivePathFinder(Maze maze){
		this.MAZE = maze;
	}

	public List<List<? extends Point>> find() {
		findFromPoint(new Point(0, 0), new ArrayList<Point>());
		return pathes;
	}

	private void findFromPoint(Point p, List<Point> curPath) {
		curPath.add(p);
		if(isFinalPoint(p)){	//recursive stop point
			pathes.add(curPath);
			return;
		}
		if(MAZE.isRoad(p.X + 1, p.Y)){
			findFromPoint(new Point(p.X + 1, p.Y), new ArrayList<Point>(curPath));
		}
		if(MAZE.isRoad(p.X, p.Y + 1)){
			findFromPoint(new Point(p.X, p.Y + 1), new ArrayList<Point>(curPath));
		}
		if(MAZE.isRoad(p.X + 1, p.Y + 1)){
			findFromPoint(new Point(p.X + 1, p.Y + 1), new ArrayList<Point>(curPath));
		}	
	}

	private boolean isFinalPoint(Point p) {
		return p.X == MAZE.getWidth() - 1 && p.Y == MAZE.getHeight() - 1;
	}

}
