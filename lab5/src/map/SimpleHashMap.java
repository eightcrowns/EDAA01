package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K, V>[] entries;
	
	public SimpleHashMap() {
		entries = (Entry<K, V>[]) new Entry[16];
	}
	
	public SimpleHashMap(int capacity) {
		entries = new Entry[capacity];
	}
	
	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public V put(K arg0, V arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public V remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int size() {
		int size = 0;
		
		for (int i = 0; i < entries.length; i++) {
			Entry<K, V> node = entries[i];
			while (node != null) {
				size++;
				node = node.next;
			}
		}
		return size;
	}
	
	public String show() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < entries.length; i++) {
			sb.append(i);
			sb.append("\t");
			
			Entry<K, V> node = entries[i];
			while (node != null) {
				sb.append(node);
				if (node.next != null) {
					sb.append(" ");
				} else {
					sb.append("\n");
				}
				node = node.next;
			}
		}
		return sb.toString();
	}
	
	private int index(K key) {
		return key.hashCode() % entries.length;
	}
	
	private Entry<K, V> find(int index, K key) {
		Entry<K, V> node = entries[index];
		while (node != null && !key.equals(node.getKey())) {
			node = node.next;
		}
		return node;
	}
	
	private static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;
		
		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
		
		public String toString() {
			return key + "=" + value;
		}
	}
}