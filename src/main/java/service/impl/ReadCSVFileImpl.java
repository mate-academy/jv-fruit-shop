package service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dao.StorageDao;
import dao.StorageDaoImpl;
import service.ReadCSVFile;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFileImpl implements ReadCSVFile {
    private static final String FILE_NAME = "src/main/resources/Input.csv";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final List<String> informationFromFile;

    public ReadCSVFileImpl() {
        informationFromFile = new ArrayList<>();
    }

    @Override
    public List<String> read() {
        try (CSVReader reader = new CSVReader(new FileReader(FILE_NAME))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                if (lineInArray[OPERATION_INDEX].equals("type")) {
                    continue;
                }
                informationFromFile.add(lineInArray[OPERATION_INDEX] + "-"
                        + lineInArray[FRUIT_INDEX] + "-" + lineInArray[QUANTITY_INDEX]);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Can't read file " + FILE_NAME);
        }
        return informationFromFile;
    }
}
