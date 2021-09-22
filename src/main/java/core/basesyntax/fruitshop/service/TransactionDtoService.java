package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.TransactionDto;
import java.util.List;

public interface TransactionDtoService {
    List<TransactionDto> createDto(List<String> data);
}
