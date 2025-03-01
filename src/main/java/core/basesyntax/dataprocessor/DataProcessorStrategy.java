package core.basesyntax.dataprocessor;

public interface DataProcessorStrategy {
    DataProcessor getDataProcessor(ProcessSchema schema);
}
