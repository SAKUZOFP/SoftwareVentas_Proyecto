package Modelos;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sakuzo
 */
public class ProductoDAO {

    public static void Actualiza(Producto producto1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public Producto ConsultaPorCodigo(int codigoProducto) {
        Producto producto = new Producto();
        con = cn.Conexion();
        String consulta = "SELECT * FROM productos WHERE id = " + codigoProducto;

        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                producto.setCodigo(rs.getInt("id"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setDescripcion(rs.getString("descripcionproducto"));
                producto.setUnidad(rs.getString("unidad"));
                producto.setPrecio(rs.getString("precio"));
                               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

    public int Agregar(Producto producto) {
        int r = 0;
        con = cn.Conexion();
        String sentencia = "INSERT INTO productos (nombreproducto, descripcionproducto, unidad, precio) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sentencia);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getUnidad());
            ps.setString(4, producto.getPrecio());
            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;

    }

    public List Listar() {
        String consulta = "SELECT * FROM productos";
        List<Producto> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("id"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setDescripcion(rs.getString("descripcionproducto"));
                producto.setUnidad(rs.getString("unidad"));
                producto.setPrecio(rs.getString("precio"));
                lista.add(producto);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
    
    //cargar
    public Producto ListarPorCodigo(int codigo) {
        Producto producto = new Producto();
        String consulta = "SELECT * FROM productos WHERE id=" + codigo;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setNombreProducto(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setUnidad(rs.getString(4));
                producto.setPrecio(rs.getString(5));
//                producto.setCategoria(rs.getString(6));
//                producto.setEstadoProducto(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return producto;

    }
    
    public int Actualizar(Producto producto) {
        String sentencia = "UPDATE productos set nombreproducto=?,descripcionproducto=?,unidad=?,precio=? WHERE id=?"; //,categoria=?,estadoproducto=?
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getUnidad());
            ps.setString(4, producto.getPrecio());
//            ps.setString(5, producto.getCategoria());
//            ps.setString(6, producto.getEstadoProducto());
            ps.setInt(5, producto.getCodigo());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public void Eliminar(int codigo) {

        String sql = "DELETE FROM productos WHERE id=" + codigo;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
