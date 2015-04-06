import java.util.*;

//To compute the two part message length of a normalised relational schema with data
class NormalisedMessageLength {
	
	public NormalisedMessageLength() {}

	// Taken from: http://stackoverflow.com/questions/2201113/combinatoric-n-choose-r-in-java-math
	private long choose(long total, long choose)
	{
		if(total < choose)
		    return 0;
		if(choose == 0 || choose == total)
		    return 1;
		return choose(total-1,choose-1)+choose(total-1,choose);
	}

	//First part of message length #H
	//
	//totalAttributes is the total number of attributes that is used amongst all tables
	//tables is a list of information for each table including the number of attributes and the number of primary keys
	//
	//returns the message length in bits
	public double FirstPart(int totalAttributes, ArrayList<AttributesPrimaryKeys> tables)
	{
		double messageLength = Logarithm.log2(totalAttributes);

		for (AttributesPrimaryKeys table : tables)
		{
			messageLength += Logarithm.log2(choose(totalAttributes,table.attributes));
			messageLength += Logarithm.log2(choose(table.attributes,table.primaryKeys));
			if (tables.size() > 1)
				messageLength += Logarithm.log2(table.attributes);
		}

		return messageLength;
	}

	//Second part of message length #A
	//
	//uniqueAttInstances is the number of unique instances for each attribute (m1,m2,m3...)
	//tables is a list of the number of rows and attributes that make up all the tables required
	//the attributes for a table are defined as a list of Integer indices that correspond to the indices of uniqueAttInstances
	//
	//returns message length in bits of second part
	public double SecondPart(ArrayList<Integer> uniqueAttInstances, ArrayList<Table> tables)
	{
		double messageLength = 0.0;

		for (Table table : tables)
		{
			double uniqueInstanceSum = 0.0;

			for (Integer uniqueAttInstanceIndex : table.attributes)
			{
				uniqueInstanceSum += Logarithm.log2(uniqueAttInstances.get(uniqueAttInstanceIndex));
			}

			messageLength += table.uniqueRows * uniqueInstanceSum;
		}

		return messageLength;
	}

	//Compute the two part message length of a relational schema encoded with data
	//Returns total message length in bits
	public double totalMessageLength(int totalAttributes, ArrayList<AttributesPrimaryKeys> tableAttsPks, ArrayList<Integer> uniqueAttInstances, ArrayList<Table> tables)
	{
		return ( this.FirstPart(totalAttributes,tableAttsPks) + this.SecondPart(uniqueAttInstances,tables) );
	}

	//Test the 1NF message length from Dowe + Zaidi paper (http://users.monash.edu.au/~nzaidi/papers/paper10a.pdf)
	public static void testDoweZaidi1NF()
	{
		//Test first part of message length
		ArrayList<AttributesPrimaryKeys> test = new ArrayList<AttributesPrimaryKeys>();
		AttributesPrimaryKeys table = new AttributesPrimaryKeys(10,3);
		test.add(table);
		NormalisedMessageLength nML = new NormalisedMessageLength();
		System.out.println(String.valueOf(nML.FirstPart(10,test))); //Should be 10.22


		//Test second part of message length
		ArrayList<Integer> uniqueInstances = new ArrayList<Integer>();
		uniqueInstances.add(5);
		uniqueInstances.add(5);
		uniqueInstances.add(5);
		uniqueInstances.add(5);
		uniqueInstances.add(4);
		uniqueInstances.add(4);
		uniqueInstances.add(2);
		uniqueInstances.add(2);
		uniqueInstances.add(3);
		uniqueInstances.add(3);

		//Set up the first table from 1NF, need to add each attribute index for this table
		ArrayList<Integer> table1 = new ArrayList<Integer>();
		table1.add(0);
		table1.add(1);
		table1.add(2);
		table1.add(3);
		table1.add(4);
		table1.add(5);
		table1.add(6);
		table1.add(7);
		table1.add(8);
		table1.add(9);

		//Just add the one table to our list of tables as this is 1NF
		ArrayList<Table> tables = new ArrayList<Table>();
		tables.add(new Table(11, table1));

		System.out.println(String.valueOf(nML.SecondPart(uniqueInstances,tables))); //Should be 203.03
	}

	
}