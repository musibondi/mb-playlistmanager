package com.musibondi.helper;

import com.musibondi.domain.Playlist;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class TestHelper {

    protected static final String baseHost = "http://localhost:%s/%s";

    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void setup() {
        mongoTemplate.dropCollection(Playlist.class);
    }

}
