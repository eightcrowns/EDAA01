package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bst.BinarySearchTree;

public class TestBST {
	private BinarySearchTree<Integer> bst;
	
	@Before
	public void setUp() throws Exception {
		bst = new BinarySearchTree<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		bst = null;
	}
	
	@Test
	public void testHeight() {
		assertEquals("Fel höjd", bst.height(), 0);
		assertEquals("Fel storlek", bst.size(), 0);
		
		bst.add(4);
		bst.add(2);
		bst.add(1);
		bst.add(3);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(7);
		bst.add(5);
		
		assertEquals("Fel höjd", bst.height(), 3);
		assertEquals("Fel storlek", bst.size(), 7);
		
		bst.printTree();
	}
	
	@Test
	public void testTest() {
		bst.add(4);
		bst.add(2);
		bst.add(1);
		bst.add(3);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(7);
		bst.add(5);
		
		
	}

}
