package utils;

import constants.Gender;

public class Person {
    private String name;
    private int age;
    private Gender gender;

    public Person (String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }


}
