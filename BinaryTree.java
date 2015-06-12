	/****************************************
         *                                      *
         *             Binary Tree              *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    Description:    Java contains no BinaryTree object, which requires building new structures or modifying old ones whenever such a tree is needed.
                                        This TreeNode class intends to serve as a basic BST that can be easily adjusted to contain any type of object. Final product
                                        will contain all user-functionality of a standard Java class. This is currently a work in progress and is not ready for
                                        general use.

        				Copyright 2015, Andrew Miller-Smith. Class is free for non-commercial use. For commercial use, inquire at amillers@bowdoin.edu.

        */

import java.util.*;
import java.util.Random;
import java.lang.Math;

public class BinaryTree{

        //tree properties
        private int size = 0;

        //variables for tree
        private TreeNode root;

        //constructor takes no parameters, initializes root to null
        public BinaryTree(){
                root = null;
        }

        //getRoot function returns root
        public TreeNode getRoot(){
                return root;
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
                size--;
        }

        //recursiveDelete function called by delete function. Takes node to delete and current node to examine as parameters
        //traverses tree until finding the appropriate to insert node
        private void recursiveDelete(TreeNode curr, TreeNode node){
                
                if (curr == null){
                        System.out.println("Error: trying to delete null node.");
                        return;
                }
                if (node == null){
                        System.out.println ("Error: node to delete is null.");
                }
                //check if we've found our node
                if (node.equals(curr)){
                        remove(curr);
                        return;
                }
                //recurse either on right or left child
                else if (node.getKey() <= curr.getKey() && curr.getLeft() != null){
                        recursiveDelete(curr.getLeft(), node);
                }
                else if (node.getKey() > curr.getKey() && curr.getRight() != null){
                        recursiveDelete(curr.getRight(), node);
                }
                else{ //error
                        System.out.println("Error: node not contained in tree.");
                }
        }

        //remove function called by by recursiveDelete function to take a node out of the tree. Takes node to delete as parameter,
        //restructures tree depending on how many children it has. Returns void
        private void remove(TreeNode node){

                TreeNode parent = node.getParent();
                TreeNode left = node.getLeft();
                TreeNode right = node.getRight();
                //node is root
                if (parent == null){
                        if (right != null){
                                //replace root with leftmost child of right subtree
                                TreeNode curr = right;
                                while (curr.getLeft() != null){
                                        curr = curr.getLeft();
                                }
                                node.copyValues(curr);
                                curr.detach();
                                return;
                        }
                        //make left child the root
                        else if (left != null){
                                root = left;
                                node.detach();
                                return;
                        }
                        //tree contains only root
                        else{
                                root = null;
                                return;
                        }
                }
                //node has no children
                if (left == null && right == null){
                        node.detach();
                }
                //node has one left child
                else if (right == null){
                        //replace node with child
                        if (parent.getLeft() != null && parent.getLeft().equals(node)){
                                parent.setLeft(left);
                        }
                        else{
                                parent.setRight(left);
                        }
                        node.detach();
                }
                //node has one right child
                else if (left == null){
                        //replace node with child
                        if (parent.getLeft().equals(node)){
                                parent.setLeft(right);
                        }
                        else{
                                parent.setRight(right);
                        }
                        node.detach();
                }
                //node has two children
                else{
                        //replace node with leftmost node on right subtree
                        TreeNode curr = right;
                        while (curr.getLeft() != null){
                                curr = curr.getLeft();
                        }
                        node.copyValues(curr);
                        curr.detach();
                }
        }

        //isHeightBalanced function checks if any two leaves differ in height by one. Returns appropriate boolean value
        public boolean isHeightBalanced(){
                if (getMaxHeight() - getMinHeight() > 1)
                        return false;
                return true;
        }

        //getMinHeight function returns min height of leaves on the tree. Takes no parameters, returns int
        public int getMinHeight(){
                return recursiveMinHeight(root);
        }

        //recursiveMinHeight function called by getMinHeight. Takes TreeNode as parameter, returns int
        private int recursiveMinHeight(TreeNode node){
                if (node == null)
                        return 0;
                return Math.min(recursiveMinHeight(node.getLeft()), recursiveMinHeight(node.getRight())) + 1;
        }

        //recursiveMaxHeight function called by getMaxHeight. Takes TreeNode as parameter, returns int
        private int recursiveMaxHeight(TreeNode node){
                if (node == null)
                        return 0;
                return Math.max(recursiveMaxHeight(node.getLeft()), recursiveMaxHeight(node.getRight())) + 1;
        }

        //getMaxHeight function returns max height of leaves on the tree. Takes no parameters, returns int
        public int getMaxHeight(){
                return recursiveMaxHeight(root);
        }

        //size function returns number of nodes in tree. Takes no parameters, returns int
        public int size(){
                return size;
        }

        /***********************STILL TO CODE*****************************/

        //get function takes key, returns first node found that matches that key
        public TreeNode get(double key){
                return null;

        }

        //get function takes key, identifier as parameters, returns first matching 
        public TreeNode get(double key, double inputIdentifier){
                return null;

        }

        //delete function takes key, deletes first node matching that key
        public void delete(double inputKey){

        }

        //delete function takes key, identifier, deletes first node matching them
        public void delete (double inputKey, double identifier){

        }

        //contains function searches tree for specified key, returns appropriate boolean value
        public boolean contains (double key){
                return false;
        }

        //contains function searches tree for specified node, reutrns appropriate boolean value
        public boolean contains (TreeNode node){
                return false;
        }

        public void printInOrder(){

        }


}