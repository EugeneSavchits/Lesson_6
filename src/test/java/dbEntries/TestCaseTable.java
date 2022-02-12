package dbEntries;


import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class TestCaseTable {
    public static Logger logger = Logger.getLogger(TestCaseTable.class);

    DataBaseService dataBaseService;

    public TestCaseTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable() {
        logger.info("Создаем таблицу milestones");

        String createTableSQL = "CREATE TABLE testcase (" +
                "id SERIAL PRIMARY KEY, " +
                "title CHARACTER VARYING(30), " +
                "preconditions CHARACTER VARYING(30) " +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу testcase");

        String dropTableMilestonesSQL = "DROP TABLE testcase;";

        dataBaseService.executeSQL(dropTableMilestonesSQL);
    }

    public ResultSet getMilestoneByID(int id) {
        String sql = "SELECT * FROM testcase WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addTestcase(String title, String preconditions) {
        logger.info("Добавляем запись в таблицу testcase");

        String insertTableSQL = "INSERT INTO public.testcase(" +
                "title, preconditions)" +
                "VALUES ('" + title + "', '" + preconditions+"');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
