package com.store.webstore.exceptions;

public class CreditCardValidationException extends RuntimeException{
  public CreditCardValidationException(String message) {
    super(message);
  }
}

