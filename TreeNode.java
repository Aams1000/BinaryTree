		/****************************************
         *                                      *
         *               Tree Node              *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    A RouletteWheel for easy roulette selection in genetic algorithms. Constructor takes an ArrayList of fitness values,
        				which are used to form a wheel of probabilities. The selectValue() and selectAndRemove() methods generate a random
        				value and return the index of the corresponding individual. The remove() and selectAndRemove() methods remove an individual
        				(the latter after it has been selected) and reconstruct the wheel. Class tracks sum of fitnesses and includes basic
        				ArrayList functionality for the wheel. Class can also be used for general probabilistic selection and roulette wheel
        				functionality.

        				Copyright 2015, Andrew Miller-Smith. Class is free for non-commercial use. For commercial use, inquire at amillers@bowdoin.edu.

        */

import java.util.*;
import java.util.Random;

public class TreeNode {

	//random number generator
	private final Random rand = new Random();

	//height and value of initialized node
	private final int INITIAL_HEIGHT = -1;
	private final double INITIAL_VALUE = Double.NEGATIVE_INFINITY;

	//variables contained in each node
	private double value;
	private int height;
	private TreeNode parent;
	private TreeNode right;
	private TreeNode left;

	//first constructor takes no parameters
	public TreeNode(){

		//initialize parent and children to null
		parent = null;
		right = null;
		left = null;

		//initialize height and value to INITIAL_HEIGHT and NEGATIVE_INFINITY respectively
		height = INITIAL_HEIGHT;
		value = INITIAL_VALUE;
	}

	//constructor takes node's value as parameter
	public TreeNode(double val){

		//initialize parent and children to null
		parent = null;
		right = null;
		left = null;

		//initialize height and value to INITIAL_HEIGHT and NEGATIVE_INFINITY respectively
		height = INITIAL_HEIGHT;
		value = val;
	}

	//print function prints out height and value
	public void print(){
		System.out.println("Height: " + height);
		System.out.println("Value: " + value);
	}

	//getter functions
	public double getValue(){
		return value;
	}

	public int getHeight(){
		return height;
	}

	public TreeNode getParent(){
		return parent;
	}

	public TreeNode getLeft(){
		return left;
	}

	public TreeNode getRight(){
		return right;
	}

	//setter functions
	public void setValue(double val){
		value = val;
	}

	public void setHeight(int newHeight){
		height = newHeight;
	}

	public void setParent(TreeNode newParent){
		parent = newParent;
	}

	public void setLeft(TreeNode newLeft){
		left = newLeft;
	}

	public void setRight(TreeNode newRight){
		right = newRight;
	}

}