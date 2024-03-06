package cn.wxl475.config;


import com.ps.exception.MyFeignException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.nio.charset.StandardCharsets;

import static feign.FeignException.errorStatus;


@Slf4j
@Configuration
public class FeignErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(final String methodKey, final Response response) {
    log.error("feign error, request url:{} status:{}", response.request().toString(), response.status());
    try {
      if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()){
        String body = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
        JSONObject jsonObject = JSONObject.fromObject(body);
        return new MyFeignException(jsonObject.getString("msg"));
      }
      return errorStatus(methodKey, response);
    }
    catch (Exception e){
      return e;
    }
  }
}
