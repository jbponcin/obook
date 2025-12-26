package com.example.calibreapi.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.ZoneOffset;

@Converter(autoApply = false)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    // Formatter for dates with timezone offset (e.g., "1997-07-27 22:00:00+00:00")
    private static final DateTimeFormatter FORMATTER_WITH_OFFSET = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
    // Formatter for dates without timezone offset (e.g., "1997-07-27 22:00:00")
    private static final DateTimeFormatter FORMATTER_WITHOUT_OFFSET = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // Formatter for dates with milliseconds and timezone offset (e.g., "1997-07-27 22:00:00.000+00:00" or "1997-07-27 22:00:00.027000+00:00")
    private static final DateTimeFormatter FORMATTER_WITH_MILLIS_AND_OFFSET = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSXXX");
    // Formatter for dates with milliseconds without timezone offset (e.g., "1997-07-27 22:00:00.000" or "1997-07-27 22:00:00.027000")
    private static final DateTimeFormatter FORMATTER_WITH_MILLIS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");


    @Override
    public String convertToDatabaseColumn(LocalDateTime entityDateTime) {
        if (entityDateTime == null) {
            return null;
        }
        // Convert to UTC and format without milliseconds for consistency with typical SQLite storage
        return entityDateTime.atOffset(ZoneOffset.UTC).format(FORMATTER_WITHOUT_OFFSET);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String databaseColumn) {
        if (databaseColumn == null || databaseColumn.trim().isEmpty()) {
            return null;
        }

        // Try parsing with different formats
        try {
            // Try with milliseconds and offset first, as it's the most specific
            return LocalDateTime.parse(databaseColumn, FORMATTER_WITH_MILLIS_AND_OFFSET);
        } catch (DateTimeParseException e1) {
            try {
                // Then try with milliseconds without offset
                return LocalDateTime.parse(databaseColumn, FORMATTER_WITH_MILLIS);
            } catch (DateTimeParseException e2) {
                try {
                    // Then try with offset but no milliseconds
                    return LocalDateTime.parse(databaseColumn, FORMATTER_WITH_OFFSET);
                } catch (DateTimeParseException e3) {
                    try {
                        // Finally, try without offset or milliseconds
                        return LocalDateTime.parse(databaseColumn, FORMATTER_WITHOUT_OFFSET);
                    } catch (DateTimeParseException e4) {
                        // If all attempts fail, rethrow the original exception or a new one
                        throw new RuntimeException("Failed to parse LocalDateTime from database column: " + databaseColumn, e4);
                    }
                }
            }
        }
    }
}
