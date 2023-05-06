package af.mcit.Application.demoapplication.service;

import af.mcit.Application.demoapplication.entity.Department;
import af.mcit.Application.demoapplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
   @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department dprDb= departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            dprDb.setDepartmentName(department.getDepartmentName());
                    }
        if(Objects.nonNull(department.getDepartmentAddress())&&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            dprDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            dprDb.setDepartmentCode(department.getDepartmentCode());
        }
return departmentRepository.save(dprDb);
    }

    @Override
    public Department  fetchDepartmentByName(String departmentName) {
//        return departmentRepository.findByDepartmentName(departmentName);
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
