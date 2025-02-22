package kr.co.metlife.pseudomgtsystemapi.store.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ParameterValueConverter implements AttributeConverter<Object, String> {

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        if (attribute == null) {
            return null;
        }
        if (attribute instanceof Boolean) {
            return attribute.toString();
        } else if (attribute instanceof Integer) {
            return attribute.toString();
        } else if (attribute instanceof String) {
            return (String) attribute;
        }
        return attribute.toString();
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        if ("true".equalsIgnoreCase(dbData) || "false".equalsIgnoreCase(dbData)) {
            return Boolean.parseBoolean(dbData);
        } else {
            try {
                return Integer.parseInt(dbData);
            } catch (NumberFormatException e) {
                return dbData;
            }
        }
    }
}
