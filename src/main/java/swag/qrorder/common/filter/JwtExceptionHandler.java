package swag.qrorder.common.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;
import swag.qrorder.common.error.JwtErrorCode;
import swag.qrorder.common.util.ErrorUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtExceptionHandler extends OncePerRequestFilter {
    private final ErrorUtil errorUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("[JwtExceptionHandler - Request URL] : {}",request.getRequestURI());
        try {
            doFilter(request,response,filterChain);
        } catch (ExpiredJwtException exception){
            errorUtil.setResponse(response, JwtErrorCode.Token_Expired);
        } catch (SignatureException exception){
            errorUtil.setResponse(response,JwtErrorCode.Token_Tampered);
        } catch (UnsupportedJwtException exception){
            errorUtil.setResponse(response,JwtErrorCode.Token_Unsupported);
        } catch(MalformedJwtException | IllegalArgumentException exception){
            errorUtil.setResponse(response,JwtErrorCode.Token_Claims_Empty);
        } catch (ResponseStatusException exception){
            errorUtil.setResponse(response,JwtErrorCode.Token_isNull);
        }
    }
}
