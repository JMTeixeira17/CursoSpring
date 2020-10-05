package com.example.cursospringweb;

import com.example.cursospringweb.models.domain.ItemFactura;
import com.example.cursospringweb.models.domain.Producto;
import com.example.cursospringweb.models.services.IServicio;
import com.example.cursospringweb.models.services.MiServicio;
import com.example.cursospringweb.models.services.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    public IServicio registrarMiServicio(){

        return new MiServicio();
    }

    @Bean("miServicioComplejo")
    @Primary
    public IServicio registrarMiServicioComplejo(){

        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony",100);
        Producto producto2 = new Producto("Bicicleta Bianchi Ring 26",200);

        ItemFactura linea1 = new ItemFactura(producto1,5);
        ItemFactura linea2 = new ItemFactura(producto2,6);

        return Arrays.asList(linea1,linea2); //Esto es como crear un Array List

    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor LG LCD 24",250);
        Producto producto2 = new Producto("Notebook Asus",500);
        Producto producto3 = new Producto("Impresora HP Multifuncional",800);
        Producto producto4 = new Producto("Escritorio de Oficina",3400);

        ItemFactura linea1 = new ItemFactura(producto1,5);
        ItemFactura linea2 = new ItemFactura(producto2,6);
        ItemFactura linea3 = new ItemFactura(producto3,1);
        ItemFactura linea4 = new ItemFactura(producto4,9);


        return Arrays.asList(linea1,linea2,linea3,linea4); //Esto es como crear un Array List

    }
}
