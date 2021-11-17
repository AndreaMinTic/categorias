
package com.nja.dao;

import com.nja.bd.Conexion;
import com.nja.modelos.Categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class CategoriasDao {

    private Connection conexion;
    
    public CategoriasDao(Conexion conexion) {
        this.conexion = Conexion.getInstancia().conectar();
    }

    public CategoriasDao() {
        throw new UnsupportedOperationException(""); 
    }
    
    //metodos crud
    //public Categorias catg(Categorias categorias) {
     public List<Categorias> getCategorias() {
         List<Categorias> categorias = new ArrayList<Categorias>();
        

        try {
            
            String sql= "SELECT catg_id, catg_camisas, catg_blusas, catg_pantalones, catg_faldas, catg_chaquetas FROM categorias WHERE catg_camisas = ? AND catg_blusas = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Categorias C = new Categorias();
                
                C.setId(rs.getInt("catg_id"));
                C.setCamisas(rs.getString("catg_camisas"));
                C.setBlusas(rs.getString("catg_busas"));
                C.setPantalones(rs.getString("catg_pantalones"));
                C.setfaldas(rs.getString("catg_faldas"));
                C.setChaquetas(rs.getString("catg_chaquetas"));
                

                categorias.add(C);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return categorias;
        }
    
    
    public boolean CategoriasExist(int id) {

        try {
            String sql = "SELECT catg_id FROM categorias WHERE catg_id = ? AND catg_camisas = ?";

            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public Categorias addCategorias(Categorias categorias) {

        try {
            String sql = "INSERT INTO categorias VALUES (?,?,?,?,?)";

            PreparedStatement pst = this.conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            pst.setInt(1, 0);
            pst.setString(2, categorias.getCamisas());
            pst.setString(3, categorias.getBlusas());
            pst.setString(4, categorias.getPantalones());
            pst.setString(5, categorias.getFaldas());
            pst.setString(6, categorias.getChaquetas());
            
            
            int filas = pst.executeUpdate();

            if (filas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    categorias.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return categorias;
    }

    public boolean editCategorias(Categorias categorias) {
        boolean resultado = false;
        try {
            String sql = "UPDATE categorias SET catg_camisas = ?, catg_blusas = ?, catg_pantalones = ?, catg_faldas = ?, catg_chaquetas= ?, WHERE catg_id = ?";

            PreparedStatement pst = this.conexion.prepareStatement(sql);
            
            pst.setString(1, categorias.getCamisas());
            pst.setString(2, categorias.getBlusas());
            pst.setString(3, categorias.getPantalones());
            pst.setString(4, categorias.getFaldas());
             pst.setString(5, categorias.getChaquetas());
            pst.setInt(6, categorias.getId());
            
            int filas = pst.executeUpdate();

            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return resultado;
    }

    public boolean deleteCategorias(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM categorias WHERE catg_id = ?";

            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            int filas = pst.executeUpdate();

            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return resultado;
    }

    public Categorias getCategorias(int id) {
        Categorias categorias = new Categorias();

        try {
            String sql = "SELECT catg_id, catg_camisas, catg_blusas, catg_pantalones, catg_faldas, catg_chaquetas FROM categorias WHERE catg_camisas = ? AND catg_id = ?";

            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Categorias C = new Categorias();
                
                C.setId(rs.getInt("catg_id"));
                C.setCamisas(rs.getString("catg_camisas"));
                C.setBlusas(rs.getString("catg_blusas"));
                C.setPantalones(rs.getString("catg_pantalones"));
                C.setFaldas(rs.getString("catg_faldas"));
                C.setChaquetas(rs.getString("catg_chaquetas"));

                return C;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return categorias;
    }

}

  
