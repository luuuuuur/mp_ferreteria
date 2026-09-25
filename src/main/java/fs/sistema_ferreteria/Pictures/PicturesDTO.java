package fs.sistema_ferreteria.Pictures;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
@Setter 
@Getter 
@AllArgsConstructor 
class PicturesDTO {
    private Long id;
    private Object url;
}
