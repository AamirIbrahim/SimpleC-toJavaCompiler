/*
Team Members:
Aamir Ibrahim
Bayleigh Correl
Adam Gonglach
Harry Haisty
 */
public class Token {
	private TokenType tokType;
	private String lexeme;
	private int rowNumber;
	private int columnNumber;
	// tokType - cannot be null
	// lexeme - cannot be null & cannot be empty
	// rowNumber - must be positive
	// columnNumber - must be positive
	// throws IllegalArgumentException if any precondition is not satisfied
	public Token(TokenType tokType, String lexeme, int rowNumber,
			int columnNumber) {
		if (tokType == null)
			throw new IllegalArgumentException ("null TokenType argument");
		if (lexeme == null || lexeme.length() == 0)
			throw new IllegalArgumentException ("invalid lexeme argument");
		if (rowNumber <= 0)
			throw new IllegalArgumentException ("invalid row number argument");
		if (columnNumber <= 0)
			throw new IllegalArgumentException ("invalid column number argument");
		this.tokType = tokType;
		this.lexeme = lexeme;
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
	}
	public TokenType getTokType()
	{
		return tokType;
	}
	public String getLexeme()
	{
		return lexeme;
	}
	public int getRowNumber()
	{
		return rowNumber;
	}
	public int getColumnNumber()
	{
		return columnNumber;
	}
}
