package service.impl;

import db.Storage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String FILE_HEAD = "fruit,quantity";

    @Override
    public List<String> getReport() {
        Stream<String> reportStream = Storage.fruits.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue());
        return Stream.concat(Stream.of(FILE_HEAD), reportStream)
                .collect(Collectors.toList());
    }
}
