package com.example.cursospringweb.models.services;

import org.springframework.stereotype.Component;

//@Component("miServicioSimple") //Tambien se puede utilizar @Service
public class MiServicio implements IServicio{

    //Todo componente Spring debe tener constructor vacío. En este caso es implícito

    @Override
    public String operacion() {
        return "Ejecutando algún proceso interesante";
    }
}
