package com.musibondi.helper;

import com.musibondi.domain.Playlist;
import com.musibondi.domain.PlaylistProperties;

import java.util.ArrayList;
import java.util.UUID;

public class PlaylistHelper {

    public static final String baseHost = "http://localhost:%s/%s";

    public enum ENDPOINTS {
        PLAYLISTS("api/v1/playlist"),
        PLAYLIST("api/v1/playlist/%s");

        ENDPOINTS(String value) {
            this.value = value;
        }

        private String value;

        public String toString() {
            return value;
        }
    }
}
