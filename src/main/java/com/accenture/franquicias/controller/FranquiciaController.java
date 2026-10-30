package com.accenture.franquicias.controller;
import com.accenture.franquicias.entity.*;
import com.accenture.franquicias.repository.*;
import com.accenture.franquicias.dto.Requests.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
@RestController @RequestMapping("/api/franquicias") public class FranquiciaController {
 private final FranquiciaRepository franquicias; private final SucursalRepository sucursales; private final ProductoRepository productos;
 public FranquiciaController(FranquiciaRepository f,SucursalRepository s,ProductoRepository p){franquicias=f;sucursales=s;productos=p;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Franquicia crear(@Valid @RequestBody Nombre r){Franquicia f=new Franquicia();f.nombre=r.nombre();return franquicias.save(f);}
 @PostMapping("/{id}/sucursales") @ResponseStatus(HttpStatus.CREATED) public Map<String,Object> sucursal(@PathVariable Long id,@Valid @RequestBody Nombre r){Franquicia f=franquicias.findById(id).orElseThrow(()->new NoSuchElementException("Franquicia no encontrada"));Sucursal s=new Sucursal();s.nombre=r.nombre();s.franquicia=f;s=sucursales.save(s);return Map.of("id",s.id,"nombre",s.nombre,"franquiciaId",f.id);}
 @PatchMapping("/{id}/nombre") public Franquicia nombre(@PathVariable Long id,@Valid @RequestBody Nombre r){Franquicia f=franquicias.findById(id).orElseThrow(()->new NoSuchElementException("Franquicia no encontrada"));f.nombre=r.nombre();return franquicias.save(f);}
 @GetMapping("/{id}/productos-max-stock") public List<MaxStock> max(@PathVariable Long id){if(!franquicias.existsById(id))throw new NoSuchElementException("Franquicia no encontrada");List<MaxStock> result=new ArrayList<>();for(Sucursal s:sucursales.findByFranquiciaId(id)){productos.findBySucursalId(s.id).stream().max(Comparator.comparingInt(p->p.stock)).ifPresent(p->result.add(new MaxStock(s.id,s.nombre,p.id,p.nombre,p.stock)));}return result;}
}
