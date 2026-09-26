package fs.sistema_ferreteria.Pictures;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;



@RestController 
@RequestMapping("/api/v1/pictures")
@RequiredArgsConstructor 
public class PicturesController {
    private final PicturesService PS;

    //método para acceder a una foto del proveedor
    @GetMapping("/GetProviderPhoto")
    public ResponseEntity<String>getProviderPicture(@RequestParam Long providerId) {
        return PS.GetProviderPicture(providerId);
    }

    // Endpoint para probar si la subida de fotos funciona
    @PostMapping("/upload")
    public ResponseEntity<String> uploadPicture(@RequestParam("file") MultipartFile file, @RequestParam Long id) {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se recibió ninguna imagen.");
        }

        return PS.SavePhotos(file, id);
    }

}
