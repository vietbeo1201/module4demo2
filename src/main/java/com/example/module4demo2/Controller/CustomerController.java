package com.example.module4demo2.Controller;

import com.example.module4demo2.Model.Customer;
import com.example.module4demo2.Model.Province;
import com.example.module4demo2.Service.ICustomerService;
import com.example.module4demo2.Service.IProvinceService;
import com.example.module4demo2.Service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/management")
    public ModelAndView listCustomer(@RequestParam("search") Optional<String> search,@PageableDefault(size = 2) Pageable pageable) {
        try{
            Page<Customer> customers;
            if(search.isPresent()){
                customers = customerService.findAllByCusName(pageable, search.get());
            } else {
                customers = customerService.findWithPage(pageable);
            }
            ModelAndView modelAndView = new ModelAndView("/customer/list");

            modelAndView.addObject("customers", customers);
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("redirect:/customer/management");
        }

    }

//    @RequestMapping("/{id}")
//    public String showCustomer(@PathVariable("id") Customer customer, Model model) {
//        model.addAttribute("customer", customer);
//        return "for Debuging";
//    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create new customer successfully");
        return "redirect:/customer/management";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable("id") Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/update");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","update customer successfully");
        return "redirect:/customer/management";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete customer successfully");
        return "redirect:/customer/management";
    }

}
