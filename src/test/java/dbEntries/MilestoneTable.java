package dbEntries;


import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class MilestoneTable {
    public static Logger logger = Logger.getLogger(MilestoneTable.class);

    DataBaseService dataBaseService;

    public MilestoneTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable() {
        logger.info("Создаем таблицу milestones");

        String createTableSQL = "CREATE TABLE milestones (" +
                "id SERIAL PRIMARY KEY, " +
                "milestone CHARACTER VARYING(30), " +
                "reference CHARACTER VARYING(30), " +
                "description CHARACTER VARYING(30) " +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу milestones");

        String dropTableMilestonesSQL = "DROP TABLE milestones;";

        dataBaseService.executeSQL(dropTableMilestonesSQL);
    }

    public ResultSet getMilestoneByID(int id) {
        String sql = "SELECT * FROM milestones WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addMilestone(String milestone, String reference, String description) {
        logger.info("Добавляем запись в таблицу milestones");

        String insertTableSQL = "INSERT INTO public.milestones(" +
                "milestone, reference, description)" +
                "VALUES ('" + milestone + "', '" + reference+"', '" + description+"');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
