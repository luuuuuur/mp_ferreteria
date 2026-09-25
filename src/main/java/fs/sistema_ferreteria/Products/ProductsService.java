package fs.sistema_ferreteria.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//Comunicacion con la base de datos
@Service 
class ProductsService{
    private final ProductsServiceInterface PSI;

    public ProductsService(ProductsServiceInterface PSI){
        this.PSI = PSI;
        
    }
    //metodo para transformar el DTO que viene de red a un model para poder usarse en el SaveToDatabase
    public ProductsModel PModel(ProductsDTO pDto){
        ProductsModel pModel = 
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
    


}
