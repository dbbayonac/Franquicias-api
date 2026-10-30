package com.accenture.franquicias.repository;
import com.accenture.franquicias.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SucursalRepository extends JpaRepository<Sucursal,Long> { java.util.List<Sucursal> findByFranquiciaId(Long id); }
