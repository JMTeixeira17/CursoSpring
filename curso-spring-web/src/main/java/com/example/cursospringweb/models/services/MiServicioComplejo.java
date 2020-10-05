package com.example.cursospringweb.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("miServicioComplejo") //Tambien se puede utilizar @Service
//@Primary  //Permite seleccionar el candidato a inyectar por defecto.
public class MiServicioComplejo implements IServicio{

    //Todo componente Spring debe tener constructor vacío. En este caso es implícito

    @Override
    public String operacion() {
        return "Ejecutando algún proceso complicado";
    }
}
