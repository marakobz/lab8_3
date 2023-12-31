package server.commands;

import common.exceptions.WrongAmountOfElementsException;
import common.util.ClientRequest;
import common.util.ResponseCode;
import common.util.ServerResponse;
import common.util.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.utility.ResponseOutputer;

/**
 * Command 'help'. Saves the collection to a file.
 */
public class HelpCommand extends AbstractCommand{
    private Logger logger = LoggerFactory.getLogger("Help command");

    public HelpCommand(){
        super("help", "show all commands");
    }

    /**
     * Execute of 'help' command.
     */

    @Override
    public ServerResponse execute(ClientRequest request) throws WrongAmountOfElementsException {
                    if (!request.getCommandArguments().isEmpty() || request.getObjectArgument() != null) throw new WrongAmountOfElementsException();
                    ResponseOutputer.appendln("Список доступных команд:\n");
                    ResponseOutputer.appendln(
                            "•\thelp : вывести справку по доступным командам\n" +
                                    "•\tinfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                                    "•\tshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                                    "•\tadd {element} : добавить новый элемент в коллекцию\n" +
                                    "•\tupdate id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                                    "•\tremove_by_id id : удалить элемент из коллекции по его id\n" +
                                    "•\tclear : очистить коллекцию\n" +
                                    "•\tsave : сохранить коллекцию в файл\n" +
                                    "•\texecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                                    "•\texit : завершить программу (без сохранения в файл)\n" +
                                    "•\thead : вывести первый элемент коллекции\n" +
                                    "•\tadd_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                                    "•\tremove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                                    "•\taverage_of_discount : вывести среднее значение поля discount для всех элементов коллекции\n" +
                                    "•\tgroup_counting : сгруппировать элементы коллекции по значению поля creationDate, вывести количество элементов в каждой группе\n" +
                                    "•\tprint_unique_person : вывести уникальные значения поля person всех элементов в коллекции\n");

                    logger.debug("Список доступных команд:\n");
                    logger.debug(
                            "•\thelp : вывести справку по доступным командам\n" +
                                    "•\tinfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                                    "•\tshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                                    "•\tadd {element} : добавить новый элемент в коллекцию\n" +
                                    "•\tupdate id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                                    "•\tremove_by_id id : удалить элемент из коллекции по его id\n" +
                                    "•\tclear : очистить коллекцию\n" +
                                    "•\tsave : сохранить коллекцию в файл\n" +
                                    "•\texecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                                    "•\texit : завершить программу (без сохранения в файл)\n" +
                                    "•\thead : вывести первый элемент коллекции\n" +
                                    "•\tadd_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                                    "•\tremove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                                    "•\taverage_of_discount : вывести среднее значение поля discount для всех элементов коллекции\n" +
                                    "•\tgroup_counting : сгруппировать элементы коллекции по значению поля creationDate, вывести количество элементов в каждой группе\n" +
                                    "•\tprint_unique_person : вывести уникальные значения поля person всех элементов в коллекции\n");
            return new ServerResponse("", ResponseCode.OK);
    }
}
