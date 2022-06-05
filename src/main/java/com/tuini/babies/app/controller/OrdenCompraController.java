package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.LogHistoProduct;
import com.tuini.babies.app.model.Marca;
import com.tuini.babies.app.model.OrdenCompraCab;
import com.tuini.babies.app.model.OrdenCompraDet;
import com.tuini.babies.app.payload.OrdeCompraRequest;
import com.tuini.babies.app.service.MonedaService;
import com.tuini.babies.app.service.OrdenCompraDetService;
import com.tuini.babies.app.service.OrdenCompraService;
import com.tuini.babies.app.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orden-compra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @Autowired
    private OrdenCompraDetService ordenCompraDetService;

    @Autowired
    private MapperUtil mapperUtil;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(ordenCompraService.getAll());
    }

    @GetMapping("/list-cerradas")
    public ResponseEntity<?> listarCerradas() {
        return ResponseEntity.ok(ordenCompraService.listCerradas());
    }

    @GetMapping("/list-det/{id}")
    public ResponseEntity<?> listarDet(@PathVariable(value="id") Long id) {
        return ResponseEntity.ok(ordenCompraDetService.getAllVwByOc(id));
    }

    @PostMapping("/create")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> create(@RequestBody OrdeCompraRequest ordeCompraRequest) {
        List<OrdenCompraDet> list =
                mapperUtil.listOrdeCompraDetClassToOrdenCompraDet(ordeCompraRequest.getOrdenCompraDetList());
        OrdenCompraCab oc = ordenCompraService.create(ordeCompraRequest.getOrdenCompraCab(), list);

        list.forEach( item -> {
            System.out.println(item);
            item.setOrdenCompra(oc.getId());
        });
        ordenCompraDetService.createAll(list);
        return  ResponseEntity.ok(oc);
    }

    @PostMapping("/update")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> update(@RequestBody OrdeCompraRequest ordeCompraRequest) {
        System.out.println(ordeCompraRequest.toString());
        OrdenCompraCab oc = ordenCompraService.update(ordeCompraRequest);
        List<OrdenCompraDet> list =
                mapperUtil.listOrdeCompraDetClassToOrdenCompraDet(ordeCompraRequest.getOrdenCompraDetList());
        ordenCompraDetService.updateAll(list);
        return  ResponseEntity.ok(oc);
    }

    @DeleteMapping("/delete-detalle/{id}")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> deleteDetalle(@PathVariable(value="id") Long id) {
        ordenCompraDetService.deleteDetalle(id);
        return  ResponseEntity.noContent().build();
    }

    @PostMapping("/cerrar-oc/{id}")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> cerrarOc(@PathVariable(value="id") Long id) {
        System.out.println("ID OC: " + id);
        return  ResponseEntity.ok(ordenCompraService.cerrarOc(id));
    }

    @PostMapping("/validar/{id}")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> validar_descarga_almacen(@PathVariable(value="id") Long id) {
        return  ResponseEntity.ok(ordenCompraService.validarProceso(id));
    }

    @PostMapping("/anular-descarga/{ocId}")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> anular_descarga(@PathVariable(value="ocId") Long ocId) {
        Long eliminados = ordenCompraService.anularDescarga(ocId);
        return  ResponseEntity.ok(ordenCompraService.anularProceso(ocId));
    }

    @GetMapping("/count")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok(ordenCompraService.count());
    }
}
