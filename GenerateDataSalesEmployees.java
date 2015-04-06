import java.util.*;

class GenerateDataSalesEmployees {
	
	public ArrayList<Integer> attributeUniqueInstances;
	public final int totalAttributes;
	public ArrayList<Integer> tableRows;
	public HashSet<ArrayList<Integer>> generatedRows;

	public GenerateDataSalesEmployees(int totalAtts)
	{
		totalAttributes = totalAtts;

		attributeUniqueInstances = new ArrayList<Integer>();
		tableRows = new ArrayList<Integer>();
		generatedRows = new HashSet<ArrayList<Integer>>();
	}

	//Will setup 1NF table that has all attributes to begin with 
	//
	//parameters define how many of each primary key attribute do we want to generate values for per employee
	public void generateData(int numberEmployees, int companiesPerEmp, int productsPerEmp, int skillsPerEmp, int langPerEmp, int trainersPerEmp) 
	{
		//keep unique set of primary keys (EmployeeID,Company,Product,Skill,Language,Trainer)
		HashSet<ArrayList<Integer>> table1uniques = new HashSet<ArrayList<Integer>>();

		//actual count of uniques for each attribute (m1,m2,m3....)
		HashSet<Integer> uniqueEmps = new HashSet<Integer>();
		HashSet<Integer> uniqueNames = new HashSet<Integer>();
		HashSet<Integer> uniqueDepts = new HashSet<Integer>();
		HashSet<Integer> uniqueLocs = new HashSet<Integer>();
		HashSet<Integer> uniqueComps = new HashSet<Integer>();
		HashSet<Integer> uniqueProds = new HashSet<Integer>();
		HashSet<Integer> uniqueSkis = new HashSet<Integer>();
		HashSet<Integer> uniqueLangs = new HashSet<Integer>();
		HashSet<Integer> uniqueTrains = new HashSet<Integer>();
		HashSet<Integer> uniqueCors = new HashSet<Integer>();
		HashSet<Integer> uniqueDates = new HashSet<Integer>();

		//max uniques to draw from (ie. the range for m1,m2,m3...)
		int uniqueEmployees = numberEmployees;
		int uniqueEmpNames = (int)(numberEmployees*0.95);
		int uniqueDepartments = 5;
		int uniqueLocations = 5;
		int uniqueCompanies = 5;
		int uniqueProducts = 5;
		int uniqueSkills = 10;
		int uniqueLanguages = 6;
		int uniqueTrainers = 1;
		int uniqueCourses = 1;
		int uniqueCompletionDates = 365;

		Random randomGenarator = new Random();

		for (int i = 0; i < numberEmployees; i++)
		{
			int[] uniqueRow = new int[11];
			int[] primaryKey = new int[6];

			int employeeID = i;
			int name = randomGenarator.nextInt(uniqueEmpNames);
			int department = randomGenarator.nextInt(uniqueDepartments);
			int location = randomGenarator.nextInt(uniqueLocations);

			uniqueRow[0] = employeeID;
			uniqueRow[1] = name;
			uniqueRow[2] = department;
			uniqueRow[3] = location;

			primaryKey[0] = employeeID;

			for (int j = 0; j < companiesPerEmp; j++)
			{
				int company = randomGenarator.nextInt(uniqueCompanies);

				for (int k = 0; k < productsPerEmp; k++)
				{
					int product = randomGenarator.nextInt(uniqueProducts);

					for (int l = 0; l < skillsPerEmp; l++)
					{
						int skill = randomGenarator.nextInt(uniqueSkills);

						for (int m = 0; m < langPerEmp; m++)
						{
							int language = randomGenarator.nextInt(uniqueLanguages);

							for (int n = 0; n < trainersPerEmp; n++)
							{
								int trainer = randomGenarator.nextInt(uniqueTrainers);
								//int session = randomGenarator.nextInt(uniqueCourses);
								int session = trainer;
								int completionDate = randomGenarator.nextInt(uniqueCompletionDates);

								uniqueRow[4] = company;
								uniqueRow[5] = product;
								uniqueRow[6] = skill;
								uniqueRow[7] = language;
								uniqueRow[8] = trainer;
								uniqueRow[9] = session;
								uniqueRow[10] = completionDate;

								primaryKey[1] = company;
								primaryKey[2] = product;
								primaryKey[3] = skill;
								primaryKey[4] = language;
								primaryKey[5] = trainer;

								ArrayList<Integer> row = new ArrayList<Integer>();
							    for (int index = 0; index < uniqueRow.length; index++)
							    {
							        row.add(uniqueRow[index]);
							    }

							    ArrayList<Integer> key = new ArrayList<Integer>();
							    for (int index = 0; index < primaryKey.length; index++)
							    {
							        key.add(primaryKey[index]);
							    }

							    //If the primary key doesn't exist we can add this row to our generated data rows
							    if (!table1uniques.contains(key))
								{
									generatedRows.add(row);
									table1uniques.add(key);

									if (!uniqueEmps.contains(new Integer(uniqueRow[0])))
									{
										uniqueEmps.add(new Integer(uniqueRow[0]));
									}
									if (!uniqueNames.contains(new Integer(uniqueRow[1])))
									{
										uniqueNames.add(new Integer(uniqueRow[1]));
									}
									if (!uniqueDepts.contains(new Integer(uniqueRow[2])))
									{
										uniqueDepts.add(new Integer(uniqueRow[2]));
									}
									if (!uniqueLocs.contains(new Integer(uniqueRow[3])))
									{
										uniqueLocs.add(new Integer(uniqueRow[3]));
									}
									if (!uniqueComps.contains(new Integer(uniqueRow[4])))
									{
										uniqueComps.add(new Integer(uniqueRow[4]));
									}
									if (!uniqueProds.contains(new Integer(uniqueRow[5])))
									{
										uniqueProds.add(new Integer(uniqueRow[5]));
									}
									if (!uniqueSkis.contains(new Integer(uniqueRow[6])))
									{
										uniqueSkis.add(new Integer(uniqueRow[6]));
									}
									if (!uniqueLangs.contains(new Integer(uniqueRow[7])))
									{
										uniqueLangs.add(new Integer(uniqueRow[7]));
									}
									if (!uniqueTrains.contains(new Integer(uniqueRow[8])))
									{
										uniqueTrains.add(new Integer(uniqueRow[8]));
									}
									if (!uniqueCors.contains(new Integer(uniqueRow[9])))
									{
										uniqueCors.add(new Integer(uniqueRow[9]));
									}
									if (!uniqueDates.contains(new Integer(uniqueRow[10])))
									{
										uniqueDates.add(new Integer(uniqueRow[10]));
									}
								}
							}
						}
					}
				}
			}

		}

		//Unique instances of each attribue
		attributeUniqueInstances.add(uniqueEmps.size());
		attributeUniqueInstances.add(uniqueEmps.size());
		attributeUniqueInstances.add(uniqueDepts.size());
		attributeUniqueInstances.add(uniqueLocs.size());
		attributeUniqueInstances.add(uniqueComps.size());
		attributeUniqueInstances.add(uniqueProds.size());
		attributeUniqueInstances.add(uniqueSkis.size());
		attributeUniqueInstances.add(uniqueLangs.size());
		attributeUniqueInstances.add(uniqueTrains.size());
		attributeUniqueInstances.add(uniqueCors.size());
		attributeUniqueInstances.add(uniqueDates.size());

		this.calculateTableRows();
	}

