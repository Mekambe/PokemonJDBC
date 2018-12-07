package com.JDBC.App.rest;

import com.JDBC.App.dto.PokemonDto;
import com.JDBC.App.exception.RestPokemonException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PokemonRestInterface {

    ResponseEntity<PokemonDto> findById (Integer id) throws RestPokemonException;
    ResponseEntity<PokemonDto> findByName (String name);
    ResponseEntity<List<PokemonDto>> findAllPokemons();
    ResponseEntity<Integer> addNewPokemon (PokemonDto pokemonDto) throws RestPokemonException;
    ResponseEntity<Integer>  count() throws RestPokemonException;
    ResponseEntity<Void> delete (Integer id);



}
