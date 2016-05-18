
import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws BootstrapException, GlassFishException {
        int puerto = 10000;
        String sPuerto = System.getenv("PORT");
        if (sPuerto != null && !sPuerto.isEmpty()) {
            puerto = Integer.parseInt(sPuerto);
        }
        File file = new File("payara-sample-web.war");
        LOG.log(Level.INFO, "war path:{0}", file.getAbsolutePath());
        LOG.log(Level.INFO, "Existe:{0}", file.exists());
        PayaraMicro micro = PayaraMicro.getInstance();
        micro.setHttpPort(puerto)
                .addDeploymentFile(file)
                .bootStrap();
        /*GlassFishRuntime runtime = GlassFishRuntime.bootstrap();
        GlassFishProperties props = new GlassFishProperties();
        props.setPort("http-listener", puerto);
        GlassFish gf = runtime.newGlassFish(props);
        gf.start();
        gf.getDeployer().deploy(file);*/

    }

}
