package fs.sistema_ferreteria.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import fs.sistema_ferreteria.ProductProvider.ProductProviderInterface;
import fs.sistema_ferreteria.ProductProvider.ProductProviderModel;

//Comunicacion con la base de datos
@Service 
public class ProductsService{
    private final ProductsServiceInterface PSI;
    private final ProductProviderInterface PPI;
    public ProductsService(ProductsServiceInterface PSI, ProductProviderInterface PPI){
        this.PSI = PSI;
        this.PPI = PPI;
        
    }
    //metodo para transformar el DTO que viene de red a un model para poder usarse en el SaveToDatabase
    public ProductsModel PModel(ProductsDTO pDto){
        ProductProviderModel PPM = PPI.findById(pDto.getId_provider()).orElse(null);
        if(PPM == null){
            return null;
        }
        ProductsModel pModel = new ProductsModel(null, pDto.getNombre(), pDto.getPrecio(), 
        pDto.getDescripcion(), PPM, null);
        return pModel;
    }
    public ResponseEntity<String> SaveToDatabase(ProductsModel pmModel){
        try {
            PSI.save(pmModel);
            return ResponseEntity.ok("Guardado exitosamente!");
        } catch (Exception e) {
            //en caso de cualquier excepcion
            return ResponseEntity.internalServerError().body(e.getMessage());
        }        
    }

    public List<ProductsModel> GetAllProviderProducts(ProductProviderModel PPM){
        List<ProductsModel> lModels = PSI.findByPPM(PPM);
        return lModels;
    }
    


}
