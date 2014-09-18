package com.example.jbehave.pages;

public interface ContactFormPage {

    void go();

    void submitContactForm(String firstName, String lastName, String email, String comments);
}
