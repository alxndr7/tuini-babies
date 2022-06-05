package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.InfoContacto;
import com.tuini.babies.app.model.OrdenVentaCab;
import com.tuini.babies.app.model.OrdenVentaDet;
import com.tuini.babies.app.model.ProductosPagina;
import com.tuini.babies.app.payload.ProductoRequest;
import com.tuini.babies.app.payload.VentaRequest;
import com.tuini.babies.app.repository.InfoContactoRepository;
import com.tuini.babies.app.repository.OrdenVentaDetRepository;
import com.tuini.babies.app.repository.OrdenVentaRepository;
import com.tuini.babies.app.service.EcommerceService;
import com.tuini.babies.app.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EcommerceServiceImpl implements EcommerceService {

    @Autowired
    private InfoContactoRepository infoContactoRepository;

    @Autowired
    private OrdenVentaRepository ordenVentaRepository;

    @Autowired
    private OrdenVentaDetRepository ordenVentaDetRepository;

    @Autowired
    private MailService mailService;

    @Override
    public InfoContacto createInfoContacto(InfoContacto item) {
        return infoContactoRepository.save(item);
    }

    @Override
    public OrdenVentaCab procesarPedido(VentaRequest item) throws MessagingException, UnsupportedEncodingException {
        InfoContacto infoContacto = this.createInfoContacto(item.getInfoContacto());
        OrdenVentaCab ordenVentaCab = new OrdenVentaCab();
        ordenVentaCab.setAnulada(Boolean.FALSE);
        ordenVentaCab.setPagada(Boolean.FALSE);
        ordenVentaCab.setCompradorId(infoContacto.getId());
        ordenVentaCab.setFechaCompra(new Date());
        ordenVentaCab.setNumero("TUINIBP-" + String.format("%05d", ordenVentaRepository.countOrdenes()+1000));
        ordenVentaCab.setTotalPagar(this.getTotal(item.getProductos()));
        ordenVentaCab.setDescuento(new BigDecimal("0"));
        OrdenVentaCab ovRet =  this.ordenVentaRepository.save(ordenVentaCab);

        List<OrdenVentaDet> ordenVentaDetList = new ArrayList<>();

        List<ProductosPagina> list = item.getProductos();
        for (ProductosPagina p : list) {
            OrdenVentaDet ordenVentaDet = new OrdenVentaDet();
            ordenVentaDet.setOrdenVentaId(ovRet.getId());
            ordenVentaDet.setProductoId(p.getProductoId());
            ordenVentaDet.setCantidad(new BigDecimal(p.getQty()));
            ordenVentaDet.setPrecioUnitario(new BigDecimal(String.valueOf(p.getEcom_precio())));
            ordenVentaDet.setCaracteristicaDetId(1L);
            ordenVentaDetList.add(ordenVentaDet);
        }
        ordenVentaDetRepository.saveAll(ordenVentaDetList);
        mailService.sendEmailHtml(sendEmailIds(), item, ovRet);
        mailService.sendEmailHtmlParaVenta(sendEmailIds(), item, ovRet);
        return ovRet;
    }

    private BigDecimal getTotal(List<ProductosPagina> productoRequestList) {
        BigDecimal a = new BigDecimal(0);
        for (ProductosPagina p : productoRequestList) {
            a = a.add(new BigDecimal(String.valueOf(p.getEcom_precio())).multiply(new BigDecimal(p.getQty())));
        }
        return a;
    }

    public String[] sendEmailIds() {
        String[] emailIds = new String[3];
        emailIds[0] = "carolyn.ramos@ucsp.edu.pe";
        emailIds[1] = "c.alxndr.pl@gmail.com";
        emailIds[2] = "ventas@tuini.pe";
/*		emailIds[2] = "cpalo.luque@gmail.com";
		emailIds[3] = "carolyn.ramos@ucsp.edu.pe";*/
        return emailIds;
    }

}
