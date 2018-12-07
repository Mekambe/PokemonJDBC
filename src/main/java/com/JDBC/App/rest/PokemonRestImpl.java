package com.JDBC.App.rest;

import com.JDBC.App.domain.PokemonDomain;
import com.JDBC.App.dto.PokemonDto;
import com.JDBC.App.exception.RestPokemonException;
import com.JDBC.App.service.PokemonService;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
public class PokemonRestImpl implements PokemonRestInterface {
    private PokemonService pokemonService;

    @Autowired
    public PokemonRestImpl(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping ("/api/findID")
    @Override
    public ResponseEntity<PokemonDto> findById(Integer id) throws RestPokemonException {
        PokemonDto byId = pokemonService.findById(id);
        if (byId != null) {
            //byId.a(linkTo(methodOn(PokemonRestImpl.class).count()).withSelfRel());
            return ResponseEntity.status(HttpStatus.OK).body(byId);
        } else {
            throw new RestPokemonException();
        }
    }

    @GetMapping ("/api/findByName")
    @Override
    public ResponseEntity<PokemonDto> findByName(String name) {
        return null;
    }

    @GetMapping("/api/findAll")
    @Override
    public ResponseEntity<List<PokemonDto>> findAllPokemons() {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.findAllPokemons());
    }

    @PostMapping("/api/addNewPokemon")
    @Override
    public ResponseEntity<Integer> addNewPokemon(@RequestBody PokemonDto pokemonDto) throws RestPokemonException {

        Integer i = pokemonService.addNewPokemon(pokemonDto);

        if (i<0)
        throw  new RestPokemonException();

        return ResponseEntity.status(HttpStatus.CREATED).body(i);
    }

    @GetMapping ("/api/countPokemon")
    @Override
    public ResponseEntity<Integer> count() throws RestPokemonException {

        Integer i = pokemonService.count();

        if (i<0)
            throw  new RestPokemonException();

        return ResponseEntity.status(HttpStatus.OK).body(i);

    }

    @DeleteMapping("/api/deletePokemon")
    @Override
    public ResponseEntity<Void> delete(Integer id) {

        pokemonService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
