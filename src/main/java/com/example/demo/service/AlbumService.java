package com.example.demo.service;

import com.example.demo.dao.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    public List<Album> getAllAlbums();

    public Optional<Album> getAlbumById(Long id);

    public Album createAlbum(Album album);

    public Album updateAlbum(Long id, Album albumDetails);

    public void deleteAlbum(Long id);


}
