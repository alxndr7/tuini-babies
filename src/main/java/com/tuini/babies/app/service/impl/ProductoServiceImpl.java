package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.LogHistoProduct;
import com.tuini.babies.app.model.Producto;
import com.tuini.babies.app.model.UrlBusqueda;
import com.tuini.babies.app.model.VwProductosRS;
import com.tuini.babies.app.repository.LogHistoProductRepository;
import com.tuini.babies.app.repository.ProductoRepository;
import com.tuini.babies.app.repository.UrlBusquedaRepository;
import com.tuini.babies.app.service.ProductoService;
import com.tuini.babies.app.utils.MapperUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private String url_base = "https://www.carters.com";

    private List<LogHistoProduct> histoProductList;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private LogHistoProductRepository logHistoProductRepository;

    @Autowired
    private UrlBusquedaRepository urlBusquedaRepository;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<Producto> insertarNuevosProductos() throws IOException {
        List<Producto> listProductos = productoRepository.getAllProductos();
        List<Producto> listProductosScraping = this.getProductosScraping();
        List<Producto> finalListProductosScraping = listProductosScraping
                .stream()
                .filter(distinctByKey(Producto::getId_carters))
                .collect(Collectors.toList());

        List<Producto> differences = finalListProductosScraping.stream()
                .filter(element -> listProductos.stream()
                        .noneMatch(p -> p.getId_carters().equals(element.getId_carters()))
                )
                .collect(Collectors.toList());
        List<Producto> differencesWithoutDuplicates = differences
                .stream()
                .filter(distinctByKey(Producto::getId_carters))
                .collect(Collectors.toList());
        System.out.println("=============== PRODUCTOS DIFERENTES =============");
        System.out.println(differencesWithoutDuplicates.size());

        productoRepository.saveAll(differencesWithoutDuplicates);

        return listProductosScraping;
//        return differencesWithoutDuplicates;
    }

    @Override
    public  List<LogHistoProduct> insertarLogProductos(List<Producto> list) {
        System.out.println("=============== PRODUCTOS =============");
        System.out.println("Productos distintos: " + list.size());
        List<LogHistoProduct> listLog = mapperUtil.productToLogHistoProduct(list);
//        listLog.forEach( l -> System.out.println(l.toString()));

     /*   List<LogHistoProduct> output =
                listLog.stream()
                        .map(s-> {
                            LogHistoProduct n = new LogHistoProduct(); // create new instance
                            n.setPrecio_descuento(s.getPrecio_descuento() + 1); // mutate its state
                            return n; // return mutated instance
                        })
                        .collect(Collectors.toList());*/

        System.out.println("Productos distintos mapper: " + listLog.size());
        List<LogHistoProduct> histoProductList = getLogHoy();
        List<LogHistoProduct> differencesLog = listLog.stream()
                .filter(element -> histoProductList.stream()
                            .noneMatch(p -> p.getId_carters().equals(element.getId_carters())))
                .collect(Collectors.toList());
        System.out.println("=============== PRODUCTOS LOG =============");
        System.out.println("Productos Log Hoy: " + histoProductList.size());
        System.out.println("Productos distintos log: " + differencesLog.size());
        System.out.println("Productos insertados log: " + differencesLog.size());
        logHistoProductRepository.saveAll(differencesLog);
        productoRepository.updateClearance();
        System.out.println("=============== ACTUALIZAR clearance =============");
        return differencesLog;
    }

    @Override
    public String actualizarProductos(){

        List<Producto> listFinalProducto = new ArrayList<>();
        List<LogHistoProduct> histoProductList = getLogHoy();
        List<Producto> productoList = productoRepository.getAllProductos();
        histoProductList.forEach( itemHistoProd -> {
            Producto productoTmp = productoList
                    .stream()
                    .filter(p -> p.getId_carters().equalsIgnoreCase(itemHistoProd.getId_carters()))
                    .collect(Collectors.toList()).get(0);
            productoTmp.setClearance(itemHistoProd.getClearance());
            Float pPrecioMin = productoTmp.getPrecio_min() != null ? productoTmp.getPrecio_min() : 0;
            Float pPrecioMax = productoTmp.getPrecio_max() != null ? productoTmp.getPrecio_max() : 0;
            Float hPrecioDescuento = itemHistoProd.getPrecio_descuento() != null ? itemHistoProd.getPrecio_descuento() : 0;
            if(pPrecioMin > hPrecioDescuento)
                productoTmp.setPrecio_min(hPrecioDescuento);
            if(pPrecioMax < hPrecioDescuento)
                productoTmp.setPrecio_max(hPrecioDescuento);
            if(!Objects.equals(productoTmp.getUltimo_precio_dscto(), itemHistoProd.getPrecio_descuento())){
                productoTmp.setPenultimo_precio_dscto(productoTmp.getUltimo_precio_dscto());
                productoTmp.setFecha_penultimo_precio_dscto(new Date());
                productoTmp.setUltimo_precio_dscto(itemHistoProd.getPrecio_descuento());
                productoTmp.setFecha_ultimo_precio_dscto(new Date());
            }
            if(!Objects.equals(productoTmp.getPrecio_original(), itemHistoProd.getPrecio_original())){
                productoTmp.setPrecio_original(itemHistoProd.getPrecio_original());
            }
            if(!Objects.equals(productoTmp.getPrecio_descuento(), itemHistoProd.getPrecio_descuento())){
                productoTmp.setPrecio_descuento(itemHistoProd.getPrecio_descuento());
            }
            listFinalProducto.add(productoTmp);
//            System.out.println(productoTmp);
        });
        System.out.println(histoProductList.size());
        System.out.println(productoList.size());
        System.out.println("=============== ACTUALIZAR PRODUCTOS NUEVOS =============");
        System.out.println("ACTUALIZADOS: " + listFinalProducto.size());
        productoRepository.saveAll(listFinalProducto);
        return "OK";
    }

    public void saveupdateall(){
        //25395,2022-04-03 22:50:11.120000,V_1N167210,https://cdn-fsly.yottaa.net/578855e22bb0ac10350002d6/www.carters.com/v~4b.16a/dw/image/v2/AAMK_PRD/on/demandware.static/-/Sites-carters_master_catalog/default/dw677753c2/productimages/1N167210.jpg?sw=354&sh=444&yocs=4G_4I_,Floral Jersey Tee,14.00,22.00,https://www.carters.com//carters-baby-girl-graphic-tees-and-bodysuits/V_1N167210.html,,2022-04-04 00:00:00,0.00,14.00,14.00,14.00,false,
 /*       Optional<Producto> p = productoRepository.findById(25395L);
        Producto p1 = p.get();
        p1.setClearance(Boolean.FALSE);
        System.out.println(p.get());
        List<Producto> list = new ArrayList<>();
        list.add(p1);
        productoRepository.saveAll(list);*/
    }

    @Override
    public List<VwProductosRS> getAllProductos() {
        return logHistoProductRepository.getAllProductos();
    }

    @Override
    public List<LogHistoProduct> findLast30ById(String idCarters) {
        return logHistoProductRepository.findLast30ById(idCarters);
    }

    @Override
    public List<VwProductosRS> getProductosSubidos() {
        return logHistoProductRepository.getProductosSubidos();
    }

    @Override
    public List<VwProductosRS> getProductosRebajados() {
        return logHistoProductRepository.getProductosRebajados();
    }

    @Override
    public List<VwProductosRS> getAllProductosOfertados() {
        return logHistoProductRepository.getAllProductosOfertados();
    }

    private List<LogHistoProduct> getLogHoy(){
        ZoneId zona = ZoneId.systemDefault();
        Date dateIni = Date.from(LocalDate.now().atStartOfDay(zona).toInstant());
        Date dateFin = Date.from(LocalDate.now().plusDays(1).atStartOfDay(zona).toInstant());
        List<Producto> listFinalProducto = new ArrayList<>();
        return logHistoProductRepository.getLogHoy(dateIni, dateFin);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private List<Producto> getProductosScraping() {

        List<Producto> list = new ArrayList<>();
        List<UrlBusqueda> listUrl = urlBusquedaRepository.getAllUrl();
        listUrl.forEach((itemUrl) -> {
            Document doc = null;
            try {
                doc = Jsoup.connect(itemUrl.getUrl())
                        .maxBodySize(0)
                        .timeout(60*1000)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("CANTIDAD: " + doc.getElementsByClass("product").size());
            Elements productos =  doc.getElementsByClass("product");

            int cont = 0;
            for (Element producto : productos) {
                Producto item = new Producto();
                System.out.println(cont++ + "==========================================================================");
                System.out.println("ID_PRODUCTO: " + producto.attr("data-pid") );
                item.setId_carters(producto.attr("data-pid"));
                Elements nombre_producto = producto.getElementsByClass("product-tile-title");
                System.out.println(producto.getElementsByClass("product-tile-information").attr("href"));
                item.setUrl_producto(url_base + producto.getElementsByClass("product-tile-information").attr("href"));
                for (Element nombre : nombre_producto) {
//                System.out.println(img.getElementsByTag("img").attr("data-yo-src") );
                    System.out.println("Nombre Producto:" + nombre.text());
                    item.setNombre_producto(nombre.text());
//                System.out.println(nombre.getElementsByClass("value m-asterisk").attr("content") );
                }
                Elements imagenes_producto = producto.getElementsByClass("product-tile-image-in  ");
                if(imagenes_producto.size() == 0){
                    imagenes_producto = producto.getElementsByClass("product-tile-image-in  multi-image");
                }
                for (Element img : imagenes_producto) {
//                System.out.println(img.getElementsByTag("img").attr("data-yo-src") );
//                System.out.println("IMAGENES:" + img);
                    System.out.println("IMAGENES:" + img.getElementsByTag("img").attr("data-yo-src") );
                    item.setImagen(img.getElementsByTag("img").attr("data-yo-src"));
                }
                Elements precios_oferta = producto.getElementsByClass("product-tile-price-sale ");
                if(precios_oferta.size() != 0){
                    for (Element precio : precios_oferta) {
//                System.out.println(img.getElementsByTag("img").attr("data-yo-src") );
//                System.out.println("PRECIO DESCUENTO:" + precio);
                        item.setClearance(Boolean.FALSE);
                        item.setOferta("NO");
                        System.out.println("PRECIO DESCUENTO: " + precio.getElementsByTag("span").attr("content") );
                        String precioDescuento = precio.getElementsByTag("span").attr("content");
                        item.setPrecio_descuento(precioDescuento.isEmpty()|| precioDescuento == null ? 0 : Float.parseFloat(precioDescuento));
                    }
                } else {
                    precios_oferta = producto.getElementsByClass("product-tile-price-sale is-clearance");
                    for (Element precio : precios_oferta) {

                        item.setClearance(Boolean.TRUE);
                        item.setOferta("SI");
                        System.out.println("PRECIO DESCUENTO: " + precio.getElementsByTag("span").attr("content") );
                        String precioDescuento = precio.getElementsByTag("span").attr("content");
                        item.setPrecio_descuento(precioDescuento.isEmpty() || precioDescuento == null  ? 0 : Float.parseFloat(precioDescuento));
                    }
                }

                Elements precios_original = producto.getElementsByClass("product-tile-price-original");
                for (Element precio_o : precios_original) {
//                System.out.println(img.getElementsByTag("img").attr("data-yo-src") );
//                System.out.println("PRECIO ORIGINAL:" + precio_o);
                    System.out.println("PRECIO ORIGINAL: " + precio_o.getElementsByClass("value m-asterisk").attr("content") );
                    String precioOriginal =  precio_o.getElementsByClass("value m-asterisk").attr("content");
                    item.setPrecio_original(precioOriginal.isEmpty() || precioOriginal == null ? 0 : Float.parseFloat(precioOriginal));
                }
                item.setCreatedDate(new Date());
                list.add(item);
//            System.out.println(producto);
            }
        });
        System.out.println("CANTIDAD TOTAL: " + list.size());
        return list;
//        logHistoProductRepository.saveAll(list);
    }

}
