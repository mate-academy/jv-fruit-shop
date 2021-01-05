package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;

import java.util.List;

public interface Filereader {
    List<TransactionDto> readFile(String fileName);
}
