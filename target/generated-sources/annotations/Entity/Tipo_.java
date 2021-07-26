package Entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tipo.class)
public abstract class Tipo_ {

	public static volatile SingularAttribute<Tipo, Integer> id_tipo;
	public static volatile SingularAttribute<Tipo, String> cargo;

	public static final String ID_TIPO = "id_tipo";
	public static final String CARGO = "cargo";

}

