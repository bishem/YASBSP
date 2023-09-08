package fr.diginamic.sandbox.person;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PersonController {

  private final PersonService service;

  @GetMapping("/home")
  public Mono<Rendering> home(final Pageable pageable) {
    return service
        .find(pageable)
        .doOnNext(personns -> log.info("personns: {}", personns))
        .map(personns -> Rendering
            .view("home")
            .modelAttribute("titre", "Welcome ..")
            .modelAttribute("personns", personns)
            .build());
  }
}
