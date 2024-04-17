package cn.wxl475.client;

import cn.wxl475.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@FeignClient("user")
public interface UserClient {
    @GetMapping("/user/getNicknameById/{uid}")
    Result getNicknameById(@PathVariable Long uid);
}
