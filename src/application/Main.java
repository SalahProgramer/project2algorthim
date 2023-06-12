package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Main extends Application {
	FileInputStream input;
	TableView<comreesTable> CompressTable;
	ObservableList<comreesTable> compresInfoTable = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) throws IOException, ExecutionException, InterruptedException {

		primaryStage.setMaximized(true);

		primaryStage.setResizable(false);
		primaryStage.setTitle("Huffman coding");

		Image image = new Image("C:\\Users\\Msii\\eclipse-workspace\\Project2Algorthim\\src\\application\\winrar.png");
		Image image1 = new Image("C:\\Users\\Msii\\eclipse-workspace\\project2Algorthim\\src\\application\\3.jfif");
		ImageView imageView = new ImageView(image1);
		imageView.setFitHeight(862);
		imageView.setFitWidth(1540);

		Group group = new Group();

		Label lb = new Label("Huffman coding");
		lb.setFont(Font.font("Georgia", 37));
		lb.setTextFill(Color.DARKBLUE);
		lb.setLayoutX(680);
		lb.setLayoutY(40);

		Button lb1 = new Button("Choise file");
		lb1.setStyle(
				"-fx-border-radius: 50;-fx-border-color: yellow;-fx-background-radius: 50;-fx-background-color: darkblue");

		lb1.setFont(Font.font("Georgia", 26));
		lb1.setLayoutX(380);
		lb1.setLayoutY(120);
		lb1.setTextFill(Color.YELLOW);
		lb1.setOnMouseExited(e -> {
			lb1.setStyle(
					"-fx-border-radius: 50;-fx-border-color: yellow;-fx-background-radius: 50;-fx-background-color: darkblue");

			lb1.setFont(Font.font("Georgia", 26));

			lb1.setTextFill(Color.YELLOW);

		});
		lb1.setOnMouseMoved(e -> {
			lb1.setStyle(
					"-fx-border-radius: 50;-fx-border-color: black;-fx-background-radius: 50;-fx-background-color: white");

			lb1.setFont(Font.font("Georgia", 26));

			lb1.setTextFill(Color.DARKBLUE);

//			lb1.setBackground(new Background(
//					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

		});

		TextField text1 = new TextField();
		text1.setPromptText("Choose Name the file:");
		text1.setStyle(
				"-fx-border-color: darkblue;-fx-border-radius: 50;-fx-background-radius: 50;-fx-setTextfill-color: darkblue;");
//					text1.setresultground(
//							new resultground(new resultgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
		text1.setLayoutX(610);
		text1.setLayoutY(125);
		text1.setFont(Font.font("Georgia", 22));
		text1.setAlignment(Pos.CENTER);
		text1.setPrefWidth(400);
		text1.setEditable(false);

		Button compress = new Button("Compress");

		compress.setVisible(true);
		compress.setFont(Font.font("Georgia", 26));
		compress.setLayoutX(610);
		compress.setLayoutY(220);
		compress.setStyle(
				"-fx-border-radius: 20;-fx-border-color: YELLOW;-fx-background-color: DARKBLUE;-fx-background-radius: 20;");

		compress.setTextFill(Color.WHITE);

		compress.setOnMouseMoved(e -> {
			compress.setStyle(
					"-fx-border-radius: 20;-fx-border-color: blue;-fx-background-color: white;-fx-background-radius: 20;");

			compress.setTextFill(Color.DARKBLUE);

		});
		compress.setOnMouseExited(e -> {
			compress.setStyle(
					"-fx-border-radius: 20;-fx-border-color: YELLOW;-fx-background-color: DARKBLUE;-fx-background-radius: 20;");

			compress.setTextFill(Color.WHITE);

		});

		Button decompress = new Button("Decompress");

		decompress.setVisible(true);
		decompress.setFont(Font.font("Georgia", 26));
		decompress.setLayoutX(830);
		decompress.setLayoutY(220);
		decompress.setStyle(
				"-fx-border-radius: 20;-fx-border-color: YELLOW;-fx-background-color: DARKBLUE;-fx-background-radius: 20;");

		decompress.setTextFill(Color.WHITE);

		decompress.setOnMouseMoved(e -> {
			decompress.setStyle(
					"-fx-border-radius: 20;-fx-border-color: blue;-fx-background-color: white;-fx-background-radius: 20;");

			decompress.setTextFill(Color.DARKBLUE);

		});
		decompress.setOnMouseExited(e -> {
			decompress.setStyle(
					"-fx-border-radius: 20;-fx-border-color: YELLOW;-fx-background-color: DARKBLUE;-fx-background-radius: 20;");

			decompress.setTextFill(Color.WHITE);

		});
		compress.setDisable(true);
		decompress.setDisable(true);

		TableColumn<comreesTable, Character> String_Type = new TableColumn<>("Character");
		String_Type.setPrefWidth(130);
		String_Type.setCellValueFactory(new PropertyValueFactory<>("character"));

		TableColumn<comreesTable, Integer> ascii = new TableColumn<>("ASCII");
		ascii.setPrefWidth(150);
		ascii.setCellValueFactory(new PropertyValueFactory<>("asci"));
		TableColumn<comreesTable, String> VariableLengthHufman = new TableColumn<>("Variable_Length(Huffman)");
		VariableLengthHufman.setPrefWidth(170);
		VariableLengthHufman.setCellValueFactory(new PropertyValueFactory<>("length"));
		TableColumn<comreesTable, Integer> frequancy = new TableColumn<>("Frequancy");
		frequancy.setPrefWidth(170);
		frequancy.setCellValueFactory(new PropertyValueFactory<>("frequancy"));
		CompressTable = new TableView<>();

		String_Type.setStyle(
				"-fx-border-radius: 50;-fx-border-color: darkblue;-fx-background-radius: 50;-fx-background-color: white;text-align: center;");
		ascii.setStyle(
				"-fx-border-radius: 50;-fx-border-color: darkblue;-fx-background-radius: 50;-fx-background-color: white");
		VariableLengthHufman.setStyle(
				"-fx-border-radius: 50;-fx-border-color: darkblue;-fx-background-radius: 50;-fx-background-color: white");
		frequancy.setStyle(
				"-fx-border-radius: 50;-fx-border-color: darkblue;-fx-background-radius: 50;-fx-background-color: white");

		String_Type.setResizable(false);
		ascii.setResizable(false);
		VariableLengthHufman.setResizable(false);
		frequancy.setResizable(false);

//		employees.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
//		employees.setItems(data);
		CompressTable.setPrefHeight(350);
		CompressTable.setPrefWidth(625);

		CompressTable.getColumns().addAll(String_Type, ascii, VariableLengthHufman, frequancy);
		Label lb3 = new Label("Done, was compressed, But the file is empty");
		CompressTable.setEditable(false);
		CompressTable.setCenterShape(true);

		lb3.setFont(Font.font("Georgia", 25));
		lb3.setTextFill(Color.DARKBLUE);
		lb3.setLayoutX(570);
		lb3.setLayoutY(180);
		lb3.setVisible(false);
		lb3.setDisable(true);

		lb1.setOnAction(e1 -> {
			lb3.setVisible(false);
			lb3.setDisable(true);
			text1.clear();
			compress.setDisable(true);
			decompress.setDisable(true);
			FileChooser file = new FileChooser();

			File File = file.showOpenDialog(primaryStage);
			String FileRead = String.valueOf(File);
			File selectFile = new File(FileRead);

			try {
				input = new FileInputStream(selectFile);
				input.close();
				text1.setText(selectFile.getName());

			} catch (FileNotFoundException e) {
				text1.setText("File not found");
			} catch (IOException e2) {
				text1.setText("File not found");

			}

			if (text1.getText().equals("File not found")) {
				decompress.setDisable(true);
				compress.setDisable(true);

			} else if (text1.getText().contains(".na") == false) {
				compress.setDisable(false);
				decompress.setDisable(true);
				compress.setOnAction(e -> {
					compresInfoTable.clear();
					try {

						String data = readFileCompress(selectFile + "");

						if (data.isEmpty()) {
							FileOutputStream fos = new FileOutputStream(selectFile + ".na");

							fos.write(data.getBytes());

							fos.close();

							lb3.setVisible(true);
							lb3.setDisable(false);

						} else {
							HuffmanTree tree = new HuffmanTree();

							FileInputStream fis = new FileInputStream(selectFile);

							tree.create(fis);

							Map<Byte, Integer> characterWithfrequencyTable = tree.getCarWithFreq();
							StringBuilder sb = new StringBuilder();
							StringBuilder sb1 = new StringBuilder();

							try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(selectFile + ""));
									BufferedOutputStream out = new BufferedOutputStream(
											new FileOutputStream(selectFile + ".na"))) {

					             OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.ISO_8859_1);

								Map<Byte, String> characterWithcodehuff = tree.getEncodingMap();
								for (Map.Entry<Byte, Integer> entry : characterWithfrequencyTable.entrySet()) {
									byte s = entry.getKey();
									compresInfoTable.add(new comreesTable((char) s, (int) (entry.getKey()),
											characterWithcodehuff.get(entry.getKey()), entry.getValue()));
									sb1.append((int) entry.getKey() + " " + entry.getValue() + "\n");

								}
								String characters = sb1 + "";
								String sizeHuf = String.valueOf(sb1.length()) + "";
								int extension = selectFile.getName().lastIndexOf('.');
								String fileExtension = selectFile.getName().substring(extension + 1) + "\n";
								String size = compresInfoTable.size() + "\n";
								out.write(size.getBytes());

								out.write(sizeHuf.getBytes());
								out.write(fileExtension.getBytes());

								String sizeFIleOrginal = String.valueOf(selectFile.length()) + "\n";
								CompressTable.setItems(compresInfoTable);
								Map<Byte, String> encodingMap = tree.getEncodingMap();
								int BUFFER_SIZE = 1024;

								byte[] buffer = new byte[BUFFER_SIZE];

								int numBytes;
								while ((numBytes = in.read(buffer)) != -1) {
									for (int i = 0; i < numBytes; i++) {
										byte s = buffer[i];
										sb.append(encodingMap.get(s));
//										System.out.println(sb);

									}

								}
								String lengthBits = String.valueOf(sb.length());

								out.write(sizeFIleOrginal.getBytes());

								out.write(lengthBits.getBytes());

								out.write("\n".getBytes());

								out.write(characters.getBytes());
								String bits = sb + "";
//								System.out.println("before add: " + bits);
								while (bits.length() % 8 != 0) {
									bits = bits + '0';
								}

//								for (int i = 0; i < s.length(); i++) {
//									System.out.println((int) s.charAt(i) + " " + s.charAt(i));
//
//								}

//								System.out.println("After add:  " + bits);
								out.write(toBytes(bits));

								out.close();

							}

						}

						lb3.setVisible(true);
						lb3.setDisable(false);
						lb3.setText("             Done: this file was compressed");

					} catch (IOException e2) {
						e2.printStackTrace();
					}
				});

			} else if (text1.getText().contains(".na") == true) {
				compresInfoTable.clear();
				decompress.setDisable(false);
				compress.setDisable(true);
				lb3.setVisible(false);
				lb3.setDisable(true);
				decompress.setOnAction(e -> {

					try {

//						try (BufferedReader reader = new BufferedReader(
//				                new InputStreamReader(new FileInputStream(selectFile + ""), "ISO-8859-1"))) {
//				            String line;
//				            while ((line = reader.readLine()) != null) {
//				                System.out.println(line);
//				            }
//				        } catch (IOException e2) {
//				            e2.printStackTrace();
//				        }
						String stringbuilder = new String();
						FileReader file1 = new FileReader(selectFile + "");
						BufferedReader buffer = new BufferedReader(
				                new InputStreamReader(new FileInputStream(selectFile + ""), "ISO-8859-1"));
						String line;
						HuffmanTree tree = new HuffmanTree();
						int lineFrq = 0;
						int k = 1;
						String sizebits = "";
						String characterBytes = "";
						Map<Byte, Integer> chaeWithFreq;
						int i = 0;
						while ((line = buffer.readLine()) != null) {
							i++;
							if (i == 1) {
								lineFrq = Integer.parseInt(line.trim());
							}
							if (i == 4) {
								sizebits = line.trim();

							}
							if (i >= 5 && k <= lineFrq) {
//								System.out.println(line);
								k++;
								stringbuilder += line.trim() + "\n";

							} else if (k > lineFrq) {
								characterBytes += line;
//								System.out.println(line);

							}
						}
//						System.out.println(characterBytes);

						StringBuilder bitsrev2 = new StringBuilder();
						byte[] bytes = new byte[characterBytes.length()];

						for (int j = 0; j < characterBytes.length(); j++) {
							StringBuilder bitsrev = new StringBuilder();
							bytes[j] = (byte) characterBytes.charAt(j);
//							System.out.println(charToBits((char) characterBytes.charAt(j)) + "    " + bytes[j]);
							bitsrev.append(charToBits((char) characterBytes.charAt(j)));
							bitsrev2.append(bitsrev.reverse());

						}
//						System.out.println(bitsrev2);
						chaeWithFreq = countFrequencies(stringbuilder.trim());
						MinHeap<NodeHuffman> queue = new MinHeap<NodeHuffman>();
						for (Map.Entry<Byte, Integer> entry : chaeWithFreq.entrySet()) {

							queue.push(new NodeHuffman(entry.getKey(), entry.getValue()));

						}

						tree.createDecomprees(queue, chaeWithFreq);
						Map<Byte, String> characterWithcodehuff = tree.getEncodingMap();

						Map<Byte, String> encodingMap = new HashMap<>();
						buildEncodingMap(tree.getRoot(), "", encodingMap);
						for (Map.Entry<Byte, Integer> entry : chaeWithFreq.entrySet()) {
							byte s = entry.getKey();

							compresInfoTable.add(new comreesTable((char) s, (int) (entry.getKey()),
									characterWithcodehuff.get(entry.getKey()), entry.getValue()));

						}
						CompressTable.setItems(compresInfoTable);
						buffer.close();
						file1.close();
						int sizeByte = characterBytes.length();
//						System.out.println(sizeByte);
						String dataComp = "";
						String bitss = "";
						String binary_num = "";
						StringBuilder bits = new StringBuilder();

						String finl = sizebits.trim();
						int s = Integer.parseInt(finl);
						System.out.println(s);
						System.out.println(bitsrev2.length());
						String encodedData = "";
						if(s>bitsrev2.length()) {
							
							 encodedData = bitsrev2.substring(0);

						}
						else {
						 encodedData = bitsrev2.substring(0, s);
						}
//						System.out.println("After add:  " + encodedData);
//						System.out.println(encodedData.length());
						StringBuilder sb = new StringBuilder();

						for (int l = 0; l < encodedData.length();) {
							int j = l;
							while (j < encodedData.length()
									&& !encodingMap.containsValue(encodedData.substring(l, j))) {
								j++;
							}
							byte c = 0;
							String encoding = encodedData.substring(l, j);
							if (getKeyForValue(encodingMap, encoding) != null) {
								c = getKeyForValue(encodingMap, encoding);
								sb.append((char) c);
								l = j;
							} else {
								break;
							}
						}
//						System.out.println(sb);
						String data1 = sb.toString();
						writeFile(selectFile.getName().substring(0, (selectFile.getName().length()) - 3), data1);
						lb3.setVisible(true);
						lb3.setDisable(false);
						lb3.setText("           Done: this file was Decompressed");
					} catch (IOException e2) {

						text1.setText("Cannot find the file");

					}
				});
			}

		});

		final VBox vbox = new VBox();
		vbox.setSpacing(50);
		vbox.setLayoutX(450);
		vbox.setLayoutY(400);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-border-color: darkblue");

		vbox.getChildren().addAll(CompressTable);

		group.getChildren().addAll(imageView, lb, text1, lb1, compress, decompress, lb3, vbox);

		Scene scene = new Scene(group);
		primaryStage.getIcons().add(image);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static String readFileCompress(String string) throws IOException {
		StringBuilder stringbuilder = new StringBuilder();
		FileReader file = new FileReader(string);
		BufferedReader buffer = new BufferedReader(
                new InputStreamReader(new FileInputStream(string), "ISO-8859-1"));
		String line;
		while ((line = buffer.readLine()) != null) {
			stringbuilder.append(line + "\n");
		}
		buffer.close();
		file.close();
		return stringbuilder.toString();
	}

	public static String charToBits(char character) {
		// Convert the character to its ASCII value
		int asciiValue = (int) character;
//System.out.println(character);
		// Convert the ASCII value to a binary string
		String binaryString = Integer.toBinaryString(asciiValue);

		// Pad the binary string with leading zeros if necessary
		binaryString = String.format("%8s", binaryString).replace(' ', '0');

		// Return the binary string
		return binaryString;
	}

	public static String readFiledecompress(String string) throws IOException {
		StringBuilder stringbuilder = new StringBuilder();
		FileReader file = new FileReader(string);
		BufferedReader buffer = new BufferedReader(file);
		String line;
		int i = 0;
		while ((line = buffer.readLine()) != null) {
			i++;
			stringbuilder.append(line + "\n");
		}
		buffer.close();
		file.close();
		return stringbuilder.toString();
	}

	public static void writeFile(String filename, String data) throws IOException {
		FileOutputStream output = new FileOutputStream(filename);

		output.write(data.getBytes());
		output.close();
	}

	private static Map<Byte, Integer> countFrequencies(String data) {
		Map<Byte, Integer> frequencyMap = new HashMap<>();
		String[] tokens = data.split("\n");

		for (int i = 0; i < tokens.length; i++) {
			String[] token = tokens[i].split(" ");
			for (int j = 0; j < token.length; j++) {
				frequencyMap.put(Byte.valueOf(token[0]), Integer.parseInt(token[1]));
			}
		}
		return frequencyMap;
	}

	private static void buildEncodingMap(NodeHuffman node, String s, Map<Byte, String> encodingMap) {
		if (node.isLeaf()) {
			encodingMap.put(node.getAsciCode(), s);
			return;
		}
		buildEncodingMap(node.getLeft(), s + "0", encodingMap);
		buildEncodingMap(node.getRight(), s + "1", encodingMap);
	}

	private static Byte getKeyForValue(Map<Byte, String> encodingMap, String encoding) {
		for (Map.Entry<Byte, String> entry : encodingMap.entrySet()) {
			if (entry.getValue().equals(encoding)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static byte[] toBytes(String bits) throws UnsupportedEncodingException {
		int numOfBytes = (bits.length() + 7) / 8;
		byte[] bytes = new byte[numOfBytes];

		for (int i = 0; i < bits.length(); i++) {
			int byteIndex = i / 8;
			int bitIndex = i % 8;

			if (bits.charAt(i) == '1') {
				bytes[byteIndex] |= (1 << bitIndex);
			}
		}
//
//		PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8.name());
//		out.println("ô");
//		String binary = Integer.toBinaryString('ô');
//		System.out.println(binary);
//
//		String binary2 = "11110100";
//		int decimal = Integer.parseInt(binary2, 2);
//		char ch = (char) decimal;
//		System.out.println(ch);
//		String binary3 = Integer.toBinaryString(ch);
//		System.out.println(binary3);

		return bytes;
	}

	public static String bytesToBits(byte[] bytes) {
		StringBuilder sb = new StringBuilder();

		for (byte b : bytes) {
			int value = b & 0xFF; // Convert byte to unsigned integer
			String binaryString = Integer.toBinaryString(value);
			binaryString = String.format("%8s", binaryString).replace(' ', '0');
			sb.append(binaryString);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
