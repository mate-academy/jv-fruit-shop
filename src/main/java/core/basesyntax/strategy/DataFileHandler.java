package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.CsvDataParserImpl;
import core.basesyntax.strategy.impl.CsvReportBuilderImpl;
import core.basesyntax.strategy.impl.JsonDataParserImpl;
import core.basesyntax.strategy.impl.JsonReportBuilderImpl;
import core.basesyntax.strategy.impl.XmlDataParserImpl;
import core.basesyntax.strategy.impl.XmlReportBuilderImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataFileHandler {
    private final Map<String, DataParser> dataParsers = new HashMap<>();
    private final Map<String, ReportBuilder> reportBuilders = new HashMap<>();

    {
        dataParsers.put(FileType.CSV.getName(), new CsvDataParserImpl());
        dataParsers.put(FileType.XML.getName(), new XmlDataParserImpl());
        dataParsers.put(FileType.JSON.getName(), new JsonDataParserImpl());

        reportBuilders.put(FileType.CSV.getName(), new CsvReportBuilderImpl());
        reportBuilders.put(FileType.XML.getName(), new XmlReportBuilderImpl());
        reportBuilders.put(FileType.JSON.getName(), new JsonReportBuilderImpl());
    }

    public DataParser getDataParser(String type) {
        Optional<DataParser> dataParserOptional = Optional.of(dataParsers.get(type));
        return dataParserOptional.orElseThrow(
                () -> new RuntimeException("Invalid file type " + type));
    }

    public ReportBuilder getReportBuilder(String type) {
        Optional<ReportBuilder> reportBuilderOptional = Optional.of(reportBuilders.get(type));
        return reportBuilderOptional.orElseThrow(
                () -> new RuntimeException("Invalid file type " + type));
    }

    public enum FileType {
        CSV("csv"),
        XML("xml"),
        JSON("json");

        private final String name;

        FileType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
