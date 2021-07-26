package Entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, Integer> id_tipo;
	public static volatile SingularAttribute<Usuario, String> cargo;

	public static final String ID_TIPO = "id_tipo";
	public static final String CARGO = "cargo";

}

