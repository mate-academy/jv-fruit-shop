package core.basesyntax.service;

import core.basesyntax.dto.TransferAction;
import core.basesyntax.dto.TransferActionImpl;
import core.basesyntax.service.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String WORDS_SEPARATOR = ",";
    private final Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    public List<TransferAction> parseToDto(List<String> inputData) {
        inputData.remove(0);
        validator.validate(inputData);
        List<TransferAction> transferActions = new ArrayList<>();
        for (String record : inputData) {
            String[] words = record.trim().split(WORDS_SEPARATOR);
            transferActions.add(new TransferActionImpl(words[0],
                    words[1], Integer.parseInt(words[2])));
        }
        return transferActions;
    }
}
