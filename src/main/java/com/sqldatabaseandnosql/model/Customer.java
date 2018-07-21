package com.sqldatabaseandnosql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
    private int age;

    public Customer() {
    }

    private Customer(final Builder builder) {
        this.login = builder.login;
        this.password = builder.password;
        this.city = builder.city;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Mutator mutator(Customer customer) {
        return new Mutator(customer);
    }

    public static class Builder {
        private String login;
        private String password;
        private String city;

        public Builder() {
        }

        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public static class Mutator {
        private Customer customer;

        public Mutator(Customer customer) {
            this.customer = customer;
        }

        public Mutator withLogin(String login) {
            this.customer.login = login;
            return this;
        }

        public Mutator withPassword(String password) {
            this.customer.password = password   ;
            return this;
        }

        public Mutator withFirstName(String firstName) {
            this.customer.firstName = firstName;
            return this;
        }

        public Mutator withLastName(String lastName) {
            this.customer.lastName = lastName;
            return this;
        }

        public Mutator withCity(String city) {
            this.customer.city  = city;
            return this;
        }

        public Mutator withLogin(int age) {
            this.customer.age = age;
            return this;
        }

        public Customer mutate() {
            return customer;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                age == customer.age &&
                Objects.equals(login, customer.login) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(city, customer.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, lastName, city, age);
    }

    @Override
    public String toString() {
        return String.format("hello, Customer![id = %d, login = %s, First Name = %s, Last Name = %s, City = %s, age = %c]",
        id, login, firstName, lastName, city, age);
    }
}
