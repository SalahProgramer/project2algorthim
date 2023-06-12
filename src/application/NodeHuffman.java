package application;

public class NodeHuffman implements Comparable<NodeHuffman> {
	private char character;
	private int frequency;
	private NodeHuffman left;
	private NodeHuffman right;
	private byte asciCode;

	public NodeHuffman(char character, int frequency) {
		this.character = character;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}
	
	public NodeHuffman(byte asciCode, int frequency) {
		this.asciCode = asciCode;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}

	public NodeHuffman(NodeHuffman left, NodeHuffman right) {
		this.left = left;
		this.right = right;
		this.frequency = left.frequency + right.frequency;
	}

	public NodeHuffman(char character, int frequency, NodeHuffman left, NodeHuffman right) {
		super();
		this.character = character;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

	public NodeHuffman(NodeHuffman left, NodeHuffman right, int frequency) {
		this.left = left;
		this.right = right;
		this.frequency = frequency;
	}

	public char getCharacter() {
		return character;
	}

	public int getFrequency() {
		return frequency;
	}

	public NodeHuffman getLeft() {
		return left;
	}

	public byte getAsciCode() {
		return asciCode;
	}

	public void setAsciCode(byte asciCode) {
		this.asciCode = asciCode;
	}

	public void setLeft(NodeHuffman left) {
		this.left = left;
	}

	public NodeHuffman getRight() {
		return right;
	}

	public void setRight(NodeHuffman right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	@Override
	public int compareTo(NodeHuffman o) {
//        return this.frequency - other.frequency;        

		if (this.frequency > o.frequency) {
			return -1;
		} else if (this.frequency < o.frequency) {
			return 1;
		} else {
			return 0;
		}
	}

}

//import java.util.Map;
//import java.util.PriorityQueue;
//
//
//  private final Node root;
//  private final Map<Character, String> encodingMap;
//
//  private HuffmanTree(Node root, Map<Character, String> encodingMap) {
//    this.root = root;
//    this.encodingMap = encodingMap;
//  }
//
//  public static HuffmanTree create(String data) {
//    // Count the frequency of each character in the data
//    Map<Character, Integer> frequencyMap = countFrequencies(data);
//
//    // Create a leaf node for each unique character
//    PriorityQueue<Node> nodes = new PriorityQueue<>();
//    for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
//      nodes.add(new Node(entry.getValue(), entry.getKey()));
//    }
//
//    // Continuously merge the two lowest-frequency nodes until there is only one root node
//    while (nodes.size() > 1) {
//      Node left = nodes.poll();
//      Node right = nodes.poll();
//      Node parent = new Node(left.frequency + right.frequency, '\0', left, right);
//      nodes.add(parent);
//    }
//
//    // Create the encoding map by traversing the tree and assigning encodings to each leaf node
//    Map<Character, String> encodingMap = createEncodingMap(nodes.poll(), new StringBuilder());
//
//    return new HuffmanTree(nodes.poll(), encodingMap);
//  }
//
//  private static Map<Character, String> createEncodingMap(Node node, StringBuilder prefix) {
//    // This method will traverse the tree and assign encodings to each leaf node
//    // using a depth-first search. The encodings will be stored in a hash map
//    // and returned at the end of the traversal.
//  }
//
//  private static Map<Character, Integer> countFrequencies(String data) {
//	    // This method will count the frequency of each character in the data
//	    // and return a hash map with the character as the key and the frequency as the value
//	  }
//
//	  public Map<Character, String> getEncodingMap() {
//	    return encodingMap;
//	  }
//	}
