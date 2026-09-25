package fs.sistema_ferreteria.ProductProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//PP = ProductProvider
@Data 
@Getter 
@Setter
@AllArgsConstructor  
class ProductProviderDTO {
    private Long ID;
    private String Name;
    
}
