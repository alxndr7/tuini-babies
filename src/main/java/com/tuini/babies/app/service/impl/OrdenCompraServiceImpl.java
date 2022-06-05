package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.*;
import com.tuini.babies.app.payload.OrdeCompraRequest;
import com.tuini.babies.app.repository.*;
import com.tuini.babies.app.service.OrdenCompraService;
import com.tuini.babies.app.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private OrdenCompraDetRepository ordenCompraDetRepository;

    @Autowired
    private ProductoEcommerceRepository productoEcommerceRepository;

    @Autowired
    private ProductoPaginaRepository productoPaginaRepository;

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private CaracteristicaDetRepository caracteristicaDetRepository;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<OrdenCompraCab> getAll() {
        return ordenCompraRepository.getAll();
    }

    @Override
    public List<OrdenCompraCab> listCerradas() {
        return ordenCompraRepository.listCerradas();
    }

    @Override
    public OrdenCompraCab create(OrdenCompraCab item, List<OrdenCompraDet> list) {
        item.setTotal(calcularTotal(list));
        item.setImpuesto(calcularImpuesto(list));
        item.setSubtotal(calcularTotal(list).subtract(calcularImpuesto(list)));
        item.setMontoPagado(calcularTotal(list));
        return ordenCompraRepository.save(item);
    }

    @Override
    public List<OrdenCompraCab> createAll(List<OrdenCompraCab> items) {
        return (List<OrdenCompraCab>) ordenCompraRepository.saveAll(items);
    }

    @Override
    public OrdenCompraCab update(OrdeCompraRequest item) {
        OrdenCompraCab oc = item.getOrdenCompraCab();
        List<OrdenCompraDet> list =
                mapperUtil.listOrdeCompraDetClassToOrdenCompraDet(item.getOrdenCompraDetList());
        Optional<OrdenCompraCab> o = this.ordenCompraRepository.findById(oc.getId());
        if(o.orElse(null) == null)
            return  oc;
        OrdenCompraCab upd = o.get();
        upd.setNumero(oc.getNumero());
        upd.setFechaCompra(oc.getFechaCompra());
        upd.setFechaLLegada(oc.getFechaLLegada());
        upd.setMonedaId(oc.getMonedaId());
        upd.setFormaPagoId(oc.getFormaPagoId());
        upd.setImpuestoId(oc.getImpuestoId());
        upd.setTipoCambio(oc.getTipoCambio());
        upd.setTotal(calcularTotal(list));
        upd.setImpuesto(calcularImpuesto(list));
        upd.setSubtotal(calcularTotal(list).subtract(calcularImpuesto(list)));
        upd.setMontoPagado(calcularTotal(list));
        upd.setNumeroFacturas(oc.getNumeroFacturas());

        return this.ordenCompraRepository.save(upd);
    }

    @Override
    public OrdenCompraCab cerrarOc(Long id) {
        Optional<OrdenCompraCab> o = this.ordenCompraRepository.findById(id);
        if(o.orElse(null) == null)
            return null;
        OrdenCompraCab upd = o.get();
        upd.setCerrada(Boolean.TRUE);
        System.out.println(this.ordenCompraRepository.save(upd));
        return this.ordenCompraRepository.save(upd);
    }

    @Override
    public OrdenCompraCab validarProceso(Long id) {
        Optional<OrdenCompraCab> o = this.ordenCompraRepository.findById(id);
        if(o.orElse(null) == null)
            return null;
        OrdenCompraCab upd = o.get();
        upd.setDescargada(Boolean.TRUE);
        List<OrdenCompraDet> oDet = this.ordenCompraDetRepository.getAllByOc(id);
        List<CaracteristicaDet> caracteristicaDetList = this.caracteristicaDetRepository.getAll();
        oDet.forEach(item -> {
            Optional<ProductosPagina> oProd = Optional.ofNullable(this.productoPaginaRepository.findByProductoId(item.getProductoId()));
            if(o.orElse(null) != null){
                ProductosPagina upProd = oProd.get();
                upProd.setStock(upProd.getStock() + item.getCantidad().intValue());
                upProd.setStock(upProd.getStock_ecom() + item.getCantidad().intValue());

                CaracteristicaDet caracteristicaDet = caracteristicaDetList.stream()
                        .filter(e -> e.getId().equals(item.getCaracteristicaDetId()))
                        .findFirst()
                        .orElse(null);

                if(upProd.getTallas().contains(caracteristicaDet.getDescripcion())){
                    System.out.println("IF ");
                    List<String> newTallas = new ArrayList<>();
                    System.out.println(upProd.getTallas());
                    List<String> listTallas = new ArrayList<String>(Arrays.asList(upProd.getTallas().split(";")));
                    listTallas.forEach( t -> {
                        System.out.println(t);
                        List<String> tallasDet = new ArrayList<String>(Arrays.asList(t.split(",")));
                        System.out.println(tallasDet);
                        if(tallasDet.get(1).compareToIgnoreCase(caracteristicaDet.getDescripcion())==0){
                            tallasDet.set(2, añadirEnTalla(tallasDet.get(2), item.getCantidad().intValue()));
                        }
                        newTallas.add(String.join(",", tallasDet));
                    });
//                    tallas.add(caracteristicaDet.getDescripcion());
                    upProd.setTallas(String.join(";", newTallas));
                } else {
                    System.out.println("ELSE");
                    List<String> listTallas = upProd.getTallas().isEmpty() ? new ArrayList<>()
                            : new ArrayList<String>(Arrays.asList(upProd.getTallas().split(";")));
                    System.out.println(listTallas);
                    listTallas.add(caracteristicaDet.getId() + "," + caracteristicaDet.getDescripcion() + "," + item.getCantidad());

                    upProd.setTallas(String.join(";", listTallas));
                }
                this.productoPaginaRepository.save(upProd);
            }
        });
        return this.ordenCompraRepository.save(upd);
    }


    private OrdenCompraCab validarProceso2(Long id) {
        Optional<OrdenCompraCab> o = this.ordenCompraRepository.findById(id);
        if(o.orElse(null) == null)
            return null;
        OrdenCompraCab upd = o.get();
        upd.setDescargada(Boolean.TRUE);
        List<OrdenCompraDet> oDet = this.ordenCompraDetRepository.getAllByOc(id);
        oDet.forEach(item -> {
            Optional<ProductoEcommerce> oProd = this.productoEcommerceRepository.findById(item.getProductoId());
            if(o.orElse(null) != null){
                ProductoEcommerce upProd = oProd.get();
                upProd.setStock(upProd.getStock() + item.getCantidad().intValue());
                this.productoEcommerceRepository.save(upProd);
            }
        });
        return this.ordenCompraRepository.save(upd);
    }

    @Override
    public OrdenCompraCab anularProceso(Long id) {
        Optional<OrdenCompraCab> o = this.ordenCompraRepository.findById(id);
        if(o.orElse(null) == null)
            return null;
        OrdenCompraCab upd = o.get();
        upd.setDescargada(Boolean.FALSE);
        return this.ordenCompraRepository.save(upd);
    }

    @Override
    public Long anularDescarga(Long id) {
        return this.articuloRepository.deleteByOrdenCompraId(id);
    }

    @Override
    public Long count() {
        return this.ordenCompraRepository.count();
    }


    private Boolean existeTalla(List<CaracteristicaDet> caracteristicaDetList, Long idCaract){
        return caracteristicaDetList
                .stream()
                .anyMatch(entry -> entry.getId().compareTo(idCaract) == 0);
    }

    private BigDecimal calcularTotal(List<OrdenCompraDet> list){
        return list.stream()
                .map(x -> x.getCantidad().multiply(x.getPrecioUnitario()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal calcularImpuesto(List<OrdenCompraDet> list){
        return (list.stream()
                .map(x -> x.getCantidad().multiply(x.getPrecioUnitario()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add)).multiply(BigDecimal.valueOf(0.18));//2, RoundingMode.HALF_UP
    }
    private String añadirEnTalla(String stockActual, Integer cantidadIn){
        return (new BigDecimal(stockActual).add(new BigDecimal(cantidadIn+""))).toString() ;
    }

}
