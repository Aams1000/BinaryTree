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
	private static final int NUM_NODES = 50;

	//ArrayList for nodes in tree
	private static final ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();

	public static void main(String[] args){

		//test TreeNode constructors
		// TreeNode node = new TreeNode();
		// TreeNode secondNode = new TreeNode(5, 10);
		TreeNode thirdNode = new TreeNode(25, 25, 50);
		// secondNode.setParent(thirdNode);
		// thirdNode.setLeft(secondNode);
		// secondNode.getParent().print();
		// thirdNode.getLeft().print();
		// secondNode.detach();
		// if (secondNode.getParent() == null){
		// 	System.out.println("SecondNode parent is null.");
		// }
		// if (thirdNode.getLeft() == null){
		// 	System.out.println("ThirdNode left is null.");
		// }

		//testing print function, getters and setters
		//node.print();
		// secondNode.print();
		// thirdNode.print();
		// node.setValue(2);
		// node.setHeight(4);
		// node.setKey(6);
		// node.print();
		// node.setParent(secondNode);
		// node.getParent().print();

		BinaryTree tree = new BinaryTree();
		
		//testing insertion
		tree.insert(thirdNode);
		//nodes.add(thirdNode);
		//generate NUM_NODES random nodes
		for (int i = 0; i < NUM_NODES; i++){
			TreeNode randomNode = generateNode();
			tree.insert(randomNode);
			nodes.add(randomNode);
			//System.out.println("Node key: " + randomNode.getKey());
			//randomNode.print();
		}

		//testing root deletion
		for (int i = 0; i < NUM_NODES + 1; i++){
			TreeNode root = tree.getRoot();
			root.print();
			tree.delete(root);
		}

		// //testing root reassignment and deletion
		// for (int i = 0; i < NUM_NODES; i++){
		// 	TreeNode root = tree.getRoot();
		// 	tree.delete(root);
		// }

		//testing contains functions
		// for (int i = 0; i < nodes.size(); i++){
		// 	if (tree.contains(nodes.get(i).getIdentifier() + 1, "identifier"))
		// 		System.out.println("Contains node: " + nodes.get(i).getIdentifier());
		// 	else
		// 		System.out.println("Does not contain key: " + nodes.get(i).getIdentifier());
		// }
		// if (tree.contains(thirdNode.getIdentifier(), "identifier"))
		// 	System.out.println("Contains identifier: " + 50);
		// else
		// 	System.out.println("Does not contain identifier: " + 50);

	}

	public static TreeNode generateNode(){

		double randomKey = random.nextDouble()*MAX_VALUE;
		double randomValue = random.nextDouble()*MAX_VALUE;
		int randomIdentifier = random.nextInt() % MAX_VALUE;
		TreeNode randomNode = new TreeNode(randomKey, randomValue, randomIdentifier);
		//randomNode.print();
		return randomNode;
	
	}

	/* THE CAKE IS A LIE. */
}