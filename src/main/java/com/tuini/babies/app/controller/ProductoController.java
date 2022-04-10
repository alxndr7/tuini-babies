package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.LogHistoProduct;
import com.tuini.babies.app.model.Producto;
import com.tuini.babies.app.model.UrlBusqueda;
import com.tuini.babies.app.model.VwProductosRS;
import com.tuini.babies.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("hola-mundo")
    public String holaMundo(){
        System.out.println("HOLA MUNDO");
        return "HOLA MUNDO";
    }

/*    @GetMapping("productos")
    public Iterable<Producto> getProductos()  {
        return productoRepository.findAll();
    }*/

    @GetMapping("all-productos")
    public List<VwProductosRS> getAllProductos(@RequestParam String categoria)  {
        return productoService.getAllProductos(categoria);
    }

    @GetMapping("producto-detalle-30dias")
    public List<LogHistoProduct> findLast30ById(@RequestParam String id_carters)  {
        return productoService.findLast30ById(id_carters);
    }

    @GetMapping("productos-subidos")
    public List<VwProductosRS> get_productos_subidos(@RequestParam String categoria)  {
        return productoService.getProductosSubidos(categoria);
    }

    @GetMapping("producto-rebajados")
    public List<VwProductosRS> get_productos_rebajados(@RequestParam String categoria)  {
        return productoService.getProductosRebajados(categoria);
    }

    @GetMapping("producto-ofertados")
    public List<VwProductosRS> get_productos_ofertados(@RequestParam String categoria)  {
        return productoService.getAllProductosOfertados(categoria);
    }

    @GetMapping("job-diario")
    public String getJobDiario12M() throws IOException {
        List<Producto> listProdScraping = productoService.insertarNuevosProductos();
        List<LogHistoProduct> histoProductList = productoService.insertarLogProductos(listProdScraping);
        productoService.actualizarProductos2();
        return "OK";
    }
    @GetMapping("actualizar-productos")
    public String actualizarProductos() {
        productoService.actualizarProductos();
        return "OK";
    }

    @GetMapping("update-categoria")
    public String updateCategoria(){
        productoService.updateCategoria();
        return "OK";
    }

    @GetMapping("get-categorias")
    public List<UrlBusqueda> getCategorias(){
        return productoService.getCategorias();
//        productoService.updateCategoria();
    }
}
