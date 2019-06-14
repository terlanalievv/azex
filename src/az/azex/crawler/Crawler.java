package az.azex.crawler;

import az.azex.domain.Product;

import java.util.Optional;

public interface Crawler {

    Optional<Product> parse(String url);

}
