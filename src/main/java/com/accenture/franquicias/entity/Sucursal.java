package com.accenture.franquicias.entity;
import jakarta.persistence.*;
@Entity public class Sucursal { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @Column(nullable=false) public String nombre; @ManyToOne(optional=false) public Franquicia franquicia; }
