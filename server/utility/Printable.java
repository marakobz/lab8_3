package server.utility;

import common.util.ConsoleColors;

public interface Printable {
    void println(String a);
    void print(String a);
    default void println(String a, ConsoleColors consoleColors){
        println(a);
    };
    default void print(String a, ConsoleColors consoleColors){
        print(a);
    };
    void printError(String a);
}

