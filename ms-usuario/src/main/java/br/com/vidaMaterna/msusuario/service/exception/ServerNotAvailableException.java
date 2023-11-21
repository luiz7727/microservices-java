package br.com.vidaMaterna.msusuario.service.exception;

public class ServerNotAvailableException extends RuntimeException {
  public ServerNotAvailableException(String message) {
    super(message);
  }
}
