package common.models;

import common.util.ConsoleColors;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Person implements Serializable,Validator {
    private LocalDate birthday; //Поле не может быть null
    private Float height; //Поле не может быть null, Значение поля должно быть больше 0
    private Float weight; //Поле может быть null, Значение поля должно быть больше 0
    private Country nationality; //Поле может быть null


    public Person(LocalDate birthday, Float height, Float weight, Country nationality){
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.nationality = nationality;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public Float getHeight() {
        return height;
    }


    public Float getWeight(){
        return weight;
    }

    public Country getNationality() {
        return nationality;
    }

    @Override
    public boolean validate() {
        if (this.birthday == null) return false;
        return this.weight > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getBirthday() == person.getBirthday() &&
                getHeight() == person.getHeight() &&
                getWeight() == person.getWeight() &&
                getNationality() == person.getNationality();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBirthday(), getHeight(), getWeight(), getNationality());
    }
    @Override
    public String toString() {
        return "Person{" + "\n" +
                "\t" + "\t" + ConsoleColors.toColor("birthday=", ConsoleColors.CYAN) + birthday  + "\n" +
                "\t" + "\t" + ConsoleColors.toColor("height=", ConsoleColors.CYAN) + height + "\n" +
                "\t" + "\t" + ConsoleColors.toColor("weight=", ConsoleColors.CYAN) + weight + "\n" +
                "\t" + "\t" + ConsoleColors.toColor("nationality=", ConsoleColors.CYAN) + nationality + "\n" +
                "\t" +'}';
    }
}
