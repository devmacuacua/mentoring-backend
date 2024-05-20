package mz.org.fgh.mentoring.entity.authority;

import io.micronaut.core.annotation.Creator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mz.org.fgh.mentoring.base.BaseEntity;
import mz.org.fgh.mentoring.entity.role.RoleAuthority;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Schema(name = "Authority", description = "Represent the role a user can be granted")
@Entity(name = "Authority")
@Table(name = "authority")
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Authority extends BaseEntity {

    @NotEmpty
    @Column(name = "module", nullable = false)
    private  String module;

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @NotEmpty
    @Column(name = "code", nullable = false)
    private  String code;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "authority")
    private List<RoleAuthority> roleAuthorities;

    @Creator
    public Authority(){}

    @Override
    public String toString() {
        return "Authority{" +
                "module='" + module + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", roleAuthorities='" + roleAuthorities + '\'' +
                '}';
    }
}
