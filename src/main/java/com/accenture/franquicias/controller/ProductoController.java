package com.accenture.franquicias.controller;
import com.accenture.franquicias.entity.*;
import com.accenture.franquicias.repository.*;
import com.accenture.franquicias.dto.Requests.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/productos") public class ProductoController {
 private final ProductoRepository productos;
 public ProductoController(ProductoRepository p){productos=p;}
 @PatchMapping("/{id}/stock") public Map<String,Object> stock(@PathVariable Long id,@Valid @RequestBody Stock r){Producto p=get(id);p.stock=r.stock();return response(productos.save(p));}
 @PatchMapping("/{id}/nombre") public Map<String,Object> nombre(@PathVariable Long id,@Valid @RequestBody Nombre r){Producto p=get(id);p.nombre=r.nombre();return response(productos.save(p));}
 private Producto get(Long id){return productos.findById(id).orElseThrow(()->new NoSuchElementException("Producto no encontrado"));}
 private Map<String,Object> response(Producto p){return Map.of("id",p.id,"nombre",p.nombre,"stock",p.stock,"sucursalId",p.sucursal.id);}
}
