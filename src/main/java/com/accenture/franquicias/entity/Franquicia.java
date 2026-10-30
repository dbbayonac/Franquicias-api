package com.accenture.franquicias.entity;
import jakarta.persistence.*;
@Entity public class Franquicia { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @Column(nullable=false) public String nombre; }
