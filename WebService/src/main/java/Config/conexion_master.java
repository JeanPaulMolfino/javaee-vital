package Config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class conexion_master{
    public DriverManagerDataSource Conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/master_javaee?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("Admin");
        dataSource.setPassword("123");
        return dataSource;
    }
}
