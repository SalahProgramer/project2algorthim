package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HuffmanTree {

	NodeHuffman root;
	Map<Byte, String> encodingMap;
	Map<Byte, Integer> carWithFreq;
	HuffmanTree(NodeHuffman root, Map<Byte, String> encodingMap) {
		this.root = root;
		this.encodingMap = encodingMap;
	}

	public HuffmanTree() {
	}

	public HuffmanTree(NodeHuffman root) {
		this.root = root;
	}

	public NodeHuffman getRoot() {
		return root;
	}

	public Map<Byte, String> getEncodingMap() {
		return encodingMap;
	}

	public Map<Byte, Integer> getCarWithFreq() {
		return carWithFreq;
	}

	
	public HuffmanTree create(FileInputStream fis) throws IOException {

		Map<Byte, Integer> characterWithfrequencyTable = countFrequencies(fis);
		MinHeap<NodeHuffman> queue = new MinHeap<NodeHuffman>();
		for (Map.Entry<Byte, Integer> entry : characterWithfrequencyTable.entrySet()) {

			queue.push(new NodeHuffman(entry.getKey(), entry.getValue()));
		}
		Map<Byte, String> encodingMap1;
		if (queue.size() == 1) {
			root = queue.pop();

			queue.push(new NodeHuffman('-', root.getFrequency()));

			encodingMap1 = buildEncodingTable(root, "0");
			encodingMap = encodingMap1;
			carWithFreq=characterWithfrequencyTable;
			return new HuffmanTree(root, encodingMap);

		} 
		
		
		else {

			while (queue.size() > 1) {

				NodeHuffman x = queue.pop();

				NodeHuffman y = queue.pop();

				int sum = x.getFrequency() + y.getFrequency();
				queue.push(new NodeHuffman('-', sum, x, y));

			}

		
		root = queue.pop();

		encodingMap1 = buildEncodingTable(root, "");

		encodingMap = encodingMap1;
		carWithFreq=characterWithfrequencyTable;

		return new HuffmanTree(root, encodingMap);
		}

	}

	private static Map<Byte, String> buildEncodingTable(NodeHuffman root, String prefix) {
		Map<Byte, String> encodingTable = new TreeMap<>();
		if (root.getLeft() == null && root.getRight() == null) {
			encodingTable.put(root.getAsciCode(), prefix);
		} else {
			encodingTable.putAll(buildEncodingTable(root.getLeft(), prefix + "0"));
			encodingTable.putAll(buildEncodingTable(root.getRight(), prefix + "1"));
		}
		return encodingTable;
	}

	private static Map<Byte, Integer> countFrequencies(FileInputStream fis) throws IOException {
		Map<Byte, Integer> frequencyMap = new HashMap<>();
		
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		fis.close();

		for (byte b : bytes) {
			frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
		}
		
		
		return frequencyMap;
	}

	public HuffmanTree createDecomprees(MinHeap<NodeHuffman> queue, Map<Byte, Integer> chaeWithFreq) {
		Map<Byte, String> encodingMap1;
		if (queue.size() == 1) {
			root = queue.pop();

			queue.push(new NodeHuffman('\0', root.getFrequency()));

			encodingMap1 = buildEncodingTable(root, "0");
			encodingMap = encodingMap1;
			carWithFreq=chaeWithFreq;
			return new HuffmanTree(root, encodingMap);

		} 
		
		
		else {

			while (queue.size() > 1) {

				NodeHuffman x = queue.pop();

				NodeHuffman y = queue.pop();

				int sum = x.getFrequency() + y.getFrequency();
				queue.push(new NodeHuffman('-', sum, x, y));

			}

		
		root = queue.pop();

		encodingMap1 = buildEncodingTable(root, "");

		encodingMap = encodingMap1;
		carWithFreq=chaeWithFreq;

		return new HuffmanTree(root, encodingMap);
		}		
	}

}
