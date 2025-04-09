package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.service.ICategoryService;

@Controller
public class AdminController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/category")
    public String category(@RequestParam(defaultValue = "0") Integer page ,@RequestParam(defaultValue = "5") Integer size, Model model) {
//        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("categories", categoryService.findByPagination(page,size));
        model.addAttribute("totalPages", categoryService.countTotalPages(size));
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        return "category";
    }

    @GetMapping("/product")
    public String product() {
        return "product";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
}
