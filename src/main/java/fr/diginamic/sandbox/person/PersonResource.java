package fr.diginamic.sandbox.person;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PersonResource implements PersonApi {

  private final PersonService service;

  @Override
  public ResponseEntity<Mono<Person>> create(final Person person) {
    return ResponseEntity.ok(service.save(person));
  }

  @Override
  public ResponseEntity<Mono<Void>> delete(final Long id) {
    return ResponseEntity.ok(service.delete(id));
  }

  @Override
  public ResponseEntity<Mono<Void>> delete(final List<Long> ids) {
    return PersonApi.super.delete(ids);
  }

  @Override
  public ResponseEntity<Mono<Person>> fetch(final Long id) {
    return PersonApi.super.fetch(id);
  }

  @Override
  public ResponseEntity<Flux<Person>> fetch(final List<Long> ids) {
    return PersonApi.super.fetch(ids);
  }

  @Override
  public ResponseEntity<Mono<Page<Person>>> fetch(final Person person, final Pageable pageable) {
    return PersonApi.super.fetch(person, pageable);
  }

  @Override
  public ResponseEntity<Mono<Page<Person>>> fetch(final Pageable pageable) {
    return PersonApi.super.fetch(pageable);
  }

  @Override
  public ResponseEntity<Mono<Person>> update(final Person person) {
    return PersonApi.super.update(person);
  }
}
