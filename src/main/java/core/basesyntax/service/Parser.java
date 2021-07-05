package core.basesyntax.service;

import core.basesyntax.dto.TransferAction;
import java.util.List;

public interface Parser {
    List<TransferAction> parseToDto(List<String> inputData);
}
