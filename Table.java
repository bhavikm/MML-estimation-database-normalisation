import java.util.*;

//Represents the number of unique rows in a table and which attributes it contains (by maintaining a list of indices upto the total number of possible attributes)
public class Table {
	public final int uniqueRows;
	public final ArrayList<Integer> attributes; //Indices of another arraylist that gives the attributes for this table

	public Table(int rows, ArrayList<Integer> attributeKeys)
	{
		uniqueRows = rows;
		attributes = new ArrayList<Integer>(attributeKeys);
	}
}