package mz.org.fgh.mentoring.service.user;

import jakarta.inject.Singleton;
import mz.org.fgh.mentoring.entity.role.Role;
import mz.org.fgh.mentoring.entity.role.UserRole;
import mz.org.fgh.mentoring.dto.role.RoleDTO;
import mz.org.fgh.mentoring.dto.role.UserRoleDTO;
import mz.org.fgh.mentoring.repository.role.RoleRepository;
import mz.org.fgh.mentoring.repository.role.UserRoleRepository;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDTO> findAllRoles() {
        List<Role> userRoleList = this.roleRepository.findAll();
        List<RoleDTO> users = new ArrayList<RoleDTO>();
        for (Role role: userRoleList) {
            RoleDTO userDTO = new RoleDTO(role);
            users.add(userDTO);
        }
        return users;
    }
}
