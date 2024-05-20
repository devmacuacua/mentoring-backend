package mz.org.fgh.mentoring.service.user;

import jakarta.inject.Singleton;
import mz.org.fgh.mentoring.entity.role.UserRole;
import mz.org.fgh.mentoring.dto.role.UserRoleDTO;
import mz.org.fgh.mentoring.repository.role.UserRoleRepository;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public List<UserRoleDTO> findAllUserRoles() {
        List<UserRole> userRoleList = this.userRoleRepository.findAll();
        List<UserRoleDTO> users = new ArrayList<UserRoleDTO>();
        for (UserRole user: userRoleList) {
            UserRoleDTO userDTO = new UserRoleDTO(user);
            users.add(userDTO);
        }
        return users;
    }
}
