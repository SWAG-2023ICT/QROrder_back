package swag.qrorder.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Response<T> {
    private final int code;
    private final String message;
    private final String exceptionMessage;
    private final T t;
}
