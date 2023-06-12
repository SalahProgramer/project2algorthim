package application;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<NodeHuffman>> {
	private ArrayList<NodeHuffman> heap;
	private int size;

	public MinHeap() {
		heap = new ArrayList<>();
	}

	public void push(NodeHuffman value) {
		heap.add(value);
		swim(heap.size() - 1);
		size++;
	}

	public NodeHuffman pop() {
		if (heap.isEmpty()) {
			return null;
		}
		if (heap.size() == 1) {
			size--;

			return heap.remove(0);
		}
		NodeHuffman minValue = heap.get(0);
		heap.set(0, heap.remove(heap.size() - 1));
		size--;
		sink(0);
		return minValue;
	}

	private void swim(int index) {
		if (index == 0) {
			return;
		}
		int parent = (index - 1) / 2;
		if (heap.get(index).compareTo(heap.get(parent)) > 0) {
			NodeHuffman temp = heap.get(index);
			heap.set(index, heap.get(parent));
			heap.set(parent, temp);
			swim(parent);
		}
	}

	private void sink(int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int smallest = index;
		if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) > 0) {
			smallest = left;
		}
		if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) > 0) {
			smallest = right;
		}
		if (smallest != index) {
			NodeHuffman temp = heap.get(index);
			heap.set(index, heap.get(smallest));
			heap.set(smallest, temp);
			sink(smallest);
		}
	}

	public int size() {
		return size;
	}
}
