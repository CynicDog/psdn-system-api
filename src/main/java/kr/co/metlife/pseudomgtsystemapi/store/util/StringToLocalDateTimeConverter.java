package kr.co.metlife.pseudomgtsystemapi.store.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Converter
public class StringToLocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    // MS-SQL DATETIME2(3) Format
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String convertToDatabaseColumn(LocalDateTime attribute){
        return attribute == null ? null : FORMATTER.format(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dbData){
        return dbData == null ? null : LocalDateTime.parse(dbData, FORMATTER);
    }
}
