package fr.diginamic.sandbox.person;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface PersonRepository extends JpaRepositoryImplementation<Person, Long> {
  Page<Person> findPageByIdIn(List<Long> ids, Pageable pageable);
}
