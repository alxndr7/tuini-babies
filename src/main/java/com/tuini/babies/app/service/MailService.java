package com.tuini.babies.app.service;

import com.tuini.babies.app.model.OrdenVentaCab;
import com.tuini.babies.app.payload.VentaRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface MailService {

    void sendEmail(String[] to, String subject, String content) throws UnsupportedEncodingException;
    void sendEmailHtml(String[] to, VentaRequest venta, OrdenVentaCab ordenVentaCab) throws UnsupportedEncodingException, MessagingException;
    void sendEmailHtmlParaVenta(String[] to, VentaRequest venta, OrdenVentaCab ordenVentaCab) throws UnsupportedEncodingException, MessagingException;
    void sendEmailHtml2(String[] to, String subject, String content, VentaRequest venta) throws UnsupportedEncodingException, MessagingException;
    void sendEmailHtml3(String[] to, String subject, String content, VentaRequest venta) throws UnsupportedEncodingException, MessagingException;
}
