package fs.sistema_ferreteria.ProductProvider;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fs.sistema_ferreteria.Products.ProductsModel;
import fs.sistema_ferreteria.Products.ProductsServiceInterface;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//toda la lógica de negocio va acá
@Getter 
@Setter
@NoArgsConstructor 
class Response{
    private String nombre;
    private Long id;
    private List<Long>productsId;
}
@Service 
public class ProductProviderService{
    private final ProductProviderInterface PPI;
    private final ProductsServiceInterface PPS;
    public ProductProviderService(ProductProviderInterface PPI, ProductsServiceInterface PPS){
        this.PPI = PPI;
        this.PPS = PPS; 

    }
    public ProductProviderModel providerModel(ProductProviderDTO pDto){
        ProductProviderModel PPM = new ProductProviderModel(null, pDto.getName(), null);
        return PPM;
    }

    public ResponseEntity<?> SaveProvider(ProductProviderModel PPM){
        try{
            PPI.save(PPM);
            return ResponseEntity.ok("Proveedor Guardado!");
        }catch(Exception E){
            return ResponseEntity.status(500).body(E.getMessage());
        }
    }
    public ProductProviderModel GetProvider(Long id){
        ProductProviderModel PPM = PPI.findById(id).orElse(null);
        if(PPM == null){
            return null;
        }
        return PPM;
    }
    public Response buildResponse(ProductProviderModel PPM){
        Response body = new Response();
        body.setNombre(PPM.getNombreProveedor());
        body.setId(PPM.getProviderId());
        List<ProductsModel> lModels = PPS.findByPPM(PPM);
        List<Long> ids = new ArrayList<>();
        for(ProductsModel PM : lModels){
            ids.add(PM.getProductId());
        }
        body.setProductsId(ids);
        return body;
    }
    
    


}
