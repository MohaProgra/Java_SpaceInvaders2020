/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

/**
 *
 * @author jorgecisneros
 */
public class VentanaJuego extends javax.swing.JFrame {
    
    static int ANCHOPANTALLA = 800;
    static int ALTOPANTALLA = 600;
    
    
    //UNA VARIABLE QUE GUARDA CUANTOS MARCIANOS VOY A PONER.
    //CUANTAS FILAS VAN A SALIR Y CUANTAS COLUMNAS VA A TENER
    
    int filasMarcianos = 5;
    int columnasMarcianos = 10;
    int contador = 0;
    
    BufferedImage buffer = null;
    
    //bucle de animacion del juego.
    //en este caso, es un hilo de ejecución que se encarga 
    //de refrescar el contenido de la pantalla
    //es un objeto de tipo timer
    //10 es el tiempo en milisegundo/el listener eschuca que el temporizador
    //ha sonado.
    Timer temporizador = new Timer (10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO : CODIGO DE LA ANIMACIÓN. CADA 10 MILISEGUNDO VA A LLAMAR
            //AL SIGUIENTE CODIGO QUE VOY A ESCRIBIR.
            //CREAMOS UN METODO QUE SALE EN ROJO PORQUE NO ESTA CREADO
            bucleDelJuego();
        }
    });
    
    //DECLARAMOS UNA VARIABLE DE INSTANCIA
        Marciano miMarciano = new Marciano (ANCHOPANTALLA);
        
        //ES PARA TODOS LOS MARCIANO. DECLARO UN ARRAY DE 2 DIMENSIONES.
        Marciano [][] listaMarcianos = new Marciano [filasMarcianos][columnasMarcianos];
        boolean direccionMarcianos = false;
        
        Nave miNave = new Nave();
        Disparo miDisparo = new Disparo ();
       
    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        initComponents();
        setSize(ANCHOPANTALLA, ALTOPANTALLA);
        //crea una imagen del mismo alto y ancho que el jpanel 1 y lo guarda en el buffer
        //Busca el objeto JPanel 1 y con ese alto y ancho crea una imagen.
        buffer = (BufferedImage)jPanel2.createImage(ANCHOPANTALLA, ALTOPANTALLA);
        //crea una objeto Graphics para dibujar metodos como el circulo, recta, etc.
        //El buffer es una zona de la memoria.
        buffer.createGraphics();
        
        //ARRANCO EL TEMPORIZADOR PARA QUE EMPIECE EL JUEGO
        temporizador.start();
         //LE ASIGNAMOS UNAS COORDENADAS A LA NAVE
        miNave.posX =  ANCHOPANTALLA/2 - miNave.imagen.getWidth(this)/2;
        miNave.posY = ALTOPANTALLA - 100;
        
        for (int i=0 ; i<filasMarcianos; i++){
            for (int j=0 ; j<columnasMarcianos; j++){
                listaMarcianos [i][j] = new Marciano (ANCHOPANTALLA);
                listaMarcianos[i][j].posX = j*(15+listaMarcianos [i][j].imagen1.getWidth(null));
                listaMarcianos[i][j].posY = i*(10+listaMarcianos[i][j].imagen1.getHeight(null));
            }
        }
    }
    
         private void pintaMarcianos(Graphics2D _g2){
             
          for (int i=0 ; i<filasMarcianos; i++){
            for (int j=0 ; j<columnasMarcianos; j++){
                
                
                listaMarcianos [i][j]. mueve(direccionMarcianos);
                        if(listaMarcianos[i][j].posX >= ANCHOPANTALLA-listaMarcianos[i][j].imagen1.getWidth(null))
                        {
                            direccionMarcianos = !direccionMarcianos;
                            
                        }
                        if(listaMarcianos[i][j].posX <=0){
                            direccionMarcianos=!direccionMarcianos;
                        }
                if (contador < 50){
                    _g2.drawImage(listaMarcianos [i][j].imagen1, listaMarcianos[i][j].posX, listaMarcianos[i][j].posY, null);
                            
                }
                else if (contador < 100){
                    _g2.drawImage(listaMarcianos[i][j].imagen2, listaMarcianos[i][j].posX, listaMarcianos[i][j].posY, null);
                }
                else {
                    contador = 0;
            }
        }
    }

         }  
    
           
    
        //CREO EL METODO DEL BUCLE DEL JUEGO QUE NO DEVUELVE NADA POR ESO ES PRIVATE VOID
    
        private void bucleDelJuego(){
                   
            //ESTE METODO (BUCLE DE JUEGO) GOBBIERNA EL REDIBUJADO DE LOS OBJETOS EN EL JPANEL.
            
            
            //PRIMERO BORRO TODO LO QUE HAY EN EL BUFFER
            //HE BORRADO LO QUE HAY EN EL BUFFER PERO NO EN EL JPANEL
            Graphics2D g2 = (Graphics2D) buffer.getGraphics();
            g2.setColor(Color.BLACK);
            //creo pintar un cuadro de las siguiente dimensiones
            g2.fillRect (0, 0, ANCHOPANTALLA, ALTOPANTALLA);
            
            //CADA VEZ QUE EL TEMPORIZADOR EMPIEZA CADA 10 MS LLAMA AL JUEGO
            
            contador++;
            
          pintaMarcianos(g2);        
           
                    
            
            
            ////////////////////////////////////
            
            //DIBUJO LA NAVE
            g2. drawImage (miNave.imagen, miNave.posX, miNave.posY, null);
            g2. drawImage (miDisparo.imagen, miDisparo.posX,miDisparo.posY, null);
            
            //LE DECIMOS A MI NAVE QUE SI LA NAVE TIENE A TRUE EL LA DEREHA LO MOVERA
            miNave.mueve();
            miDisparo.mueve();
            
            //DIBUJO DE GOLPE TODO EL BUFFER SOBRE JPANEL1.
            g2 = (Graphics2D)jPanel2.getGraphics();
            g2.drawImage(buffer, 0, 0, null);
            
        }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jPanel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch(evt.getKeyCode()){
            case KeyEvent.VK_LEFT : miNave.setPulsadoIzquierda(true); break;
            case KeyEvent.VK_RIGHT : miNave.setPulsadoDerecha(true); break;
            case KeyEvent.VK_SPACE : miDisparo.posicionDisparo(miNave);
                                     break;
    }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        switch(evt.getKeyCode()){
            case KeyEvent.VK_LEFT : miNave.setPulsadoIzquierda(false); break;
            case KeyEvent.VK_RIGHT : miNave.setPulsadoDerecha(false); break;
            
        }
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
