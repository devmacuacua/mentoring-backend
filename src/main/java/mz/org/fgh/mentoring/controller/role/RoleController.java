package mz.org.fgh.mentoring.controller.role;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import mz.org.fgh.mentoring.api.RESTAPIMapping;
import mz.org.fgh.mentoring.base.BaseController;
import mz.org.fgh.mentoring.dto.role.RoleDTO;
import mz.org.fgh.mentoring.service.user.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller(RESTAPIMapping.ROLE_CONTROLLER)
public class RoleController extends BaseController {
    public static final Logger LOG = LoggerFactory.getLogger(RoleController.class);

    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @Operation(summary = "Return a list off all UserRoles")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @Tag(name = "Role")
    @Get("/getAll")
    public List<RoleDTO> getAll() {
       List<RoleDTO> userRoles = roleService.findAllRoles();
       return userRoles;
    }
}
