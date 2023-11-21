package br.com.vidamaterna.mspost.service.exception;

public class ServerNotAvailableException extends RuntimeException {
  public ServerNotAvailableException(String message) {
    super(message);
  }
}
