package com.accenture.franquicias.dto;
import jakarta.validation.constraints.*;
public class Requests {
 public record Nombre(@NotBlank String nombre) {}
 public record NuevoProducto(@NotBlank String nombre,@NotNull @Min(0) Integer stock) {}
 public record Stock(@NotNull @Min(0) Integer stock) {}
 public record MaxStock(Long sucursalId,String sucursal,Long productoId,String producto,Integer stock) {}
}
