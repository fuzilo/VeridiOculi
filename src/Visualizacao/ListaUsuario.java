/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Modelagem.QuickSortUsuarioA_Z;
import Modelagem.QuickSortUsuarioZ_A;
import Modelagem.Usuario;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
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
        listarTudo();
    }
  
    Usuario usu = new Usuario();
    QuickSortUsuarioA_Z qAZ = new QuickSortUsuarioA_Z();
    QuickSortUsuarioZ_A qZA = new QuickSortUsuarioZ_A();    
        public ArrayList<Usuario> ordenarAZ(){
            ResultSet tabela = usu.listarUsuario();
            ArrayList<Usuario> usuarios = new ArrayList<>();
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
            //Teste para validar a quantidade de registros que estão sendo inseridos no array
            System.out.println(usuario.toString());
        }
            qAZ.quicksort(usuarios);
        } catch (SQLException e) {
        }
        return usuarios;
        }
        
        public ArrayList<Usuario> ordenarZA(){
            ResultSet tabela = usu.listarUsuario();
            ArrayList<Usuario> usuarios = new ArrayList<>();
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
            //Teste para validar a quantidade de registros que estão sendo inseridos no array
            System.out.println(usuario.toString());
        }
            qZA.quicksort(usuarios);
        } catch (SQLException e) {
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
    
    public void listarTudo(){
        ResultSet tabela;
        tabela = null;
        
        tabela = usu.listarUsuario();
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
        System.out.println("Teste");
              
    }
    
    public void abrirModal(String id, String nome, String login, String senha, String cpf, String dataNascimento, String email, String telefone){
        ModalEditar modal = new ModalEditar(id,nome,login, senha, cpf, dataNascimento, email, telefone);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnBuscar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnOrdenarAZ = new javax.swing.JButton();
        btnOrdenarZA = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBusca.setBorder(null);

        jScrollPane1.setBorder(null);

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
        tblUsuario.setBackground(new Color(0, 0, 0, 0)); // Define o fundo da tabela como transparente
        tblUsuario.setOpaque(false); // Torna a tabela opaca
        ((DefaultTableCellRenderer)tblUsuario.getDefaultRenderer(Object.class)).setOpaque(false); // Torna as células opacas
        javax.swing.table.JTableHeader header = tblUsuario.getTableHeader();
        header.setBackground(new Color(0, 0, 0, 0)); // Define o fundo do cabeçalho como transparente
        header.setOpaque(false); // Torna o cabeçalho opaco
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setOpaque(false); // Torna as células do cabeçalho opacas

        btnOrdenarAZ.setBorder(null);
        btnOrdenarAZ.setContentAreaFilled(false);
        btnOrdenarAZ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenarAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarAZActionPerformed(evt);
            }
        });

        btnOrdenarZA.setBorder(null);
        btnOrdenarZA.setContentAreaFilled(false);
        btnOrdenarZA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenarZA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarZAActionPerformed(evt);
            }
        });

        btnEditar.setContentAreaFilled(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnHome.setContentAreaFilled(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnExcluir.setBorderPainted(false);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(btnOrdenarAZ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnOrdenarZA, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOrdenarZA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnOrdenarAZ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jLayeredPane1.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtBusca, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnOrdenarAZ, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnOrdenarZA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnHome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visualizacao/icones/tela_controle_usuario.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

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
            Object[] rowData = {usuario.getId_usuario(), usuario.getNome_usuario(),usuario.getLogin_usuario(),usuario.getSenha_usuario(), usuario.getCpf(), usuario.getEmail(), usuario.getTelefone(), usuario.getDt_nasc(), usuario.getDt_criacao()};
            modelo.addRow(rowData);
        }
    }//GEN-LAST:event_btnOrdenarZAActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
        int rowIndex = tblUsuario.getSelectedRow();

        if (rowIndex != -1) {
            Object idValue = tblUsuario.getValueAt(rowIndex, 0);
            Object nomeValue = tblUsuario.getValueAt(rowIndex, 1);
            Object loginValue = tblUsuario.getValueAt(rowIndex, 2);
            Object senhaValue = tblUsuario.getValueAt(rowIndex, 3);
            Object cpfValue = tblUsuario.getValueAt(rowIndex, 4);
            Object emailValue = tblUsuario.getValueAt(rowIndex, 5);
            Object telefoneValue = tblUsuario.getValueAt(rowIndex, 6);
            Object dataNascimentoValue = tblUsuario.getValueAt(rowIndex, 7);
            
            String id = idValue.toString();
            String nome = nomeValue.toString();
            String login = loginValue.toString();
            String senha = senhaValue.toString();
            String cpf = cpfValue.toString();
            String dataNascimento = dataNascimentoValue.toString();
            String email = emailValue.toString();
            String telefone = telefoneValue.toString();
  
            abrirModal(id,nome,login, senha, cpf, dataNascimento, email, telefone);

        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        
        int rowIndex = tblUsuario.getSelectedRow();
        
        if (rowIndex != -1) {
            Object id = tblUsuario.getValueAt(rowIndex, 0);
            
            usu.setId_usuario(Integer.parseInt((String) id));
            
        }
        usu.excluirUsuario();
        listarTudo();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnOrdenarAZ;
    private javax.swing.JButton btnOrdenarZA;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
