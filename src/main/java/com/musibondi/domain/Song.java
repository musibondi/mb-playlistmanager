package com.musibondi.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Song {

    @Id
    @Getter
    private String id = UUID.randomUUID().toString();
}
