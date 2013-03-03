package com.nitvakyi.maze;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativePathFinder {

	private final Maze MAZE;
	
	private List<List<? extends Point>> pathes = new ArrayList<>();
	
	public IterativePathFinder(Maze maze){
		this.MAZE = maze;
	}
	
	public List<List<? extends Point>> find() {
		internalFind();
		return pathes;
	}
	
	private static class LeveledPoint extends Point {
		public final int LEVEL;

		public LeveledPoint(int x, int y, int level){
			super(x, y);
			this.LEVEL = level;
		}
	}

	private void internalFind() {
		LinkedList<LeveledPoint> curPath = new LinkedList<>();
		Stack<LeveledPoint> stack = new Stack<LeveledPoint>();
		stack.push(new LeveledPoint(0, 0, 0));
		while(!stack.isEmpty()){
			LeveledPoint curPoint = stack.pop();
			curPath.subList(0, curPoint.LEVEL);
			log("level: " + curPoint.LEVEL);
			log(curPoint.toString());
			log(curPath.toString());
			curPath.push(curPoint);
			if(isFinalPoint(curPoint)){
				pathes.add(curPath);
				log("FINAL PATH: " + curPath);
				log("**************");
				log("");
			}
			if(MAZE.isRoad(curPoint.X + 1, curPoint.Y)){
				stack.push(new LeveledPoint(curPoint.X + 1, curPoint.Y, curPoint.LEVEL + 1));
			}
			if(MAZE.isRoad(curPoint.X, curPoint.Y + 1)){
				stack.push(new LeveledPoint(curPoint.X, curPoint.Y + 1, curPoint.LEVEL + 1));
			}
			if(MAZE.isRoad(curPoint.X + 1, curPoint.Y + 1)){
				stack.push(new LeveledPoint(curPoint.X + 1, curPoint.Y + 1, curPoint.LEVEL + 1));
			}
		}
	}
	
	private void log(String msg){
		System.out.println(msg);
	}
	
	private boolean isFinalPoint(Point p) {
		return p.X == MAZE.getWidth() - 1 && p.Y == MAZE.getHeight() - 1;
	}	
	
}
