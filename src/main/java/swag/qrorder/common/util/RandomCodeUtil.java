package swag.qrorder.common.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomCodeUtil {
    public String createRandomCode(int count){
        return RandomStringUtils.random(count,true,true);
    }
}
