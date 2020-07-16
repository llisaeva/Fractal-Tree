/*****************************************************************************************
 * TreeDriver.java
 * @author Yelyzaveta Isaeva
 * @author Dean & Dean | Introduction to Programming with Java : A Problem Solving Approach 2nd ed.
 * 
 *****************************************************************************************/


package com.lisaeva.tree;

import javax.swing.JFrame;
import java.util.ArrayList;

public class TreeDriver 
{
	private final int WIDTH = 625, HEIGHT = 400;
	private TreePanel panel = new TreePanel(HEIGHT, WIDTH);
	private int time = 0;
	
	public TreeDriver()
	{
		JFrame frame = new JFrame ("Growing Trees");
		
		frame.setSize(WIDTH, HEIGHT);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void simulate() throws Exception
	{
		ArrayList<Tree> trees = panel.getTree();
		boolean done = false;
		
		while (!done)
		{
			switch (time)
			{
				case 0:
					panel.addTree(400, 3, time);
					break;
				case 360:
					panel.addTree(100, 3, time);
					break;
				case 540:
					panel.addTree(300, 3, time);
					break;
				case 630:
					panel.addTree(200, 3, time);
					break;
				case 675:
					done = true;
					break;
			}
			
			panel.repaint();				// calls TreePanels paintComponent method
			time++;
			
			panel.setTime(time);
			
			for (Tree tree : trees)
			{
				tree.updateTrunkLength();	// to correspond to the new time			
			}
			Thread.sleep(10);				// throws an InterruptedExeption
		}
	} // end simulate()
	
	public static void main(String[] args) throws Exception
	{
		TreeDriver driver = new TreeDriver();
		driver.simulate();
	}
}
