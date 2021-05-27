package kz.storelink.service.storage;

import kz.storelink.model.storage.Parameter;
import kz.storelink.repository.storage.ParameterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ParameterService {

    private ParameterRepository parameterRepository;

    public List<Parameter> showAllParameters() {
        return parameterRepository.findAll();
    }

    public Parameter getParameterById(Long parameterId) {
        Parameter parameter = parameterRepository.findById(parameterId).orElse(null);
        System.out.println("Parameter searching by id: " + parameter);
        return parameter;
    }

    public List<Parameter> getParameterByName(String parameterName) {
        System.out.println("Parameter searching by name '" + parameterName + "' founded");
        return parameterRepository.findByParameterNameLike(parameterName);
    }

    public Parameter saveParameter(Parameter parameter) {
        return parameterRepository.save(parameter);
    }

    public void deleteParameterById(Long parameterId) {
        parameterRepository.deleteById(parameterId);
    }

    public Parameter updateParameterName(Long parameterId, String parameterName) {
        Parameter parameter = parameterRepository.findById(parameterId).get();
        parameter.setParameterName(parameterName);
        return parameterRepository.save(parameter);
    }

    public Parameter updateParameterImage(Long parameterId, String parameterImage) {
        Parameter parameter = parameterRepository.findById(parameterId).get();
        parameter.setParameterImage(parameterImage);
        return parameterRepository.save(parameter);
    }

}
