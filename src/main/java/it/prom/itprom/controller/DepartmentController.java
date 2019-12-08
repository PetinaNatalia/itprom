package it.prom.itprom.controller;

import it.prom.itprom.entity.Department;
import it.prom.itprom.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public String admin() {
        return "departments";
    }

    @PostMapping("/departments")
    @ResponseBody
    public List<Department> list() {
        return departmentRepository.findAll();
    }

    @GetMapping("/add_department")
    public String getForm(Model model) {
        model.addAttribute("department", new Department());
        return "add_department";
    }

    @PostMapping("/add_department")
    public String add(@ModelAttribute Department department) {
        departmentRepository.save(department);
        departmentRepository.flush();
        return "redirect:/departments";
    }

    @GetMapping("/edit_department")
    public String updateForm(Model model) {
        model.addAttribute("department", new Department());
        return "edit_department";
    }

    @PutMapping("/edit_department/{departmentId}")
    public String replaceDepartment(@PathVariable Integer departmentId, @RequestAttribute Department newDepartment) {
            Department intoRep = departmentRepository.getOne(departmentId);
            intoRep.setName(newDepartment.getName());
            intoRep.setNote(newDepartment.getNote());
            System.out.println(intoRep.getId() + intoRep.getName());
            departmentRepository.save(intoRep);
            departmentRepository.flush();
        return "redirect:/departments";
    }

    @DeleteMapping("/departments/{departmentId}")
    @ResponseBody
    public String delete(@PathVariable Integer departmentId, HttpServletResponse response) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            departmentRepository.delete(department.get());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return "OK";
    }

}
