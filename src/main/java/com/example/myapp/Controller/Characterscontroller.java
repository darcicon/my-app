package com.example.myapp.Controller;

import com.example.myapp.Entity.Characters;
import com.example.myapp.Service.CharactersService;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/genshin")
public class Characterscontroller {

    private CharactersService charactersService;

    public Characterscontroller(CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @GetMapping("/characters")
    public List<Characters> getAllCharacters() {
       return charactersService.findAll();
    }

    @GetMapping("/characters/{id}")
    public Characters getbyId(@PathVariable int id) {
        Characters ch = charactersService.findById(id);

        if(ch == null) {
            throw new RuntimeException("character with ID:" + id + " Not Found");
        } else {
            return ch;
        }
    }

    @PostMapping("/characters")
    public Characters createCharacter(@RequestBody Characters characters) {
        return charactersService.save(characters);
    }

    @PutMapping("/characters/{id}")
    public Characters editCharacters(@RequestBody Characters characters, @PathVariable int id) {
        Characters ch = charactersService.findById(id);
        ch.setName(characters.getName());
        ch.setElement(characters.getElement());
        ch.setWeaponName(characters.getWeaponName());
        ch.setRegion(characters.getRegion());
        ch.setSrc(characters.getSrc());

        return charactersService.save(ch);
    }

    @DeleteMapping("/characters/{id}")
    public String deleteById(@PathVariable int id) {
        Characters ch = charactersService.findById(id);

        if(ch==null) {
            throw new RuntimeException("Character not found!");
        } else {
            charactersService.deleteById(id);
            return "Deleted " + ch.getName() + " with ID - " + ch.getId();
        }
    }

}
