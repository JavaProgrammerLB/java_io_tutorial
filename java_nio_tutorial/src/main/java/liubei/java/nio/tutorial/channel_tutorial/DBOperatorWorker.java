package liubei.java.nio.tutorial.channel_tutorial;

public class DBOperatorWorker {

    public static void main(String[] args) {
        try (DBOperator dbOperator = new DBOperator()) {
            System.out.println("使用dbOperator进行数据库的操作");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
