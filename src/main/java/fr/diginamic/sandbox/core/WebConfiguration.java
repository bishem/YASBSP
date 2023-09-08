package fr.diginamic.sandbox.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

@Configuration
public class WebConfiguration implements WebFluxConfigurer {

  @Override
  public void configureArgumentResolvers(final ArgumentResolverConfigurer configurer) {
    configurer.addCustomResolver(new ReactivePageableHandlerMethodArgumentResolver());
  }
}
