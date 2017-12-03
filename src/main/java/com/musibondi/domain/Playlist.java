package com.musibondi.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Data
public class Playlist {

    @Id
    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private Collection<Song> songs;

    @NonNull
    private PlaylistProperties playlistProperties;
}
