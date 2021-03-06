package queue;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> 
implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		last = null;
		size = 0;
	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	x the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E x) {
		if (size == 0) {
			last = new QueueNode<E>(x);
			last.next = last;
		} else {
			QueueNode<E> prevLast = last, first = last.next;
			last = new QueueNode<E>(x);
			prevLast.next = last;
			last.next = first;
		}
		size++;
		return true;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (size > 0) {
			QueueNode<E> first = last.next;
			last.next = last.next.next;
			size--;
			if (size == 0) {
				last = null;
			}
			return first.element;
		} else {
			return null;
		}
	}

	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (last != null) {
			return last.next.element;
		} else {
			return null;
		}
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		
		private QueueIterator() {
			if (last != null) {
				pos = last.next;
			} else {
				pos = null;
			}
		}
		
		public boolean hasNext() {
			if (pos != null) {
				return true;
			}
			return false;
		}
		
		public E next() {
			if (hasNext()) {
				E item = pos.element;
				if (pos == last) {
					pos = null;
				} else {
					pos = pos.next;
				}
				return item;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public void append(FifoQueue<E> q) {
		if (last != null) {
			if (q.last != null) {
				QueueNode<E> first = last.next;
				last.next = q.last.next;
				last = q.last;
				last.next = first;
				size += q.size;
			}
		} else {
			if (q.last != null) {
				last = q.last;
				size = q.size;
			}
		}
		q.last = null;
		q.size = 0;
	}

}
