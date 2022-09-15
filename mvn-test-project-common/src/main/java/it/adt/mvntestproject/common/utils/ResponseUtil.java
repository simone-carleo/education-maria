package it.adt.mvntestproject.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseUtil.class);

    private ResponseUtil() {

    }

    public static final <T> ResponseEntity<T> getOkResponse(final T body) {
        return getResponse(body, HttpStatus.OK);
    }

    public static final <T> ResponseEntity<T> getCreatedResponse(final T body) {
        return getResponse(body, HttpStatus.CREATED);
    }

    public static final <T> ResponseEntity<T> getResponse(final T body, final HttpStatus status) {
        return new ResponseEntity<>(body, status);
    }

    public static final <T> ResponseEntity<T> getBadRequestErrorResponse(final Exception e) {
        return getResponseEntity(e, HttpStatus.BAD_REQUEST);
    }

    public static final <T> ResponseEntity<T> getInternalServerErrorResponse(final Exception e) {
        return getResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static final <T> ResponseEntity<T> getNotFoundErrorResponse(final Exception e) {
        return getResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    public static final <T> ResponseEntity<T> getConflictErrorResponse(final Exception e) {
        return getResponseEntity(e, HttpStatus.CONFLICT);
    }

    public static final <T> ResponseEntity<T> getNoContentResponse() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public static final <T> ResponseEntity<T> getResponseEntity(final Exception e, final HttpStatus status) {
        LOGGER.error(e.getMessage());
        HttpHeaders headers = new HttpHeaders();
        String headerMessage = removeIndentationChars(e);
        if (headerMessage.length() > 3000)
            headerMessage = StringUtils.abbreviate(removeIndentationChars(e), 3000).concat("...");

        headers.add("error-message", headerMessage);
        return new ResponseEntity<>(headers, status);
    }

    public static final String removeIndentationChars(final Exception e) {
        // lascio solo caratteri "normali" e spazi
        return StringUtils.isNotBlank(e.getMessage()) ? e.getMessage().replaceAll("[^\\S' ']+", "") : String.format("Error type: %s", e.getClass().getName());// NOSONAR
    }
}
