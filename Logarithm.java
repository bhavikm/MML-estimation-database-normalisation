import java.util.*;

//From: http://www.giannistsakiris.com/2010/01/09/base-2-and-base-n-logarithm-calculation-in-java/
public class Logarithm
{
	public static double logb( double a, double b )
	{
		return ( Math.log(a) / Math.log(b) );
	}

	public static double log2( double a )
	{
		return logb(a,2);
	}
}