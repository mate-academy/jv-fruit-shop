package services;

import dto.FruitDto;

public class FileParser {
    private static final String SEPARATOR = ",";

    public FruitDto parse(String line) {
        String[] cortege = line.split(SEPARATOR);
        FruitDto fruitDto = new FruitDto(cortege[0],
                cortege[1], Integer.parseInt(cortege[2]), cortege[3]);
        return fruitDto;
    }
}
