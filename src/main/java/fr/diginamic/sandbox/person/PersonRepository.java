package fr.diginamic.sandbox.person;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface PersonRepository extends JpaRepositoryImplementation<Person, Long> {}
