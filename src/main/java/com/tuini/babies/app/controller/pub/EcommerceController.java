package com.tuini.babies.app.controller.pub;

import com.tuini.babies.app.model.InfoContacto;
import com.tuini.babies.app.model.Mensaje;
import com.tuini.babies.app.payload.ProductoRequest;
import com.tuini.babies.app.payload.VentaRequest;
import com.tuini.babies.app.service.EcommerceService;
import com.tuini.babies.app.service.MailService;
import com.tuini.babies.app.service.MensajeService;
import com.tuini.babies.app.service.pub.ProductoEPaginaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/public/ecommerce")
public class EcommerceController {
	
	@Autowired
	private ProductoEPaginaService productoEPaginaService;

	@Autowired
	private MensajeService mensajeService;

	@Autowired
	private EcommerceService ecommerceService;

	@Autowired
	private MailService mailService;

	@GetMapping("/list-productos")
	public ResponseEntity<?> listProductos() {
		return ResponseEntity.ok(this.productoEPaginaService.getAllEcommerce());
	}

	@GetMapping("/list-productos-ofertas")
	public ResponseEntity<?> listProductosOfertas() {
		return ResponseEntity.ok(this.productoEPaginaService.getProductosOferta());
	}

	@GetMapping("/get-producto")
	public ResponseEntity<?> getProductoPorId(@RequestParam String codigo) {
		return ResponseEntity.ok(this.productoEPaginaService.getProductoPorId(codigo));
	}

	@GetMapping("/get-caracteristicas")
	public ResponseEntity<?> getCaracteristicasPorId() {
		return ResponseEntity.ok(this.productoEPaginaService.getCaracteristicas());
	}

	@GetMapping("/get-productos-relacionados")
	public ResponseEntity<?> getProductosRelacionados(@RequestParam Long categoria_id) {
		return ResponseEntity.ok(this.productoEPaginaService.getProductosRelacionados(categoria_id));
	}

	@GetMapping("/get-productos-random")
	public ResponseEntity<?> getProductosRelacionados() {
		return ResponseEntity.ok(this.productoEPaginaService.getProductosRandom());
	}

	@PostMapping("/create-mensaje")
	public ResponseEntity<?> create(@RequestBody Mensaje item) {
		return ResponseEntity.ok(mensajeService.create(item));
	}

	@PostMapping("/venta")
	public ResponseEntity<?> venta(@RequestBody VentaRequest item) throws MessagingException, UnsupportedEncodingException {

//		InfoContacto infoContacto = ecommerceService.create(item.getInfoContacto());

/*		String subject = "VENTA se registro a siguiente venta";
		StringBuilder content = new StringBuilder(" Contactar con el cliente sobre la siguiente venta:  \n\n"
				+ "Info de contacto:  \n\n"
				+ "Nombre: " + infoContacto.getNombre() + " \n"
				+ "Apellido: " + infoContacto.getApellido() + " \n"
				+ "Telefono: " + infoContacto.getTelefono() + " \n"
				+ "Email: " + infoContacto.getEmail() + " \n\n");
		content.append("Info de venta:  \n\n");
		List<ProductoRequest> list = item.getProductos();

		for (ProductoRequest p : list) {
			content.append(p.getQty()).append(" ").append(p.getNombre()).append(" S/").append(p.getEcom_PRECIO()).append(" \n");
		}

		mailService.sendEmailHtml(sendEmailIds(), subject, content.toString(), item);*/

		return ResponseEntity.ok(ecommerceService.procesarPedido(item));
	}
}
