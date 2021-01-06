package service.implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransactionDto;
import service.DataReader;

public class CsvDataReaderImpl implements DataReader {

    @Override
    public List<FruitTransactionDto> readFromFile(String readFromFile) {
        List<FruitTransactionDto> parsedCsvData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(readFromFile))) {
            String line = reader.readLine();
            while (line != null) {
                CsvDataParser csvParser = new CsvDataParser();
                parsedCsvData.add(csvParser.parse(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File : " + readFromFile + " not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can not read file " + readFromFile, e);
        }
        return parsedCsvData;
    }
}
