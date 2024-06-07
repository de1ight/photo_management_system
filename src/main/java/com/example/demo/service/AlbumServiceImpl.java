package com.example.demo.service;

import com.example.demo.dao.Album;
import com.example.demo.dao.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;


    //查询所有的相册
    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }
    //根据id查相册
    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    //新建相册
    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    //更新相册
    public Album updateAlbum(Long id, Album albumDetails) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
        album.setAlbum_name(albumDetails.getAlbum_name());
        album.setFirst_p(albumDetails.getFirst_p());
        album.setP_num(albumDetails.getP_num());
        return albumRepository.save(album);
    }

    //删除相册
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

}
