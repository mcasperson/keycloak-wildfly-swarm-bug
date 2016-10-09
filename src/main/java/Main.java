import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;

/**
 * Created by matthewcasperson on 9/10/16.
 */
public class Main {
    public static void main(String... args) throws Exception {
        final Swarm swarm = new Swarm();

        swarm.fraction(new DatasourcesFraction()
                .dataSource("KeycloakDS", (ds) -> {
                    ds.driverName("mysql");
                    ds.connectionUrl("jdbc:mysql://localhost:3306/Keycloak");
                    ds.userName("root");
                    ds.password("password1!");
                    ds.maxPoolSize(2);
                    ds.minPoolSize(0);
                    ds.validConnectionCheckerClassName("org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker");
                    ds.exceptionSorterClassName("org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter");
                    ds.validateOnMatch(true);
                    ds.backgroundValidation(true);
                    ds.backgroundValidationMillis(1000l);
                })
        );

        swarm.start();
    }
}
