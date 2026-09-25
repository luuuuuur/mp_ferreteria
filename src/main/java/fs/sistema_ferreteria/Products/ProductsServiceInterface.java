package fs.sistema_ferreteria.Products;
import org.springframework.data.jpa.repository.JpaRepository;
//Se manejan los metodos por defecto, no requiere de @Repository
interface ProductsServiceInterface extends JpaRepository<ProductsModel, Long>{
    
}
