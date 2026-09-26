package fs.sistema_ferreteria.ProductProvider;


import fs.sistema_ferreteria.Pictures.PicturesModel;
import jakarta.persistence.Column;
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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "ProductProvider")
@Data 
@AllArgsConstructor 
@Setter 
@Getter 
@NoArgsConstructor 
public class ProductProviderModel {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "providerId")
    private Long providerId;
    @Column(name = "provider_name")
    private String NombreProveedor;
    @OneToOne
    @JoinColumn(name = "photos_id",referencedColumnName = "id", nullable = true) //icóno del proveedor
    private PicturesModel PM;
}
