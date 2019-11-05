/*
Team Members:
Aamir Ibrahim
Bayleigh Correl
Adam Gonglach
Harry Haisty
 */
public class Id implements ArithmeticExpression
{
	private char ch;
	// ch - must be a valid identifier
	// throws new IllegalArgument exception if ch if not a valid identifier
	public Id(char ch) {
		if (!Character.isLetter(ch))
			throw new IllegalArgumentException ("invalid identifier argument");
		this.ch = ch;
	}
	public char getChar()
	{
		return ch;
	}
	@Override
	public int evaluate()
	{
		return Memory.fetch (ch);
	}
}
