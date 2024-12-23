public class Person {
    private String name;
    private int age;
    private GenderConstants gender;

    public Person (String name, int age, GenderConstants gender) {
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

    public GenderConstants getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setGender(GenderConstants gender) {
        this.gender = gender;
    }


}
