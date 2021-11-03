package com.example.gomarket.Estructural;

import java.util.ArrayList;

public class Principal {

    private static ArrayList<String> Usuarios = new ArrayList<>();
    private static ArrayList<String> Clave = new ArrayList<>();

    public static void cargarUsuarios(){
        addUsuarios("admin");
        addUsuarios("nicolas");
        addUsuarios("juanita");
    }

    public static  void cargarClave(){
        addClaves("admin");
        addClaves("123nicolas");
        addClaves("123juanita");
    }

    public static ArrayList<String> getUsuarios() {
        return Usuarios;
    }
    public static ArrayList<String> getClave() {
        return Clave;
    }

    public static String getUsuario(int i) {
        return Usuarios.get(i);
    }
    public static String getClave(int i) {
        return Clave.get(i);
    }


    public static void addUsuarios(String user) {
        Usuarios.add(user);
    }

    public static void addClaves(String clave) {
        Clave.add(clave);
    }

    public static void addUsuarioParam(String user) {
        int contador = 0;
        for (int i = 0; i < Usuarios.size(); i++) {

            if ((Usuarios.get(i) != user) && (contador < 1)) {
                Usuarios.add(user);
                contador++;
            }
        }
    }

    public static void addClaveParam(String clave) {
        int contador = 0;
        for (int i = 0; i < Clave.size(); i++) {

            if ((Clave.get(i) != clave) && (contador < 1)) {
                Clave.add(clave);
                contador++;
            }
        }
    }



}
