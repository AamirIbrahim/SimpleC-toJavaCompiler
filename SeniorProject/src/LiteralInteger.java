/*
Team Members:
Aamir Ibrahim
Bayleigh Correl
Adam Gonglach
Harry Haisty
 */
public class LiteralInteger implements ArithmeticExpression
{
	private int value;
	public LiteralInteger(int value)
	{
		this.value = value;
	}
	@Override
	public int evaluate()
	{
		return value;
	}

}