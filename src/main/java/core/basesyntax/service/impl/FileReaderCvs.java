package core.basesyntax.service.impl;

import core.basesyntax.model.Event;
import core.basesyntax.service.IFileReader;
import core.basesyntax.service.IOperatorIdentifier;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderCvs implements IFileReader {

    @Override
    public List<Event> read(String path) {
        List<String> events;
        try {
            events = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't get date from file" + path);
        }

        return events.stream().filter(line -> !line.equals("type,fruit,quantity"))
                .map(this::getEventFromCvs)
                .collect(Collectors.toList());
    }

    private Event getEventFromCvs(String line) {
        String[] fields = line.split(",");
        IOperatorIdentifier operatorIdentifier = new OperatorIdentifier();

        return new Event(operatorIdentifier
                .getOperator(fields[0]), fields[1], Integer.parseInt(fields[2]));
    }
}
