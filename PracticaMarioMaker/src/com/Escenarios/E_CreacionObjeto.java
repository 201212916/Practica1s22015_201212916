package com.Escenarios;

import com.Main.CargaObjetos;
import com.Pojos.*;
import com.Reportes.ArchivoListas;
import com.Reportes.ArchivoOrtogonal;
import javax.swing.JOptionPane;

public class E_CreacionObjeto extends javax.swing.JFrame {

    /* Variables globales*/
    private CargaObjetos carga;
    private ArchivoListas archivoL;
   // private ArchivoOrtogonal archivoO;
    /* Fin de variables globales */

    public E_CreacionObjeto() {
        initComponents();
        setLocationRelativeTo(null);

        carga = new CargaObjetos();
        archivoL = new ArchivoListas();
        //archivoO = new ArchivoOrtogonal(carga);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creacion de Objeto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Creacion de Objeto");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Personaje", "Goomba", "Koopa", "Moneda", "Hongo_Vida", "Suelo", "Pared", "Castillo" }));

        jLabel2.setText("Tipo");

        jLabel3.setText("Nombre");

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 97, Short.MAX_VALUE)
                                    .addComponent(jTextField1))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String item = this.jComboBox1.getSelectedItem().toString();
        String nombre =  item + "_";
        String complemento = jTextField1.getText();

        switch (item) {
            case "Personaje":
                if(carga.getJugador().esVacio()){
                   if(complemento.equals("")){
                       carga.getJugador().agregarNodo(new Personaje(1, "Mario Bros"));
                   }else{
                       carga.getJugador().agregarNodo(new Personaje(1,complemento));
                   }   
                }else{
                  JOptionPane.showMessageDialog(null, "Ya hay un personaje creado anteriormente");
                }
                break;
            case "Goomba":
                if(complemento.equals("")){
                    carga.getGoomba().agregarNodo(new Goomba(carga.getGoomba().getSize() + 1, nombre + (carga.getGoomba().getSize() + 1)));
                }else{
                    carga.getGoomba().agregarNodo(new Goomba(carga.getGoomba().getSize() + 1, nombre + complemento));
                }
                carga.getGoomba().verLista();
                break;
            case "Koopa":
                if(complemento.equals("")){
                    carga.getKoopa().agregarNodo(new Koopa(carga.getKoopa().getSize() + 1, nombre + (carga.getKoopa().getSize() + 1)));
                }else{
                    carga.getKoopa().agregarNodo(new Koopa(carga.getKoopa().getSize() + 1, nombre + complemento));
                }
                carga.getKoopa().verLista();
                break;
            case "Moneda":
                if(complemento.equals("")){
                    carga.getMoneda().agregarNodo(new Moneda(carga.getMoneda().getSize() + 1, nombre + (carga.getMoneda().getSize() + 1)));
                }else{
                    carga.getMoneda().agregarNodo(new Moneda(carga.getMoneda().getSize() + 1, nombre + complemento));
                }
                carga.getMoneda().verLista();
                break;
            case "Hongo_Vida":
                if(complemento.equals("")){
                    carga.getVida().agregarNodo(new Vida(carga.getVida().getSize() + 1, nombre + (carga.getVida().getSize() + 1)));
                }else{
                    carga.getVida().agregarNodo(new Vida(carga.getVida().getSize() + 1, nombre + complemento));
                }
                carga.getVida().verLista();
                break;
            case "Suelo":
                if(complemento.equals("")){
                    carga.getSuelo().agregarNodo(new Suelo(carga.getSuelo().getSize() + 1, nombre + (carga.getSuelo().getSize() + 1)));
                }else{
                    carga.getSuelo().agregarNodo(new Suelo(carga.getSuelo().getSize() + 1, nombre + complemento));
                }
                carga.getSuelo().verLista();
                break;
            case "Pared":
                if(complemento.equals("")){
                    carga.getPared().agregarNodo(new Pared(carga.getPared().getSize() + 1, nombre + (carga.getPared().getSize() + 1)));
                }else{
                    carga.getPared().agregarNodo(new Pared(carga.getPared().getSize() + 1, nombre + complemento));
                }
                carga.getPared().verLista();
                break;
            case "Castillo":
                if(carga.getCastillo().esVacio()){
                   if(complemento.equals("")){
                       carga.getCastillo().agregarNodo(new Castillo(1, nombre + "1"));
                   }else{
                       carga.getCastillo().agregarNodo(new Castillo(1,nombre +complemento));
                   }   
                }else{
                  JOptionPane.showMessageDialog(null, "Ya hay un castillo creado anteriormente");
                }
        }
        
        
		
		archivoL.generarArchivo();

		
        
        this.hide();


    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
