package core.basesyntax.service;

import java.util.List;

public interface DataParserService<O, I> {
    List<O> parseData(List<I> data);
}
