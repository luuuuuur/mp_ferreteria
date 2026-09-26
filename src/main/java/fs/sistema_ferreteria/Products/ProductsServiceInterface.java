package fs.sistema_ferreteria.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import fs.sistema_ferreteria.ProductProvider.ProductProviderModel;



//Se manejan los metodos por defecto, no requiere de @Repository
public interface ProductsServiceInterface extends JpaRepository<ProductsModel, Long>{
    List<ProductsModel> findByPPM(ProductProviderModel pPM);
}
