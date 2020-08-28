package core.basesyntax.servise;

import core.basesyntax.ProductsDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements FileReadService{
    private static final String TEXT_DELIMETER = ",";

    @Override
    public List<ProductsDto> readFromFile(String fileName) {
        List<ProductsDto> listWithData = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null){
                String [] arrayFromLine = line.split(TEXT_DELIMETER);
                listWithData.add(new ProductsDto(arrayFromLine[0], arrayFromLine[1]
                        , Integer.parseInt(arrayFromLine[2]), LocalDate.parse(arrayFromLine[3])));
            }

        } catch (IOException e) {
            throw new RuntimeException("File is empty");
        }
        if (listWithData.size() > 0) {
            listWithData.remove(0);
        }
        return listWithData;
    }
}
