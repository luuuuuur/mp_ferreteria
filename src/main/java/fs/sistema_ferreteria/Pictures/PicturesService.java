package fs.sistema_ferreteria.Pictures;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fs.sistema_ferreteria.ProductProvider.ProductProviderInterface;
import fs.sistema_ferreteria.ProductProvider.ProductProviderModel;
import fs.sistema_ferreteria.Products.*;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
@Service 
class PicturesService{
    private final ProductsServiceInterface PSI;
    private final PicturesInterface PI;
    private final ProductProviderInterface PPI;

    public PicturesService(PicturesInterface PI, ProductsServiceInterface PSI, ProductProviderInterface PPI){
        this.PI = PI;
        this.PSI = PSI;
        this.PPI = PPI;
    }

    public PicturesModel picturesModel(String URL, ProductsModel pModel){
        PicturesModel picturesModel = new PicturesModel(null, URL, pModel);
        return picturesModel;
    }
    //este método se usa una vez se haya guardado en la base de datos
    //dado que la relacion es 1-1, sabemos de ante mano que solo habrá un string
    //por seguridad se castea a String
    public ResponseEntity<String>GetProviderPicture(Long providerId){
        PicturesModel PM = PI.getReferenceById(providerId);
        try{
            String url = (String) PM.getURL_Foto();
            return ResponseEntity.ok(url);
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    
    }
    //método para validar si es un arreglo o un string único
    //si no es ninguno de los dos retorna false
    //este método se usa para validar la subida de fotos a la base de datos
    public static Object DetectType(Object T){
        if(T instanceof MultipartFile file){
            return file;
        }
        if(T instanceof List<?>){
            List<?>list = (List<?>) T;
            List<MultipartFile> files = new ArrayList<>();
            for(Object file : list ){
                if(file instanceof MultipartFile multipartFile){
                    files.add(multipartFile);
                }
            }
            return files;
        }else{
            return false;
        }
        
    }
    //método para guardar las FOTOS de los PRODUCTOS
    public ResponseEntity<String> SavePhotos(Object o, Long productoId){
        ProductsModel PM = PSI.findById(productoId).orElse(null);
        if(PM == null){
            return ResponseEntity.status(404).body("Not found");
        }
        Object T = PicturesService.DetectType(o);
        if(T instanceof Boolean){
            return ResponseEntity.status(400).body("Invalid Files");
        }
        //es un solo archivo
        if(T instanceof MultipartFile F){
            File ffFile = new File("/pictures");
            try{
                F.transferTo(ffFile);
                String URL = F.getOriginalFilename();
                PicturesModel picturesModel = picturesModel(URL, PM);
                PI.save(picturesModel);
                return ResponseEntity.ok("Foto guardada Correctamente!");
                
            }catch(IOException IO){
                ResponseEntity.status(500).body(IO.getMessage());
            }
        }  
        return ResponseEntity.badRequest().body("Invalid Request");
    }


    //método para entregar la foto al provider
    //entrega una URL
    public String GetPhotoURL(Long providerId){
        ProductProviderModel PPM = PPI.getReferenceById(providerId);
        // si no existe el provider
        if(PPM == null){
            return null;
        }
        PicturesModel PM = PI.findById(PPM.getPM().getId()).orElse(null);
        //En caso de que NO exista alguna foto asociada al Provider
        if(PM == null){
            return null;
        }
        return (String) PM.getURL_Foto();
    }
    
}
