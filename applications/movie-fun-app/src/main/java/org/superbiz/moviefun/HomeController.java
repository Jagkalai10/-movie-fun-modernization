package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.albums.Album;
import org.superbiz.moviefun.albumsapi.AlbumFixtures;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.MovieFixtures;
import org.superbiz.moviefun.moviesapi.MovieInfo;
import org.superbiz.moviefun.moviesapi.MoviesClient;

import java.util.Map;

@Controller
public class HomeController {

    //private final MoviesRepository moviesRepository;
    private final MoviesClient moviesClient;
    private final MovieFixtures movieFixtures;
    private final AlbumsClient albumsClient;
    private final AlbumFixtures albumFixtures;

    public HomeController(MoviesClient moviesClient, MovieFixtures movieFixtures, AlbumsClient albumsClient, AlbumFixtures albumFixtures) {
        this.moviesClient = moviesClient;
        this.movieFixtures = movieFixtures;
        this.albumsClient = albumsClient;
        this.albumFixtures = albumFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movieInfo : movieFixtures.load()) {
            moviesClient.addMovie(movieInfo);
        }

        for (Album album : albumFixtures.load()) {
            albumsClient.addAlbum(album);
        }

        model.put("movies", moviesClient.getMovies());
        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }

}
