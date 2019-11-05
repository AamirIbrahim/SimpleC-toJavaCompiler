/*
Team Members:
Aamir Ibrahim
Bayleigh Correl
Adam Gonglach
Harry Haisty
 */
public class Program
{
	private Block blk;
	// blk cannot be null
	// throws IllegalArgumentException if blk is null

	public Program(Block blk)
	{
		if (blk == null)
			throw new IllegalArgumentException ("null block argument");
		this.blk = blk;
	}
	//postcondition: program has been executed
	public void execute ()
	{
		blk.execute();
	}
}