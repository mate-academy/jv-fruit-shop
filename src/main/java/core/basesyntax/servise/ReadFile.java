package core.basesyntax.servise;

import com.opencsv.CSVReader;
import core.basesyntax.ProductsDto;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements FileReadService {

    @Override
    public List<ProductsDto> readFromFile(String fileName) {
        List<ProductsDto> listWithData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> lines = reader.readAll();
            for (String[] line : lines) {
                listWithData.add(new ProductsDto(line[0], line[1],
                        Integer.parseInt(line[2]), LocalDate.parse(line[3])));
            }

        } catch (IOException e) {
            throw new RuntimeException("File is empty", e);
        }
        return listWithData;
    }
}
