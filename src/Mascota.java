import java.sql.*;
import conexion.conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Mascota extends mascotaAPP.MascotaPOA{
    
    private ORB orb;
    conexion conex = new conexion();

    @Override
    public boolean insertarMascota(int id, String nombreMascota, String apellidoMascota, String nombreDueno, int telefonoDueno) {
        
        boolean resultado=false;
        try {
            String query = "insert into mascota(id,nombreMascota,apellidoMascota,nombreDueno,telefonoDueno)" + "values ('"+id+"','"+nombreMascota+"','"+apellidoMascota+"','"+nombreDueno+"','"+telefonoDueno+"')";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0) {
                resultado = true;
                JOptionPane.showMessageDialog(null, "Datos insertados");
            }
            //cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ocurrió un error" +e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarMascota(int id) {
        String resultado = "";
        try {
            String query = "Select * from mascota WHERE id ="+ id;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                resultado +=  rs.getString(2) + " - " 
                            + rs.getString(3) + " - " 
                            + rs.getString(4) + " - " 
                            + rs.getLong(5) + "\n" ;
            }
            //cerramos los recursos.
            st.close();
            rs.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ocurrió un error" +e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarMascota(int id) {
        
        boolean resultado=false;
        try {
            String query = "Delete from mascota WHERE id ="+ id;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0) {
                resultado = true;
            }
            //cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ocurrió un error" +e.getMessage());
        }
        return resultado;  
    }

    @Override
    public boolean actualizarMascota(int id, String nombreMascota, String apellidoMascota, String nombreDueno, int telefonoDueno) {
        boolean resultado=false;
        try {
            String query = "update mascota set nombreMascota = '"+nombreMascota+"',apellidoMascota = '"+apellidoMascota+"',nombreDueno ='"+nombreDueno+"',telefonoDueno = '"+telefonoDueno+"' where id = "+id;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0) {
                resultado = true;
            }
            //cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ocurrió un error" +e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarMascota() {
        String resultado = "";
        try {
            String query = "Select * from mascota";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                resultado +=  rs.getString(2) + " - " 
                            + rs.getString(3) + " - " 
                            + rs.getString(4) + " - " 
                            + rs.getLong(5) + "\n" ;
            }
            //cerramos los recursos.
            st.close();
            rs.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ocurrió un error" +e.getMessage());
        }
        return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
