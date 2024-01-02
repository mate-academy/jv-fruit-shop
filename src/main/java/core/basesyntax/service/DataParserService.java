package core.basesyntax.service;

import java.util.List;

public interface DataParserService<T> {
    List<T> parse(List<String> fileData);
}
