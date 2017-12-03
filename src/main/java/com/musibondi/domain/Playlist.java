package com.musibondi.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.Collection;

@Data
public class Playlist {

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private Collection<Song> songs;

    @NonNull
    private PlaylistProperties playlistProperties;
}
