package mz.org.fgh.mentoring.repository.employee;

import io.micronaut.data.annotation.Repository;
import mz.org.fgh.mentoring.entity.employee.Employee;
import mz.org.fgh.mentoring.entity.user.User;
import mz.org.fgh.mentoring.util.DateUtils;
import mz.org.fgh.mentoring.util.LifeCycleStatus;

import java.util.Optional;
import java.util.UUID;

@Repository
public abstract class EmployeeRepositoryImpl implements EmployeeRepository{

    public Employee createOrUpdate(Employee employee, User user) {
        Optional<Employee> possibleEmployee = findByUuid(employee.getUuid());

        if (possibleEmployee.isPresent()) {
            employee.setId(possibleEmployee.get().getId());
            employee.setUpdatedBy(user.getUuid());
            employee.setUpdatedAt(DateUtils.getCurrentDate());
            return update(employee);
        } else {
            employee.setCreatedBy(user.getUuid());
            employee.setUuid(UUID.randomUUID().toString());
            employee.setCreatedAt(DateUtils.getCurrentDate());
            employee.setLifeCycleStatus(LifeCycleStatus.ACTIVE);
            return save(employee);
        }
    }
}
