package com.musibondi.resources;


import com.musibondi.domain.Playlist;
import com.musibondi.domain.PlaylistProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistResource.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Playlist>> getPlaylists() {
        LOGGER.info("Get all playlists called.");

        List<Playlist> playlists = new ArrayList<>();

        Playlist mockPlaylistOne = new Playlist(
                "cc7e32b6-d832-11e7-9296-cec278b6b50a",
                "Piashen's Playlist of Epicness",
                new ArrayList(),
                new PlaylistProperties());

        Playlist mockPlaylistTwo = new Playlist(
                "cc7e32b6-d832-11e7-9296-cec278b6b50a",
                "Piashen's Playlist of Epicness",
                new ArrayList(),
                new PlaylistProperties());

        playlists.add(mockPlaylistOne);
        playlists.add(mockPlaylistTwo);

        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        LOGGER.info("Create playlist: {} called.", playlist);

        // Here we save it in the magical DB

        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @RequestMapping(value = "/{playlistId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Playlist> getPlaylistDetails(@PathVariable("playlistId") String id) {
        LOGGER.info("Get playlist: {} called.", id);

        Playlist mockPlaylist = new Playlist(
                "cc7e32b6-d832-11e7-9296-cec278b6b50a",
                "Piashen's Playlist of Epicness",
                new ArrayList(),
                new PlaylistProperties());

        return new ResponseEntity<>(mockPlaylist, HttpStatus.OK);
    }

    @RequestMapping(value = "/{playlistId}", method = RequestMethod.PATCH, produces = "application/json")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("playlistId") String id, @RequestBody Playlist playlist) {
        LOGGER.info("Update playlist: {} with body: {} called.", id, playlist);

        // Here we save it in the magical DB

        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

}
