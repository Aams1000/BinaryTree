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

public class BinaryTree{

        //tree properties
        private int size = 0;

        //variables for tree
        private TreeNode root;

        //constructor takes no parameters, initializes root to null
        public BinaryTree(){
                root = null;
        }

        //add function takes TreeNode as parameter, returns void. If root is null, make node root,
        //otherwise places it in appropriate location
        public void add(TreeNode node){

                //make sure node has been initialized
                if (node == null){
                        System.out.println("Warning: added node is null.");
                        return;
                }

                //if tree is empty, set root to node
                if (root == null){
                        root = node;
                        size++;
                        return;
                }

                //add node to important
                recursiveAdd(root, node);
        }

        //recursiveAdd function called by add function. Takes node to add and current node to examine as parameters
        //traverses tree until finding the appropriate location to add node
        private void recursiveAdd(TreeNode curr, TreeNode newNode){

                //if newNode's value is less than or equal to curr's value
                if (newNode.getValue() <= curr.getValue()){        
                        //check if we've reached a leaf
                        if (curr.getLeft() == null){
                                curr.setLeft(newNode);
                                newNode.setParent(curr);
                                size++;
                        }            
                        else{
                                recursiveAdd(curr.getLeft(), newNode);
                        }
                }
                //node's key is greater than curr's key
                else{
                        if (curr.getRight() == null){
                                curr.setRight(newNode);
                                newNode.setParent(curr);
                                size++;
                        }
                        else{
                                recursiveAdd(curr.getRight(), newNode);
                        }
                }
        }


}