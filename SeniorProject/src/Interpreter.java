/*
Author:
Aamir Ibrahim
 */
import java.io.*;
import java.util.regex.Pattern;

public class Interpreter {
	public static void main(String[] args) {
		try {
			FileTransfer("src/test1.cs", "src/a.java");
			CSharptoJava("src/a.java");
			FileTransfer("src/test2.cs", "src/b.java");
			CSharptoJava("src/b.java");
			FileTransfer("src/test3.cs", "src/c.java");
			CSharptoJava("src/c.java");
			FileTransfer("src/test4.cs", "src/d.java");
			CSharptoJava("src/d.java");

			PrintStream printStream = new PrintStream(new FileOutputStream("src/output.txt"));
			System.setOut(printStream);

			Parser p = new Parser("src/test1.cs");
			Program program1 = p.parse();
			program1.execute();
			System.out.println();
			printStream.close();

			PrintStream printStream2 = new PrintStream(new FileOutputStream("src/output2.txt"));
			System.setOut(printStream2);

			Parser p2 = new Parser("src/test2.cs");
			Program program2 = p2.parse();
			program2.execute();
			System.out.println();
			printStream2.close();

			PrintStream printStream3 = new PrintStream(new FileOutputStream("src/output3.txt"));
			System.setOut(printStream3);

			Parser p3 = new Parser("src/test3.cs");
			Program program3 = p3.parse();
			program3.execute();
			System.out.println();
			printStream3.close();

			PrintStream printStream4 = new PrintStream(new FileOutputStream("src/output4.txt"));
			System.setOut(printStream4);

			Parser p4 = new Parser("src/test4.cs");
			Program program4 = p4.parse();
			program4.execute();
			System.out.println();
			printStream4.close();

			interpreterGUI gui = new interpreterGUI("src/test1.cs", "src/a.java", "src/output.txt");
			interpreterGUI gui2 = new interpreterGUI("src/test2.cs", "src/b.java", "src/output2.txt");
			interpreterGUI gui3 = new interpreterGUI("src/test3.cs", "src/c.java", "src/output3.txt");
			interpreterGUI gui4 = new interpreterGUI("src/test4.cs", "src/d.java", "src/output4.txt");

			deleteUnneededValues();
		}
		catch (ParserException e) {
			System.out.println (e.getMessage());
		}
		catch (LexicalException e) {
			System.out.println (e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println (e.getMessage());
		}
		catch (FileNotFoundException e) {
			System.out.println ("source file is not found");
		}
		catch (Exception e) {
			System.out.println ("unknown error occurred - terminating");
		}
	}
	private static void deleteUnneededValues(){
		File file = new File("src/output.txt");
		File file2 = new File("src/output2.txt");
		File file3 = new File("src/output3.txt");
		File file4 = new File("src/output4.txt");

		File file5 = new File("src/a.java");
		File file6 = new File("src/b.java");
		File file7 = new File("src/c.java");
		File file8 = new File("src/d.java");

		file.deleteOnExit();
		file2.deleteOnExit();
		file3.deleteOnExit();
		file4.deleteOnExit();
		file5.deleteOnExit();
		file6.deleteOnExit();
		file7.deleteOnExit();
		file8.deleteOnExit();
	}
	private static void CSharptoJava(String fileName) {
		try {
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line, oldtext = "";
			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r\n";
			}
			reader.close();

			String newText = oldtext.replaceAll(Pattern.quote("string[]"), "String[]");
			newText = newText.replaceAll("Console.WriteLine", "System.out.println");
			newText = newText.replaceAll("Main", "main");

			FileWriter writer = new FileWriter(fileName);
			writer.write(newText);
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static void FileTransfer(String inputFile, String outputFile){
		File file = new File(outputFile);
		FileInputStream instream = null;
		FileOutputStream outstream = null;
		try{
			File infile = new File(inputFile);
			File outfile = new File(outputFile);

			instream = new FileInputStream(infile);
			outstream = new FileOutputStream(outfile);

			byte[] buffer = new byte[1024];

			int length;

			while ((length = instream.read(buffer)) > 0){
				outstream.write(buffer, 0, length);
			}

			instream.close();
			outstream.close();

		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
