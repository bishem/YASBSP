package fr.diginamic.sandbox.person;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

  Mono<Person> save(Person person);

  Mono<Person> find(Long id);

  Flux<Person> find(final List<Long> ids);

  Mono<Page<Person>> find(Person person, Pageable pageable);

  Mono<Page<Person>> find(Pageable pageable);

  Mono<Person> update(Person person);

  Mono<Void> delete(Long id);

  Mono<Void> delete(List<Long> ids);
}
