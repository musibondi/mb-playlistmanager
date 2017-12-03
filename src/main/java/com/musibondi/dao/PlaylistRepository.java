package com.musibondi.dao;

import com.musibondi.domain.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends MongoRepository<Playlist, String> {

}
