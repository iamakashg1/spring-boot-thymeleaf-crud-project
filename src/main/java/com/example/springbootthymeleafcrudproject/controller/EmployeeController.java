package com.example.springbootthymeleafcrudproject.controller;

import com.example.springbootthymeleafcrudproject.model.Employees;
import com.example.springbootthymeleafcrudproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class EmployeeController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    EmployeeService service;

    // Creating method handler for home page (index.html) to display the list of employee.
    @GetMapping("/")
    public String homepage(Model model){
        return findPaginated(1,  "firstName", "asc", model);
    }

    // add new employee method handler
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employees employee = new Employees();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    // Save employee method handler
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employees employee){
        service.saveEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
        // get employee from the service
        Employees employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
       this.service.deleteEmployeeById(id);
        return "redirect:/";
    }

    // handle pagination
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model ){
        int pageSize = 5;

        Page<Employees> page = service.findPaginated (pageNo,pageSize,sortField,sortDir);
        List<Employees> listEmployees = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        // Sorting Attribute
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
         return "index";

    }

}
