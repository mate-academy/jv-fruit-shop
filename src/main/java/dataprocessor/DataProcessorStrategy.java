package dataprocessor;

public interface DataProcessorStrategy {
    DataProcessor getDataProcessor(ProcessSchema schema);
}
