/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author mohel
 */
public class Marciano {
    //NECESITO DOS IMAGENES PARA EL MARCIANO
    
    public Image imagen1 = null;
    public Image imagen2 = null;
 
        //PARA QUE EL MARCIANO SEPA CUANDO MIDE LA PANTALLA DE ANCHO PARA QUE SEPA QUE HA LLEGADO AL FINAL DE LA PANTALLA
       private int anchoPantalla; 

       //DECLARO UN PUBLIC
       public int vida = 50;
       
       //NECESITO UN CONSTRUCTOR QUE SE LLAMA IGUAL QUE LA CLASE MARCIANO Y A ESTE CONSTRCUTOR LE PASO UN INTEGER QUE
       //ES EL ANCHO DE PANTALLA 
       public Marciano (int _anchoPantalla){
           
           anchoPantalla = _anchoPantalla;
           
           //PARA CARGAR LAS IMAGENES Y SINO ME DEJA PONGO EL CATCH PARA QUE SALGA UN TEXTO DE ERROR
           try {
               imagen1 = ImageIO.read(getClass().getResource("/imagenes/marcianito1.png"));
               imagen2 = ImageIO.read(getClass().getResource("/imagenes/marcianito2.png"));
           }
            catch(Exception e){
                
            }
            }
       }
    


