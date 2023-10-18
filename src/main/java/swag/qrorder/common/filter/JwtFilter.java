package swag.qrorder.common.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;
import swag.qrorder.common.util.TokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final TokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("[JwtFilter - Request URL] : {}", request.getRequestURI());
        List<String> list = List.of(
                "/qrorder/restaurants",
                "/qrorder/seats",
                "/qrorder/items",
                "/qrorder/owner"
        );
        boolean flag = list.stream().anyMatch(url -> request.getRequestURI().startsWith(url));
        // 현재 URL 이 LIST 안에 포함되있는걸로 시작되나?
        if(!flag) {
            filterChain.doFilter(request,response);
            return;
        }

        String header = request.getHeader("Authorization");
        log.info("[JwtFilter - header] : {}",header);
        if(header != null && !header.equalsIgnoreCase("")){
            if(header.startsWith("Bearer")){
                String access_token = header.split(" ")[1];
                if(tokenUtil.isValidToken(access_token)){
                    request.setAttribute("restaurantId",
                            tokenUtil.getClaims(access_token).getSubject());
                    filterChain.doFilter(request,response);
                }
            }
        } else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
}