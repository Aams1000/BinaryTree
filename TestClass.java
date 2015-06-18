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
	private static final int NUM_NODES = 5;

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
			randomNode.print();
		}

		//test for null parents
		for (int i = 0; i < nodes.size(); i++){
			if (nodes.get(i).getParent() == null){
				System.out.println("PARENT IS NULL:");
				nodes.get(i).print();
				return;
			}
		}
		// System.out.println("Tree size: " + tree.size());
		// TreeNode root = tree.getRoot();
		// root.print();
		// tree.delete(thirdNode);
		// System.out.println("Tree size: " + tree.size());
		// root = tree.getRoot();
		// root.print();

		//testing height functions
		// System.out.println("Max height: " + tree.getMaxHeight());
		// System.out.println("Min height: " + tree.getMinHeight());
		// if (tree.isHeightBalanced()){
		// 	System.out.println("Tree is height balanced.");
		// }
		// else{
		// 	System.out.println("Tree is not height balanced.");
		// }


		//testing root reassignment and deletion
		for (int i = 0; i < NUM_NODES; i++){
			TreeNode root = tree.getRoot();
			tree.delete(root);
		}

		//testing deletion
		// for (int i = 0; i < NUM_NODES; i++){
		// 	// nodes.get(i).print();
		// 	if (nodes.get(i).getParent() == null){
		// 		System.out.println("PARENT IS NULL:");
		// 		nodes.get(i).print();
		// 		break;
		// 	}
		// 	if (tree.getRoot().equals(nodes.get(i))){
		// 		System.out.println("Removing root.");
		// 	}
		// 	// System.out.println(i + "th deletion.");
		// 	// tree.getRoot().print();
		// 	tree.delete(nodes.get(i));
		// }
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