/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supert;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author ironfart
 */
public class Pool {

    public DataSource dataSource;

    //public String db = "";
    public String url = "jdbc:mysql://127.0.0.1:3306/SuperT_v1.0?useSSL=false";
    public String user = "root";
    public String pass = "Asd123456.";

    public Pool() {

        inicializaDataSource();

    }

    private void inicializaDataSource() {

        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(50);

        dataSource = basicDataSource;

    }
}