	//For each table we defined at various parts of normalisation process, how many rows result in these tables after normalising from the 1NF table
	public void calculateTableRows()
	{	
		//Some tables we need to count how many rows will result from the 1NF table based on unique combinations of a subset of the primary key
		HashSet<ArrayList<Integer>> table3uniques = new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> table4uniques = new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> table7uniques = new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> table9uniques = new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> table10uniques = new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> table11uniques = new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> table12uniques = new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> table13uniques = new HashSet<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> table14uniques = new HashSet<ArrayList<Integer>>();

		//Iterate through each generated row from the 1NF table
		for (ArrayList<Integer> row : generatedRows)
		{
			int empID = row.get(0);
			int company = row.get(4);
			int product = row.get(5);
			int skill = row.get(6);
			int language = row.get(7);
			int trainer = row.get(8);
			int session = row.get(9);

			//For table 3 (EmployeeID,Session,Trainer,CompletionDate) where (EmployeeID,Session) make up the primary key
			//How many unique combinations of this primary key do we have in the 1NF table after normalising into this table
			//Same process is followed for other tables
			ArrayList<Integer> table3row = new ArrayList<Integer>();
			table3row.add(empID);
			table3row.add(session);
			if (!table3uniques.contains(table3row))
			{
				table3uniques.add(table3row);
			}

			ArrayList<Integer> table4row = new ArrayList<Integer>();
			table4row.add(empID);
			table4row.add(company);
			table4row.add(product);
			table4row.add(skill);
			table4row.add(language);
			if (!table4uniques.contains(table4row))
			{
				table4uniques.add(table4row);
			}

			ArrayList<Integer> table7row = new ArrayList<Integer>();
			table7row.add(empID);
			table7row.add(session);
			if (!table7uniques.contains(table7row))
			{
				table7uniques.add(table7row);
			}

			ArrayList<Integer> table9row = new ArrayList<Integer>();
			table9row.add(empID);
			table9row.add(skill);
			if (!table9uniques.contains(table9row))
			{
				table9uniques.add(table9row);
			}

			ArrayList<Integer> table10row = new ArrayList<Integer>();
			table10row.add(empID);
			table10row.add(language);
			if (!table10uniques.contains(table10row))
			{
				table10uniques.add(table10row);
			}

			ArrayList<Integer> table11row = new ArrayList<Integer>();
			table11row.add(empID);
			table11row.add(company);
			table11row.add(product);
			if (!table11uniques.contains(table11row))
			{
				table11uniques.add(table11row);
			}

			ArrayList<Integer> table12row = new ArrayList<Integer>();
			table12row.add(empID);
			table12row.add(company);
			if (!table12uniques.contains(table12row))
			{
				table12uniques.add(table12row);
			}

			ArrayList<Integer> table13row = new ArrayList<Integer>();
			table13row.add(empID);
			table13row.add(product);
			if (!table13uniques.contains(table13row))
			{
				table13uniques.add(table13row);
			}

			ArrayList<Integer> table14row = new ArrayList<Integer>();
			table14row.add(company);
			table14row.add(product);
			if (!table14uniques.contains(table14row))
			{
				table14uniques.add(table14row);
			}
		}

		//Add these to our list of row counts for each table
		//Some table's row counts will be based on the unique number of attribute instances in the 1NF table

		//Table 1 rows count
		tableRows.add(this.generatedRows.size());

		//table 2 rows count
		tableRows.add(this.attributeUniqueInstances.get(0));

		//table 3 rows count
		tableRows.add(this.attributeUniqueInstances.get(0));

		//table 4 rows count
		tableRows.add(table4uniques.size());

		//table 5 rows count
		tableRows.add(this.attributeUniqueInstances.get(0));

		//table 6 rows count
		tableRows.add(this.attributeUniqueInstances.get(3));

		//table 7 rows count
		tableRows.add(table7uniques.size());

		//table 8 rows count
		tableRows.add(this.attributeUniqueInstances.get(8));

		//table 9 rows count
		tableRows.add(table9uniques.size());

		//table 10 rows count
		tableRows.add(table10uniques.size());

		//table 11 rows count
		tableRows.add(table11uniques.size());

		//table 12 rows count
		tableRows.add(table12uniques.size());

		//table 13 rows count
		tableRows.add(table13uniques.size());

		//table 14 rows count
		tableRows.add(table14uniques.size());
	}

}