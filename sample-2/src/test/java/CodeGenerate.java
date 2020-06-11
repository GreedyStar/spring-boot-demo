import com.greedystar.generator.invoker.Many2ManyInvoker;
import com.greedystar.generator.invoker.One2ManyInvoker;
import com.greedystar.generator.invoker.SingleInvoker;
import com.greedystar.generator.invoker.base.Invoker;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
public class CodeGenerate {

    public static void main(String[] args) {
        single();
    }

    private static void single() {
        Invoker invoker = new SingleInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .build();
        invoker.execute();
    }

    private static void one2many() {
        Invoker invoker = new One2ManyInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .setParentTableName("office")
                .setParentClassName("Office")
                .setForeignKey("office_id")
                .build();
        invoker.execute();
    }

    private static void many2many() {
        Invoker invoker = new Many2ManyInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .setParentTableName("role")
                .setParentClassName("Role")
                .setRelationTableName("user_role")
                .setForeignKey("user_id")
                .setParentForeignKey("role_id")
                .build();
        invoker.execute();
    }

}
