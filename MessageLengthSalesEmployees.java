import java.util.*;

//For computing message length specific to report's schema
public class MessageLengthSalesEmployees {
	
	public ArrayList<Integer> attributeUniqueInstances; //m1,m2,m3.... the number of unique instances for each attribute
	public final int totalAttributes;  //total number of possible attributes used
	public ArrayList<Table> tables; //list of all tables used in each normal form, each Table instance has how many rows that table is encoded with and what attributes it has
	public ArrayList<AttributesPrimaryKeys> tableAttsPKs; //List of information about each table including the number of attributes it has and number of attributes in its primary key
	private ArrayList<Integer> tableRows; //number of rows encoded in each table

	//Setup based on small test example introduced in report
	public MessageLengthSalesEmployees()
	{
		totalAttributes = 11;
		attributeUniqueInstances = new ArrayList<Integer>();
		tables = new ArrayList<Table>();
		tableAttsPKs = new ArrayList<AttributesPrimaryKeys>();
		tableRows = new ArrayList<Integer>();

		//Unique instances of each attribue in table 1
		attributeUniqueInstances.add(3);
		attributeUniqueInstances.add(3);
		attributeUniqueInstances.add(1);
		attributeUniqueInstances.add(2);
		attributeUniqueInstances.add(3);
		attributeUniqueInstances.add(3);
		attributeUniqueInstances.add(3);
		attributeUniqueInstances.add(4);
		attributeUniqueInstances.add(2);
		attributeUniqueInstances.add(2);
		attributeUniqueInstances.add(3);

		tableRows.add(15); //table 1 has 15 rows
		tableRows.add(attributeUniqueInstances.get(0));
		tableRows.add(3); //table 3 has 3 rows
		tableRows.add(14); //table 4 has 14 rows
		tableRows.add(attributeUniqueInstances.get(0)); //table 5 has as many rows as m1
		tableRows.add(attributeUniqueInstances.get(3)); //table 6 has as many rows as m4
		tableRows.add(3); //table 7 has 3 rows
		tableRows.add(attributeUniqueInstances.get(0)); //table 8 has as many rows as m9
		tableRows.add(5); //table 9 has 5 rows
		tableRows.add(6); //table 10 has 6 rows
		tableRows.add(9); //table 11 has 9 rows
		tableRows.add(5); //table 12 has 5 rows
		tableRows.add(7); //table 13 has 7 rows
		tableRows.add(7); //table 14 has 7 rows

		this.setUpTables();
		this.setUpTableAttsPks();
	}

	//Use this when generating data from GenerateDataSalesEmployees class
	//
	//totalAtts - total number of unique attributes for all tables
	//attUniques - how many unique instances of each attribute in table 1
	//tableRows - number of rows in each table
	public MessageLengthSalesEmployees(int totalAtts, ArrayList<Integer> attUniques, ArrayList<Integer> newTableRows)
	{
		totalAttributes = totalAtts;

		attributeUniqueInstances = new ArrayList<Integer>(attUniques);
		tables = new ArrayList<Table>();
		tableAttsPKs = new ArrayList<AttributesPrimaryKeys>();
		tableRows = new ArrayList<Integer>(newTableRows);

		this.setUpTables();
		this.setUpTableAttsPks();
	}

	private void setUpTableAttsPks()
	{
		tableAttsPKs.add(new AttributesPrimaryKeys(11,6));
		tableAttsPKs.add(new AttributesPrimaryKeys(4,1));
		tableAttsPKs.add(new AttributesPrimaryKeys(4,2));
		tableAttsPKs.add(new AttributesPrimaryKeys(5,5));
		tableAttsPKs.add(new AttributesPrimaryKeys(3,1));
		tableAttsPKs.add(new AttributesPrimaryKeys(2,1));
		tableAttsPKs.add(new AttributesPrimaryKeys(3,2));
		tableAttsPKs.add(new AttributesPrimaryKeys(2,1));
		tableAttsPKs.add(new AttributesPrimaryKeys(2,1));
		tableAttsPKs.add(new AttributesPrimaryKeys(2,2));
		tableAttsPKs.add(new AttributesPrimaryKeys(3,3));
		tableAttsPKs.add(new AttributesPrimaryKeys(2,2));
		tableAttsPKs.add(new AttributesPrimaryKeys(2,2));
		tableAttsPKs.add(new AttributesPrimaryKeys(2,2));
	}

