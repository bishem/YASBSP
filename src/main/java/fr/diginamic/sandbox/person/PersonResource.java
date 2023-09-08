package fr.diginamic.sandbox.person;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PersonResource implements PersonApi {

  private final PersonService service;

  @Override
  public Mono<ResponseEntity<Person>> create(final Person person) {
    return service
        .save(person)
        .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Void>> delete(final Long id) {
    return service
        .delete(id)
        .map(deleted -> ResponseEntity
            .noContent()
            .build());
  }

  @Override
  public Mono<ResponseEntity<Void>> delete(final List<Long> ids) {
    return service
        .delete(ids)
        .map(deleted -> ResponseEntity
            .noContent()
            .build());
  }

  @Override
  public Mono<ResponseEntity<Person>> fetch(final Long id) {
    return service
        .find(id)
        .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Page<Person>>> fetch(final List<Long> ids, final Pageable pageable) {
    return service
        .find(ids, pageable)
        .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Page<Person>>> fetch(final Person person, final Pageable pageable) {
    return service
        .find(person, pageable)
        .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Page<Person>>> fetch(final Pageable pageable) {
    return service
        .find(pageable)
        .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Person>> update(final Person person) {
    return service
        .update(person)
        .map(updated -> ResponseEntity
            .accepted()
            .body(updated));
  }
}
