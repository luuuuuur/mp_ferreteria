package fs.sistema_ferreteria.Products;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import lombok.*;
import fs.sistema_ferreteria.Pictures.PicturesModel;
import fs.sistema_ferreteria.ProductProvider.ProductProviderModel;
//Tabla en la base de datos
@Entity
@Table(name="Product")
@Data 
@AllArgsConstructor 
@Getter 
@Setter
class ProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nombre;
    private double precio;
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = true)
    private ProductProviderModel PPM;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = true)
    private PicturesModel PM;
}
