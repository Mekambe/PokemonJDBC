package com.JDBC.App.service;

import com.JDBC.App.domain.PokemonDomain;
import com.JDBC.App.dto.PokemonDto;
import com.JDBC.App.dto.SpeciesDto;
import com.JDBC.App.mapper.PokemonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PokemonServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PokemonDto findById(Integer id) {


        PokemonDomain query;
        try {
            query = this.jdbcTemplate.queryForObject(
                    "SELECT * FROM pokemons WHERE idPokemon = ?", new PokemonMapper(), id);
            return pokemonConvertToPokemon(query);

        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public PokemonDto findByName(String name) {
        return null;
    }

    @Override
    public List<PokemonDto> findAllPokemons() {

       List<PokemonDomain> pokemonDomainList = jdbcTemplate.query("select name, weight, speciesUrl, speciesName from pokemons",
        new PokemonMapper() );

       List<PokemonDto> List = new ArrayList<>();

       for (PokemonDomain pok : pokemonDomainList){
           List.add(pokemonConvertToPokemon (pok));

       }

      // return pokemonDomainList.stream().map(this :: pokemonConvertToPokemon).collect(Collectors.toList());

return List;

    }

    private PokemonDto pokemonConvertToPokemon(PokemonDomain pok) {
        return new PokemonDto(pok.getName(), String.valueOf(pok.getWeight()),
                new SpeciesDto(pok.getSpeciesUrl(), pok.getSpeciesName()));
    }

    @Override
    public Integer addNewPokemon(PokemonDto pokemonDto) {
        return jdbcTemplate.update("INSERT INTO pokemons (name, weight, speciesUrl, speciesName)" +
                "VALUES (?,?,?,?)", pokemonDto.getName(), pokemonDto.getWeight(),
                pokemonDto.getSpecies(), pokemonDto.getSpecies());


    }

    @Override
    public Integer count() {

        Integer update = jdbcTemplate.queryForObject("SELECT COUNT (*) FROM pokemons", Integer.class);
        return update;


    }

    @Override
    public void delete(Integer id) {

       jdbcTemplate.update("delete from pokemons where idPokemon=" + id);




    }
}
