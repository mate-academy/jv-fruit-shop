package service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReadFileService;

public class ReadFileServiceImpl implements ReadFileService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<String> read(String fileName) {
        List<String> informationFromFile = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                if (lineInArray[OPERATION_INDEX].equals("type")) {
                    continue;
                }
                informationFromFile.add(lineInArray[OPERATION_INDEX] + "-"
                        + lineInArray[FRUIT_INDEX] + "-" + lineInArray[QUANTITY_INDEX]);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Can't read file " + fileName);
        }
        return informationFromFile;
    }
}
