		/****************************************
         *                                      *
         *        Binary Tree Test Class        *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    Testing class for BinaryTree object.

        				Copyright 2015, Andrew Miller-Smith. Class is free for non-commercial use. For commercial use, inquire at amillers@bowdoin.edu.
        */

import java.util.*;
import java.util.Random;

public class TestClass {

	//random number generator, named constants for testing
	private static final Random random = new Random();
	private static final int NUM_VALUES = 20;
	private static final int MAX_VALUE = 50;
	private static final int NUM_TESTS = 1000;

	public static void main(String[] args){

		//test TreeNode constructors
		TreeNode node = new TreeNode();
		node.print();
		TreeNode secondNode = new TreeNode(5);
		secondNode.print();
		node.setValue(15);
		node.setHeight(4);
		node.print();
		node.setParent(secondNode);
		node.getParent().print();

		BinaryTree tree = new BinaryTree();
		tree.add(node);
		tree.add(secondNode);
	}

	/* THE CAKE IS A LIE. */
}