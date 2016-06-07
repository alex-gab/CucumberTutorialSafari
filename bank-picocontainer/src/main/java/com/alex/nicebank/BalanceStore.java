package com.alex.nicebank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static com.alex.nicebank.utils.Exceptions.newRuntimeException;

public final class BalanceStore {
    private static String BALANCE_FILE_PATH = "./balance";

    public static void clear() {
        new File(BALANCE_FILE_PATH).delete();

        setBalance(new Money(0, 0));
    }

    public static Money getBalance() {
        final File balanceFile = new File(BALANCE_FILE_PATH);
        Scanner scanner;
        try {
            scanner = new Scanner(balanceFile);
        } catch (FileNotFoundException e) {
            throw newRuntimeException("Could not find the file %s to read", e, BALANCE_FILE_PATH);
        }
        final Money balance = new Money(scanner.nextLine());
        scanner.close();

        return balance;
    }

    public static void setBalance(final Money newBalance) {

        PrintWriter writer;
        try {
            writer = new PrintWriter(BALANCE_FILE_PATH, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw newRuntimeException("Could open a stream to: %s.", e, BALANCE_FILE_PATH);
        }
        writer.println(newBalance.toString());
        writer.close();
    }
}
