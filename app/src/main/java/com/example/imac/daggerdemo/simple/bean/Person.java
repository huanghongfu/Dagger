package com.example.imac.daggerdemo.simple.bean;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 */
public class Person {

    private String name;

    private String age;

    private String gender;

    private static final String TAG = "Person";

    public Person() {
        Log.e(TAG, "Person:0 ");
    }

    public Person(String name) {
        this.name = name;
        Log.e(TAG, "Person: 1");
    }


    public Person(String name, String age, String gender) {
        this.name = "name";
        this.age = "age";
        this.gender = "gender";

        Log.e(TAG, "Person:3 ");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
