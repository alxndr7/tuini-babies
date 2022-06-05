package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.InfoContacto;
import com.tuini.babies.app.model.OrdenVentaCab;
import com.tuini.babies.app.model.ProductosPagina;
import com.tuini.babies.app.payload.ProductoRequest;
import com.tuini.babies.app.payload.VentaRequest;
import com.tuini.babies.app.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String[] to, String subject, String content) throws UnsupportedEncodingException {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom(String.valueOf(new InternetAddress("ventas@tuini.pe", "Example")));
        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);

        mailSender.send(email);
    }

    @Override
    public void sendEmailHtml(String[] to, VentaRequest venta, OrdenVentaCab ordenVentaCab) throws UnsupportedEncodingException, MessagingException {
        InfoContacto infoContacto = venta.getInfoContacto();
        MimeMessage msg = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, false);

        helper.setFrom(String.valueOf(new InternetAddress("ventas@tuini.pe", "TUINI - Ventas")));

        helper.setTo(infoContacto.getEmail());
     /*   msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse("carolyn.ramos@ucsp.edu.pe," +
                "c.alxndr.pl@gmail.com  ,ventas@tuini.pe"));*/

        helper.setSubject("Tu pedido #" + ordenVentaCab.getNumero() + " se registró con éxito");

        helper.setText("  <div role=\"article\" aria-roledescription=\"email\" lang=\"en\" style=\"text-size-adjust:100%;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;background-color:#939297;\">\n" +
                "    <table role=\"presentation\" style=\"width:100%;border:none;border-spacing:0;\">\n" +
                "      <tr>\n" +
                "        <td align=\"center\" style=\"padding:0;\">\n" +
                "          <!--[if mso]>\n" +
                "          <table role=\"presentation\" align=\"center\" style=\"width:600px;\">\n" +
                "          <tr>\n" +
                "          <td>\n" +
                "          <![endif]-->\n" +
                "          <table role=\"presentation\" style=\"width:94%;max-width:600px;border:none;border-spacing:0;text-align:left;font-family:Arial,sans-serif;font-size:16px;line-height:22px;color:#363636;\">\n" +
                logoMensaje() +
                mensajeParaComprador(infoContacto.getNombre(), ordenVentaCab.getNumero()) +
                getDetalleProductos(venta.getProductos()) +
                getTotal(venta.getProductos()) +
                metodoDePago( ordenVentaCab.getNumero()) +
                        getMsjCompraRedes() +
                "          </table>\n" +
                "          <!--[if mso]>\n" +
                "          </td>\n" +
                "          </tr>\n" +
                "          </table>\n" +
                "          <![endif]-->\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "  </div>", true);

        // hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));

//        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        mailSender.send(msg);
    }

    @Override
    public void sendEmailHtmlParaVenta(String[] to, VentaRequest venta, OrdenVentaCab ordenVentaCab) throws UnsupportedEncodingException, MessagingException {
        InfoContacto infoContacto = venta.getInfoContacto();

        BigDecimal a = new BigDecimal(0);
        for (ProductosPagina p : venta.getProductos()) {
            a =  a.add(new BigDecimal(String.valueOf(p.getEcom_precio())).multiply(new BigDecimal(p.getQty())));
        }

        MimeMessage msg = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, false);

        helper.setFrom(String.valueOf(new InternetAddress("ventas@tuini.pe", "TUINI - Nueva venta")));

        helper.setTo(InternetAddress.parse("carolyn.ramos@ucsp.edu.pe," +
                "c.alxndr.pl@gmail.com  ,ventas@tuini.pe"));

        helper.setSubject("Cerrar pedido #" + ordenVentaCab.getNumero());

        helper.setText("  <div role=\"article\" aria-roledescription=\"email\" lang=\"en\" style=\"text-size-adjust:100%;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;background-color:#939297;\">\n" +
                "    <table role=\"presentation\" style=\"width:100%;border:none;border-spacing:0;\">\n" +
                "      <tr>\n" +
                "        <td align=\"center\" style=\"padding:0;\">\n" +
                "          <!--[if mso]>\n" +
                "          <table role=\"presentation\" align=\"center\" style=\"width:600px;\">\n" +
                "          <tr>\n" +
                "          <td>\n" +
                "          <![endif]-->\n" +
                "          <table role=\"presentation\" style=\"width:94%;max-width:600px;border:none;border-spacing:0;text-align:left;font-family:Arial,sans-serif;font-size:16px;line-height:22px;color:#363636;\">\n" +
                logoMensaje() +
                getDetalleProductos(venta.getProductos()) +
                getTotal(venta.getProductos()) +
                infoContactoCerraVenta(infoContacto, ordenVentaCab.getNumero(), a.setScale(2, BigDecimal.ROUND_HALF_UP).toString()) +
                getRedes() +
                "          </table>\n" +
                "          <!--[if mso]>\n" +
                "          </td>\n" +
                "          </tr>\n" +
                "          </table>\n" +
                "          <![endif]-->\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "  </div>", true);
        mailSender.send(msg);
    }

    @Override
    public void sendEmailHtml2(String[] to, String subject, String content, VentaRequest venta) throws UnsupportedEncodingException, MessagingException {

    }

    @Override
    public void sendEmailHtml3(String[] to, String subject, String content, VentaRequest venta) throws UnsupportedEncodingException, MessagingException {

    }

    private String mensajeParaComprador(String nombre, String orden){
        return "            <tr>\n" +
                "              <td style=\"padding:30px;background-color:#ffffff;\">\n" +
                "                <h1 style=\"text-align:center;margin-top:0;margin-bottom:16px;font-size:26px;line-height:32px;font-weight:bold;letter-spacing:-0.02em;\">¡Gracias por confiar en TUINI!</h1>\n" +
                "                <p style=\"margin:0;\"> Hola " + nombre +", tu pedido fue reservado, tu código es: <span style=\"font-weight:bold\">" + orden +"</span> , a continuación detallamos la información de tu pedido: </p>\n" +
                "              </td>\n" +
                "            </tr>\n";
    }

    private String logoMensaje(){
        return       "            <tr>\n" +
                "              <td style=\"padding:30px 30px 30px 30px;text-align:center;font-size:24px;font-weight:bold;\">\n" +
                "                <a href=\"http://www.tuini.pe/\" style=\"text-decoration:none;\"><img src=\"https://tuini.pe/public_images/logo_tuini_1.png\" width=\"165\" alt=\"Logo\" style=\"width:165px;max-width:80%;height:auto;border:none;text-decoration:none;color:#ffffff;\"></a>\n" +
                "              </td>\n" +
                "            </tr>\n";
    }

    private String metodoDePago(String orden){
        return      "            <tr>\n" +
                "              <td style=\"padding:35px 30px 11px 30px;font-size:0;background-color:#ffffff;border-bottom:1px solid #f0f0f5;border-color:rgba(201,201,207,.35);\">\n" +
                "                <!--[if mso]>\n" +
                "                <table role=\"presentation\" width=\"100%\">\n" +
                "                <tr>\n" +
                "                <td style=\"width:145px;\" align=\"left\" valign=\"top\">\n" +
                "                <![endif]-->\n" +
                "                <div class=\"col-sml\" style=\"display:inline-block;width:100%;max-width:145px;vertical-align:top;text-align:left;font-family:Arial,sans-serif;font-size:14px;color:#363636;\">\n" +
                "                  <img src=\"https://tuini.pe/public_images/metodopago.png\" width=\"115\" alt=\"\" style=\"width:115px;max-width:80%;margin-bottom:20px;\">\n" +
                "                </div>\n" +
                "                <!--[if mso]>\n" +
                "                </td>\n" +
                "                <td style=\"width:395px;padding-bottom:20px;\" valign=\"top\">\n" +
                "                <![endif]-->\n" +
                "                <div class=\"col-lge\" style=\"display:inline-block;width:100%;max-width:395px;vertical-align:top;padding-bottom:20px;font-family:Arial,sans-serif;font-size:16px;line-height:22px;color:#363636;\">\n" +
                "                  <p style=\"margin-top:0;margin-bottom:12px;\"><span style=\"font-weight:bold\">Metodos de pago por transferencia:</span></p>\n" +
                "                  <p style=\"margin-top:0;margin-bottom:5px;\"><span style=\"font-weight:bold\">BCP:</span> 21599942160071</p>\n" +
                "                  <p style=\"margin-top:0;margin-bottom:5px;\"><span style=\"font-weight:bold\">Interbank:</span> 3433123068153</p>\n" +
                "                  <p style=\"margin-top:0;margin-bottom:15px;\"><span style=\"font-weight:bold\">Yape/Plin:</span> 964170284</p>\n" +
                "                  <p style=\"margin-top:0;margin-bottom:15px;\"><span style=\"font-weight:bold\">A nombre de:</span> Carolyn Ramos/Cesar Palo</p>\n" +
                "                  <p style=\"margin:0;\"><a href=\"https://wa.me/51966708902?text=Hola ya realicé el pago de mi pedido con el código " + orden + " mi número de operación es:.... mediante....\" style=\"background: #ff3884; text-decoration: none; padding: 10px 25px; color: #ffffff; border-radius: 4px; display:inline-block; mso-padding-alt:0;text-underline-color:#ff3884\"><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%;mso-text-raise:20pt\">&nbsp;</i><![endif]--><span style=\"mso-text-raise:10pt;font-weight:bold;\">¿Ya pagaste? Click aquí</span><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%\">&nbsp;</i><![endif]--></a></p>\n" +
                "                </div>\n" +
                "                <!--[if mso]>\n" +
                "                </td>\n" +
                "                </tr>\n" +
                "                </table>\n" +
                "                <![endif]-->\n" +
                "              </td>\n" +
                "            </tr>\n";
    }

    private String getMsjCompraRedes(){
        return                 "            <tr>\n" +
                "              <td style=\"padding:30px;background-color:#ffffff;\">\n" +
                "                <p style=\"margin:0;\">*Recuerda que luego de reservado tu pedido tienes como máximo 4 horas para poder pagarlo, si tienes alguna duda o consulta " +
                " no dudes en escribirnos a nuestras redes sociales o a nuestros whatsapp, estaremos gustosos de atenderte!</p>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td style=\"padding:30px;text-align:center;font-size:12px;background-color:#404040;color:#cccccc;\">\n" +
                "                <p style=\"margin:0 0 8px 0;\">" +
                "<a href=\"https://www.facebook.com/Tuini-Accesorios-para-beb%C3%A9s-110990771583246\" style=\"text-decoration:none;\"><img src=\"https://tuini.pe/public_images/facebook.png\" width=\"40\" height=\"40\" alt=\"f\" style=\"display:inline-block;color:#cccccc;\"></a> " +
                "<a href=\"https://wa.me/51966708902?text=Hola me puedes ayudar con...\" style=\"text-decoration:none;\"><img src=\"https://tuini.pe/public_images/whatsapp.png\" width=\"40\" height=\"40\" alt=\"t\" style=\"display:inline-block;color:#cccccc;\"></a> " +
                "<a href=\"https://www.instagram.com/tuini.peru\" style=\"text-decoration:none;\"><img src=\"https://tuini.pe/public_images/instagram.png\" width=\"40\" height=\"40\" alt=\"t\" style=\"display:inline-block;color:#cccccc;\"></a></p>\n" +
                "                <p style=\"margin:0;font-size:14px;line-height:20px;\">Visita nuestra nuestras redes y nuestra página para más Tuini <br><a class=\"unsub\" href=\"https://www.tuini.pe/\" style=\"color:#cccccc;text-decoration:underline;\">www.tuini.pe</a></p>\n" +
                "              </td>\n" +
                "            </tr>\n";
    }

    private String getRedes(){
        return  "            <tr>\n" +
                "              <td style=\"padding:30px;text-align:center;font-size:12px;background-color:#404040;color:#cccccc;\">\n" +
                "                <p style=\"margin:0 0 8px 0;\">" +
                "<a href=\"https://www.facebook.com/Tuini-Accesorios-para-beb%C3%A9s-110990771583246\" style=\"text-decoration:none;\"><img src=\"https://tuini.pe/public_images/facebook.png\" width=\"40\" height=\"40\" alt=\"f\" style=\"display:inline-block;color:#cccccc;\"></a> " +
                "<a href=\"https://wa.me/51966708902?text=Hola me puedes ayudar con...\" style=\"text-decoration:none;\"><img src=\"https://tuini.pe/public_images/whatsapp.png\" width=\"40\" height=\"40\" alt=\"t\" style=\"display:inline-block;color:#cccccc;\"></a> " +
                "<a href=\"https://www.instagram.com/tuini.peru\" style=\"text-decoration:none;\"><img src=\"https://tuini.pe/public_images/instagram.png\" width=\"40\" height=\"40\" alt=\"t\" style=\"display:inline-block;color:#cccccc;\"></a></p>\n" +
                "                <p style=\"margin:0;font-size:14px;line-height:20px;\">Visita nuestra nuestras redes y nuestra página para más Tuini <br><a class=\"unsub\" href=\"https://www.tuini.pe/\" style=\"color:#cccccc;text-decoration:underline;\">www.tuini.pe</a></p>\n" +
                "              </td>\n" +
                "            </tr>\n";
    }

    private String infoContactoCerraVenta(InfoContacto info, String orden, String total){
        return      "            <tr>\n" +
                "              <td style=\"padding:35px 30px 11px 30px;font-size:0;background-color:#ffffff;border-bottom:1px solid #f0f0f5;border-color:rgba(201,201,207,.35);\">\n" +
                "                <!--[if mso]>\n" +
                "                <table role=\"presentation\" width=\"100%\">\n" +
                "                <tr>\n" +
                "                <td style=\"width:395px;padding-bottom:20px;\" valign=\"top\">\n" +
                "                <![endif]-->\n" +
                "                <div class=\"col-lge\" style=\"display:inline-block;width:100%;max-width:395px;vertical-align:top;padding-bottom:20px;font-family:Arial,sans-serif;font-size:16px;line-height:22px;color:#363636;\">\n" +
                "                  <p style=\"margin-top:0;margin-bottom:12px;\"><span style=\"font-weight:bold\">Info de comprador:</span></p>\n" +
                "                  <p style=\"margin-top:0;margin-bottom:5px;\"><span style=\"font-weight:bold\">Nombre:</span> "+ info.getNombre() + " " + info.getApellido() + "</p>\n" +
                "                  <p style=\"margin-top:0;margin-bottom:5px;\"><span style=\"font-weight:bold\">Correo:</span> " + info.getEmail() + "</p>\n" +
                "                  <p style=\"margin-top:0;margin-bottom:15px;\"><span style=\"font-weight:bold\">Celular:</span> " + info.getTelefono() +"</p>\n" +
                "                  <p style=\"margin:0;\"><a href=\"https://wa.me/51" +  info.getTelefono() + "?text=Hola " + info.getNombre() +" te saluda TUINI, realizaste el pedido número " + orden + " por el monto de S/" + total + "....\" style=\"background: #ff3884; text-decoration: none; padding: 10px 25px; color: #ffffff; border-radius: 4px; display:inline-block; mso-padding-alt:0;text-underline-color:#ff3884\"><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%;mso-text-raise:20pt\">&nbsp;</i><![endif]--><span style=\"mso-text-raise:10pt;font-weight:bold;\">Contactar comprador</span><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%\">&nbsp;</i><![endif]--></a></p>\n" +
                "                </div>\n" +
                "                <!--[if mso]>\n" +
                "                </td>\n" +
                "                </tr>\n" +
                "                </table>\n" +
                "                <![endif]-->\n" +
                "              </td>\n" +
                "            </tr>\n";
    }

    private String getDetalleProductos(List<ProductosPagina> productoRequestList){

        String prodHtml = "";

        for (ProductosPagina p : productoRequestList) {

            BigDecimal a = new BigDecimal(String.valueOf(p.getEcom_precio())).multiply( new BigDecimal(p.getQty()));
            BigDecimal b = a.setScale(2,     BigDecimal.ROUND_HALF_UP);
            prodHtml += " <tr>\n" +
                    "              <td style=\"padding:35px 30px 11px 30px;font-size:0;background-color:#ffffff;border-bottom:1px solid #f0f0f5;border-color:rgba(201,201,207,.35);\">\n" +
                    "                <!--[if mso]>\n" +
                    "                <table role=\"presentation\" width=\"100%\">\n" +
                    "                <tr>\n" +
                    "                <td style=\"width:145px;\" align=\"left\" valign=\"top\">\n" +
                    "                <![endif]-->\n" +
                    "                <div class=\"col-sml\" style=\"display:inline-block;width:100%;max-width:145px;vertical-align:top;text-align:left;font-family:Arial,sans-serif;font-size:14px;color:#363636;\">\n" +
                    "                  <img src=\""+ p.getEcom_img1() +"\" width=\"115\" alt=\"\" style=\"width:115px;max-width:80%;margin-bottom:20px;\">\n" +
                    "                </div>\n" +
                    "                <!--[if mso]>\n" +
                    "                </td>\n" +
                    "                <td style=\"width:395px;padding-bottom:20px;\" valign=\"top\">\n" +
                    "                <![endif]-->\n" +
                    "                <div class=\"col-lge\" style=\"display:inline-block;width:100%;max-width:395px;vertical-align:top;padding-bottom:20px;font-family:Arial,sans-serif;font-size:16px;line-height:22px;color:#363636;\">\n" +
                    "                  <p style=\"margin-top:0;margin-bottom:12px;\">Producto: " +  p.getNombre() +" </p>\n" +
                    "                  <p style=\"margin-top:0;margin-bottom:12px;\">Talla: " +  p.getTalla_compra() +" </p>\n" +
                    "                    <p style=\"margin-top:0;margin-bottom:12px;\">Cantidad: " + p.getQty() +" </p>\n" +
                    "                    <p style=\"margin-top:0;margin-bottom:12px;\">Precio unitario: S/"+ new BigDecimal(String.valueOf(p.getEcom_precio())).setScale(2, BigDecimal.ROUND_HALF_UP) + "</p>\n" +
                    "                    <p style=\"margin-top:0;margin-bottom:12px;\">Total producto: S/" + b.toString() + "</p>\n" +
                    "                </div>\n" +
                    "                <!--[if mso]>\n" +
                    "                </td>\n" +
                    "                </tr>\n" +
                    "                </table>\n" +
                    "                <![endif]-->\n" +
                    "              </td>\n" +
                    "            </tr>";
        }

        return prodHtml;

    }

    private String getTotal(List<ProductosPagina> productoRequestList){

        BigDecimal a = new BigDecimal(0);
        for (ProductosPagina p : productoRequestList) {
            a =  a.add(new BigDecimal(String.valueOf(p.getEcom_precio())).multiply(new BigDecimal(p.getQty())));
        }
        return " <tr>\n" +
                "              <td style=\"padding:35px 30px 11px 30px;font-size:0;background-color:#ffffff;border-bottom:1px solid #f0f0f5;border-color:rgba(201,201,207,.35);\">\n" +
                "                <!--[if mso]>\n" +
                "                <table role=\"presentation\" width=\"100%\">\n" +
                "                <tr>\n" +
                "                <td style=\"width:145px;\" align=\"left\" valign=\"top\">\n" +
                "                <![endif]-->\n" +
                "                <div class=\"col-sml\" style=\"text-align:center;margin-top:0;margin-bottom:16px;font-size:26px;line-height:32px;font-weight:bold;letter-spacing:-0.02em;\">\n" +
                "               TOTAL: S/" + a.setScale(2, BigDecimal.ROUND_HALF_UP) +
                "                </div>\n" +
                "                <!--[if mso]>\n" +
                "                </td>\n" +
                "                </tr>\n" +
                "                </table>\n" +
                "                <![endif]-->\n" +
                "              </td>\n" +
                "            </tr>";
    }

    private String getMetodosDepago(){

        return " <tr>\n" +
                "              <td style=\"padding:35px 30px 11px 30px;font-size:0;background-color:#ffffff;border-bottom:1px solid #f0f0f5;border-color:rgba(201,201,207,.35);\">\n" +
                "                <!--[if mso]>\n" +
                "                <table role=\"presentation\" width=\"100%\">\n" +
                "                <tr>\n" +
                "                <td style=\"width:145px;\" align=\"left\" valign=\"top\">\n" +
                "                <![endif]-->\n" +
                "                <div class=\"col-sml\" style=\"text-align:left;margin-top:0;margin-bottom:16px;font-size:16px;line-height:32px;font-weight:bold;letter-spacing:-0.02em;\">\n" +
                "               Los metodos de pago son: " +
                "                </div>\n" +
                "                <!--[if mso]>\n" +
                "                </td>\n" +
                "                </tr>\n" +
                "                </table>\n" +
                "                <![endif]-->\n" +
                "              </td>\n" +
                "            </tr>";
    }

    private String getProductos2(List<ProductoRequest> productoRequestList){
        String prodHtml = "";

        for (ProductoRequest p : productoRequestList) {
            BigDecimal a = new BigDecimal(p.getEcom_PRECIO()).multiply( new BigDecimal(p.getQty()));
            BigDecimal b = a.setScale(2,     BigDecimal.ROUND_HALF_UP);
            prodHtml += "<tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n" +
                    "<td valign=\"middle\" width=\"80%\" style=\"text-align:left; padding: 0 2.5em;\">\n" +
                    "<div class=\"product-entry\">\n" +
                    "<img src=\"" + p.getEcom_IMG1() + "\" alt=\"\" style=\"width: 100px; max-width: 600px; height: auto; margin-bottom: 20px; display: block;\">\n" +
                    "<div class=\"text\">\n" +
                    "<h3>" +  p.getNombre() + "</h3>\n" +
                    "<span>Cantidad: " + p.getQty() +" </span>\n" +
                    "<br><span>Precio: S/" + p.getEcom_PRECIO() +" </span>\n" +
                    "<p>" + p.getDescripcion() +"</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "<td valign=\"middle\" width=\"20%\" style=\"text-align:left; padding: 0 2.5em;\">\n" +
                    "<span class=\"price\" style=\"color: #000; font-size: 20px;\"> S/" + b.toString() +"</span>\n" +
                    "</td>\n" +
                    "</tr>\n";
        }
        return prodHtml;
    }
}
