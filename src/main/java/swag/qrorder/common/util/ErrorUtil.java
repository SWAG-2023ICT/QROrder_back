package swag.qrorder.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import swag.qrorder.common.model.ApiResponse;
import swag.qrorder.common.model.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ErrorUtil {
    private final ObjectMapper objectMapper;
    public void setResponse(HttpServletResponse httpServletResponse, ApiResponse errorCode) throws IOException {
        Response<?> errorResponse = Response.builder()
                        .code(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build();
        httpServletResponse.setStatus(errorResponse.getCode());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter()
                .write(objectMapper.writeValueAsString(errorResponse));
    }
}