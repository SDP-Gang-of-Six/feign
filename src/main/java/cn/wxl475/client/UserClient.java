//package cn.wxl475.client;
//
//import com.ps.pojo.Result;
//import com.ps.pojo.User;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//
//@FeignClient("user")
//public interface UserClient {
//
//    //true为审核通过，false为其他
//    @PostMapping("/isSellerSafe")
//    Result isSellerSafe(@RequestBody User user);
//
//    @PostMapping("/getUseridByName")
//    Result getUseridByName(@RequestBody User user);
//}
