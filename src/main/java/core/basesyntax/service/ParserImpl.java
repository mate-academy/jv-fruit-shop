package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final int TITLE_INDEX = 0;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitDto> parseDto(List<String> information) {
        information.remove(TITLE_INDEX);
        return information.stream()
                .map(l -> l.split(SEPARATOR))
                .map(l -> new FruitDto(l[1], Integer.parseInt(l[2]), l[0]))
                .collect(Collectors.toList());
    }
}
