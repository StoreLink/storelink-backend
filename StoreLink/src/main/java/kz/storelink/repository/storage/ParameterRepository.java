package kz.storelink.repository.storage;

import kz.storelink.model.storage.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    List<Parameter> findByParameterNameLike(String parameterName);

}
