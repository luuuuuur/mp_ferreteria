package fs.sistema_ferreteria.Products;
//este es el que recibe el trafico de red
//PPM = ProductProviderModel
//PM = PictureModel
import lombok.*;
@Data 
@AllArgsConstructor
@Getter 
@Setter 
class ProductsDTO {
    private Long id;
    private String Nombre;
    private double precio;
    private String descripcion;
    private Long ID_PPM;
    private Long ID_PM;
}
