package com.java.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvFileReader

{
	private static final String[] FILE_HEADER_MAPPING = { "operand1", "operand2", "operator" };
	
	private static final String STUDENT_OPERAND1 = "operand1";
	
	private static final String STUDENT_OPERAND2 = "operand2";
	
	private static final String STUDENT_OPERATOR = "operator";

	public List<CsvData> readCsvFile(File inputFile) {

		FileReader inputFileReader = null;
	
		CSVParser csvFileParser = null;
		
		List<CsvData> csvEntry = new ArrayList<CsvData>();
		
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

		try {

			inputFileReader = new FileReader(inputFile);

			csvFileParser = new CSVParser(inputFileReader, csvFileFormat);

			List<CSVRecord> inputCsvList = csvFileParser.getRecords();

			for (int rawIndex = 1; rawIndex < inputCsvList.size(); rawIndex++) {

				CSVRecord record = inputCsvList.get(rawIndex);

				CsvData csvData = new CsvData(Integer.parseInt(record.get(STUDENT_OPERAND1)),
						Integer.parseInt(record.get(STUDENT_OPERAND2)), record.get(STUDENT_OPERATOR));

				csvEntry.add(csvData);

			}

		} catch (Exception e) {

			System.out.println("Error in CsvFileReader !!!");

			e.printStackTrace();

		}

		finally {

			try

			{

				inputFileReader.close();

				csvFileParser.close();

			}

			catch (IOException e)

			{

				System.out.println("Error while closing fileReader/csvFileParser !!!");

				e.printStackTrace();

			}
		}
		return csvEntry;
	}

}