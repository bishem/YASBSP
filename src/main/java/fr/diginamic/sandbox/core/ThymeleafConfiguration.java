package fr.diginamic.sandbox.core;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ThymeleafConfiguration {

  /**
   * Configuration pour le chargement des messages Intenationaux messages.properties
   * 
   * @return
   */
  @Bean
  MessageSource messageSource() {
    final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("i18n/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
