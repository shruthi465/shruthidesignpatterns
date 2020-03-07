package com.designpatterns.task;
public class Builder
{
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional
 
    private Builder(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
 
    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }
 
    public static class UserBuilder 
    {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;
 
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        
        public Builder build() {
        	Builder user =  new Builder(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(Builder user) {
           
        }
    }
public static void main(String[] args) {
	Builder user1 = new Builder.UserBuilder("Shruthi", "Reddy").age(30).phone("987654321").address("3-4-90").build();
	System.out.println(user1);
    Builder user2 = new Builder.UserBuilder("Swecha", "Royal").age(40).phone("2394756578").build();
    System.out.println(user2);
    Builder user3 = new Builder.UserBuilder("Dumsy", "Dendi").build();
    System.out.println(user3);
    Builder user4 = new Builder.UserBuilder("","").build();
    System.out.println(user4);		
}}