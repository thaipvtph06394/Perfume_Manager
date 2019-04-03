package vn.edu.poly.perfume_manager.sqlitedao;

import vn.edu.poly.perfume_manager.Constant;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;

public class ThongKeDAO implements Constant {
    private DatabaseHelper databaseHelper;

    public ThongKeDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }
}
