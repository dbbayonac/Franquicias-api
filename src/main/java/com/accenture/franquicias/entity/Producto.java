package com.accenture.franquicias.entity;
import jakarta.persistence.*;
@Entity public class Producto { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @Column(nullable=false) public String nombre; @Column(nullable=false) public Integer stock; @ManyToOne(optional=false) public Sucursal sucursal; }
