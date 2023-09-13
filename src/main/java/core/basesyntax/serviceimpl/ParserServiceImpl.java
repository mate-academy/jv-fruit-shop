package core.basesyntax.serviceimpl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationName;
import core.basesyntax.service.ParserService;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private final String separator;

    public ParserServiceImpl(String separator) {
        this.separator = separator;
    }

    @Override
    public List<Operation> parseOperations(List<String> lines) {
        return lines.stream()
                .map(line -> {
                    String[] splitted = line.split(separator);
                    return new Operation(OperationName.getByCode(splitted[0]),
                            splitted[1],
                            Integer.parseInt(splitted[2]));
                })
                .toList();
    }
}
