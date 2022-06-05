package com.tuini.babies.app.payload;

import com.tuini.babies.app.model.InfoContacto;
import com.tuini.babies.app.model.ProductosPagina;
import com.tuini.babies.app.model.VwProductosPagina;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class VentaRequest {
	InfoContacto infoContacto;
	List<ProductosPagina> productos;

	public InfoContacto getInfoContacto() {
		return infoContacto;
	}

	public void setInfoContacto(InfoContacto infoContacto) {
		this.infoContacto = infoContacto;
	}

	public List<ProductosPagina> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductosPagina> productos) {
		this.productos = productos;
	}
}
