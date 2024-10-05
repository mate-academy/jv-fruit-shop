package core.basesyntax.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigService {
    private final Properties properties;

    public ConfigService(String configFilePath) {
        properties = new Properties();
        loadConfig(configFilePath);
    }

    private void loadConfig(String configFilePath) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFilePath)) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find " + configFilePath);
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Error loading configuration file: " + configFilePath, ex);
        }
    }

    public String getSourcePath() {
        return properties.getProperty("source.path");
    }

    public String getTargetPath() {
        return properties.getProperty("target.path");
    }
}
