package core.basesyntax.lib;

import core.basesyntax.parse.DataParser;
import core.basesyntax.parse.DataParserImpl;
import core.basesyntax.process.ProcessData;
import core.basesyntax.process.ProcessDataImpl;
import core.basesyntax.readdata.DataReader;
import core.basesyntax.readdata.DataReaderImpl;
import core.basesyntax.report.ReportData;
import core.basesyntax.report.ReportDataImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.writedata.DataWriter;
import core.basesyntax.writedata.DataWriterImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Injector {
    private static final Injector injector = new Injector();
    private Map<Class<?>, Object> instances = new HashMap<>();

    public static Injector getInjector() {
        return injector;
    }

    public Object getInstance(Class<?> interfaceClazz) {
        Class<?> clazz = findImplementation(interfaceClazz);
        Object clazzImplementationInstance = null;
        Field[] declaredField = clazz.getDeclaredFields();
        for (Field field : declaredField) {
            if (field.isAnnotationPresent(Inject.class)) {
                // create a new object of field type
                Object fieldInstance = getInstance(field.getType());
                // create an object of interface (or implementation class)
                clazzImplementationInstance = createNewInstance(clazz);
                //set 'field type object' to interfaceClazz object
                try {
                    field.setAccessible(true);
                    field.set(clazzImplementationInstance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Can't initialize field value. "
                            + "Class; " + clazz.getName() + ". Field: " + field.getName());
                }
            }
        }
        if (clazzImplementationInstance == null) {
            clazzImplementationInstance = createNewInstance(clazz);
        }
        return clazzImplementationInstance;
    }

    private Object createNewInstance(Class<?> clazz) {
        // if we create an object - let's use it
        if (instances.containsKey(clazz)) {
            return instances.get(clazz);
        }
        // create a new object
        try {
            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();
            instances.put(clazz, instance);
            return instance;
        } catch (NoSuchMethodException | InstantiationException
                 | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Can't create new instance of" + clazz.getName());
        }
    }

    private Class<?> findImplementation(Class<?> interfaceClazz) {
        Map<Class<?>, Class<?>> interfaceImplementation = new HashMap<>();
        interfaceImplementation.put(ProcessData.class, ProcessDataImpl.class);
        interfaceImplementation.put(DataReader.class, DataReaderImpl.class);
        interfaceImplementation.put(OperationStrategy.class, OperationStrategyImpl.class);
        interfaceImplementation.put(DataParser.class, DataParserImpl.class);
        interfaceImplementation.put(ShopService.class, ShopServiceImpl.class);
        interfaceImplementation.put(ReportData.class, ReportDataImpl.class);
        interfaceImplementation.put(DataWriter.class, DataWriterImpl.class);
        if (interfaceClazz.isInterface()) {
            return interfaceImplementation.get(interfaceClazz);
        }
        return interfaceClazz;
    }
}
