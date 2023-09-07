package fr.diginamic.sandbox.core;

public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(final String message) {
    super(message);
  }
}
