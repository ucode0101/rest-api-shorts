package com.ucodeacademy;

public class TestPerson {

    public static void main(String[] args) {
       Person person = new Person();
       person.setFirstName("test");
        System.out.println(person.getFirstName());
        System.out.println(person);

        Person person1 = new Person("test","test","01-01-01","test@test.com","8575875875857");
        System.out.println(person1);



    }
}
