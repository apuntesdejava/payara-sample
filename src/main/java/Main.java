import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

public class Main {

  public static void main(String[] args) throws BootstrapException {
      PayaraMicro.getInstance()
              .setHttpPort(Integer.parseInt(System.getenv("PORT")))
              .addDeployment("payara-sample-web-1.0-SNAPSHOT.war")
              .bootStrap();

  }

}
