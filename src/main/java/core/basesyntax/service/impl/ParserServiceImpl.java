package core.basesyntax.service.impl;

import core.basesyntax.db.InputReader;
import core.basesyntax.db.InputReaderImpl;
import core.basesyntax.service.ParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COLUMNS_SEPARATOR = ",";
    private final InputReader inputReader;

    public ParserServiceImpl() {
        this.inputReader = new InputReaderImpl();
    }

    @Override
    public List<List<String>> parseDataFromCsv(String inputFilePath) {
        String data = inputReader.readInputCsv(inputFilePath);
        return Arrays.stream(data.split(System.lineSeparator()))
                .map(l -> Arrays.stream(l.split(COLUMNS_SEPARATOR)).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
