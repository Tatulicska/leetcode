package tree;

public class BinaryTreeImpl {

  public static void main(String[] args) {
	BinaryTree tree = new BinaryTree();
	tree.addLeft(6);
	tree.addLeft(3);
	tree.addRight(2);
	tree.addLeft(7);
	tree.addLeft(8);
	tree.mirrorGivenTree();
	System.out.println();
  }

  private static class BinaryTree {
	Node root;

	public boolean isMirror() {
	  return isMirror(root, root);
	}

	private boolean isMirror(Node n1, Node n2) {
	  if(n1 == null && n2 == null){
		return true;
	  }
	  if(n1 == null || n2 == null){
		return false;
	  }
	  return n1.val == n2.val && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
	}

	public void addLeft(int i) {
	  addLeft(root, i);
	}

	private void addLeft(Node root, int i) {
	  if (root == null) {
		this.root = new Node(i);
		return;
	  }
	  if (root.left == null) {
		root.left = new Node(i);
		return;
	  } else if (root.right == null) {
		root.right = new Node(i);
		return;
	  }
	  addLeft(root.left, i);
	}

	public void addRight(int i) {
	  addRight(root, i);
	}

	private void addRight(Node root, int i) {
	  if (root == null) {
		this.root = new Node(i);
		return;
	  }
	  if (root.right == null) {
		root.right = new Node(i);
		return;
	  } else if (root.left == null) {
		root.left = new Node(i);
		return;
	  }
	  addLeft(root.right, i);
	}

	public void mirrorGivenTree() {
		mirrorGivenTree(root);
	}

	private Node mirrorGivenTree(Node node) {
		if(node == null){
		  return node;
		}

		Node left = mirrorGivenTree(node.left);
		Node right = mirrorGivenTree(node.right);
		node.left = right;
		node.right = left;

		return node;
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
