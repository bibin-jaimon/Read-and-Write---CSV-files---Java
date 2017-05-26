package com.java.csv;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		List<CsvData> csvEntries = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nEnter the path of input CSV file:");

		String inputFilePath = scanner.next();

		File inputFile = new File(inputFilePath);

		CsvFileReader csvFileReader = new CsvFileReader();

		csvEntries = csvFileReader.readCsvFile(inputFile);

		System.out.println("\nEnter the path of output CSV File:");

		String outputFilePath = scanner.next();

		CsvFileWriter csvFileWriter = new CsvFileWriter();
		
		csvFileWriter.writeCsvFile(csvEntries, outputFilePath);
		
		scanner.close();
	}

}
