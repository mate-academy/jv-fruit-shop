package core.basesyntax.service.impl;

import core.basesyntax.service.ParserService;

public class FileParserService implements ParserService {
    private static final int START_INDEX = 19;
    private static final String SPLIT_REGEX = "(?<=[0-9])(?=[a-zA-Z])";
    
    @Override
    public String[] parse(String data) {
        return data.replace(" ", "")
                .substring(START_INDEX)
                .split(SPLIT_REGEX);
    }
}
