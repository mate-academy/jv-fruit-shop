package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface TransactionParser {

    List<TransactionDto> parse(List<String> lines);
}
