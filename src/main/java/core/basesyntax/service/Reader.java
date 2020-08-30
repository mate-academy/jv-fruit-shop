package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<FruitDto> readFromFile(String filePath) {
        List<FruitDto> fruitDtos = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                List<String> row = new ArrayList<>();
                String[] str = line.split(",");
                if (!(str[0].equals("s")) && !(str[0].equals("b")) && !(str[0].equals("r"))) {
                    throw new RuntimeException("Don't have such operation");
                }
                FruitDto fruitDto = new FruitDto();
                fruitDto.setOperation(str[0]);
                fruitDto.setFruitName(str[1]);
                fruitDto.setAmount(str[2]);
                fruitDto.setFruitDtoDate(str[3]);
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
