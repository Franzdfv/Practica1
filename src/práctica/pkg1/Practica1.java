/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica.pkg1;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
/**
 */

 class Usuario {
    private String nombre, apellido, nacimiento, direccion, areafavorita;
     int cedula, telefono;
    
    // constructor
    public Usuario() {
        nombre = "desconocido";
        apellido = "desconocido";
        nacimiento= "desconocido";
        cedula = 0;
        direccion = "desconocido";
        telefono = 0;
        areafavorita = "desconocido";
        
    //  metodos modificadores
    public void setnombre(String nombre){this.nombre = nombre; }
    public void setapellido(String apellido){this.apellido = apellido; }
    public void setnacimiento(String nacimiento){this.nacimiento = nacimiento; }
    public void setcedula(int cedula){this.cedula = cedula; }
    public void setdireccion(String direccion){this.direccion = direccion; }
    public void settelefono(int telefono){this.telefono = telefono; }
    public void setareafavorita(String areafavorita){this.areafavorita = areafavorita; }
    
    // metodos analizadores
    public String getnombre() {return nombre; }
    public String getapellido() {return apellido; }
    public String getnacimiento() { return nacimiento; }
    public int getcedula() {return cedula; }
    public String getdireccion() { return direccion;}
    public int gettelefono() {return telefono;}
    public String getStringusuario () {
        
        String mensaje = "Información actual del usuario: \n";
        mensaje = mensaje + "nombre: " + this.getnombre()+"\n";
        mensaje = mensaje + "apellido: " + this.getapellido()+"\n";
        mensaje = mensaje + "nacimiento: " + this.getnacimiento() + "\n";
        mensaje = mensaje + "cedula: " + this.getcedula() + "\n";
        mensaje = mensaje + "direccion: " + this.getdireccion() + "\n";
        mensaje = mensaje + "telefono: " + this.gettelefono() + "\n";
        mensaje = mensaje + "\n\n\n";
        return mensaje;
    }
    

public class Dialogo {

    String dialogo;

    public Dialogo() {     }

    public int obtenerOpcionMenu() throws IOException {
        dialogo = "MENU DE PROGRAMA USUARIOS\n";
        dialogo += "1.  Ingrasar usuario\n";
        dialogo += "2.  Modificar datos de usuario \n";
        dialogo += "3.  Buscar usuario \n";
        dialogo += "4.  Eliminar usuario\n";
        dialogo += "5.  Salir\n";
        dialogo += "Escoja Opción:\n";
        return Integer.parseInt(JOptionPane.showInputDialog(dialogo));
    }

    public String obtenernombredeusuario() throws IOException {
        dialogo = "Introduzca Nombre de Usuario\n";
        return JOptionPane.showInputDialog(dialogo);
    }

    public String obtenerapellidodeusuario() throws IOException {
        dialogo = "Introduzca Apellido de Usuario\n";
        return JOptionPane.showInputDialog(dialogo);
    }

    public String obtenernacimientodeusuario() throws IOException {
        dialogo = "Introduzca Nacimiento de Usuario\n";
        return JOptionPane.showInputDialog(dialogo);
    }

    public String obtenerceduladeusuario() throws IOException {
        dialogo = "Introduzca Cedula de Usuario\n";
        return JOptionPane.showInputDialog(dialogo);
    }

    public String obtenerdirecciondeusuario() throws IOException {
        dialogo = "Introduzca Direccion de Usuario\n";
        return JOptionPane.showInputDialog(dialogo);
    }

    public int obtenertelefonodeusuario() throws IOException {
        dialogo = "Introduzca Telefono de Usuario\n";
        return Integer.parseInt(JOptionPane.showInputDialog(dialogo));
    }
    
    public void mostrarMensaje (String mensaje) {
        JFrame frame = new JFrame("Mensaje");
        JOptionPane.showMessageDialog(frame, mensaje);
    }
    
    public void cerrarPrograma () {
        JFrame frame = new JFrame("Final del programa");
        JOptionPane.showMessageDialog(frame, "Gracias por usar este programa. Fin");
        System.exit(0);
    }
}
//Clase con el main
    public class algoritmoTest {

    public void main (String[] Args) throws IOException {

        int opcionEligecliente = 0;
        ArrayList <Usuario> listadeusuarios = new ArrayList<Usuario>();
        Dialogo opcionescliente = new Dialogo();
        Dialogo mensajeVent = new Dialogo();

        while (opcionEligecliente != 5 ) {

            opcionEligecliente = opcionescliente.obtenerOpcionMenu();

            //Registrar la información de pasajero opción 1
            if (opcionEligecliente == 1) {

                usuario tmpusuario = new usuario();
                tmpusuario.Setnombre(opcionescliente.obtenernombredeusuario());
                tmpusuario.Setapellido(opcionescliente.obtenerapellidodeusuario());
                tmpusuario.Setnacimiento(opcionescliente.obtenernacimientodeusuario());
                tmpusuario.Setcedula(opcionescliente.obtenerceduladeusuario());
                tmpusuario.Setdireccion(opcionescliente.obtenerdirecciondeusuario());
                tmpusuario.Settelefono(opcionescliente.obtenertelefonodeusuario());
                
                //Terminamos guardando el objeto usuario
                usuario.add(tmpusuario);
            }
            

            //Modificar la información de un usuario opción 2
            if (opcionEligecliente == 2) {
                String usuarioBuscado = opcionescliente.obtenernombredeusuario();
                boolean usuarioEncontrado = false;

                Iterator<usuario> it = listadeusuarios.iterator();
                usuario tmpAnalizando;

                while ( it.hasNext() ) {           //Utilizamos el método hasNext de los objetos tipo Iterator

                    tmpAnalizando = it.next();                //Utilizamos el método next de los objetos tipo Iterator

                    if (tmpAnalizando.getnombre().equals(usuarioBuscado) ) {
                        usuarioEncontrado = true;
                        String mensaje = tmpAnalizando.getStringusuario();
                        mensaje = mensaje + "\n\n\n";
                        mensaje = mensaje + "A continuación introduzca nuevos datos para este usuario";

                        mensajeVent.mostrarMensaje(mensaje);

                        // Aquí código para pedir nuevos datos para el usuario

                        mensajeVent.mostrarMensaje("La identificación no puede ser modificada, indique resto de datos");
                        tmpAnalizando.Setapellido(opcionescliente.obtenerapellidodeusuario());
                        tmpAnalizando.Setnacimiento(opcionescliente.obtenernacimientodeusuario());
                        tmpAnalizando.Setcedula(opcionescliente.obtenerceduladeusuario());
                        tmpAnalizando.Setdireccion(opcionescliente.obtenerdirecciondeusuario());
                        tmpAnalizando.Settelefono(opcionescliente.obtenertelefonodeusuario());

                        mensaje = tmpAnalizando.getStringusuario();
                        mensajeVent.mostrarMensaje(mensaje);

                    } else { }    //else vacío. No hay acciones a ejecutar.

                } 

                if (usuarioEncontrado == false) {
                    mensajeVent.mostrarMensaje("No se encontró el usuario con esa identificación");
                }
            } //Fin opción 2 

            //Opción 3 
            if (opcionEligecliente == 3) {

                String listado = "";

                Iterator<usuario> it2 = listadeusuarios.iterator();
                usuario tmpAnalizando;

                while ( it2.hasNext() ) {           //Utilizamos el método hasNext de los objetos tipo Iterator
                    tmpAnalizando = it2.next();                //Utilizamos el método next de los objetos tipo Iterator
                    listado = listado + tmpAnalizando.getStringusuario();
                    listado = listado + "\n\n\n";
                } 

                mensajeVent.mostrarMensaje(listado);

            } //Fin opción 3 

            // Opción 4
            if (opcionEligecliente == 4) {
                String identclienteBuscado = opcionescliente.obtenernombredeusuario();
                boolean usuarioEncontrado = false;

                Iterator<usuario> it = listadeusuarios.iterator();
                usuario tmpAnalizando;

                while ( it.hasNext() && usuarioEncontrado==false ) {           //Utilizamos el método hasNext de los objetos tipo Iterator

                    tmpAnalizando = it.next();                //Utilizamos el método next de los objetos tipo Iterator

                    if (tmpAnalizando.getnombre().equals(identclienteBuscado) ) {
                        usuarioEncontrado = true;
                        String mensaje = tmpAnalizando.getStringusuario();
                        mensaje = mensaje + "\n\n\n";
                        mensaje = mensaje + "Se procede al borrado de datos de este usuario\n\n";

                        mensajeVent.mostrarMensaje(mensaje);

                        // Aquí código para pedir nuevos datos para el usuario
                        listadeusuarios.remove(tmpAnalizando);
                        usuarioEncontrado=true;

                    } else { }    

                } 

                if (usuarioEncontrado == false) {
                    mensajeVent.mostrarMensaje("No se encontró el usuario con esa identificación");
                }
            } //Fin opción 2 

        }

        opcionescliente.cerrarPrograma();
    }

    /**
     * @param args the command line arguments
     */
   
    }
    
}
