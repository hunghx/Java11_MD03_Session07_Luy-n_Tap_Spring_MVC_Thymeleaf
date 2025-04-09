package ra.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.edu.dto.FormRequest;

@Controller
public class Form {
    @GetMapping("/form")
    public String form(){
        return "form";
    }
    @PostMapping("/form")
    public String submit(@ModelAttribute FormRequest request){
        return "form";
    }
}
