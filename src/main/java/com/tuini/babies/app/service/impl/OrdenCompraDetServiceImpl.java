package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.CaracteristicaDet;
import com.tuini.babies.app.model.OrdenCompraDet;
import com.tuini.babies.app.model.OrdeCompraDetVw;
import com.tuini.babies.app.repository.OrdenCompraDetRepository;
import com.tuini.babies.app.service.OrdenCompraDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraDetServiceImpl implements OrdenCompraDetService {

    @Autowired
    private OrdenCompraDetRepository ordenCompraDetRepository;

    @Override
    public List<OrdenCompraDet> getAll() {
        return ordenCompraDetRepository.getAll();
    }

    @Override
    public List<OrdenCompraDet> getAllByOc(Long id) {
        return ordenCompraDetRepository.getAllByOc(id);
    }

    @Override
    public List<OrdeCompraDetVw> getAllVwByOc(Long id) {
        return ordenCompraDetRepository.getDetalleOrdenCompra(id);
    }

    @Override
    public OrdenCompraDet create(OrdenCompraDet item) {
        return ordenCompraDetRepository.save(item);
    }

    @Override
    public List<OrdenCompraDet> createAll(List<OrdenCompraDet> items) {
        return (List<OrdenCompraDet>) ordenCompraDetRepository.saveAll(items);
    }

    @Override
    public List<OrdenCompraDet> updateAll(List<OrdenCompraDet> items) {
        List<OrdenCompraDet> ret = new ArrayList<>();
        items.forEach( item -> {
            if(item.getId() == null){
                ret.add(this.create(item));
            } else {
                Optional<OrdenCompraDet> o = ordenCompraDetRepository.findById(item.getId());
                if(o.orElse(null) == null){
                    ret.add(this.create(item));
                } else {
                    OrdenCompraDet upd = o.get();
                    upd.setOrdenCompra(item.getOrdenCompra());
                    upd.setProductoId(item.getProductoId());
                    upd.setCantidad(item.getCantidad());
                    upd.setPrecioUnitario(item.getPrecioUnitario());
                    upd.setCaracteristicaDetId(item.getCaracteristicaDetId());
                    ret.add(this.create(upd));
                }
            }

        });
        return ret;
    }

    @Override
    public void deleteDetalle(Long id) {
        ordenCompraDetRepository.deleteById(id);
    }

}
