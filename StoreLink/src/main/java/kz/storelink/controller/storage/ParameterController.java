package kz.storelink.controller.storage;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.storage.Parameter;
import kz.storelink.service.storage.ParameterService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parameter")
@AllArgsConstructor
public class ParameterController {

    private final ParameterService parameterService;

    @ApiOperation(value = "Show all parameters", response = List.class)
    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Parameter> showAllParameters() {
        return parameterService.showAllParameters();
    }

    @ApiOperation(value = "Get parameter by id", response = List.class)
    @PostMapping("/{parameterId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Parameter getParameterById(@PathVariable("parameterId") Long parameterId) {
        return parameterService.getParameterById(parameterId);
    }

    @ApiOperation(value = "Get parameter by name", response = Parameter.class)
    @GetMapping("/name/{parameterName}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Parameter> getParameterByName(@PathVariable("parameterName") String parameterName) {
        List<Parameter> parameter = parameterService.getParameterByName(parameterName);
        return parameter;
    }

    @ApiOperation(value = "Add new parameter into database", response = List.class)
    @PostMapping("/new")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Parameter saveParameter(@RequestBody() Parameter parameter) {
        return parameterService.saveParameter(parameter);
    }

    @ApiOperation(value = "Delete parameter from database", response = List.class)
    @PostMapping("/delete/{parameterId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteParameterById(@PathVariable("parameterId") Long parameterId) {
        parameterService.deleteParameterById(parameterId);
        return "parameter deleted successfully";
    }

    @ApiOperation(value = "Update all fields by id", response = Parameter.class)
    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Parameter updateParameter(@RequestBody Parameter parameter) {
        return parameterService.saveParameter(parameter);
    }

    @ApiOperation(value = "Update only parameter name", response = Parameter.class)
    @PatchMapping("update/name")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Parameter updateParameterName(@RequestParam Long parameterId, @RequestParam String parameterName) {
        return parameterService.updateParameterName(parameterId, parameterName);
    }

    @ApiOperation(value = "Update only storage type image", response = Parameter.class)
    @PatchMapping("update/image")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Parameter updateParameterImage(@RequestParam Long parameterId, @RequestParam String parameterImage) {
        return parameterService.updateParameterImage(parameterId, parameterImage);
    }

}
