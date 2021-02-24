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

import com.radio.model.Video;
import com.radio.repository.VideoRepository;

import exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class VideoController {

	@Autowired
	VideoRepository videoRepository;

	// Get All Videos
	@GetMapping("/videos")
	public List<Video> getAllVideoss() {
		return videoRepository.findAll();
	}

	// Create a new Videos
	@PostMapping("/videos")
	public Video createVideos(@RequestBody Video video) {
		return videoRepository.save(video);
	}

	// Get a Single Video
	@GetMapping("/videos/{id}")
	public Video getVideoById(@PathVariable(value = "id") Long videosId) {
		return videoRepository.findById(videosId)
				.orElseThrow(() -> new ResourceNotFoundException("Video", "id", videosId));
	}

	// Update a Video
	@PutMapping("/video/{id}")
	public Video updateVideo(@PathVariable(value = "id") Long videoId, @RequestBody Video videoDetails) {

		Video video = videoRepository.findById(videoId)
				.orElseThrow(() -> new ResourceNotFoundException("Video", "id", videoId));

		video.setNome(videoDetails.getNome());
		video.setTempo(videoDetails.getTempo());
		video.setCompositor(videoDetails.getCompositor());
		video.setAutor(videoDetails.getAutor());
		video.setBanda(videoDetails.getBanda());
		video.setVideo(videoDetails.getVideo());

		Video updatedVideo = videoRepository.save(video);
		return updatedVideo;
	}

	// Delete a Video
	@DeleteMapping("/video/{id}")
	public ResponseEntity<?> deleteVideo(@PathVariable(value = "id") Long videoId) {
		Video video = videoRepository.findById(videoId)
				.orElseThrow(() -> new ResourceNotFoundException("Video", "id", videoId));

		videoRepository.delete(video);

		return ResponseEntity.ok().build();
	}
}