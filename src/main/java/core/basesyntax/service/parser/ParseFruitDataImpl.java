package core.basesyntax.service.parser;

import core.basesyntax.dao.FruitFileReader;
import core.basesyntax.service.FruitTransaction;
import java.util.List;

public class ParseFruitDataImpl implements ParseFruitData {
    private final FruitFileReader fileReader;

    public ParseFruitDataImpl(FruitFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<FruitTransaction> parseData(String fileName) {
        List<String> inputArray = fileReader.read(fileName);
        inputArray.remove(0);
        return inputArray.stream()
                .map(s -> s.split(","))
                .map(s -> new FruitTransaction(s[0],s[1],Integer.parseInt(s[2])))
                .toList();
    }
}
