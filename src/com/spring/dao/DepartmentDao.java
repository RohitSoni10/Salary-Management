package com.spring.dao; 
  import java.util.List;
  import com.spring.employee.Department;
import com.spring.model.CommonResponsibleDropDownObject; 
  public interface DepartmentDao {
  public void saveDepartment(Department department); 
  public List<Department> getDepartment(); 
  public Department getDepartmentById(Long id); 
  public Department updateDepartment(Long id); 
  public void deleteDepartment(Long id);
  public List<CommonResponsibleDropDownObject> getSelectionList();
  }
 