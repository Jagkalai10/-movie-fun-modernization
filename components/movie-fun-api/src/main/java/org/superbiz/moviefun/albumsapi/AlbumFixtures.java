package org.superbiz.moviefun.albumsapi;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class AlbumFixtures {

    public List<AlbumInfo> load() {
        return asList(
            new AlbumInfo(1L,"Massive Attack", "Mezzanine", 1998, 9),
            new AlbumInfo(2L, "Radiohead", "OK Computer", 1997, 8),
            new AlbumInfo(3L, "Radiohead", "Kid A", 2000, 9)
        );
    }
}
