package com.radio.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "musicas")
public class Musica implements Serializable {
	private static final long serialVersionUID = -2632182432050611605L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	private String nome;
	private Timestamp tempo;
	private String compositor;
	private String autor;
	private String banda;
	private Blob musica;

	public Musica() {

	}

	public Musica(long id, String nome, Timestamp tempo, String compositor, String autor, String banda, Blob musica) {
		this.id = id;
		this.nome = nome;
		this.tempo = tempo;
		this.compositor = compositor;
		this.autor = autor;
		this.banda = banda;
		this.musica = musica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Timestamp getTempo() {
		return tempo;
	}

	public void setTempo(Timestamp tempo) {
		this.tempo = tempo;
	}

	public String getCompositor() {
		return compositor;
	}

	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public Blob getMusica() {
		return musica;
	}

	public void setMusica(Blob musica) {
		this.musica = musica;
	}

}
