package com.musibondi.resource;


import com.musibondi.domain.Playlist;
import com.musibondi.domain.PlaylistProperties;
import com.musibondi.service.PlaylistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistResource.class);

    private PlaylistService playlistService;

    @Autowired
    public PlaylistResource(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Playlist>> getPlaylists() {
        LOGGER.info("Get all playlists.");

        return new ResponseEntity<>(playlistService.getAllPlaylists(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        LOGGER.info("Create playlist: {}.", playlist);

        return new ResponseEntity<>(playlistService.savePlaylist(playlist), HttpStatus.OK);
    }

    @RequestMapping(value = "/{playlistId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Playlist> getPlaylistDetails(@PathVariable("playlistId") String id) {
        LOGGER.info("Get playlist: {}.", id);

        return new ResponseEntity<>(playlistService.getPlaylist(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{playlistId}", method = RequestMethod.PATCH, produces = "application/json")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("playlistId") String id, @RequestBody Playlist playlist) {
        LOGGER.info("Update playlist: {} with body: {} called.", id, playlist);

        playlistService.updatePlaylist(id, playlist);

        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

}
