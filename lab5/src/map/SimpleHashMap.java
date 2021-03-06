package map;

import java.util.Random;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K, V>[] entries;
	
	public SimpleHashMap() {
		entries = (Entry<K, V>[]) new Entry[16];
	}
	
	public SimpleHashMap(int capacity) {
		entries = new Entry[capacity];
	}
	
	public V get(Object arg0) {
		K key = (K) arg0;
		Entry<K, V> entry = find(index(key), key);
		if (entry != null) {
			return entry.getValue();
		}
		return null;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public V put(K key, V value) {
		int index = index(key);
		Entry<K, V> previous = find(index, key);
		if (previous == null) {
			Entry<K, V> oldEntry = entries[index];
			entries[index] = new Entry<K, V>(key, value);
			entries[index].next = oldEntry;
			
			if ((double)size() / entries.length > 0.75) {
				rehash();
			}
			return null;
		} else {
			V oldValue = previous.getValue();
			previous.setValue(value);
			return oldValue;
		}
	}
	
	public V remove(Object arg0) {
		K key = (K) arg0;
		int index = index(key);
		if (entries[index] == null) { // listan �r tom
			return null;
		} else {
			Entry<K, V> node = entries[index], previousNode = null;
			while (node != null && !key.equals(node.getKey())) {
				previousNode = node;
				node = node.next;
			}
			
			if (node == entries[index]) { // key �r f�rsta elementet i listan
				entries[index] = entries[index].next;
				return node.getValue();
			} else if (node != null) { // key finns senare i listan
				previousNode.next = node.next;
				return node.getValue();
			} else { // key finns inte i listan
				return null;
			}
		}
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
				}
				node = node.next;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private int index(K key) {
		return Math.abs(key.hashCode() % entries.length);
	}
	
	private Entry<K, V> find(int index, K key) {
		Entry<K, V> node = entries[index];
		while (node != null && !key.equals(node.getKey())) {
			node = node.next;
		}
		return node;
	}
	
	private void rehash() {
		Entry<K, V>[] oldEntries = entries;
		entries = new Entry[oldEntries.length * 2];
		
		for (int i = 0; i < oldEntries.length; i++) {
			Entry<K, V> node = oldEntries[i];
			while (node != null) {
				put(node.getKey(), node.getValue());
				node = node.next;
			}
		}
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
	/*
	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> shm = new SimpleHashMap<Integer, Integer>(10);
		for (int i = 0; i < 80; i++) {
			Random rand = new Random();
			int random = rand.nextInt(100);
			shm.put(random, random);
		}
		System.out.println(shm.show());
	}*/
}
