
package Models;
import java.sql.DriverManager; 
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionBD {
    public String cadConexion;
    public String user;
    public String password;
    public String database;
    public String server;
    public String driver;
    public ConexionBD(){
        driver="com.mysql.jdbc.Driver";
	server = "localhost:3306";
        database = "gcarga";
        user = "root";
        password = "12345678";
  	cadConexion = "jdbc:mysql://" + server + "/" + database;
    }
    public ConexionBD(String cadenaConexion,String driver,String user,String password) {
        this.cadConexion=cadenaConexion;
        this.driver=driver;
        this.user=user;
        this.password=password;
}
    public Connection getConnection() throws Exception{   
        Connection con = null;
	try{
	Class.forName(driver);
        con = DriverManager.getConnection(cadConexion, user, password);
	System.out.println("conexion etablecida");
	JOptionPane.showMessageDialog(null,"Conexion establecida");
	}catch(ClassNotFoundException | SQLException e){
	JOptionPane.showMessageDialog(null,"error Conexion"+e);
	}	
        return con;
    } 
}
