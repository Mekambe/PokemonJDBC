package com.JDBC.App.mapper;

import com.JDBC.App.domain.PokemonDomain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PokemonMapper implements RowMapper<PokemonDomain> {

@Override
    public PokemonDomain mapRow (ResultSet rs, int rowNumber) throws SQLException {
        PokemonDomain pokemonDomain = new PokemonDomain();
        pokemonDomain.setName(rs.getString("name"));
        pokemonDomain.setWeight(rs.getInt("weight"));
        pokemonDomain.setSpeciesUrl(rs.getString("speciesUrl"));
        pokemonDomain.setSpeciesName("speciesName");


        return pokemonDomain;


}}
