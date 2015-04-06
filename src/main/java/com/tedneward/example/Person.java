// Eden Ghirmai
// INFO 498C, Spr 2014
// HW #1 -- uw java test
// A simple person class to go over the fundamentals of java

package com.tedneward.example;

import java.beans.*;
import java.lang.Double;
import java.lang.Math;
import java.lang.Object;
import java.lang.Override;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int count;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    count++;
  }

  // returns an ArrayList<Person> of Ted Neward's family
  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> newardFamily = new ArrayList<Person>();

    Person ted = new Person("Ted", 41, 250000);
    Person charlotte = new Person("Charlotte", 43, 150000);
    Person michael = new Person("Michael", 22, 10000);
    Person matthew = new Person("Matthew", 15, 0);

    newardFamily.add(ted);
    newardFamily.add(charlotte);
    newardFamily.add(michael);
    newardFamily.add(matthew);

    return newardFamily;

  }

  public int count() { return count; }

  public void setAge(int age) {
    if (age < 0) { throw new IllegalArgumentException(); }

    this.age = age;
  }

  public void setName(String name) {
    if (name == null) { throw new IllegalArgumentException(); }

    this.name = name;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public boolean isPropertyChangeFired() {
    return propertyChangeFired;
  }

  public void setPropertyChangeFired(boolean propertyChangeFired) {
    this.propertyChangeFired = propertyChangeFired;
  }

  public PropertyChangeSupport getPcs() {
    return pcs;
  }

  public int getAge() {
    return age;
  }
  
  public String getName() {
    return name;
  }
  
  public double getSalary() {
    return salary;
  }
  
  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Person) {
      Person p = (Person)other;
      return (this.name.equals(p.name) && this.age == p.age);
    }
    return false;
  }

  @Override
  public String toString() {
    return "[Person name:" + name + " age:" + age + " salary:" + salary + "]";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }

  @Override
  public int compareTo(Person other) {
    double difference = other.salary = this.salary;
    int result = (int)Math.signum(salary);

    return result;
  }

  public static class AgeComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
      return p1.age - p2.age;
    }
  }
}
