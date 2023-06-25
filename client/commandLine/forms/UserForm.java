package client.commandLine.forms;

import client.commandLine.*;
import client.utility.*;
import common.exceptions.ExceptionInFileMode;
import common.util.ConsoleColors;
import common.util.User;

import java.util.Objects;

public class UserForm extends Form<User>{
    private final Printable console;
    private final UserInput scanner;

    public UserForm(Printable console) {
        this.console = (Console.isFileMode())
                ? new BlankConsole()
                : console;
        this.scanner = (Console.isFileMode())
                ? new ExecuteFileManager()
                : new ConsoleInput();
    }


    @Override
    public User build() {
        return new User(
                askLogin(),
                askPassword()
        );
    }

    public boolean askIfLogin(){
        for(;;) {
            console.print("У вас уже есть аккаунт? [yn]  ");
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input){
                case "y", "yes", "да", "д" -> {
                    return true;
                }
                case "n", "no", "нет", "н" -> {
                    return false;
                }
                default -> console.printError("Ответ не распознан");
            }
        }
    }

    private String askLogin(){
        String login;
        while (true){
            console.println(ConsoleColors.toColor("Введите ваш логин", ConsoleColors.GREEN));
            login = scanner.nextLine().trim();
            if (login.isEmpty()){
                console.printError("Логин не может быть пустым");
                if (Console.isFileMode()) throw new ExceptionInFileMode();
            }
            else{
                return login;
            }
        }
    }

    private String askPassword(){
        String pass;
        while (true){
            console.println(ConsoleColors.toColor("Введите пароль", ConsoleColors.GREEN));
            pass = (Objects.isNull(System.console()))
                    ? scanner.nextLine().trim()
                    : new String(System.console().readPassword());
            if (pass.isEmpty()){
                console.printError("Пароль не может быть пустым");
                if (Console.isFileMode()) throw new ExceptionInFileMode();
            }
            else{
                return pass;
            }
        }
    }
}
