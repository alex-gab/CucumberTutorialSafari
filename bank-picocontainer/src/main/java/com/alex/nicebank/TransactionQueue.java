package com.alex.nicebank;


import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static com.alex.nicebank.utils.Exceptions.newRuntimeException;
import static java.lang.String.format;

public final class TransactionQueue {
    private static final String MESSAGES_FOLDER = "./messages";
    private static final String MESSAGE_FILE_PATH = "%s/%03d";
    private int nextId = 1;

    public static void clear() {
        try {
            FileUtils.deleteDirectory(new File(MESSAGES_FOLDER));
        } catch (IOException e) {
            throw newRuntimeException("Could not delete directory: %s.", e, MESSAGES_FOLDER);
        }
        new File(MESSAGES_FOLDER).mkdirs();
    }

    public final void write(final String transaction) {
        final String messageFilePath = format(MESSAGE_FILE_PATH, MESSAGES_FOLDER, nextId);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(messageFilePath, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw newRuntimeException("Could open a stream to: %s.", e, messageFilePath);
        }
        writer.println(transaction);
        writer.close();
        nextId++;
    }

    public final String read() {
        final File messagesFolder = new File(MESSAGES_FOLDER);
        final File[] messages = messagesFolder.listFiles();

        String message = "";

        if (messages != null && messages.length > 0) {
            Arrays.sort(messages, (f1, f2) -> Integer.parseInt(f1.getName())
                    - Integer.parseInt(f2.getName()));

            Scanner scanner;
            try {
                scanner = new Scanner(messages[0]);

                if (scanner.hasNextLine()) {
                    message = scanner.nextLine();
                    scanner.close();

                    // Delete it
                    messages[0].delete();
                } else {
                    scanner.close();
                }

            } catch (final FileNotFoundException e) {
                throw newRuntimeException("Could not find the file to read", e);
            }
        }

        return message;
    }
}
