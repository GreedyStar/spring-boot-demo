import com.greedystar.generator.invoker.Many2ManyInvoker;
import com.greedystar.generator.invoker.base.Invoker;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
public class CodeGenerate {

    public static void main(String[] args) {
        many2many();
    }

    public static void many2many() {
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
