package set;

import java.util.ArrayList;

public class UniqueMaxSet {
	 public static int[] uniqueElements(int[] ints) {
		 MaxSet<Integer> max = new MaxSet<Integer>();
		 for (int i : ints) {
			 max.add(i);
		 }
		 
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 while (!max.isEmpty()) {
			 int maxVal = max.getMax();
			 max.remove(maxVal);
			 list.add(maxVal);
		 }
		 
		 int[] reverseList = new int[list.size()];
		 int a = 0;
		 for (int i = list.size()-1; i >= 0; i--) {
			 reverseList[a] = list.get(i);
			 a++;
		 }
		 
		 return reverseList;
	 }
	 
	 public static void main(String[] args) {
		 int[] ints = {7, 5, 3, 5, 2, 2, 7};
		 
		 ints = uniqueElements(ints);
		 
		 for (int i : ints) {
			 System.out.print(i + " ");
		 }
		 System.out.println();
	 }
}
