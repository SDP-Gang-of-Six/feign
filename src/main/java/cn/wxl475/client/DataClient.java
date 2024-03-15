package cn.wxl475.client;

import cn.wxl475.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@FeignClient("data")
public interface DataClient {
    @PostMapping("/uploadImages")
    Result uploadImages(@RequestHeader String Authorization, @RequestBody ArrayList<MultipartFile> images);
}
