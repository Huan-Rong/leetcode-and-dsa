package site.bulibucai;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

public class StringsToIntsConverter implements ArgumentConverter {
    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (source instanceof String) {
            String[] strings = ((String) source).split("\\s*,\\s*");
            return Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        }
        return null;
    }
}
