package fr.diginamic.sandbox.person;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "Person", description = "API for the person domain")
@RequestMapping(value = "person", produces = "application/json")
public interface PersonApi {

  @PostMapping(consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "create a person")
  default ResponseEntity<Mono<Person>> create(@RequestBody final Person person) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Mono.empty());
  }

  @GetMapping("{id}")
  @Operation(summary = "fetch a person by id")
  default ResponseEntity<Mono<Person>> fetch(@PathVariable final Long id) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Mono.empty());
  }

  @GetMapping("all")
  @Operation(summary = "fetch a list of persons by ids")
  default ResponseEntity<Flux<Person>> fetch(@RequestParam final List<Long> ids) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Flux.empty());
  }

  @GetMapping("match")
  @Operation(summary = "fetch a list of persons by example")
  default ResponseEntity<Mono<Page<Person>>> fetch(@RequestParam final Person person, @ParameterObject final Pageable pageable) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Mono.empty());
  }

  @GetMapping
  @Operation(summary = "fetch a page of persons")
  default ResponseEntity<Mono<Page<Person>>> fetch(@ParameterObject final Pageable pageable) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Mono.empty());
  }

  @PutMapping(consumes = "application/json")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @Operation(summary = "update a person")
  default ResponseEntity<Mono<Person>> update(@RequestBody final Person person) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Mono.empty());
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "delete a person by id")
  default ResponseEntity<Mono<Void>> delete(@PathVariable final Long id) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Mono.empty());
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "delete a list of persons by ids")
  default ResponseEntity<Mono<Void>> delete(@RequestParam final List<Long> ids) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Mono.empty());
  }
}
