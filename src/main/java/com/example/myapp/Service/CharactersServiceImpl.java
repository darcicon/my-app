package com.example.myapp.Service;

import com.example.myapp.Entity.Characters;
import com.example.myapp.Repository.CharactersRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharactersServiceImpl implements CharactersService{

    private CharactersRepository charactersRepository;

    public CharactersServiceImpl(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @Cacheable("characters")
    @Override
    public List<Characters> findAll() {
        System.out.println("test caching");
        return charactersRepository.findAll();
    }

    @Override
    public Characters findById(int id) {
        return charactersRepository.findById(id);
    }

    @CacheEvict(value = "characters", allEntries = true)
    @Override
    public Characters save(Characters characters) {
        return charactersRepository.save(characters);
    }

    @CacheEvict(value = "characters", allEntries = true)
    @Override
    public void deleteById(int id) {
        charactersRepository.deleteById(id);
    }
}
