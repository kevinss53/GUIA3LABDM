package com.example.guia3labdm.Entidades;

public class Nombres {
    private String nombres;
    private static int contador =0;

    public void setNombres(String nomb)
    {
        this.nombres = nomb;
    }
    public String getNombres()
    {
        return this.nombres;
    }
    public void correlativo()
    {
        contador++;
    }

}
