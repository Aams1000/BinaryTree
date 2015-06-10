	/****************************************
         *                                      *
         *               Tree Node              *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    A RouletteWheel for easy roulette selection in genetic algorithms. Constructor takes an ArrayList of fitness values,
        				which are used to form a wheel of probabilities. The selectKey() and selectAndRemove() methods generate a random
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

        //insert function takes TreeNode as parameter, returns void. If root is null, make node root,
        //otherwise places it in appropriate location
        public void insert(TreeNode node){

                //make sure node has been initialized
                if (node == null){
                        System.out.println("Warning: inserted node is null.");
                        return;
                }
                //print warnings if node appears uninitialized
                node.appearsUninitialized();
                //if tree is empty, set root to node
                if (root == null){
                        root = node;
                        size++;
                        return;
                }

                //insert node to important
                recursiveInsert(root, node);
        }

        //recursiveInsert function called by insert function. Takes node to insert and current node to examine as parameters
        //traverses tree until finding the appropriate location to insert node
        private void recursiveInsert(TreeNode curr, TreeNode newNode){

                //if newNode's key is less than or equal to curr's key
                if (newNode.getKey() <= curr.getKey()){        
                        //check if we've reached a leaf
                        if (curr.getLeft() == null){
                                curr.setLeft(newNode);
                                newNode.setParent(curr);
                                size++;
                        }            
                        else{
                                recursiveInsert(curr.getLeft(), newNode);
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
                                recursiveInsert(curr.getRight(), newNode);
                        }
                }
        }

        //delete function takes node, deletes it from tree and rearranges branches accordingly
        public void delete(TreeNode node){

                //make sure node isn't null, has been initialized
                if (node == null){
                        System.out.println("Warning: node is null.");
                        return;
                }
                node.appearsUninitialized();
                recursiveDelete(root, node);
        }

        //recursiveDelete function called by delete function. Takes node to delete and current node to examine as parameters
        //traverses tree until finding the appropriate to insert node
        private void recursiveDelete(TreeNode curr, TreeNode node){
                
                //check if we've found our node
                if (node.equals(curr)){
                        remove(curr);
                        return;
                }
                //recurse either on right or left child
                else if (node.getKey() <= curr.getKey() && curr.getLeft() != null){
                        recursiveDelete(curr.getLeft(), node);
                }
                else if (curr.getRight() != null){
                        recursiveDelete(curr.getRight(), node);
                }
                else{ //error
                        System.out.println("Error: node not contained in tree.");
                }
        }

        //remove function called by by recursiveDelete function to take a node out of the tree. Takes node to delete as parameter,
        //restructures tree depending on how many children it has. Returns void
        private void remove(TreeNode node){

                //node has no children
                if (node.getLeft() == null && node.getRight() == null){
                        node.detach();
                }

                //node has one left child

                //node has one right child

                //node has two children
        }


        //size funciton returns number of nodes in tree. Takes no parameters, returns int
        public int size(){
                return size;
        }


}