	//Setup what attributes each table has and how many rows each table has
	//Will setup all tables used upto and including 5NF (see report for details)
	private void setUpTables()
	{
		//Table 1
		ArrayList<Integer> table1Atts = new ArrayList<Integer>();
		table1Atts.add(0);
		table1Atts.add(1);
		table1Atts.add(2);
		table1Atts.add(3);
		table1Atts.add(4);
		table1Atts.add(5);
		table1Atts.add(6);
		table1Atts.add(7);
		table1Atts.add(8);
		table1Atts.add(9);
		table1Atts.add(10);
		Table table1 = new Table(tableRows.get(0), table1Atts);

		//Table 2
		ArrayList<Integer> table2Atts = new ArrayList<Integer>();
		table2Atts.add(0);
		table2Atts.add(1);
		table2Atts.add(2);
		table2Atts.add(3);
		Table table2 = new Table(tableRows.get(1), table2Atts);

		//Table 3
		ArrayList<Integer> table3Atts = new ArrayList<Integer>();
		table3Atts.add(0);
		table3Atts.add(8);
		table3Atts.add(9);
		table3Atts.add(10);
		Table table3 = new Table(tableRows.get(2), table2Atts);

		//Table 4
		ArrayList<Integer> table4Atts = new ArrayList<Integer>();
		table4Atts.add(0);
		table4Atts.add(4);
		table4Atts.add(5);
		table4Atts.add(6);
		table4Atts.add(7);
		Table table4 = new Table(tableRows.get(3), table4Atts);


		//Table 5
		ArrayList<Integer> table5Atts = new ArrayList<Integer>();
		table5Atts.add(0);
		table5Atts.add(1);
		table5Atts.add(3);
		Table table5 = new Table(tableRows.get(4), table5Atts);

		//Table 6
		ArrayList<Integer> table6Atts = new ArrayList<Integer>();
		table6Atts.add(2);
		table6Atts.add(3);
		Table table6 = new Table(tableRows.get(5), table6Atts);

		//Table 7
		ArrayList<Integer> table7Atts = new ArrayList<Integer>();
		table7Atts.add(0);
		table7Atts.add(9);
		table7Atts.add(10);
		Table table7 = new Table(tableRows.get(6), table7Atts);

		//Table 8
		ArrayList<Integer> table8Atts = new ArrayList<Integer>();
		table8Atts.add(8);
		table8Atts.add(9);
		Table table8 = new Table(tableRows.get(7), table8Atts);

		//Table 9
		ArrayList<Integer> table9Atts = new ArrayList<Integer>();
		table9Atts.add(0);
		table9Atts.add(6);
		Table table9 = new Table(tableRows.get(8), table9Atts);

		//Table 10
		ArrayList<Integer> table10Atts = new ArrayList<Integer>();
		table10Atts.add(0);
		table10Atts.add(7);
		Table table10 = new Table(tableRows.get(9), table10Atts);

		//Table 11
		ArrayList<Integer> table11Atts = new ArrayList<Integer>();
		table11Atts.add(0);
		table11Atts.add(4);
		table11Atts.add(5);
		Table table11 = new Table(tableRows.get(10), table11Atts);


		//Table 12
		ArrayList<Integer> table12Atts = new ArrayList<Integer>();
		table12Atts.add(0);
		table12Atts.add(4);
		Table table12 = new Table(tableRows.get(11), table12Atts);

		//Table 13
		ArrayList<Integer> table13Atts = new ArrayList<Integer>();
		table13Atts.add(0);
		table13Atts.add(5);
		Table table13 = new Table(tableRows.get(12), table13Atts);

		//Table 14
		ArrayList<Integer> table14Atts = new ArrayList<Integer>();
		table14Atts.add(4);
		table14Atts.add(5);
		Table table14 = new Table(tableRows.get(13), table14Atts);

		//Add each to our list of tables
		tables.add(table1);
		tables.add(table2);
		tables.add(table3);
		tables.add(table4);
		tables.add(table5);
		tables.add(table6);
		tables.add(table7);
		tables.add(table8);
		tables.add(table9);
		tables.add(table10);
		tables.add(table11);
		tables.add(table12);
		tables.add(table13);
		tables.add(table14);
	} 

