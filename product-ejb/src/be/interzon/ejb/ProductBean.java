package be.interzon.ejb;



import be.interzon.model.Product;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.NoSuchElementException;

@Stateless
public class ProductBean{

    @EJB
    ProductDaoBean productDaoBean;

    public List<Product> getProducts(){
        return productDaoBean.findAll();
    }

    public Product getId(long id)
    {
        try{
            return productDaoBean.findById(id);
        }catch (NoSuchElementException e){
            System.err.print("pas d'id trouvé:"+id);
            return null;
        }
    }
}
