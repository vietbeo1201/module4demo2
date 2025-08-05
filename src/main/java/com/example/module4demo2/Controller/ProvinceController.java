package com.example.module4demo2.Controller;

import com.example.module4demo2.Model.Province;
import com.example.module4demo2.Service.ICustomerService;
import com.example.module4demo2.Service.IProvinceService;
import com.example.module4demo2.Service.impl.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService iProvinceService;

    @GetMapping("/all")
    public ModelAndView listProvince() {
        ModelAndView modelAndView = new ModelAndView("/province/list");
        Iterable<Province> province = iProvinceService.findAll();
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createProvince(@ModelAttribute("province" ) Province province, RedirectAttributes redirectAttributes) {
        iProvinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "create new province successfully");
        return "redirect:/province/all";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateProvince(@PathVariable Long id) {
        Optional<Province> province = iProvinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/update");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }

    }

}
