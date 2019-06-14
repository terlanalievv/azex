package az.azex.crawler;

import az.azex.domain.Product;

import java.lang.reflect.Proxy;
import java.util.Optional;
import java.util.OptionalInt;

public class CrawlerTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        String url = "https://www.trendyol.com/hummel-kids/siyah-kiz-cocuk-t-shirt-p-4009501?boutiqueId=307111";
//        String url = "https://www.trendyol.com/trendyol-man/erkek-siyah-erkek-slim-fit-baskili-t-shirt-tmnss19bo0023-p-4283780?boutiqueId=304318&merchantId=968";
//        String url = "https://www.trendyol.com/sogutlu-silver/kadin-925-ayar-gumus-nazar-boncugu-kolye-sgtl4654-p-2118583?boutiqueId=305708&merchantId=2602";
        String url = "https://www.trendyol.com/konami/pes-2018-p-2705548?boutiqueId=301958&merchantId=105333";


        String crawlerClassName = "az.azex.crawler.TrendyolCrawler";
        Class crawlerClass = Class.forName(crawlerClassName);


//        Crawler crawler = new TrendyolCrawler();
        Crawler crawler = (Crawler) crawlerClass.newInstance();

        Optional<Product> optionalProduct = crawler.parse(url);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            System.out.println(product);
        } else {
            System.out.println("Can not parse product info");
        }
    }
}
