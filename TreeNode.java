		/****************************************
         *                                      *
         *               Tree Node              *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    A RouletteWheel for easy roulette selection in genetic algorithms. Constructor takes an ArrayList of fitness keys,
        				which are used to form a wheel of probabilities. The selectKey() and selectAndRemove() methods generate a random
        				key and return the index of the corresponding individual. The remove() and selectAndRemove() methods remove an individual
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

	//height and key of initialized node
	private final int INITIAL_HEIGHT = -1;
	private final double INITIAL_KEY = Double.NEGATIVE_INFINITY;
	private final int INITIAL_IDENTIFIER = Integer.MIN_VALUE;
	private final double INITIAL_VALUE = Double.NEGATIVE_INFINITY;

	//variables contained in each node
	private double key;
	private double value;
	private int height;
	private TreeNode parent;
	private TreeNode right;
	private TreeNode left;
	private int identifier;

	//first constructor takes no parameters
	public TreeNode(){

		//initialize parent and children to null
		parent = null;
		right = null;
		left = null;

		//initialize height and key to INITIAL_HEIGHT and NEGATIVE_INFINITY respectively
		height = INITIAL_HEIGHT;
		key = INITIAL_KEY;
		value = INITIAL_VALUE;
		identifier = INITIAL_IDENTIFIER;
	}

	//constructor takes node's key as parameter
	public TreeNode(double nodeKey, double val){

		//initialize parent and children to null
		parent = null;
		right = null;
		left = null;

		//initialize height and key to INITIAL_HEIGHT and NEGATIVE_INFINITY respectively
		height = INITIAL_HEIGHT;
		identifier = INITIAL_IDENTIFIER;
		key = nodeKey;
		value = val;
	}

	//constructor takes node's key and identifier as parameters
	public TreeNode(double nodeKey, double val, int ident){

		//initialize parent and children to null
		parent = null;
		right = null;
		left = null;

		//initialize height to INITIAL_HEIGHT and key and value to parameter values
		height = INITIAL_HEIGHT;
		identifier = ident;
		key = nodeKey;
		value = val;
	}

	//print function prints out height and key
	public void print(){
		System.out.println("Node: " + identifier);
		System.out.println("Height: " + height);
		System.out.println("Key: " + key);
		System.out.println("Value: " + value);
		System.out.println();
	}

	//equals function compares key, value, and identifier for equality. Takes TreeNode as parameter, returns appropriate boolean value
	public boolean equals(TreeNode node){
		if (node.getKey() == key && node.getValue() == value && node.getIdentifier() == identifier)
			return true;
		return false;
	}

	//detach function removes all pointers to and from node, returns void
	public void detach(){

		//find if node is parent's right or left child
		if (parent != null){
			if (parent.getLeft().equals(this)){
				parent.setLeft(null);
			}
			else if(parent.getRight().equals(this)){
				parent.setRight(null);
			}
		}

		//detach children
		if (left != null && left.getParent().equals(this)){
			left.setParent(null);
		}
		if (right != null && right.getParent().equals(this)){
			right.setParent(null);
		}
		parent = null;
		left = null;
		right = null;
	}


	//appearsUninitialized function checks if key value is set to INITIAL_KEY or INITIAL_VALUE.
	//Takes no parameters, prints warnings and returns appropriate boolean value
	public boolean appearsUninitialized(){
		boolean uninitialized = false;
		if (key == INITIAL_KEY){
			if (identifier != INITIAL_IDENTIFIER){
				System.out.println("Warning: node " + identifier + " key might not have been initialied.");
			}
			else{
				System.out.println("Warning: node key might not have been initialied.");
			}
			uninitialized = true;
		}
		if (value == INITIAL_VALUE){
			if (identifier != INITIAL_IDENTIFIER){
				System.out.println("Warning: node " + identifier + " value might not have been initialized.");
			}
			else{
				System.out.println("Warning: node value might not have been initialized.");
			}
			uninitialized = true;
		}
		return uninitialized;
	}

	//getter functions
	public double getKey(){
		return key;
	}

	public int getHeight(){
		return height;
	}

	public double getValue(){
		return value;
	}

	public int getIdentifier(){
		if (identifier == INITIAL_IDENTIFIER){
			System.out.println("Warning: identifier might not have been initialized.");
		}
		return identifier;
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
	public void setKey(double newKey){
		key = newKey;
	}

	public void setHeight(int newHeight){
		height = newHeight;
	}

	public void setValue(double val){
		value = val;
	}

	public void setIdentifier(int ident){
		identifier = ident;
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