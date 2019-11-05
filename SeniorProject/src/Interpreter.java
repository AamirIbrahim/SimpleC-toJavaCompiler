/*
Team Members:
Aamir Ibrahim
Bayleigh Correl
Adam Gonglach
Harry Haisty
 */
import java.io.FileNotFoundException;

public class Interpreter
{
	public static void main(String[] args) {
		try {

			System.out.print("First Program Output: \n");
			Parser p = new Parser("src/test1.cs");
			Program program1 = p.parse();
			program1.execute();
			System.out.println();

			System.out.print("Second Program Output: \n");
			Parser p2 = new Parser("src/test2.cs");
			Program program2 = p2.parse();
			program2.execute();
			System.out.println();

			System.out.print("Third Program Output: \n");
			Parser p3 = new Parser("src/test3.cs");
			Program program3 = p3.parse();
			program3.execute();
			System.out.println();

			System.out.print("Fourth Program Output: \n");
			Parser p4 = new Parser("src/test4.cs");
			Program program4 = p4.parse();
			program4.execute();
			System.out.println();

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
}