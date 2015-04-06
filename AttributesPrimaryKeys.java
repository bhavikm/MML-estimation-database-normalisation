//A class to represent number of attributes and primary keys in a table
public class AttributesPrimaryKeys {
	public final int attributes;
	public final int primaryKeys;

	public AttributesPrimaryKeys(int tableAtts, int tablePKs)
	{
		attributes = tableAtts;
		primaryKeys = tablePKs;
	}
}