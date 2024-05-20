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
import mz.org.fgh.mentoring.dto.role.UserRoleDTO;
import mz.org.fgh.mentoring.service.user.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller(RESTAPIMapping.USER_ROLE_CONTROLLER)
public class UserRoleController extends BaseController {
    public static final Logger LOG = LoggerFactory.getLogger(UserRoleController.class);

    @Inject
    private UserRoleService userRoleService;

    @Operation(summary = "Return a list off all UserRoles")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @Tag(name = "UserRole")
    @Get("/getAll")
    public List<UserRoleDTO> getAll() {
       List<UserRoleDTO> userRoles = userRoleService.findAllUserRoles();
       return userRoles;
    }
}
