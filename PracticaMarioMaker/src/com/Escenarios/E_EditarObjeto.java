package com.Escenarios;

import com.Main.CargaObjetos;
import com.Pojos.*;
import com.Reportes.ArchivoListas;
import javax.swing.JOptionPane;

public class E_EditarObjeto extends javax.swing.JFrame {

    /* Variables globales*/
    private CargaObjetos carga;
    private ArchivoListas a;
    /* Fin de variables globales */

    
    
    public E_EditarObjeto() {
        initComponents();
        setLocationRelativeTo(null);
        
        carga = new CargaObjetos();
        a = new ArchivoListas();
        
    }
    
    public void ejecutar(){
    	jComboBox2.removeAllItems();
        jTextField1.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Modificar Objeto");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Personaje", "Goomba", "Koopa", "Moneda", "Hongo_Vida", "Suelo", "Pared", "Castillo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo");

        jLabel3.setText("Nombre");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nuevo nombre");

        jTextField1.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 97, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
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
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String item = this.jComboBox1.getSelectedItem().toString();

        switch (item) {
            case "Personaje":
            jTextField1.setText("");
            jComboBox2.removeAllItems();
            if(!carga.getJugador().esVacio()){
                String jugador[] = carga.getJugador().getNodo(1).getDato().toString().split(":");
                for(int i = 1; i<=carga.getJugador().getSize(); i++){
                    jComboBox2.addItem(i + " " + jugador[2]);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay items de este objeto");
            }
            break;
            case "Goomba":
            jTextField1.setText("");
            jComboBox2.removeAllItems();
            if(!carga.getJugador().esVacio()){
                for(int i = 1; i<=carga.getGoomba().getSize(); i++){
                    jComboBox2.addItem(i + " " + carga.getGoomba().getNodo(i).getDato().toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay items de este objeto");
            }
            break;
            case "Koopa":
                jTextField1.setText("");
                jComboBox2.removeAllItems();
            if(!carga.getJugador().esVacio()){
                
                for(int i = 1; i<=carga.getKoopa().getSize(); i++){
                    jComboBox2.addItem(i + " " + carga.getKoopa().getNodo(i).getDato().toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay items de este objeto");
            }
            break;
            case "Moneda":
                jTextField1.setText("");
                jComboBox2.removeAllItems();
            if(!carga.getJugador().esVacio()){
                
                for(int i = 1; i<=carga.getMoneda().getSize(); i++){
                    jComboBox2.addItem(i + " " + carga.getMoneda().getNodo(i).getDato().toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay items de este objeto");
            }
            break;
            case "Hongo_Vida":
                jTextField1.setText("");
                jComboBox2.removeAllItems();
            if(!carga.getJugador().esVacio()){
                
                for(int i = 1; i<=carga.getVida().getSize(); i++){
                    jComboBox2.addItem(i + " " + carga.getVida().getNodo(i).getDato().toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay items de este objeto");
            }
            break;
            case "Suelo":
                jTextField1.setText("");
                jComboBox2.removeAllItems();
            if(!carga.getJugador().esVacio()){
                
                for(int i = 1; i<=carga.getSuelo().getSize(); i++){
                    jComboBox2.addItem(i + " " + carga.getSuelo().getNodo(i).getDato().toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay items de este objeto");
            }
            break;
            case "Pared":
                jTextField1.setText("");
                jComboBox2.removeAllItems();
            if(!carga.getJugador().esVacio()){
                
                for(int i = 1; i<=carga.getPared().getSize(); i++){
                    jComboBox2.addItem(i + " " + carga.getPared().getNodo(i).getDato().toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay items de este objeto");
            }
            break;
            case "Castillo":
                jTextField1.setText("");
                jComboBox2.removeAllItems();
            if(!carga.getJugador().esVacio()){
                
                for(int i = 1; i<=carga.getCastillo().getSize(); i++){
                    jComboBox2.addItem(i + " " + carga.getCastillo().getNodo(i).getDato().toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay items de este objeto");
            }
            break;
        }

        a.generarArchivo();

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String item = this.jComboBox1.getSelectedItem().toString();
        String item2 = this.jComboBox2.getSelectedItem().toString();
        String objetos[] = item2.split(" ");
        int posicion = Integer.parseInt(objetos[0]);
        String real = objetos[1];
        String nuevo = jTextField1.getText();
        
        String objeto = "";
        
        if(nuevo.equals("")){
            objeto = real;
        }else{
            objeto = "* " + nuevo;
        }


        switch (item) {
            case "Personaje":
                carga.getPojoPersonaje().setNombre(objeto);
            break;
            case "Goomba":
                carga.getGoomba().getNodo(posicion).setDato(objeto);
            break;
            case "Koopa":
                carga.getKoopa().getNodo(posicion).setDato(objeto);
            break;
            case "Moneda":
                carga.getMoneda().getNodo(posicion).setDato(objeto);
            break;
            case "Hongo_Vida":
                carga.getVida().getNodo(posicion).setDato(objeto);
            break;
            case "Suelo":
                carga.getSuelo().getNodo(posicion).setDato(objeto);
            break;
            case "Pared":
                carga.getPared().getNodo(posicion).setDato(objeto);
            break;
            case "Castillo":
                carga.getCastillo().getNodo(posicion).setDato(objeto);
            break;

        }

        a.generarArchivo();
        JOptionPane.showMessageDialog(null, "Item Modificado");
        this.hide();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
    }//GEN-LAST:event_jComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
