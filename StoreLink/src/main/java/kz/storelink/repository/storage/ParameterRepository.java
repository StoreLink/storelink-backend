package kz.storelink.repository.storage;

import kz.storelink.model.storage.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {
}
