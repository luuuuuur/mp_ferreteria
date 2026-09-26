package fs.sistema_ferreteria.ProductProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//esto es lo que llega por red
@Data 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
@Setter 
class ProductProviderDTO {
    private String NombreProveedor;

}
