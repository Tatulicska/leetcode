package tree;

import java.util.LinkedList;
import java.util.Queue;
//  The left subtree of a node has nodes which are only lesser than that node’s key.
//	The right subtree of a node has nodes which are only greater than that node’s key.
//	Each node has distinct keys and duplicates are not allowed in Binary Search Tree.
//	The left and right subtree must also be a binary search tree.

public class BinarySearchTreeImpl {

  public static void main(String[] args) {
	BinaryTree tree = new BinaryTree();
	tree.addNode(6);
	tree.addNode(4);
	tree.addNode(5);
	tree.addNode(3);
	tree.addNode(8);
	tree.addNode(7);
	tree.addNode(9);

	tree.traverseLevelOrder();
	System.out.println();
  }

  public static class BinaryTree {
	Node root;

	public void addNode(Integer val) {
	  root = addNodeRecursive(root, val);
	}

	private Node addNodeRecursive(Node head, int val) {
	  if (head == null) {
		return new Node(val);
	  }
	  if (val < head.val) {
		head.left = addNodeRecursive(head.left, val);
	  } else if (val > head.val) {
		head.right = addNodeRecursive(head.right, val);
	  } else {
		return head;//value already exists
	  }
	  return head;
	}

	private Node addNodeIter(Node head, int val) {
	  if (head == null) {
		return new Node(val);
	  }

	  Node temp = head;
	  while (true) {
		if (temp.val <= val) {
		  if (temp.right == null) {
			temp.right = new Node(val);
			break;
		  } else {
			temp = temp.right;
		  }
		} else {
		  if (temp.left == null) {
			temp.left = new Node(val);
			break;
		  } else {
			temp = temp.left;
		  }
		}
	  }
	  return head;
	}

	public Node findNode(int val) {
	  return findNode(root, val);
	}

	private Node findNode(Node node, int val) {
	  if (node == null) {
		return null;
	  }
	  if (node.val == val) {
		return node;
	  }
	  if (node.val > val) {
		return findNode(node.left, val);
	  } else {
		return findNode(node.right, val);
	  }
	}

	private void deleteNode(int val) {
	  deleteNode(root, val);
	}

	private Node deleteNode(Node node, int val) {
	  if (node == null) {
		return null;
	  }
	  if (node.val == val) {
		if (node.left == null && node.right == null) { //node has no children
		  return null;
		}
		if (node.left == null) { // node has 1 child. Here we're returning the non-null child so it can be assigned to the parent node.
		  return node.right;
		}
		if (node.right == null) { // node has 1 child. Here we're returning the non-null child so it can be assigned to the parent node.
		  return node.left;
		}
//		Finally, we have to handle the case where the node has two children.
//		  First, we need to find the node that will replace the deleted node.
//		  We'll use the smallest node of the soon-to-be deleted node's right subtree (or we could use biggest from left subtree)
		int smallestValue = findSmallestNode(node.right);
		node.val = smallestValue;
		node.right = deleteNode(node.right, smallestValue);
	  } else {
		if (node.val > val) {
		  node.left = deleteNode(node.left, val);
		} else {
		  node.right = deleteNode(node.right, val);
		}
		return node;
	  }
	  return node;
	}

	private int findSmallestNode(Node node) {
	  return node.left == null ? node.val : findSmallestNode(node.left);
	}

//	!!!! Depth-First Search
//	Depth-first search is a type of traversal that goes deep as much as possible in every child before exploring the next sibling.
	//The in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right sub-tree:
	public void inOrderTraverse() {
	  inOrderTraverse(root);
	}

	private void inOrderTraverse(Node node){
		if(node != null){
		  inOrderTraverse(node.left);
		  System.out.println(node.val);
		  inOrderTraverse(node.right);
		}
	}

	//Pre-order traversal visits first the root node, then the left sub-tree, and finally the right sub-tree:
	public void preOrderTraverse() {
	  preOrderTraverse(root);
	}

	private void preOrderTraverse(Node node){
		if(node != null){
		  System.out.println(node.val);
		  preOrderTraverse(node.left);
		  preOrderTraverse(node.right);
		}
	}

	//Post-order traversal visits the left sub-tree, the right subt-ree, and the root node at the end:
	public void postOrderTraverse() {
	  postOrderTraverse(root);
	}

	private void postOrderTraverse(Node node){
		if(node != null){
		  postOrderTraverse(node.left);
		  postOrderTraverse(node.right);
		  System.out.println(node.val);
		}
	}



	//Breadth-First Search
//	This is another common type of traversal that visits all the nodes of a level before going to the next level.
//	This kind of traversal is also called level-order, and visits all the levels of the tree starting from the root, and from left to right.

	public void traverseLevelOrder(){
	  traverseLevelOrder(root);
	}

	private void traverseLevelOrder(Node root) {
	  if(root == null){
		return;
	  }

	  //	For the implementation, we'll use a Queue to hold the nodes from each level in order.
	  //	We'll extract each node from the list, print its values, then add its children to the queue:
	  Queue<Node> nodes = new LinkedList<>();
	  nodes.add(root);

	  while(!nodes.isEmpty()){
		Node node = nodes.remove();//Retrieves and removes the head of this queue.
		System.out.print(" " + node.val);

		if(node.left != null){
		  nodes.add(node.left);
		}
		if(node.right != null){
		  nodes.add(node.right);
		}


	  }
	}

  }


  public static class Node {
	int val;
	Node left;
	Node right;

	Node() {
	}

	Node(int val) {
	  this.val = val;
	}

	Node(int val, Node left, Node right) {
	  this.val = val;
	  this.left = left;
	  this.right = right;
	}
  }
}
