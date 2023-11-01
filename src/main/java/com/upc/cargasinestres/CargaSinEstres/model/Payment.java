package com.upc.cargasinestres.CargaSinEstres.model;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "totalAmount", nullable = false)
    private double totalAmount;

    @Column(name = "paymentMethod", nullable = false)
    private String paymentMethod;

    @OneToOne(mappedBy = "payment")
    private BookingHistory bookingHistory;

}