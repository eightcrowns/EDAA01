package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
    int size;
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			return true;
		} else {
			return add(root, x);
		}
	}
	
	private boolean add(BinaryNode<E> n, E item) {
		int compResult = item.compareTo(n.element);
		if (compResult == 0) {
			return false;
		}
		if (compResult < 0) {
			if (n.left == null) {
				n.left = new BinaryNode<E>(item);
				return true;
			} else {
				return add(n.left, item);
			}
		} else {
			if (n.right == null) {
				n.right = new BinaryNode<E>(item);
				return true;
			} else {
				return add(n.right, item);
			}
		}
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}
	
	private int height(BinaryNode<E> node) {
		if (node == null) {
			return 0;
		} else {
			int leftHeight = height(node.left);
			int rightHeight = height(node.right);
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size(root);
	}
	
	private int size(BinaryNode<E> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + size(node.left) + size(node.right);
		}
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printInorder(root);
	}
	
	private void printInorder(BinaryNode<E> n) {
		if (n != null) {
			printInorder(n.left);
			System.out.println(n.element);
			printInorder(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] array = (E[]) new Comparable[size()];
		int last = toArray(root, array, 0);
		
		root = buildTree(array, 0, last - 1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	public int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n == null) {
			return index;
		} else {
			int pos = toArray(n.left, a, index);
			a[pos] = n.element;
			return toArray(n.right, a, pos + 1);
		}
	}
	
	/*
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		if (first > last) {
			return null;
		} else {
			int mid = (last + first) / 2;
			BinaryNode<E> node = new BinaryNode<E>(a[mid]);
			node.left = buildTree(a, first, mid-1);
			node.right = buildTree(a, mid+1, last);
			return node;
		}		
	}
	
	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
	public static void main(String args[]) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTVisualizer bst = new BSTVisualizer("BSTVisualizer", 600, 600);
		
		tree.add(4);
		tree.add(2);
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(4);
		tree.add(2);
		tree.add(7);
		tree.add(5);
		
		//bst.drawTree(tree);
		
//		Integer[] array = new Integer[tree.size()];
//		System.out.println(tree.toArray(tree.root, array, 0));
//		for (Integer i : array) {
//			System.out.print(i + " ");
//		}
		
//		tree.root = tree.buildTree(array, 0, array.length - 1);
		tree.rebuild();
		
		bst.drawTree(tree);
	}
}
