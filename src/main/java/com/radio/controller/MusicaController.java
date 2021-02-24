package com.radio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radio.model.Musica;
import com.radio.repository.MusicaRepository;

import exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class MusicaController {

	@Autowired
	MusicaRepository musicaRepository;

	// Get All Musicas
	@GetMapping("/musicas")
	public List<Musica> getAllMusicas() {
		return musicaRepository.findAll();
	}

	// Create a new Musica
	@PostMapping("/musicas")
	public Musica createMusica(@RequestBody Musica musica) {
		return musicaRepository.save(musica);
	}

	// Get a Single Musica
	@GetMapping("/musicas/{id}")
	public Musica getMusicaById(@PathVariable(value = "id") Long musicaId) {
		return musicaRepository.findById(musicaId)
				.orElseThrow(() -> new ResourceNotFoundException("Musica", "id", musicaId));
	}

	// Update a Musica
	@PutMapping("/Musicas/{id}")
	public Musica updateMusica(@PathVariable(value = "id") Long musicaId, @RequestBody Musica musicaDetails) {

		Musica musica = musicaRepository.findById(musicaId)
				.orElseThrow(() -> new ResourceNotFoundException("Musica", "id", musicaId));

		musica.setNome(musicaDetails.getNome());
		musica.setTempo(musicaDetails.getTempo());

		Musica updatedMusica = musicaRepository.save(musica);
		return updatedMusica;
	}

	// Delete a Note
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteMusica(@PathVariable(value = "id") Long musicaId) {
		Musica musica = musicaRepository.findById(musicaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Musica", "id", musicaId));

	    musicaRepository.delete(musica);

	    return ResponseEntity.ok().build();
	}
}