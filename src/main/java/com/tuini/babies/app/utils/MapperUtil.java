package com.tuini.babies.app.utils;

import com.tuini.babies.app.model.LogHistoProduct;
import com.tuini.babies.app.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperUtil {

    MapperUtil INSTANCE = Mappers.getMapper( MapperUtil.class );

    @Mapping(source = "id_carters", target = "id_carters")
    @Mapping(source = "nombre_producto", target = "nombre_producto")
    @Mapping(source = "imagen", target = "imagen")
    @Mapping(source = "precio_descuento", target = "precio_descuento")
    @Mapping(source = "precio_original", target = "precio_original")
    @Mapping(source = "clearance", target = "clearance")
    @Mapping(source = "createdDate", target = "createdDate")
    List<LogHistoProduct> productToLogHistoProduct(List<Producto> src);
}
