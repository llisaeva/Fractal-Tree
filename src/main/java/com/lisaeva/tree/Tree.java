/******************************************************************************************
 * Tree.java
 * 
 * @author Yelyzaveta Isaeva 
 * @author Dean & Dean | Introduction to Programming with Java : A Problem Solving Approach 2nd ed.
 * 
 *****************************************************************************************/

package com.lisaeva.tree;

import java.awt.Graphics;

public class Tree 
{
	/**
	 * Position of the tree in the horizontal dimension
	 */
	private final int START_X;
	
	/**
	 * Time when the tree sprouts from the earth
	 */
	private final int START_TIME;
	
	/**
	 * Maximum length of the lowest and largest tree member
	 */
	private final double MAX_TRUNK_LENGTH = 100;
	
	/**
	 * Current length of the trunk
	 */
	private double trunkLength;
	
	/**
	 * Constructs a <code>Tree</code> object.
	 * 
	 * @param location the location of where the tree trunk is placed on the x-axis
	 * @param startTime the time of when the tree starts to grow
	 * @param trunkLength the length of the trunk
	 */
	public Tree (int location, int startTime, double trunkLength)
	{
		this.START_X = location;
		this.START_TIME = startTime;
		this.trunkLength = trunkLength;
	}
	
	int getStartX()
	{
		return START_X;
	}
	
	int getStartTime()
	{
		return START_TIME;
	}
	
	double getTrunkLength()
	{
		return this.trunkLength;
	}
	
	/**
	 * Draws the branches of the <code>Tree</code>, using recursive method calls.
	 * The first statement converts degrees to radians. 
	 * 1 rad = 57.3 degrees, 180 degrees = pi radians 
	 * The second and third statements compute the x-position and 
	 * y-position of the other end of the branch.
	 * The if condition stops the recursion when the parameter <code>length</code>
	 * is equal to 2 or less. 
	 * The left branches length is 75% of the current branch's length, and the right
	 * branch's length is 67% of the current branch's length. 
	 * The branches get shorter as the recursion proceeds.
	 * 
	 * 
	 * @param g <code>Graphics</code> object, the drawing of the tree
	 * @param x0 x-position of the beginning of the branch
	 * @param y0 y-position of the beginning of the branch
	 * @param length length of the branch
	 * @param angle angle of a branch relative to the previous branch
	 */

	
	public void drawBranches(Graphics g, int x0, int y0, double length, double angle)
	{
		double radians = angle * Math.PI / 180;				
		int x1 = x0 + (int) (length * Math.cos(radians));
		int y1 = y0 - (int) (length * Math.sin(radians));
		
		if (length > 2)
		{
			g.drawLine(x0, y0, x1, y1);
			drawBranches(g, x1, y1, length * 0.75, angle + 30);
			drawBranches(g, x1, y1, length * 0.67, angle - 50);
		}
	}
	
	/**
	 * Updates the trees <code>trunkLength</code>
	 * The trees growth in time is modeled by using a venerable 
	 * recurrence relation called the logistic equation.
	 * 
	 */
	
	public void updateTrunkLength()
	{
		trunkLength = trunkLength +0.01 * trunkLength * (1.0 - trunkLength / MAX_TRUNK_LENGTH);
	}
	
	
}
