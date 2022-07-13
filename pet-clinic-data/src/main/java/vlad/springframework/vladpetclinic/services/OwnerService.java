package vlad.springframework.vladpetclinic.services;

import vlad.springframework.vladpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);

}
