package com.store.webstore.service;

import com.store.webstore.exceptions.CreditCardValidationException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidationService {
  private static final String CREDIT_CARD_FORMAT = "^[0-9]{16}$";
  private static final Set<String> STOLEN_CREDIT_CARDS = new HashSet<>();

  public CreditCardValidationService() {
    STOLEN_CREDIT_CARDS.add("1111111111111111");
    STOLEN_CREDIT_CARDS.add("9999888877776666");
  }

  public void validate(String creditCardNumber) {
    validateNumberOfDigits(creditCardNumber);
    validateNotStolenCreditCard(creditCardNumber);
  }

  private void validateNumberOfDigits(String creditCardNumber) {
    if (!creditCardNumber.matches(CREDIT_CARD_FORMAT)) {
      throw new CreditCardValidationException(String.format("%s is invalid credit card", creditCardNumber));
    }
  }

  private void validateNotStolenCreditCard(String creditCardNumber) {
    System.out.println(STOLEN_CREDIT_CARDS.stream().collect(Collectors.joining()));
    System.out.println(creditCardNumber);
    if (STOLEN_CREDIT_CARDS.contains(creditCardNumber)) {
      throw new CreditCardValidationException(String.format("%s is a stolen credit card", creditCardNumber));
    }
  }
}

