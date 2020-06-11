import com.greedystar.sample3.utils.CustomPasswordEncoder;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
public class PasswordEncode {

    public static void main(String[] args) {
        CustomPasswordEncoder passwordEncoder = new CustomPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456789"));
    }

}
