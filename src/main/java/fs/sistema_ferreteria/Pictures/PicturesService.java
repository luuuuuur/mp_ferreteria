package fs.sistema_ferreteria.Pictures;
import java.util.List;
import java.util.ArrayList;

class PicturesService{
    
    private final PicturesInterface PI; 
    
    public PicturesService(PicturesInterface PI){
        this.PI = PI;
    }
    //método para validar si es un arreglo o un string único
    //si no es ninguno de los dos retorna false
    public static Object DetectType(Object T){
        if(T instanceof String url){
            return url;
        }
        if(T instanceof ArrayList){
            List<String> sUrls = new ArrayList<>();
            for(Object url : (ArrayList<Object>) T){
                if(url instanceof String){
                    sUrls.add((String)url);
                }
            }
            return sUrls;
        }else{
            return false;
        }
        
    }
    
}
