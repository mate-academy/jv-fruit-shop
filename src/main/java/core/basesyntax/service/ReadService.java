package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadService implements Read {
    @Override
    public List<FruitDto> readData(String fromFileName) {
        File file = new File(fromFileName);
        StringBuilder dataRead = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = null;
            value = reader.readLine();
            while (value != null) {
                dataRead.append(value).append("_");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file!", e);
        }
        String[] dataFromFile = dataRead.toString().split("_");
        List<FruitDto> fruitsList = new ArrayList<>();
        for (String s: dataFromFile) {
            String[] temporary = s.split(",");
            fruitsList.add(new FruitDto(temporary[1], temporary[0],
                    Integer.parseInt(temporary[2])));
        }
        return fruitsList;
    }
}
