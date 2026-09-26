package fs.sistema_ferreteria.ProductProvider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController 
@RequestMapping("/api/v1/providers")
public class ProductProviderController {
    private final ProductProviderService pps;

    public ProductProviderController(ProductProviderService pps) {
        this.pps = pps;
    }

    @PostMapping("/add")
    public ResponseEntity<?> postMethodName(@RequestBody ProductProviderDTO pDto) {
        ProductProviderModel ppm = pps.providerModel(pDto);
        ResponseEntity<?> rs = pps.SaveProvider(ppm);
        return rs;
    }
    @GetMapping("/get")
    public ResponseEntity<?> GetMetadataProvider(@RequestParam Long id) {
        ProductProviderModel PPM = pps.GetProvider(id);
        if(PPM == null){
            return ResponseEntity.status(404).body("Provider Not Found");
        }else{
            return ResponseEntity.ok(pps.buildResponse(PPM));
        }
    }
    
}
