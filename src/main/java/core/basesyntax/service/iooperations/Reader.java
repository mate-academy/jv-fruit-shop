package core.basesyntax.service.iooperations;

import core.basesyntax.dto.FruitDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<FruitDto> readFromFile(String filePath) {
        List<FruitDto> fruitDtos = new ArrayList<>();
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        try (CSVParser parser = new CSVParser(new FileReader(filePath), format)) {
            for (CSVRecord csvRecord : parser) {
                FruitDto fruitDto = new FruitDto();
                fruitDto.setOperation(csvRecord.get("type"));
                fruitDto.setFruitName(csvRecord.get("fruit"));
                fruitDto.setAmount(csvRecord.get("quantity"));
                fruitDto.setFruitDtoDate(csvRecord.get("date"));
                fruitDtos.add(fruitDto);
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with reading file");
        }
        if (fruitDtos.isEmpty()) {
            throw new RuntimeException("This file is empty!");
        }
        return fruitDtos;
    }
}
