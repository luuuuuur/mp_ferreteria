package fs.sistema_ferreteria.Pictures;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import fs.sistema_ferreteria.Products.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity 
@Table(name = "Photos")
@Data 
@AllArgsConstructor 
@Setter 
@Getter 
public class PicturesModel {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Foto_URL", nullable = false)
    private String URL_Foto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    //aqui solo va la clave foranea del Model;
    private ProductsModel pModel;

}
