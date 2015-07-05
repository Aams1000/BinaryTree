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

                //insert node with recursveInsert function
                recursiveInsert(root, node);
        }

        //recursiveInsert function called by insert function. Takes node to insert and current node to examine as parameters
        //traverses tree until finding the appropriate location to insert node
        private void recursiveInsert(TreeNode curr, TreeNode newNode){

                //System.out.println("Current key: " + curr.getKey() + " Node key: " + newNode.getKey());

                //if newNode's key is less than or equal to curr's key
                if (newNode.getKey() <= curr.getKey()){        
                        //check if we've reached a leaf
                        if (curr.getLeft() == null){
                                curr.setLeft(newNode);
                                newNode.setParent(curr);
                                size++;
                        }            
                        else{
                                //System.out.println("Going left.");
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
                                //System.out.println("Going right.");
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

                //System.out.println("Current key: " + curr.getKey() + " Node key: " + node.getKey());

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
                        if (curr.getLeft() == null){
                                System.out.println("Got past null left check.");
                        }
                        //System.out.println("Going left.");
                        recursiveDelete(curr.getLeft(), node);
                }
                else if (node.getKey() > curr.getKey() && curr.getRight() != null){
                        if (curr.getRight() == null){
                                System.out.println("Got past null right check.");
                        }
                        //System.out.println("Going right.");
                        recursiveDelete(curr.getRight(), node);
                }
                else{ //error
                        System.out.println("Error: node not contained in tree.");
                        //curr.print();
                        node.print();

                        for (int i = 0; i < 100000; i++){
                                System.out.println("ERROR.");
                        }
                }
        }

        //remove function called by by recursiveDelete function to take a node out of the tree. Takes node to delete as parameter,
        //restructures tree depending on how many children it has. Returns void
        private void remove(TreeNode node){

                TreeNode parent = node.getParent();
                TreeNode left = node.getLeft();
                TreeNode right = node.getRight();
                //node is root
                if (node.equals(root)){

                        System.out.println("Deleting root.");
                        if (right != null){
                                //System.out.println("Going right.");
                                //replace root with leftmost child of right subtree
                                TreeNode curr = right;
                                while (curr.getLeft() != null){
                                        curr = curr.getLeft();
                                        System.out.println("Curr:");
                                        curr.print();
                                }
                                // System.out.println("Root:");
                                // root.print();
                                // System.out.println("Curr:");
                                // curr.print();
                                root.copyValues(curr);
                                // System.out.println("Updated root:");
                                // root.print();
                                //remove curr properly
                                if (curr.getRight() != null){
                                        if (curr.getParent().getLeft() != null && curr.getParent().getLeft().equals(curr)){
                                                curr.getParent().setLeft(curr.getRight());
                                                curr.getRight().setParent(curr.getParent());
                                                // curr.detach();      
                                        }
                                        // else{
                                        //         curr.getParent().setRight(curr.getRight())
                                        // }
                                        else{
                                                curr.getParent().setRight(curr.getRight());
                                                curr.getRight().setParent(curr.getParent());
                                                // curr.detach();
                                        }
                                        //curr.detach();
                                }
                                else if (curr.getParent().getLeft() != null && curr.getParent().getLeft().equals(curr)){
                                    curr.getParent().setLeft(null);
                                }
                                else{
                                    curr.getParent().setRight(null);
                                }
                                return;
                        }
                        //make left child the root
                        else if (left != null){
                                root = left;
                                root.setParent(null);
                                //node.detach();
                                //System.out.println("Going left.");
                                return;
                        }
                        //tree contains only root
                        else{
                                System.out.println("Tree contains only root.");
                                root = null;
                                return;
                        }
                }
                //node has no children
                else if (left == null && right == null){
                        node.detach();
                }
                //node has one left child
                else if (right == null){
                        //replace node with child
                        if (parent.getLeft() != null && parent.getLeft().equals(node)){
                                parent.setLeft(left);
                                left.setParent(parent);
                        }
                        else{
                                parent.setRight(left);
                                left.setParent(parent);
                        }
                        //node.detach();
                }
                //node has one right child
                else if (left == null){
                        //replace node with child
                        if (parent.getLeft() != null && parent.getLeft().equals(node)){
                                parent.setLeft(right);
                                right.setParent(parent);
                        }
                        else{
                                parent.setRight(right);
                                right.setParent(parent);
                        }
                        //node.detach();
                }
                //node has two children
                else{
                        //replace node with leftmost right subchild
                        TreeNode curr = right;
                        while (curr.getLeft() != null){
                                curr = curr.getLeft();
                        }
                        node.copyValues(curr);

                        //remove curr properly
                        if (curr.getRight() != null){
                                if (curr.getParent().getLeft() != null && curr.getParent().getLeft().equals(curr)){
                                        curr.getParent().setLeft(curr.getRight());
                                        curr.getRight().setParent(curr.getParent());
                                        // curr.detach();      
                                }
                                // else{
                                //         curr.getParent().setRight(curr.getRight())
                                // }
                                else{
                                        curr.getParent().setRight(curr.getRight());
                                        curr.getRight().setParent(curr.getParent());
                                        // curr.detach();
                                }
                                //curr.detach();
                        }
                        else if (curr.getParent().getLeft() != null && curr.getParent().getLeft().equals(curr)){
                                curr.getParent().setLeft(null);
                            }
                        else{
                            curr.getParent().setRight(null);
                        }
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

         //printInOrder function prints nodes in sorted order. Takes no parameters, returns void.
        public void printInOrder(){
                recursivePrintInOrder(root);
        }

        //recursivePrintInOrder function called by printInOrder function. Takes TreeNode as parameter, returns void
        private void recursivePrintInOrder(TreeNode node){
                if (node == null)
                        return;
                //print left child
                recursivePrintInOrder(node.getLeft());
                //print out node
                node.print();
                //print right child
                recursivePrintInOrder(node.getRight());
        }

        //sort function returns an ArrayList of sorted nodes by key. Takes no parameters, returns ArrayList<TreeNode>
        //NOTE: does not change actual tree, returns pointers to actual TreeNodes
        public ArrayList<TreeNode> sort(){
                ArrayList<TreeNode> sortedNodes = new ArrayList<TreeNode>();
                recursiveSort(root, sortedNodes);
                return sortedNodes;
        }

        //recursiveSort function called by sort function. Takes TreeNode and ArrayList<TreeNode> as parameters, returns void
        private void recursiveSort(TreeNode node, ArrayList<TreeNode> list){
                if (node == null)
                        return;
                //add left child
                recursiveSort(node.getLeft(), list);
                //add node
                list.add(node);
                //add right child
                recursiveSort(node.getRight(), list);
        }

        //get function takes key, returns first node found that matches that key
        //NOTE: for trees containing repeating keys, this function may not locate the node the user has in mind
        //in this situation, the alternate get function that takes an identifier as a second parameter is recommended
        public TreeNode get(double key){
                //traverse tree
                TreeNode curr = root;
                while (curr != null){
                        if (key == curr.getKey()){
                                return curr;
                        }
                        else if (key <= curr.getKey()){
                                curr = curr.getLeft();
                        }
                        else{
                                curr = curr.getRight();
                        }
                }
                return null;
        }

        //get function takes key, identifier as parameters, returns first matching 
        public TreeNode get(double key, double inputIdentifier){
                //traverse tree
                TreeNode curr = root;
                while (curr != null){
                        if (key == curr.getKey() && inputIdentifier == curr.getIdentifier()){
                                return curr;
                        }
                        else if (key <= curr.getKey()){
                                curr = curr.getLeft();
                        }
                        else{
                                curr = curr.getRight();
                        }
                }
                return null;
        }

        //contains function searches tree for specified key, returns appropriate boolean value
        public boolean contains (double key){
                //traverse tree
                TreeNode curr = root;
                while (curr != null){
                        if (key == curr.getKey()){
                                return true;
                        }
                        else if (key <= curr.getKey()){
                                curr = curr.getLeft();
                        }
                        else{
                                curr = curr.getRight();
                        }
                }
                return false;
        }

        //contains function searches tree for specified node, reutrns appropriate boolean value
        public boolean contains (TreeNode node){
                //traverse tree
                TreeNode curr = root;
                double key = node.getKey();
                while (curr != null){
                        if (curr.equals(node)){
                                return true;
                        }
                        else if (key <= curr.getKey()){
                                curr = curr.getLeft();
                        }
                        else{
                                curr = curr.getRight();
                        }
                }
                return false;
        }

        //contains function searches tree for specified key, returns appropriate boolean value
        public boolean contains (double identifier, String s){
                if (!s.equals("identifier")){
                        System.out.println("Error: incorrect input string. To search for an identifier, the String argument must equal 'identifier.'");
                        return false;
                }
                //traverse using BFS
                Queue<TreeNode> q = new LinkedList<TreeNode>();
                q.add(root);
                while (q.isEmpty() == false){
                        TreeNode curr = q.remove();
                        //check if curr is our node
                        if (curr.getIdentifier() == identifier)
                                return true;
                        //add children
                        if (curr.getLeft() != null)
                                q.add(curr.getLeft());
                        if (curr.getRight() != null)
                                q.add(curr.getRight());
                }
                return false;       
        }

        /***********************IN PROGRESS*****************************/




        /***********************STILL TO CODE*****************************/

        //delete function takes key, deletes first node matching that key
        public void delete(double inputKey){

        }

        //delete function takes key, identifier, deletes first node matching them
        public void delete (double inputKey, double identifier){

        }
}