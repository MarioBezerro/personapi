package one.digitalinnovationpersonapi.repositories;

import one.digitalinnovationpersonapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
