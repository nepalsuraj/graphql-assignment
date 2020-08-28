package com.graphql.test.exception;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.graphql.test.model.ErrorDetails;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Catches malformed request exceptions when calling the APIs
   * Supports error level logging.
   *
   * @param ex      The exception caught.
   * @param request The request that was made when the exception was caught.
   * @return return an error state response with HttpStatus BAD_REQUEST. Response
   *         contains the fields with error message that went wrong.
   */
  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    log.error("Caught Client Exception. request url: {} exception: {}",
        ((ServletWebRequest) request).getRequest().getRequestURI(), ex.getMessage());

    List<String> errors = ex.getBindingResult().getAllErrors().stream().map(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      return new StringBuilder().append(fieldName).append(" : ").append(errorMessage).toString();
    }).collect(Collectors.toList());

    ErrorDetails errorDetails = ErrorDetails.builder().timestamp(ZonedDateTime.now()).errors(errors).build();

    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  
  /**
   * Catches exceptions when calling the  APIs.
   * Supports error level logging.
   *
   * @param ex      The exception caught. A type of Exception in this case.
   * @param request The request that was made when the exception was caught
   * @return return an error state response with http status INTERNAL_SERVER_ERROR.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleManaerApprovalNotFoundException(Exception ex, WebRequest request) {
    log.error("Caught Client Exception. request url: {} exception: {}",
        ((ServletWebRequest) request).getRequest().getRequestURI(), ex.getMessage());
    ErrorDetails errorDetails = ErrorDetails.builder().timestamp(ZonedDateTime.now())
        .errors(Arrays.asList(ex.getMessage())).build();
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
