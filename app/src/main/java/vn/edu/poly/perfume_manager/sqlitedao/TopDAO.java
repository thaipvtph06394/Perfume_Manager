package vn.edu.poly.perfume_manager.sqlitedao;

import vn.edu.poly.perfume_manager.Constant;
import vn.edu.poly.perfume_manager.database.DatabaseHelper;

public class TopDAO implements Constant{
    private DatabaseHelper databaseHelper;

    public TopDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

}
