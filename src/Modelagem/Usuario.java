/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm-2
 */
public class Usuario {
    private int id_usuario;
    private String nome_usuario;
    private String login_usuario;
    private String senha_usuario;
    private String cpf;
    private String email;
    private String telefone;
    private String dt_nasc;
    private String dt_criacao;
    
    private Conexao con = new Conexao();

    public Usuario() {
        this(0,"","","","","","","","");
    }

    public Usuario(int id_usuario, String nome_usuario, String login_usuario, String senha_usuario, String cpf, String email, String telefone, String dt_nasc, String dt_criacao) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.login_usuario = login_usuario;
        this.senha_usuario = senha_usuario;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dt_nasc = dt_nasc;
        this.dt_criacao = dt_criacao;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Conexao getCon() {
        return con;
    }

    public void setCon(Conexao con) {
        this.con = con;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    
    public void cadastrarUsuario(){
        String sql;
        sql = "insert into usuario(nome_usuario,login_usuario,senha_usuario,cpf,email,telefone,dt_nasc) values ('"+getNome_usuario()+"','"+getLogin_usuario()+"','"+getSenha_usuario()+"','"+getCpf()+"','"+getEmail()+"','"+getTelefone()+"','"+getDt_nasc()+"')";
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
    }
    
    public void alterarUsuario(){
        String sql;
        sql = "update usuario set nome_usuario='"+getNome_usuario()+"',login_usuario='"+getLogin_usuario()+"',senha_usuario='"+getSenha_usuario()+"',cpf='"+getCpf()+"',email='"+getEmail()+"',telefone='"+getTelefone()+"',dt_nasc='"+getDt_nasc()+"' where id_usuario='"+getId_usuario()+"'";
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
    }
    
    public ResultSet loginUsuario(){
        String sql;
        ResultSet tabela;
        tabela = null;
        sql = "select * from usuario where login_usuario='"+getLogin_usuario()+"' and senha_usuario='"+getSenha_usuario()+"'";
        tabela = con.RetornarResultset(sql);
        return tabela;
    }
    
    public ResultSet listarUsuario(){
        ResultSet tabela;
        tabela = null;
        String sql = "select * from usuario";
        tabela = con.RetornarResultset(sql);
        return tabela;
    }
    
        public ResultSet listarUsuarioEspecifico(){
        String sql;
        ResultSet tabela;
        tabela = null;
        try{
            sql = "select * from usuario where nome_usuario like '"+getNome_usuario()+"%'";
            tabela = con.RetornarResultset(sql);
            return tabela;
        }
        catch(Exception sqle){
            JOptionPane.showMessageDialog(null, "Erro ao localizar registro: "+sqle);
        }
        return tabela;
    }
    
}
