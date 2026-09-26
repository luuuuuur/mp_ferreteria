package fs.sistema_ferreteria.Products;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import java.util.List;
import fs.sistema_ferreteria.Pictures.PicturesModel;
import fs.sistema_ferreteria.ProductProvider.ProductProviderModel;
//Tabla en la base de datos
@Entity
@Table(name="product")
@Data 
@AllArgsConstructor 
@Getter 
@Setter
public class ProductsModel {
    //esto genera una columna en SQL que se llamará "product_id" que actuará como clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "Name")
    private String nombre;
    @Column(name = "price")
    private double precio;
    @Column(name = "description")
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "providerId", nullable = true)
    private ProductProviderModel PPM;
    //esto mapea en la tabla Photos la columna pModel para acceder a sus IDs.
    @OneToMany(mappedBy = "pModel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PicturesModel> pM;
}
