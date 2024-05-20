package mz.org.fgh.mentoring.entity.role;

import io.micronaut.core.annotation.Creator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mz.org.fgh.mentoring.base.BaseEntity;
import mz.org.fgh.mentoring.dto.role.RoleDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Schema(name = "Role", description = "Represent the role a user can be granted")
@Entity(name = "Role")
@Table(name = "role")
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Role extends BaseEntity {

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @NotEmpty
    @Column(name = "code", nullable = false)
    private  String code;

    @NotEmpty
    @Column(name = "level", nullable = false)
    private  String level;

    @NotEmpty
    @Column(name = "HIERARCHY_LEVEL", nullable = false)
    private  int hierarchyLevel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    private List<RoleAuthority> roleAuthorities;

    @Creator
    public Role() {}

    public Role(RoleDTO roleDTO) {
        super(roleDTO);
        this.description = roleDTO.getDescription();
        this.code = roleDTO.getCode();
        this.level = roleDTO.getLevel();
        this.hierarchyLevel = roleDTO.getHierarchyLevel();
    }

    @Override
    public String toString() {
        return "Role{" +
                "description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", level='" + level + '\'' +
                ", hierarchyLevel=" + hierarchyLevel +
                ", roleAuthorities=" + roleAuthorities +
                '}';
    }
}
