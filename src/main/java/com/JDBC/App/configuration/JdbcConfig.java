package com.JDBC.App.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.JDBC.App")
public class JdbcConfig {

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2) //  data base configuration
                .addScript("db/create-db.sql") //path to the data base
                .addScript("db/insert-data.sql")
                .build();
    }


    @Primary
    @Bean   //it means that this bean is primary
    public JdbcTemplate jdbcTemplate (DataSource dataSource) { // date base comunicator, configuration is given inside
        return new JdbcTemplate(dataSource);

    }



}
