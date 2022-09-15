package it.adt.mvntestproject.common.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeSerializer extends StdSerializer<OffsetDateTime> {
   
    /**
     *
     */
    private static final long serialVersionUID = 3449503416444981292L;

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    public DateTimeSerializer() {
        this(null);
    }

    public DateTimeSerializer(Class<OffsetDateTime> t) {
        super(t);
    }

    @Override
    public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider arg2) throws IOException {
        if (formatter == null) {
            formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        }
        gen.writeString(formatter.format(value));
    }
}