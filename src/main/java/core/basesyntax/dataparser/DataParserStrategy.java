package core.basesyntax.dataparser;

public interface DataParserStrategy {
    DataParser getDataParser(ParserModels model);
}
