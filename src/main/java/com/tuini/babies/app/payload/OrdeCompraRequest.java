package com.tuini.babies.app.payload;

import com.tuini.babies.app.model.OrdenCompraCab;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class OrdeCompraRequest {
	@NotBlank
	private OrdenCompraCab ordenCompraCab;

	@NotBlank
	private List<OrdenCompraDetVw> ordenCompraDetList;

	public OrdenCompraCab getOrdenCompraCab() {
		return ordenCompraCab;
	}

	public void setOrdenCompraCab(OrdenCompraCab ordenCompraCab) {
		this.ordenCompraCab = ordenCompraCab;
	}

	public List<OrdenCompraDetVw> getOrdenCompraDetList() {
		return ordenCompraDetList;
	}

	public void setOrdenCompraDetList(List<OrdenCompraDetVw> ordenCompraDetList) {
		this.ordenCompraDetList = ordenCompraDetList;
	}

	@Override
	public String toString() {
		return "OrdeCompraRequest{" +
				"ordenCompraCab=" + ordenCompraCab +
				", ordenCompraDetList=" + ordenCompraDetList +
				'}';
	}
}
