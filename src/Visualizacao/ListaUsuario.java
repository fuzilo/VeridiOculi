/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Modelagem.QuickSortUsuarioA_Z;
import Modelagem.QuickSortUsuarioZ_A;
import Modelagem.Usuario;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dsm-2
 */
public class ListaUsuario extends javax.swing.JFrame {
    /**
     * Creates new form ListaUsuario
     */
    public ListaUsuario() {
        initComponents();
    }
    Usuario usu = new Usuario();
    QuickSortUsuarioA_Z qAZ = new QuickSortUsuarioA_Z();
    QuickSortUsuarioZ_A qZA = new QuickSortUsuarioZ_A();    
        public ArrayList<Usuario> ordenarAZ(){
            ResultSet tabela = usu.listarUsuario();
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
             try {
            // Convert the ResultSet into a List of Projeto objects
            tabela.beforeFirst();
            while (tabela.next()) {
                int id_usuario = tabela.getInt("id_usuario");
                String nome_usuario = tabela.getString("nome_usuario");
                String login_usuario = tabela.getString("login_usuario");
                String senha_usuario = tabela.getString("senha_usuario");
                String cpf = tabela.getString("cpf");
                String email = tabela.getString("email");
                String telefone = tabela.getString("telefone");
                String dt_nasc = tabela.getString("dt_nasc");
                String dt_criacao = tabela.getString("dt_criacao");
                Usuario usuario = new Usuario(id_usuario, nome_usuario, login_usuario, senha_usuario, cpf, email, telefone, dt_nasc, dt_criacao);
                usuarios.add(usuario);
            }
             for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
            qAZ.quicksort(usuarios);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
        }
        
        public ArrayList<Usuario> ordenarZA(){
            ResultSet tabela = usu.listarUsuario();
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
             try {
            // Convert the ResultSet into a List of Projeto objects
            tabela.beforeFirst();
            while (tabela.next()) {
                int id_usuario = tabela.getInt("id_usuario");
                String nome_usuario = tabela.getString("nome_usuario");
                String login_usuario = tabela.getString("login_usuario");
                String senha_usuario = tabela.getString("senha_usuario");
                String cpf = tabela.getString("cpf");
                String email = tabela.getString("email");
                String telefone = tabela.getString("telefone");
                String dt_nasc = tabela.getString("dt_nasc");
                String dt_criacao = tabela.getString("dt_criacao");
                Usuario usuario = new Usuario(id_usuario, nome_usuario, login_usuario, senha_usuario, cpf, email, telefone, dt_nasc, dt_criacao);
                usuarios.add(usuario);
            }
             for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
            qZA.quicksort(usuarios);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
        }
   
    public void listarUsuarioEspecifico(){
        
        ResultSet tabela;
        tabela = null;
        
        tabela = usu.listarUsuarioEspecifico();
        DefaultTableModel modelo = (DefaultTableModel) tblUsuario.getModel();
        modelo.setNumRows(0);
        
        try
        {
            do{
                modelo.addRow(new String[]{tabela.getString(1),tabela.getString(2),tabela.getString(3),tabela.getString(4),tabela.getString(5),tabela.getString(6),tabela.getString(7),tabela.getString(8),tabela.getString(9)});
            }
            while(tabela.next());
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela: "+erro);
        }
    }
    
    public void abrirModal(String id){
        ModalEditar modal = new ModalEditar(id);
        modal.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnOrdenarAZ = new javax.swing.JButton();
        btnOrdenarZA = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setText("Controle de usuários");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(224, 224, 224)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel2.setText("Filtros:");

        btnOrdenarAZ.setText("A->Z");
        btnOrdenarAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarAZActionPerformed(evt);
            }
        });

        btnOrdenarZA.setText("Z->A");
        btnOrdenarZA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarZAActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenarAZ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenarZA)
                .addGap(98, 98, 98)
                .addComponent(btnEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnOrdenarAZ)
                    .addComponent(btnOrdenarZA)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Login", "Senha", "CPF", "E-mail", "Telefone", "Data de nascimento", "Data de criação"
            }
        ));
        jScrollPane1.setViewportView(tblUsuario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        usu.setNome_usuario(txtBusca.getText());
        usu.listarUsuarioEspecifico();
        listarUsuarioEspecifico();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnOrdenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarAZActionPerformed
        // TODO add your handling code here:
        ArrayList<Usuario> usuariosOrdenados = ordenarAZ();

        // Limpe o modelo da tabela antes de atualizá-la
        DefaultTableModel modelo = (DefaultTableModel) tblUsuario.getModel();
        if (modelo.getRowCount() > 0) {
            modelo.setRowCount(0);
        }

        // Adicione os dados do array ordenado à tabela
        for (Usuario usuario : usuariosOrdenados) {
            Object[] rowData = {usuario.getId_usuario(), usuario.getNome_usuario(),usuario.getLogin_usuario(),usuario.getSenha_usuario(), usuario.getCpf(), usuario.getEmail(), usuario.getTelefone(), usuario.getDt_nasc(), usuario.getDt_criacao()};
            modelo.addRow(rowData);
        }
    }//GEN-LAST:event_btnOrdenarAZActionPerformed

    private void btnOrdenarZAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarZAActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        ArrayList<Usuario> usuariosOrdenados = ordenarZA();

        // Limpe o modelo da tabela antes de atualizá-la
        DefaultTableModel modelo = (DefaultTableModel) tblUsuario.getModel();
        if (modelo.getRowCount() > 0) {
            modelo.setRowCount(0);
        }

        // Adicione os dados do array ordenado à tabela
        for (Usuario usuario : usuariosOrdenados) {
            Object[] rowData = {usuario.getId_usuario(), usuario.getNome_usuario(), usuario.getCpf(), usuario.getEmail(), usuario.getTelefone(), usuario.getDt_nasc(), usuario.getDt_criacao()};
            modelo.addRow(rowData);
        }
    }//GEN-LAST:event_btnOrdenarZAActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
        int rowIndex = tblUsuario.getSelectedRow();

        if (rowIndex != -1) {
            Object idValue = tblUsuario.getValueAt(rowIndex, 0);
            Object usuarioValue = tblUsuario.getValueAt(rowIndex, 1);
            Object loginValue = tblUsuario.getValueAt(rowIndex, 2);
            Object senhaValue = tblUsuario.getValueAt(rowIndex, 3);
            Object cpfValue = tblUsuario.getValueAt(rowIndex, 4);
            Object emailValue = tblUsuario.getValueAt(rowIndex, 5);
            Object telefoneValue = tblUsuario.getValueAt(rowIndex, 6);
            Object dataNascimentoValue = tblUsuario.getValueAt(rowIndex, 7);
            
            String id = idValue.toString();
            String usuario = usuarioValue.toString();
            String login = loginValue.toString();
            String senha = senhaValue.toString();
            String cpf = cpfValue.toString();
            String dataNascimento = dataNascimentoValue.toString();
            String email = emailValue.toString();
            String telefone = telefoneValue.toString();
            
            abrirModal(id);

        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnOrdenarAZ;
    private javax.swing.JButton btnOrdenarZA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
