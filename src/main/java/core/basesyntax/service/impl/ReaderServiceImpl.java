package core.basesyntax.service.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.parsers.ActivityParser;
import core.basesyntax.service.parsers.impl.ActivityParserImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderServiceImpl implements ReaderService {
    private ActivityParser activityParser;

    public ReaderServiceImpl() {
        activityParser = new ActivityParserImpl();
    }

    @Override
    public List<Activity> read(Path path) {
        try (Stream<String> stringStream = Files.lines(path)) {
            return stringStream
                    .skip(1)
                    .map(string -> string.trim())
                    .map(activityParser::parse)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Check file " + path + " " + e);
        }
    }
}
