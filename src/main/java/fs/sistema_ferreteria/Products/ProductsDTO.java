package fs.sistema_ferreteria.Products;
//este es el que recibe el trafico de red
import lombok.*;
@Data 
@AllArgsConstructor
@Getter 
@Setter 
public class ProductsDTO {
    private String Nombre;
    private double precio;
    private String descripcion;
    private Long id_provider;
}
