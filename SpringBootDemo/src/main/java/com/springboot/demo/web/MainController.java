package com.springboot.demo.web;

import com.springboot.demo.domain.Banner;
import com.springboot.demo.exception.BannerMissException;
import com.springboot.demo.tool.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Created By ShenXi
 * @Created On 2019/9/15 15:01
 * @ClassName : MainController
 * @Description :
 */
@RestController
public class MainController {
    @GetMapping("/success")
    public JSONResult success() {
        return JSONResult.success();
    }

    @GetMapping("/data-error")
    public JSONResult error() {
        return JSONResult.failMsg("校验失败！");
    }


    @GetMapping("/fail")
    public JSONResult fail() {

        return null;

        //return JSONResult.custom("500", "系统错误！");
    }

    @GetMapping("/banner")
    public JSONResult getBanner() {
        Banner banner = null;

        if (banner == null){
            throw new BannerMissException();
        }
        return JSONResult.success();
    }

    @GetMapping("/define")
    public JSONResult define() {
        return null;
        /*return JSONResult.custom("201", "自定义！", new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String, Object>() {{
                put("id", 1);
                put("name", "张三");
                put("age", 15);
            }});
            add(new HashMap<String, Object>() {{
                put("id", 2);
                put("name", "李四");
                put("age", 17);
            }});
            add(new HashMap<String, Object>() {{
                put("id", 3);
                put("name", "王五");
                put("age", 22);
            }});
        }});*/
    }
}
