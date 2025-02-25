package dataparser;

public interface DataParserStrategy {
    DataParser getDataParser(ParserModels model);
}
