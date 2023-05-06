package af.mcit.Application.demoapplication.controller;

import af.mcit.Application.demoapplication.entity.Department;
import af.mcit.Application.demoapplication.service.DepartmentService;
import af.mcit.Application.demoapplication.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
    return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{departmentId}")
    public Department fechDepartmentById(@PathVariable Long departmentId){
    return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable Long departmentId){
      departmentService.deleteDepartmentById(departmentId);
        return  "Deleted Successfully!!";

    }
    @PutMapping("/departments/{departmentId}")
    public Department updateDepartment(@PathVariable Long departmentId,
                                       @RequestBody Department department){
return departmentService.updateDepartment(departmentId,department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fechDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
