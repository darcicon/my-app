package com.example.myapp.Service;

import com.example.myapp.Entity.Characters;

import java.util.List;
import java.util.Optional;

public interface CharactersService {

    List<Characters> findAll();

    Characters findById(int id);

    Characters save(Characters characters);

    void deleteById(int id);
}
