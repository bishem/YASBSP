package fr.diginamic.sandbox.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class PersonController {

  private final PersonService service;

  @GetMapping("/home")
  public Mono<Rendering> home() {
    return Mono.just(Rendering
        .view("home")
        .modelAttribute("titre", "Welcome ..")
        .build());
  }
}
