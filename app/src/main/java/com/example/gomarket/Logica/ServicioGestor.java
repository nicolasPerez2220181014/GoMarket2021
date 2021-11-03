package com.example.gomarket.Logica;

import com.example.gomarket.Estructural.Gestor;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ServicioGestor {

    public static final int TAM_ID = 5;
    public static final int TAM_NOMBRE  = 20;
    public static final int TAM_NIT  = 20;
    public static final int TAM_UBICACION  = 20;
    public static final int TAM_DESCRIPCION = 30;
    public static final int TAM_URL_IMAGEN  = 30;
    public static final int TAM_HORARIO  = 10;
    public static final int TAM_TOTAL = TAM_ID+TAM_NIT+TAM_UBICACION+TAM_DESCRIPCION+TAM_URL_IMAGEN+TAM_HORARIO+12;

    public static File directorio;
    public static String nombreArchivo;

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

    public static void adicionarGestor(String id, String nombre, String nit, String ubicacion, String descripcion, String urlImagen, String horario){
        File archivo;
        RandomAccessFile raf;
        archivo = new File(directorio, nombreArchivo);
        try{
            raf = new RandomAccessFile(archivo,"rw");
            raf.seek(archivo.length());
            id = setStringSize(id, TAM_ID);
            nombre = setStringSize(nombre, TAM_NOMBRE);
            nit = setStringSize(nit, TAM_NIT);
            ubicacion = setStringSize(ubicacion, TAM_UBICACION);
            descripcion = setStringSize(descripcion, TAM_DESCRIPCION);
            urlImagen = setStringSize(urlImagen, TAM_URL_IMAGEN);
            horario = setStringSize(horario, TAM_HORARIO);

            raf.writeUTF(id);
            raf.writeUTF(nombre);
            raf.writeUTF(nit);
            raf.writeUTF(ubicacion);
            raf.writeUTF(descripcion);
            raf.writeUTF(urlImagen);
            raf.writeUTF(horario);
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
        String nom = "";
        String nit = "";
        String ubicacion = "";
        String descripcion = "";
        String urlImagen = "";
        String horario = "";
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");

            while (raf.getFilePointer() < archivo.length()) {
                id = raf.readUTF();
                nom = raf.readUTF();
                nit = raf.readUTF();
                ubicacion = raf.readUTF();
                descripcion = raf.readUTF();
                urlImagen = raf.readUTF();
                horario = raf.readUTF();
                cad = cad+" "+id.trim()+" "+nom.trim()+" "+nit.trim()
                        +" "+ubicacion.trim()+" "+descripcion.trim()
                        +" "+urlImagen.trim()+" "+horario.trim() +"\n";
            }

            raf.close();
            return cad;
        } catch (Exception e) {
            System.out.println("Error= " + e);
        }
        return "FINAL";
    }

    public static Gestor leerPorNombre(String nombre){
        File archivo;
        RandomAccessFile raf;
        String cad ="";
        String id = "";
        String nom = "";
        String nit = "";
        String ubicacion = "";
        String descripcion = "";
        String urlImagen = "";
        String horario = "";
        Gestor ges;
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");

            while (raf.getFilePointer() < archivo.length()) {
                id = raf.readUTF();
                int idint = Integer.parseInt(id.trim());
                nom = raf.readUTF();
                nit = raf.readUTF();
                ubicacion = raf.readUTF();
                descripcion = raf.readUTF();
                urlImagen = raf.readUTF();
                horario = raf.readUTF();

                if(nom.trim().equals(nombre)){
                    ges = new Gestor(idint,nom, nit, ubicacion, descripcion, urlImagen, horario);
                    raf.close();
                    return ges;
                }
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static void actualizarGestor(String datoActualizar, String nuevoNombre, String nuevoNit,
                                          String nuevaUbicacion, String nuevaDescripcion, String nuevaUrl, String nuevoHorario){
        File archivo;
        RandomAccessFile raf;
        String cad ="";
        String id = "";
        String nom = "";
        String nit = "";
        String ubicacion = "";
        String descripcion = "";
        String urlImagen = "";
        String horario = "";
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");
            while (raf.getFilePointer() < archivo.length()){
                id  = raf.readUTF();
                nom = raf.readUTF();
                nit = raf.readUTF();
                ubicacion = raf.readUTF();
                descripcion = raf.readUTF();
                urlImagen = raf.readUTF();
                horario = raf.readUTF();
                if(nom.trim().equals(datoActualizar)){
                    raf.seek(raf.getFilePointer()-id.length()-nit.length()-ubicacion.length()-descripcion.length()-urlImagen.length()-horario.length()-12);
                    nuevoNombre = setStringSize(nuevoNombre, TAM_NOMBRE);
                    raf.writeUTF(nuevoNombre);
                    nuevoNit = setStringSize(nuevoNit, TAM_NIT);
                    raf.writeUTF(nuevoNit);
                    nuevaUbicacion = setStringSize(nuevaUbicacion, TAM_UBICACION);
                    raf.writeUTF(nuevaUbicacion);
                    nuevaDescripcion = setStringSize(nuevaDescripcion, TAM_DESCRIPCION);
                    raf.writeUTF(nuevaDescripcion);
                    nuevaUrl = setStringSize(nuevaUrl, TAM_URL_IMAGEN);
                    raf.writeUTF(nuevaUrl);
                    nuevoHorario = setStringSize(nuevoHorario, TAM_HORARIO);
                    raf.writeUTF(nuevoHorario);
                    raf.close();
                    return;
                }
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error= " + e);
        }
    }

    private static ArrayList<Gestor> listaGestor = new ArrayList<>();

    private static ArrayList<String> NombreGestor = new ArrayList<>();

    public static ArrayList<String> getnombreGestor() {

        NombreGestor.clear();
        cargarnombres();
        return NombreGestor;
    }

    public static void addGestor(Gestor nuevoGestor) {
        if (listaGestor != null) {
            listaGestor.add(nuevoGestor);
        }
    }

    public ServicioGestor(){
    }
    public static void cargarnombres (){
        File archivo;
        RandomAccessFile raf;
        String cad ="";
        String id = "";
        String nom = "";
        String nit = "";
        String ubicacion = "";
        String descripcion = "";
        String urlImagen = "";
        String horario = "";
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");

            while (raf.getFilePointer() < archivo.length()) {
                id = raf.readUTF();
                int idint = Integer.parseInt(id.trim());
                nom = raf.readUTF();
                nit = raf.readUTF();
                ubicacion = raf.readUTF();
                descripcion = raf.readUTF();
                urlImagen = raf.readUTF();
                horario = raf.readUTF();

                NombreGestor.add(nom);

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
        String nom = "";
        String nit = "";
        String ubicacion = "";
        String descripcion = "";
        String urlImagen = "";
        String horario = "";
        archivo = new File(directorio, nombreArchivo);
        try {
            raf = new RandomAccessFile(archivo, "rw");

            while (raf.getFilePointer() < archivo.length()) {
                id = raf.readUTF();
                int idint = Integer.parseInt(id.trim());
                nom = raf.readUTF();
                nit = raf.readUTF();
                ubicacion = raf.readUTF();
                descripcion = raf.readUTF();
                urlImagen = raf.readUTF();
                horario = raf.readUTF();
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}