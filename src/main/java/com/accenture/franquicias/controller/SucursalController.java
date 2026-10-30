package com.accenture.franquicias.controller;
import com.accenture.franquicias.entity.*;
import com.accenture.franquicias.repository.*;
import com.accenture.franquicias.dto.Requests.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
@RestController @RequestMapping("/api/sucursales") public class SucursalController {
 private final SucursalRepository sucursales; private final ProductoRepository productos;
 public SucursalController(SucursalRepository s,ProductoRepository p){sucursales=s;productos=p;}
 @PostMapping("/{id}/productos") @ResponseStatus(HttpStatus.CREATED) public Map<String,Object> crear(@PathVariable Long id,@Valid @RequestBody NuevoProducto r){Sucursal s=sucursales.findById(id).orElseThrow(()->new NoSuchElementException("Sucursal no encontrada"));Producto p=new Producto();p.nombre=r.nombre();p.stock=r.stock();p.sucursal=s;p=productos.save(p);return Map.of("id",p.id,"nombre",p.nombre,"stock",p.stock,"sucursalId",s.id);}
 @DeleteMapping("/{id}/productos/{productoId}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id,@PathVariable Long productoId){Producto p=productos.findById(productoId).orElseThrow(()->new NoSuchElementException("Producto no encontrado"));if(!p.sucursal.id.equals(id))throw new NoSuchElementException("Producto no pertenece a esta sucursal");productos.delete(p);}
 @PatchMapping("/{id}/nombre") public Map<String,Object> nombre(@PathVariable Long id,@Valid @RequestBody Nombre r){Sucursal s=sucursales.findById(id).orElseThrow(()->new NoSuchElementException("Sucursal no encontrada"));s.nombre=r.nombre();sucursales.save(s);return Map.of("id",s.id,"nombre",s.nombre);}
}
