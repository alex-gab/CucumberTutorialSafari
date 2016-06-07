package com.alex.nicebank.utils;

public final class Exceptions {
    public static RuntimeException newRuntimeException(final String message,
                                                       final Exception cause) {
        return new RuntimeException(message, cause);
    }

    public static RuntimeException newRuntimeException(final String messageFormat,
                                                       final Exception cause,
                                                       final Object... messageArgs) {
        return new RuntimeException(String.format(messageFormat, messageArgs), cause);
    }
}
