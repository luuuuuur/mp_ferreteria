package fs.sistema_ferreteria.ProductProvider;


import fs.sistema_ferreteria.Pictures.PicturesModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name = "ProductProvider")
@Data 
@AllArgsConstructor 
@Setter 
@Getter 
public class ProductProviderModel {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String NombreProveedor;
    @OneToOne
    @JoinColumn(name = "id", nullable = true)
    private PicturesModel PM;
}
