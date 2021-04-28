package core.basesyntax.fruit.dto;

public class FruitDtoParserImpl implements FruitDtoParser {

    @Override
    public FruitDto parseFruitDto(String[] line) {
        return new FruitDto(line[1], Integer.parseInt(line[2]));
    }
}