	// Will give message lengths for each normal form defined in report
	public static void main(String args[])
	{
		NormalisedMessageLength nML = new NormalisedMessageLength(); 

		GenerateDataSalesEmployees generator = new GenerateDataSalesEmployees(11); //generate our data
		generator.generateData(30,15,5,5,5,2); //generate data
		MessageLengthSalesEmployees schemaAndData = new MessageLengthSalesEmployees(11, generator.attributeUniqueInstances, generator.tableRows); //setup schema info with generated data

		//To use with small default data defined at start of report comment out above three lines and uncomment below line
		//MessageLengthSalesEmployees schemaAndData = new MessageLengthSalesEmployees(); //use for small default data (no generation)

		//
		//Message length calculations for each normal form
		//we have setup all schema and data information so just pass in the tables we want for each normal form (see report for details)
		//

		//print out m1,m2,m3... and number of rows we generated
		int m = 1;
		for (Integer uniqueInstances : generator.attributeUniqueInstances)
		{
			System.out.println("m"+String.valueOf(m) + ": " + String.valueOf(uniqueInstances));
			m++;
		}
		System.out.println("Total number of rows in 1NF: " + generator.generatedRows.size());

		//1NF
		ArrayList<AttributesPrimaryKeys> firstNFtableAttPKs = new ArrayList<AttributesPrimaryKeys>();
		ArrayList<Table> firstNFtables = new ArrayList<Table>();
		firstNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(0));
		firstNFtables.add(schemaAndData.tables.get(0));
		double firstPartLength =  Math.round(nML.FirstPart(schemaAndData.totalAttributes,firstNFtableAttPKs) * 100.00) / 100.00;
		double secondPartLength = Math.round(nML.SecondPart(schemaAndData.attributeUniqueInstances,firstNFtables) * 100.00) / 100.00;
		System.out.println("1NF -- 1st Part: " + String.valueOf(firstPartLength) + " 2nd Part: " + String.valueOf(secondPartLength) + " Total: " + String.valueOf(firstPartLength+secondPartLength));

