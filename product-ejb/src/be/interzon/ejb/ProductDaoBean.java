package be.interzon.ejb;

import be.interzon.model.Product;

import javax.ejb.Singleton;
import java.util.Arrays;
import java.util.List;

@Singleton(name = "ProductDaoEJB")
public class ProductDaoBean {
    private List<Product> products = Arrays.asList(
            new Product(1L,
                    "javaee pour tous",
                    "Un bon bouquin",
                    "http://blog.arungupta.me/wp-content/uploads/2013/10/javaee7-essentials-russian.jpg",
                    2500L),
            new Product(1L,
                    "java 88  pour tous",
                    "Un super bouquin",
                    "https://kbimages1-a.akamaihd.net/0fdccfa2-7687-492a-ad3f-44e32512db2b/353/569/90/False/pivotal-certified-professional-spring-developer-exam.jpg",
                    2500L)
            );
    public ProductDaoBean() {
    }

    public List<Product> findAll(){
        return products;
    }
    public Product findById(long id){
        return products.stream().filter(item->item.getId()==id).findFirst().get();
    }

}
