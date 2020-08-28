package core.basesyntax.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.model.TransactionDto;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFileServiceImpl implements ReadFileService {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int EXPIRATION_DATE = 3;

    @Override
    public List<TransactionDto> readFile(String filePath) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        FileReader fileReader;
        try {
            fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> lines = csvReader.readAll();
            for (String[] line : lines) {
                transactionDtoList.add(new TransactionDto(line[OPERATION], line[FRUIT],
                        Integer.parseInt(line[QUANTITY]), LocalDate.parse(line[EXPIRATION_DATE])));
            }
            fileReader.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("File is not found");
        }
        return transactionDtoList;
    }
}
