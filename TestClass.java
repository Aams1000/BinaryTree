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
		TreeNode secondNode = new TreeNode(5, 10);
		TreeNode thirdNode = new TreeNode(4, 4, 15);
		secondNode.setParent(thirdNode);
		thirdNode.setLeft(secondNode);
		secondNode.getParent().print();
		thirdNode.getLeft().print();
		secondNode.detach();
		if (secondNode.getParent() == null){
			System.out.println("SecondNode parent is null.");
		}
		if (thirdNode.getLeft() == null){
			System.out.println("ThirdNode left is null.");
		}
		//node.print();
		// secondNode.print();
		// thirdNode.print();
		// node.setValue(2);
		// node.setHeight(4);
		// node.setKey(6);
		// node.print();
		// node.setParent(secondNode);
		// node.getParent().print();

		// BinaryTree tree = new BinaryTree();
		// tree.insert(secondNode);
		// tree.insert(thirdNode);
		// thirdNode.getParent().print();
		// secondNode.getLeft().print();
		//tree.delete(secondNode);
	}

	/* THE CAKE IS A LIE. */
}