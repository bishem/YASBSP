package fr.diginamic.sandbox.core;

import java.util.function.Supplier;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler({ ResourceNotFoundException.class })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorDto handleNotFound(final Exception e) {
    return buildError(e, HttpStatus.NOT_FOUND.value());
  }

  @ExceptionHandler({
      InvalidRequestException.class,
      JsonProcessingException.class,
      IllegalArgumentException.class,
      MethodArgumentNotValidException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto handleBadRequest(final Exception e) {
    return buildError(e, HttpStatus.BAD_REQUEST.value());
  }

  private static ErrorDto buildError(final Throwable e, final int status) {
    return ErrorDto.builder()
        .status(status)
        .message(e.getMessage())
        .trace(ExceptionUtils.getStackFrames(e))
        .build();
  }

  public static Supplier<ResourceNotFoundException> notFound(final String message) {
    return () -> new ResourceNotFoundException(message);
  }

  public static Supplier<InvalidRequestException> badRequest(final String message) {
    return () -> new InvalidRequestException(message);
  }
}
