package com.example.gomarket.Logica;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.gomarket.Estructural.Usuario;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ServicioUsuarios {

    public static final int TAM_ID = 5;
    public static final int TAM_NOMBRE  = 20;
    public static final int TAM_CLAVE  = 20;

    public static final int TAM_TOTAL = TAM_ID+TAM_NOMBRE+TAM_CLAVE+12;

    private static File directorio;

    private static String nombreArchivo = "";

    public static File getDirectorio() {
        return directorio;
    }

    public static void setDirectorio(File directorio) {
        ServicioGestor.directorio = directorio;
    }

    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    public static void setNombreArchivo(String nombreArchivo) {
        ServicioGestor.nombreArchivo = nombreArchivo;
    }

    private static String setStringSize(String cad, int tam){
        int dif = 0;
        if(cad.length() > tam){
            cad = cad.substring(0, tam);
            return cad;
        }
        dif = tam - cad.length();
        cad = cad + new String(new char[dif]).replace('\0', ' ');
        return cad;
    }

    public static void adicionarUsuario(String id, String usuario, String clave){
        File archivo;
        RandomAccessFile raf;
        archivo = new File(directorio, nombreArchivo);
        try{
            raf = new RandomAccessFile(archivo,"rw");
            raf.seek(archivo.length());
            id = setStringSize(id, TAM_ID);
            usuario = setStringSize(usuario, TAM_NOMBRE);
            clave = setStringSize(clave, TAM_CLAVE);

            raf.writeUTF(id);
            raf.writeUTF(usuario);
            raf.writeUTF(clave);
            raf.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static String leerTodosRegistros(){
        File archivo;
        RandomAccessFile raf;
        String cad ="";
        String id = "";
        String usuario = "";
        String clave = "";

        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");

            while (raf.getFilePointer() < archivo.length()) {
                id = raf.readUTF();
                usuario = raf.readUTF();
                clave = raf.readUTF();
                cad = cad+" "+id.trim()+" "+ usuario.trim() +" "+ clave.trim() +"\n";
            }

            raf.close();
            return cad;
        } catch (Exception e) {
            System.out.println("Error= " + e);
        }
        return "FINAL";
    }

    public static Usuario leerPorNombre(String nombre){
        File archivo;
        RandomAccessFile raf;
        String cad ="";
        String id = "";
        String usuario = "";
        String clave = "";
        Usuario user;
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");

            while (raf.getFilePointer() < archivo.length()) {
                id = raf.readUTF();
                int idint = Integer.parseInt(id.trim());
                usuario = raf.readUTF();
                clave = raf.readUTF();

                if(usuario.trim().equals(nombre)){
                    user = new Usuario(usuario, clave, idint);
                    raf.close();
                    return user;
                }
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static void actualizarUsuario(String datoActualizar, String usuarioNuevo, String claveNuevo){
        File archivo;
        RandomAccessFile raf;
        String cad ="";
        String id = "";
        String usuario = "";
        String clave = "";
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");
            while (raf.getFilePointer() < archivo.length()){
                id  = raf.readUTF();
                usuario = raf.readUTF();
                clave = raf.readUTF();
                if(usuario.trim().equals(datoActualizar)){
                    raf.seek(raf.getFilePointer()-id.length()-usuario.length()-clave.length()-12);
                    usuario = setStringSize(usuario, TAM_NOMBRE);
                    raf.writeUTF(usuario);
                    clave = setStringSize(clave, TAM_CLAVE);
                    raf.writeUTF(clave);
                    raf.close();
                    return;
                }
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error= " + e);
        }
    }

    private static ArrayList<Usuario> listaUsuario = new ArrayList<>();

    private static ArrayList<String> NombreUsuario = new ArrayList<>();

    public static ArrayList<String> getnombreUsuario() {

        NombreUsuario.clear();
        cargarnombres();
        return NombreUsuario;
    }

    public static void addusiaro(Usuario nuevoUsuario) {
        if (listaUsuario != null) {
            listaUsuario.add(nuevoUsuario);
        }
    }

    public ServicioUsuarios(){
    }
    public static void cargarnombres (){
        File archivo;
        RandomAccessFile raf;
        String cad ="";
        String id = "";
        String usuario = "";
        String clave = "";
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");

            while (raf.getFilePointer() < archivo.length()) {
                id = raf.readUTF();
                int idint = Integer.parseInt(id.trim());
                usuario = raf.readUTF();
                clave = raf.readUTF();

                NombreUsuario.add(usuario);

            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void eliminarRegistros (String nombre){
        File archivo;
        RandomAccessFile raf;
        String id = "";
        String usuario = "";
        String clave = "";
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");

            while (raf.getFilePointer() < archivo.length()) {
                id = raf.readUTF();
                int idint = Integer.parseInt(id.trim());
                usuario = raf.readUTF();
                clave = raf.readUTF();
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


}
