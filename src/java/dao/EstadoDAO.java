/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estado;

/**
 *
 * @author SAULOD
 */
public class EstadoDAO {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    public EstadoDAO() {

    }

    public boolean inserir(Estado estado) {
        String sql = "INSERT INTO tb_estado(var_desc, var_uf) VALUES (?,?)";

        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, estado.getVarDesc());
            pst.setString(2, estado.getVarUf());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public boolean atualizar(Estado estado) {
        String sql = "UPDATE estado set var_desc=?,var_uf=? where idtb_estado=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, estado.getVarDesc());
            pst.setString(2, estado.getVarUf());
            pst.setInt(3, estado.getIdTbEstado());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public boolean excluir(Estado estado) {
        String sql = "DELETE FROM tb_estado where idtb_estado=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, estado.getIdTbEstado());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public List<Estado> listar() {
        String sql = "SELECT * FROM tb_estado";
        List<Estado> retorno = new ArrayList<Estado>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Estado item = new Estado();
                item.setIdTbEstado(res.getInt("idtb_estado"));
                item.setVarDesc(res.getString("var_desc"));
                item.setVarUf(res.getString("var_uf"));

                retorno.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }
    

    public Estado buscarUF(Estado estado) {
        String sql = "SELECT * FROM tb_estado where var_uf like ?";
        Estado retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, estado.getVarUf());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new Estado();
                retorno.setIdTbEstado(res.getInt("idtb_estado"));
                retorno.setVarDesc(res.getString("var_desc"));
                retorno.setVarUf(res.getString("var_uf"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }
    public Estado buscarDesc(Estado estado) {
        String sql = "SELECT * FROM tb_estado where var_desc like *?*";
        Estado retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, estado.getVarDesc());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new Estado();
                retorno.setIdTbEstado(res.getInt("idtb_estado"));
                retorno.setVarDesc(res.getString("var_desc"));
                retorno.setVarUf(res.getString("var_uf"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }
    
    public Estado buscarId(Estado estado) {
        String sql = "SELECT * FROM tb_estado where idtb_estado = ?";
        Estado retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, estado.getVarDesc());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new Estado();
                retorno.setIdTbEstado(res.getInt("idtb_estado"));
                retorno.setVarDesc(res.getString("var_desc"));
                retorno.setVarUf(res.getString("var_uf"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

}
