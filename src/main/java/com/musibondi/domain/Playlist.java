package com.musibondi.domain;

import java.util.Collection;

public class Playlist {

    private String id;
    private String name;
    private Collection<Song> songs;
    private PlaylistProperties playlistProperties;

    public Playlist() {}

    public Playlist(String id,
                    String name,
                    Collection songs,
                    PlaylistProperties playlistProperties) {
        this.id = id;
        this.name = name;
        this.songs = songs;
        this.playlistProperties = playlistProperties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public void setSongs(Collection<Song> songs) {
        this.songs = songs;
    }

    public PlaylistProperties getPlaylistProperties() {
        return playlistProperties;
    }

    public void setPlaylistProperties(PlaylistProperties playlistProperties) {
        this.playlistProperties = playlistProperties;
    }
}
