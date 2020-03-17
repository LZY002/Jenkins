package fr.unice;

public class ExternalPartnerException extends Throwable {
    public ExternalPartnerException() {}

    public ExternalPartnerException(String n) {super(n); }

    public ExternalPartnerException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return "ExternalPartnerException on " + getMessage() + " ->" + getCause().toString();
    }
}
