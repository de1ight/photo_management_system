package com.example.demo.controller;

import com.example.demo.dao.Album;
import com.example.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;


    @PostMapping("/fetch")
    public ResponseEntity<?> fetchAlbum(@RequestBody Album albumDetails) {
        if (albumDetails.getId() == 0) {
            List<Album> albums = albumService.getAllAlbums();
            return ResponseEntity.ok(albums);
        } else {
            Optional<Album> album = albumService.getAlbumById(albumDetails.getId());
            return album.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
    }

    @PostMapping("/create")
    public Album createAlbum(@RequestBody Album album) {
        return albumService.createAlbum(album);
    }

    @PostMapping("/updata")
    public ResponseEntity<Album> updateAlbum( @RequestBody Album albumDetails) {
        Album updatedAlbum = albumService.updateAlbum(albumDetails.getId(), albumDetails);
        return ResponseEntity.ok(updatedAlbum);
    }

    @PostMapping ("/delete")
    public ResponseEntity<Void> deleteAlbum(@RequestBody Album albumDetails) {
        albumService.deleteAlbum(albumDetails.getId());
        return ResponseEntity.noContent().build();
    }



}
