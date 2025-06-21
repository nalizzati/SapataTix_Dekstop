package com.example.sapatatix.Model;

public class Ticket {
    private int idTicket;
    private int idEvent; // Untuk mengaitkan tiket dengan event
    private String ticketName;
    private double price;
    private int quantity;
    private String ticketType; // Misalnya, "berbayar" atau "gratis"

    // Konstruktor lengkap
    public Ticket(int idTicket, int idEvent, String ticketName, double price, int quantity, String ticketType) {
        this.idTicket = idTicket;
        this.idEvent = idEvent;
        this.ticketName = ticketName;
        this.price = price;
        this.quantity = quantity;
        this.ticketType = ticketType;
    }

    // Konstruktor tanpa idTicket (untuk insert baru)
    public Ticket(int idEvent, String ticketName, double price, int quantity, String ticketType) {
        this.idEvent = idEvent;
        this.ticketName = ticketName;
        this.price = price;
        this.quantity = quantity;
        this.ticketType = ticketType;
    }

    // Getters
    public int getIdTicket() {
        return idTicket;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getTicketName() {
        return ticketName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTicketType() {
        return ticketType;
    }

    // Setters
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}