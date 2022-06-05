package com.tuini.babies.app.service;

import com.tuini.babies.app.model.InfoContacto;
import com.tuini.babies.app.model.OrdenVentaCab;
import com.tuini.babies.app.payload.VentaRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EcommerceService {
    InfoContacto createInfoContacto(InfoContacto item);
    OrdenVentaCab procesarPedido(VentaRequest item) throws MessagingException, UnsupportedEncodingException;
}
