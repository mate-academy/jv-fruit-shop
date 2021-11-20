package core.basesyntax.service.impl;

import core.basesyntax.strategy.Activity;
import core.basesyntax.service.ReaderService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<Activity> read(File file) {
        try (Stream<String> stringStream = Files.lines(Paths.get(file.getPath()))) {
            return stringStream
                    .skip(1)
                    .map(s -> s.trim())
                    .map(new ActivityParserImpl()::parse)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Check file " + file.getName() + " " + e);
        }
    }
}
