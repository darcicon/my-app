package com.example.myapp.Repository;

import com.example.myapp.Entity.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends JpaRepository<Characters, Integer> {

    Characters findById(int id);
}
