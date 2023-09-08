package fr.diginamic.sandbox.person;

import static fr.diginamic.sandbox.core.ExceptionAdvice.notFound;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonServiceImplementation implements PersonService {

  private final PersonRepository repository;

  @Override
  public Mono<Person> save(final Person person) {
    Assert.isNull(person.getId(), "person id must be null");
    return Mono.just(repository.save(person));
  }

  @Override
  public Mono<Person> find(final Long id) {
    return Mono.just(repository.findById(id).orElseThrow(notFound("could not find person with provided id")));
  }

  @Override
  public Mono<Page<Person>> find(final Pageable pageable) {
    return Mono.just(repository.findAll(pageable));
  }

  @Override
  public Mono<Page<Person>> find(final List<Long> ids, final Pageable pageable) {
    return Mono.just(repository.findPageByIdIn(ids, pageable));
  }

  @Override
  public Mono<Page<Person>> find(final Person person, final Pageable pageable) {
    return Mono.just(repository.findAll(Example.of(person), pageable));
  }

  @Override
  public Mono<Void> delete(final Long id) {
    repository.deleteById(id);
    return Mono.empty();
  }

  @Override
  public Mono<Void> delete(final List<Long> ids) {
    repository.deleteAllById(ids);
    return Mono.empty();
  }

  @Override
  public Mono<Person> update(final Person person) {
    Assert.notNull(person.getId(), "person id must not be null");
    return Mono.just(repository.save(person));
  }
}
