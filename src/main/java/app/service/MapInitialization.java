package app.service;

import app.strategy.OperationHandler;
import java.util.Map;

public interface MapInitialization {
    Map<String, OperationHandler> createMap();
}
