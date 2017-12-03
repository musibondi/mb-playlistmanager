package com.musibondi.service;

import com.musibondi.dao.PlaylistRepository;
import com.musibondi.domain.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylist(String id) {
        return playlistRepository.findOne(id);
    }

    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(String id, Playlist playlist) {
        if (playlistRepository.exists(id)) {
            playlistRepository.save(playlist);
        }
        
        throw new IllegalArgumentException(String.format("Playlist with id %s could not be found.", id));
    }
}
