package ua.goit.offline.configuration;


import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan({"ua.goit.offline.dao", "ua.goit.offline.service"}) //ищем в этих папках dao и service
@PropertySource("classpath:database.properties")
@EnableTransactionManagement //чтобы можно было проводить транзакции
public class ModelConfiguration {


    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.driver}")
    private String driverClassname;
    @Value("${db.dialect}")
    private String dialect;

    //TODO 2 В этом методе не надо ловить exception?
    @Bean(destroyMethod = "close")//вызовет клоуз при окончании
    public BasicDataSource DataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassname);

        return dataSource;
    }


    //TODO 1 почему выбрали именно эту реализацию (LocalSessionFactoryBean)   SessionFactory? Можно ли здесь использовать другую?
    // Eсли бы конфигурацию написали в hibernate.cfg.xml, то могли бы написать SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();?
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("ua.goit.offline.entity");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        bean.setHibernateProperties(properties);
        return bean;
    }

    @Bean //чтобы использовать транзакции
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }


}