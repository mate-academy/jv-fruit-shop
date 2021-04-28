package core.basesyntax.service.transactionservice;

import core.basesyntax.model.dto.TransactionDto;
import java.util.List;

public interface TransactionDtoService {
    List<TransactionDto> transform(List<String> data);
}
