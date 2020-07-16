/********************************************************************************************
 * TreePanel.java
 * @author Yelyzaveta Isaeva
 * @author Dean & Dean | Introduction to Programming with Java : A Problem Solving Approach 2nd ed.
 * 
 *******************************************************************************************/

package com.lisaeva.tree;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class TreePanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	/** Panel height */
	private final int HEIGHT;
	/** Panel width */
	private final int WIDTH;
	/** Array of <code>Tree</code> objects */
	private ArrayList<Tree> trees = new ArrayList<>();
	/** Current simulation time */
	int time = 0;
	
	/**
	 * Constructs the panel that will hold the <code>Graphics</code> object.
	 * 
	 * @param frameHeight sets the <code>HEIGHT</code> of the panel
	 * @param frameWidth sets the <code>WIDTH</code> of the panel
	 */
	public TreePanel(int frameHeight, int frameWidth)
	{
		this.HEIGHT = frameHeight;
		this.WIDTH = frameWidth;
	}
	
	/**
	 * Allows the driver to update the <code>time</code> variable.
	 * 
	 * @param time
	 */
	public void setTime (int time)
	{
		this.time = time;
	}
	
	/**
	 * Adds a <code>Tree</code> object to the <code>trees</code> array.
	 * 
	 * @param location of the <code>Tree</code> object's position on the x-axis
	 * @param trunkLength length of the initial trunk
	 * @param plantTime the time the <code>Tree</code> appears
	 */
	public void addTree(int location, double trunkLength, int plantTime)
	{
		trees.add(new Tree(location, plantTime, trunkLength));
	}
	
	/**
	 * @return the <code>Tree</code> objects that are currently on the scene
	 */
	
	public ArrayList<Tree> getTree()
	{
		return this.trees;
	}
	
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		int location;									// horizontal starting position of a tree
		String age;										// age of the tree in years
		
		super.paintComponent(g);						
		g.drawLine(25, HEIGHT - 75, WIDTH - 45,			// draw a horizontal line representing surface of the earth
								HEIGHT - 75);
		
		for (Tree tree : trees)
		{
			location = tree.getStartX();				// draw branches
			tree.drawBranches(g, location, HEIGHT - 75, 
							tree.getTrunkLength(), 90);
			
			age = Integer.toString((time - tree.getStartTime()) / 12);	// write the age of the current tree
			g.drawString(age, location - 5, HEIGHT - 50);
		}
	}
}