		//2NF
		ArrayList<AttributesPrimaryKeys> secondNFtableAttPKs = new ArrayList<AttributesPrimaryKeys>();
		ArrayList<Table> secondNFtables = new ArrayList<Table>();
		secondNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(1));
		secondNFtables.add(schemaAndData.tables.get(1));
		secondNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(2));
		secondNFtables.add(schemaAndData.tables.get(2));
		secondNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(3));
		secondNFtables.add(schemaAndData.tables.get(3));
		firstPartLength =  Math.round(nML.FirstPart(schemaAndData.totalAttributes,secondNFtableAttPKs) * 100.00) / 100.00;
		secondPartLength = Math.round(nML.SecondPart(schemaAndData.attributeUniqueInstances,secondNFtables) * 100.00) / 100.00;
		System.out.println("2NF -- 1st Part: " + String.valueOf(firstPartLength) + " 2nd Part: " + String.valueOf(secondPartLength) + " Total: " + String.valueOf(firstPartLength+secondPartLength));

		//3NF
		ArrayList<AttributesPrimaryKeys> thirdNFtableAttPKs = new ArrayList<AttributesPrimaryKeys>();
		ArrayList<Table> thirdNFtables = new ArrayList<Table>();
		thirdNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(2));
		thirdNFtables.add(schemaAndData.tables.get(2));
		thirdNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(3));
		thirdNFtables.add(schemaAndData.tables.get(3));
		thirdNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(4));
		thirdNFtables.add(schemaAndData.tables.get(4));
		thirdNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(5));
		thirdNFtables.add(schemaAndData.tables.get(5));
		firstPartLength =  Math.round(nML.FirstPart(schemaAndData.totalAttributes,thirdNFtableAttPKs) * 100.00) / 100.00;
		secondPartLength = Math.round(nML.SecondPart(schemaAndData.attributeUniqueInstances,thirdNFtables) * 100.00) / 100.00;
		System.out.println("3NF -- 1st Part: " + String.valueOf(firstPartLength) + " 2nd Part: " + String.valueOf(secondPartLength) + " Total: " + String.valueOf(firstPartLength+secondPartLength));

		//BCNF
		ArrayList<AttributesPrimaryKeys> bcnfNFtableAttPKs = new ArrayList<AttributesPrimaryKeys>();
		ArrayList<Table> bcnfNFtables = new ArrayList<Table>();
		bcnfNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(3));
		bcnfNFtables.add(schemaAndData.tables.get(3));
		bcnfNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(4));
		bcnfNFtables.add(schemaAndData.tables.get(4));
		bcnfNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(5));
		bcnfNFtables.add(schemaAndData.tables.get(5));
		bcnfNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(6));
		bcnfNFtables.add(schemaAndData.tables.get(6));
		bcnfNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(7));
		bcnfNFtables.add(schemaAndData.tables.get(7));
		firstPartLength =  Math.round(nML.FirstPart(schemaAndData.totalAttributes,bcnfNFtableAttPKs) * 100.00) / 100.00;
		secondPartLength = Math.round(nML.SecondPart(schemaAndData.attributeUniqueInstances,bcnfNFtables) * 100.00) / 100.00;
		System.out.println("BCNF -- 1st Part: " + String.valueOf(firstPartLength) + " 2nd Part: " + String.valueOf(secondPartLength) + " Total: " + String.valueOf(firstPartLength+secondPartLength));

		//4NF
		ArrayList<AttributesPrimaryKeys> fourthNFtableAttPKs = new ArrayList<AttributesPrimaryKeys>();
		ArrayList<Table> fourthNFtables = new ArrayList<Table>();
		fourthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(4));
		fourthNFtables.add(schemaAndData.tables.get(4));
		fourthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(5));
		fourthNFtables.add(schemaAndData.tables.get(5));
		fourthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(6));
		fourthNFtables.add(schemaAndData.tables.get(6));
		fourthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(7));
		fourthNFtables.add(schemaAndData.tables.get(7));
		fourthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(8));
		fourthNFtables.add(schemaAndData.tables.get(8));
		fourthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(9));
		fourthNFtables.add(schemaAndData.tables.get(9));
		fourthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(10));
		fourthNFtables.add(schemaAndData.tables.get(10));
		firstPartLength =  Math.round(nML.FirstPart(schemaAndData.totalAttributes,fourthNFtableAttPKs) * 100.00) / 100.00;
		secondPartLength = Math.round(nML.SecondPart(schemaAndData.attributeUniqueInstances,fourthNFtables) * 100.00) / 100.00;
		System.out.println("4NF -- 1st Part: " + String.valueOf(firstPartLength) + " 2nd Part: " + String.valueOf(secondPartLength) + " Total: " + String.valueOf(firstPartLength+secondPartLength));

		//5NF
		ArrayList<AttributesPrimaryKeys> fifthNFtableAttPKs = new ArrayList<AttributesPrimaryKeys>();
		ArrayList<Table> fifthNFtables = new ArrayList<Table>();
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(4));
		fifthNFtables.add(schemaAndData.tables.get(4));
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(5));
		fifthNFtables.add(schemaAndData.tables.get(5));
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(6));
		fifthNFtables.add(schemaAndData.tables.get(6));
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(7));
		fifthNFtables.add(schemaAndData.tables.get(7));
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(8));
		fifthNFtables.add(schemaAndData.tables.get(8));
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(9));
		fifthNFtables.add(schemaAndData.tables.get(9));
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(11));
		fifthNFtables.add(schemaAndData.tables.get(11));
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(12));
		fifthNFtables.add(schemaAndData.tables.get(12));
		fifthNFtableAttPKs.add(schemaAndData.tableAttsPKs.get(13));
		fifthNFtables.add(schemaAndData.tables.get(13));
		firstPartLength =  Math.round(nML.FirstPart(schemaAndData.totalAttributes,fifthNFtableAttPKs) * 100.00) / 100.00;
		secondPartLength = Math.round(nML.SecondPart(schemaAndData.attributeUniqueInstances,fifthNFtables) * 100.00) / 100.00;
		System.out.println("5NF -- 1st Part: " + String.valueOf(firstPartLength) + " 2nd Part: " + String.valueOf(secondPartLength) + " Total: " + String.valueOf(firstPartLength+secondPartLength));

	}

}