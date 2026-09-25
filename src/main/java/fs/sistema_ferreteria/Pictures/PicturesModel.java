package fs.sistema_ferreteria.Pictures;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity 
@Table(name = "Fotos")
@Data 
@AllArgsConstructor 
@Setter 
@Getter 
public class PicturesModel {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Object URL_Foto;
}
