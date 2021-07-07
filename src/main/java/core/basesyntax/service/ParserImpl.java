package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.validator.Validator;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final String WORDS_SEPARATOR = ",";
    private final Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    public List<FruitDto> parseToDto(List<String> inputData) {
        return inputData.stream().skip(1).peek(validator::validate).map(s -> {
            String[] words = s.split(WORDS_SEPARATOR);
            return new FruitDto(words[0].trim(),
                    words[1], Integer.parseInt(words[2]));
        }).collect(Collectors.toList());
    }
}
