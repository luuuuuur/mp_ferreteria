package fs.sistema_ferreteria.Pictures;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PicturesInterface
 */
//interfaz vacía no necesidad de poner @Repository
interface PicturesInterface extends JpaRepository<PicturesModel, Long>{

    
}