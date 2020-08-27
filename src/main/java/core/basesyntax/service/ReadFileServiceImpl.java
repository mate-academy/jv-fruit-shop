package core.basesyntax.service;

import com.opencsv.CSVReader;
import core.basesyntax.model.FruitDto;
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
    public List<FruitDto> readFile(String filePath) {
        List<FruitDto> fruitDtoList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> lines = csvReader.readAll();
            for (String[] line : lines) {
                fruitDtoList.add(new FruitDto(line[OPERATION], line[FRUIT],
                        Integer.parseInt(line[QUANTITY]), LocalDate.parse(line[EXPIRATION_DATE])));
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not found");
        }
        return fruitDtoList;
    }
}
