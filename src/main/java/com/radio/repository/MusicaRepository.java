package com.radio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radio.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

}
