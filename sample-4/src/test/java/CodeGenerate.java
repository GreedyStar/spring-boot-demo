import com.greedystar.generator.invoker.SingleInvoker;
import com.greedystar.generator.invoker.base.Invoker;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
public class CodeGenerate {

    public static void main(String[] args) {
        Invoker invoker = new SingleInvoker.Builder()
                .setTableName("role")
                .setClassName("Role")
                .build();
        invoker.execute();
    }

}
