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
        LOGGER.info("Get all playlists called.");

//        List<Playlist> playlists = new ArrayList<>();
//
//        Playlist mockPlaylistOne = new Playlist(
//                "cc7e32b6-d832-11e7-9296-cec278b6b50a",
//                "Piashen's Playlist of Epicness",
//                new ArrayList(),
//                new PlaylistProperties());
//
//        Playlist mockPlaylistTwo = new Playlist(
//                "cc7e32b6-d832-11e7-9296-cec278b6b50a",
//                "Piashen's Playlist of Epicness",
//                new ArrayList(),
//                new PlaylistProperties());

//        playlists.add(mockPlaylistOne);
//        playlists.add(mockPlaylistTwo);

        return new ResponseEntity<>(playlistService.getAllPlaylists(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        LOGGER.info("Create playlist: {} called.", playlist);

        playlistService.savePlaylist(playlist);

        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @RequestMapping(value = "/{playlistId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Playlist> getPlaylistDetails(@PathVariable("playlistId") String id) {
        LOGGER.info("Get playlist: {} called.", id);

//        Playlist mockPlaylist = new Playlist(
//                "cc7e32b6-d832-11e7-9296-cec278b6b50a",
//                "Piashen's Playlist of Epicness",
//                new ArrayList(),
//                new PlaylistProperties());

        return new ResponseEntity<>(playlistService.getPlaylist(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{playlistId}", method = RequestMethod.PATCH, produces = "application/json")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("playlistId") String id, @RequestBody Playlist playlist) {
        LOGGER.info("Update playlist: {} with body: {} called.", id, playlist);

        // Here we save it in the magical DB
        playlistService.updatePlaylist(id, playlist);

        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

}
