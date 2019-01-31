package lexer;

public class Real extends Token{
    public final float value;
	public Real(float v) {
		super(Tag.REAL);
		value=v;
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		return "" + value;
	}
	
}
