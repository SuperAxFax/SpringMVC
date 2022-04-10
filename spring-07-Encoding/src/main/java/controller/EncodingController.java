package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class EncodingController {
    @PostMapping("/e/t1")
    public String test(String name, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        System.out.println("从前端接受到的名字为:"+name);
        model.addAttribute("msg",name);
        return "hello";
    }
}
