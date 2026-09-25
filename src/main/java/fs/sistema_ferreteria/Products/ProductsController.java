package fs.sistema_ferreteria.Products;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



//Controllador que solo maneja el I/O de productos hacia la red (Métodos HTTP)
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor 
class ProductsController {
    //Spring mapea por si solo el BEAN e INSTANCIA la clase detrás de cámaras
    private final ProductsService PS;
    @PostMapping("/add")
    public ResponseEntity<String>Add(@RequestBody ProductsDTO pdto){
        ProductsModel pModel = PS.PModel(pdto);
        return PS.SaveToDatabase(pModel);
    }
    
    
}
