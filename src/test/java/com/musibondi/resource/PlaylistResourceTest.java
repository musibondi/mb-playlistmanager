package com.musibondi.resource;

import com.musibondi.domain.Playlist;
import com.musibondi.domain.PlaylistProperties;
import com.musibondi.helper.PlaylistHelper;
import com.musibondi.helper.TestHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlaylistResourceTest extends TestHelper {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllPlayslistShouldReturnEmptyWhenNoPlaylists() {
        assertThat(this.restTemplate.getForObject(String.format(PlaylistHelper.baseHost, port, PlaylistHelper.ENDPOINTS.PLAYLISTS),
                List.class)).size().isEqualTo(0);
    }

    @Test
    public void getAllPlayslistShouldReturnOnePlaylistIfOneExists() {
        String playlistName = "testPlaylist";
        Playlist playlist = new Playlist(playlistName, new ArrayList<>(), new PlaylistProperties());
        Playlist postPlaylist = this.restTemplate.postForObject(String.format(PlaylistHelper.baseHost, port, PlaylistHelper.ENDPOINTS.PLAYLISTS), playlist, Playlist.class);
        assertThat(postPlaylist.getId()).isNotNull();

        Playlist[] getPlaylists = this.restTemplate.getForObject(String.format(PlaylistHelper.baseHost, port, PlaylistHelper.ENDPOINTS.PLAYLISTS),
                Playlist[].class);
        assertThat(getPlaylists.length).isEqualTo(1);
        assertThat(getPlaylists[0].getName()).isEqualTo(playlistName);
    }

    @Test
    public void getAllPlayslistShouldReturnMultiplePlaylists() throws JSONException {
        postPlaylist();
        postPlaylist();
        postPlaylist();

        List<Playlist> getPlaylists = this.restTemplate.getForObject(String.format(PlaylistHelper.baseHost, port, PlaylistHelper.ENDPOINTS.PLAYLISTS),
                List.class);
        assertThat(getPlaylists.size()).isEqualTo(3);
    }

    @Test
    public void createPlaylistShouldCreatePlaylist() {
        String playlistName = "testPlaylist";
        Playlist playlist = new Playlist(playlistName, new ArrayList<>(), new PlaylistProperties());

        Playlist postPlaylist = this.restTemplate.postForObject(String.format(PlaylistHelper.baseHost, port, PlaylistHelper.ENDPOINTS.PLAYLISTS), playlist, Playlist.class);
        assertThat(postPlaylist.getId()).isNotNull();
        assertThat(postPlaylist.getName()).isEqualTo(playlistName);
        assertThat(postPlaylist.getPlaylistProperties().getRestrictions()).isNull();
        assertThat(postPlaylist.getSongs().isEmpty()).isTrue();
    }

    //TODO: Need more tests here

    private Playlist postPlaylist() {
        String playlistName = "testPlaylist-" + UUID.randomUUID().toString().substring(0,6);
        Playlist playlist = new Playlist(playlistName, new ArrayList<>(), new PlaylistProperties());
        return this.restTemplate.postForObject(String.format(PlaylistHelper.baseHost, port, PlaylistHelper.ENDPOINTS.PLAYLISTS), playlist, Playlist.class);
    }
}
