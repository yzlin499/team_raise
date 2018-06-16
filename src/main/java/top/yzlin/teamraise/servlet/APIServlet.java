package top.yzlin.teamraise.servlet;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class APIServlet {

    @RequestMapping("/submitflag")
    public void submitFlag(@RequestBody JSONObject data) {
        switch (data.getString("flagType").toLowerCase()) {
            case "goal":


        }
    }
}
