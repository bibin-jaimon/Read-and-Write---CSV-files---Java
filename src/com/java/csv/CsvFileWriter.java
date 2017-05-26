package com.java.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CsvFileWriter {

	private static final String NEW_LINE_SEPARATOR = "\n";

	public void writeCsvFile(List<CsvData> inputEntry, String outputFilePath) {

		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;

		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

		File outputFile = new File(outputFilePath);

		try {
			fileWriter = new FileWriter(outputFile);

			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

			for (int rawIndex = 0; rawIndex < inputEntry.size(); rawIndex++) {

				CsvData csvData = inputEntry.get(rawIndex);

				List<String> csvDataToWrite = new ArrayList<String>();

				csvDataToWrite.add(String.valueOf(csvData.getOperand1()));

				csvDataToWrite.add(String.valueOf(csvData.getOperand2()));

				csvDataToWrite.add(csvData.getOperator());

				csvDataToWrite.add(String.valueOf(csvData.getResult()));

				csvFilePrinter.printRecord(csvDataToWrite);

			}
			System.out.println("CSV file was created successfully !!!");

		}

		catch (Exception e) {

			System.out.println("Error in CsvFileWriter !!!");

			e.printStackTrace();

		} finally {

			try {

				fileWriter.flush();

				fileWriter.close();

				csvFilePrinter.close();

			} catch (IOException e) {

				System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");

				e.printStackTrace();

			}

		}

	}

}
