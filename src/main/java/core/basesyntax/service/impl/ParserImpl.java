package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionLine;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<TransactionLine> parser(List<String> list) {
        List<TransactionLine> transactionLines = new ArrayList<>();
        list.remove(0);
        for (String stringTransaction : list) {
            new ValidatorImpl().validate(stringTransaction.trim());
            String[] split = stringTransaction.split(",");
            transactionLines.add(new TransactionLine(split[0],
                    split[1], Integer.parseInt(split[2])));
        }
        return transactionLines;
    }
}

