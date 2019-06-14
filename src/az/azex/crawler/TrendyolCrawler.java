package az.azex.crawler;

import az.azex.domain.Currency;
import az.azex.domain.Product;
import az.azex.util.CurrencyUtility;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

public class TrendyolCrawler implements Crawler {

    @Override
    public Optional<Product> parse(String url) {
        Optional<Product> optionalProduct = Optional.empty();

        try {
            Document doc = Jsoup.connect(url).get();
            Product product = new Product();
            product.setUrl(url);

            // div class="product-info-titlebox"
            //span class="product-name-text"

            Element nameDiv = doc.selectFirst(".product-info-titlebox");
            if (nameDiv != null) {
                Element nameSpan = nameDiv.selectFirst(".product-name-text");
                if (nameSpan != null) {
                    String name = nameSpan.text().trim();
                    product.setName(name);
                }
            }

            // div class="product-info-priceBox"
            //span class="sale-price"
            Element priceDiv = doc.selectFirst(".product-info-priceBox");
            if (priceDiv != null) {
                Element priceSpan = priceDiv.selectFirst(".sale-price");
                if (priceSpan != null) {
                    String priceStr = priceSpan.text().trim();
                    System.out.println(priceStr);

                    String[] priceArr = priceStr.split(" ");
                    if (priceArr.length >= 2) {
                        BigDecimal price = new BigDecimal(priceArr[0].replace(",", "."));
                        product.setPrice(price);

                        Currency currency = CurrencyUtility.parse(priceArr[1]);
                        product.setCurrency(currency.getName());
                    }

                }

                // select class="variant-picker-select"
                //option attr="data-stock-status" != 0

                Element sizeSelect = doc.selectFirst(".variant-picker-select");

                if (sizeSelect != null) {
                    Elements options = sizeSelect.select("option");

                    for (Element option : options) {
                        if (option.hasAttr("data-stock-status") &&
                                !option.attr("data-stock-status").equals("0")) {
                            product.addSize(option.text().trim());
                        }
                    }
                }
            }


            // ul id="thumbnailContainer"
            //li.img attr="src"

            Element imageContainer = doc.getElementById("thumbnailContainer");

            if(imageContainer != null) {
                Elements images = imageContainer.select("img");

                for(Element image : images) {
                    String src = "";
                    if(image.hasAttr("data-src")) {
                        src = image.attr("data-src").trim();
                    } else {
                        src = image.attr("src").trim();
                    }
                    product.addImage(src);
                }
            }

            optionalProduct = Optional.of(product);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return optionalProduct;
    }
}
