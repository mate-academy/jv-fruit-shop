package service.Implementation;

import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import service.DataReader;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReaderImpl implements DataReader {
    public static final int OPERATION = 0;
    public static final int FRUIT_NAME = 1;
    public static final int FRUITS_AMOUNT = 2;
    public static final String COMMA = ",";
    public static final String FILE_PATH = "src/main/resources/";

    @Override
    public List<FruitTransactionDto> readFromFile(String fileName) {
        List<FruitTransactionDto> fileData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + fileName))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parsedLine = line.split(COMMA);
                fileData.add(new FruitTransactionDto(Operation.fromString(parsedLine[OPERATION])
                        , new Fruit(parsedLine[FRUIT_NAME].toLowerCase())
                        , Integer.parseInt(parsedLine[FRUITS_AMOUNT])));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File : " + fileName + " not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can not read file " + fileName, e);
        }
        return fileData;
    }
}
