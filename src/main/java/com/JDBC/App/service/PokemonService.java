package com.JDBC.App.service;

import com.JDBC.App.dto.PokemonDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PokemonService {
   PokemonDto findById (Integer id);
   PokemonDto findByName (String name);
   List<PokemonDto> findAllPokemons();
   Integer addNewPokemon (PokemonDto pokemonDto);
   Integer  count();
   void delete (Integer id);


}
