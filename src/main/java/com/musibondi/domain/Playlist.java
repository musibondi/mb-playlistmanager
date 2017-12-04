package com.musibondi.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.Collection;
import java.util.UUID;

@Data
public class Playlist {

    @Id
    @Getter
    private String id = UUID.randomUUID().toString();

    @NonNull
    private String name;

    @NonNull
    private Collection<Song> songs;

    @NonNull
    private PlaylistProperties playlistProperties;
}
