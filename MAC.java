 * @author rkichou
 */import java.util.Random;
public class MAC {
    private String mac;

    public MAC() {
        this.mac = getRandomMacAddress();
    }

    public String getMAC() {
        return mac;
    }

    public void setMAC(String MAC) {
        this.mac = MAC;
    }
    
    public static String getRandomMacAddress() {
        String mac = "";
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            //int n = r.nextInt(255);
            mac += String.format("%02x:", r.nextInt(255));
        }
        mac+=String.format("%02x", r.nextInt(255));
        return mac.toUpperCase();
    }
}
